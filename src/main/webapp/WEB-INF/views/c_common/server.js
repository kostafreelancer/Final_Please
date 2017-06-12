var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
 /* ,  url = require('url')*/
server.listen(8000);

app.get('/', function (req, res) {
	  
	 
	  res.sendfile(__dirname + '/chatting.html');
});
app.get('/client',function(req, res){
	console.log("여기 클라이언트 오는거지?");
	console.log("쓰바");
	console.log(req.param("username")+"모라도 찍혀라");
	  res.sendfile(__dirname + '/client.html');
});
io.sockets.on('connection', function (socket) {
	
	console.log("접속은 되는거지.");
	socket.on('sendchat',function(data){
		io.sockets.emit('updatechat',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
});