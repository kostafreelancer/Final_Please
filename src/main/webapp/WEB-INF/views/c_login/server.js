var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
server.listen(8000);

app.get('/', function (req, res) {
	  res.sendfile(__dirname + '/chatting.html');
});
app.get('/client',function(req, res){
	  res.sendfile(__dirname + '/client.html');
});
app.get('/img',function(req,res){
	  res.sendfile("/resources/c_common_img")
});
io.sockets.on('connection', function (socket) {
	console.log("여기 들어 오는거 아냐?");
	socket.on('sendchat',function(data){
		io.sockets.emit('updatechat',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		console.log("여기까지 안들어 오는거지?");
		socket.username = username;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
});