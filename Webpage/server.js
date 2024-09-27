

const express = require("express");
const path = require("path");

const app = express();

const server = require("http");

const Server = server.createServer(app);

app.use(express.static(__dirname + '/public'));


app.get('/', function(req, res){
    res.sendFile(__dirname + "/public/index.html");
})

Server.listen(80);

console.log("SziaSzilard")