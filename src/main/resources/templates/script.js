var stompClient = null;

$(document).ready(function () {
    console.log('Index page is loaded!')

    connect()

    $('#send').click(function () {
        sendMessage()
    })
})

function connect() {
    var socket = new SockJS('/messages');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected to: ' + frame);
        stompClient.subscribe('/topic/messages', function (message) {
            console.log(JSON.parse(message.body));
            $('#messages').append('<tr><td>' + JSON.parse(message.body).content + '</td></tr>')
        });
    });
}

function sendMessage() {
    console.log('Sending message!')
    stompClient.send("/ws/message", {}, JSON.stringify({'content': $('#message').val()}));
}