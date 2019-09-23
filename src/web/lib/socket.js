const SocketClient = (function () {
    let client;
    return {
        connect(url) {
            client = new WebSocket(url);
            client.addEventListener('message', msg => {
                console.log(msg.data);
            })
        },
        send(msg) {
            client.send(JSON.stringify(msg))
        },
        test() {
            client = new WebSocket("ws://dev.bantasy.top:8080/socket/banyq");
            client.addEventListener("open", () => {
                client.send(JSON.stringify({name: 'banyq', data: "data"}))
            });
            client.addEventListener("message", event => {
                console.log(event.data);
            });
        }
    }
})();
