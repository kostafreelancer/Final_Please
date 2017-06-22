var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
server.listen(8000);
var username;
var usernames = [];
var socket_id = [];
app.get('/', function (req, res) {
	  
	  res.sendfile(__dirname + '/chatting.html');
	  
});
app.get('/client',function(req, res){
	console.log('여기 안드와?');
	username = req.param("username");
	res.sendfile(__dirname + '/client.html');
	
});
app.use('/script',express.static(__dirname));

io.sockets.on('connection', function (socket) {

	console.log("emit되는거지?"+username);
	socket.emit('sendusername',username);
	
	socket.on('sendchat',function(data,user){
		/*io.sockets.emit('updatechat',socket.username,data);*/
		io.sockets.to(socket_id[user]).emit('hiden',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		usernames.push(username);
		socket_id[username] = socket.id;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
	
	socket.on('alllist',function(){
		socket.emit('userlist',usernames);
	});
	socket.on('disconnected',function(username,user){
		
		
		for(var i in usernames){
			if(usernames[i]==username){
				delete usernames[i];
				usernames.splice(i,1); 
			}
		}
		io.sockets.to(socket_id[user]).emit('disconneted_alram',username);
		
	});

});