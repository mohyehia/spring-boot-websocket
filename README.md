## Websockets

### What is Websockets ?
- WebSocket is a computer communications protocol, providing a simultaneous two-way communication channel over a single Transmission Control Protocol (TCP) connection.
- WebSocket is bidirectional, a full-duplex protocol that is used in the same scenario of client-server communication, unlike HTTP which starts from ws:// or wss://.
- It is a stateful protocol, which means the connection between client and server will stay alive until it gets terminated by either party (client or server).
- After closing the connection by either of the client or server, the connection is terminated from both ends.

### When can a web socket be used?
- **Real-time web application**:
  - Real-time web application uses a web socket to show the data at client end, which is continuously being sent by the backend server.
  - In WebSocket, data is continuously pushed/transmitted into the same connection which is already open, that is why WebSocket is faster and improves the application performance.
- **Gaming application**:
  - In a Gaming application, you might focus on that, data is continuously received by the server, and without refreshing the UI,
  - it will take effect on the screen, UI gets automatically refreshed without even establishing the new connection, so it is very helpful in a Gaming application.
- **Chat application**:
  - Chat applications use WebSockets to establish the connection only once for exchange, publishing, and broadcasting the message among the subscribers.
  - It reuses the same WebSocket connection, for sending and receiving the message and for one-to-one message transfer.

### When not to use WebSocket?
- WebSocket can be used if we want any real-time updated or continuous streams of data that are being transmitted over the network.
- But if we want to fetch old data, or want to get the data only once to process it with an application we should go with HTTP protocol.
- Old data which is not required very frequently or fetched only once can be queried by the simple HTTP request, so in this scenario, it’s better not use WebSocket.

### Differences between HTTP and WebSocket Connection

| HTTP                                                                                                                                                                                                                                                        | WebSocket                                                                                                                                                                                                                                                                  |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| The HTTP protocol is a unidirectional protocol that works on top of TCP protocol which is a connection-oriented transport layer protocol, we can create the connection by using HTTP request methods after getting the response HTTP connection get closed. | WebSocket is a bidirectional communication protocol that can send the data from the client to the server or from the server to the client by reusing the established connection channel. The connection is kept alive until terminated by either the client or the server. |
| Simple RESTful application uses HTTP protocol which is stateless.                                                                                                                                                                                           | Almost all the real-time applications services use WebSocket to receive the data on a single communication channel.                                                                                                                                                        |
| It is used when we do not want to retain a connection for a particular amount of time or reuse the connection for transmitting data; An HTTP connection is slower than WebSockets.                                                                          | All the frequently updated applications used WebSocket because it is faster than HTTP Connection.                                                                                                                                                                          |


### References
- [What is web socket and how it is different from the HTTP?](https://www.geeksforgeeks.org/what-is-web-socket-and-how-it-is-different-from-the-http)