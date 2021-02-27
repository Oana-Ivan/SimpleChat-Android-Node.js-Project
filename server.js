const SocketServer = require('websocket').server
const http = require('http')

const server = http.createServer((req, res) => {})

server.listen(3000, () => {
    console.log('Listening on port 3000...')
})

wsServer = new SocketServer({httpServer: server})

const connections = []

wsServer.on('request', (req) => {
    // add new connection to the connections array
    const connection = req.accept()
    console.log('new connection')
    connections.push(connection)

    // when is sent a message, sent to all connections, except the one who sent it
    connection.on('message', (m) => {
        connections.forEach(element => {
            if (element != connection)
                element.sendUTF(m.utf8Data)
        })
    })
    connection.on('close', (resCode, des) => {
        console.log('connection closed')
        connections.splice(connections.indexOf(connection), 1)
    })
})