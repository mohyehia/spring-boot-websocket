package com.moh.yehia.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // user creation in memory instead of using auth-server
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // InMemoryUserDetailsManager setup with two users
        UserDetails firstUser = User.withUsername("moh-yehia").password(passwordEncoder.encode("123456")).roles("USER").build();
        UserDetails secondUser = User.withUsername("amr-ahmed").password(passwordEncoder.encode("123456")).roles("USER").build();
        UserDetails adminUser = User.withUsername("admin").password(passwordEncoder.encode("admin")).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(firstUser, secondUser, adminUser);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/messages/**").hasRole("ADMIN")
                        .requestMatchers("/ws/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
