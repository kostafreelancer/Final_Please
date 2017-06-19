var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
server.listen(8000);
var username;
var numUsers = 0;
var usernames = [];
app.get('/', function (req, res) {
	  
	  res.sendfile(__dirname + '/chatting.html');
});
app.get('/client',function(req, res){
	
	username = req.param("username");
	res.sendfile(__dirname + '/client.html');
	
});
app.use('/script',express.static(__dirname));

io.sockets.on('connection', function (socket) {
	
	console.log("emit되는거지?"+username);
	socket.emit('sendusername',username);
	
	socket.on('sendchat',function(data){
		io.sockets.emit('updatechat',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		usernames[numUsers] = username;
		console.log(usernames[numUsers]+"이거 걸리지?");
		++numUsers;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
	
	socket.on('alllist',function(){
		socket.emit('userlist',usernames);
	});
	
});