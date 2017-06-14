var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
 /* ,  url = require('url')*/
server.listen(8000);
var username;
app.get('/', function (req, res) {
	  
	 console.log("아니 챗팅으로 보내주지?");
	  res.sendfile(__dirname + '/chatting.html');
});
app.get('/client',function(req, res){
	
	username = req.param("username");
	res.sendfile(__dirname + '/client.html');
	
});

io.sockets.on('connection', function (socket) {
	
	console.log("emit되는거지?"+username);
	socket.emit('sendusername',username);
	
	socket.on('sendchat',function(data){
		io.sockets.emit('updatechat',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
});