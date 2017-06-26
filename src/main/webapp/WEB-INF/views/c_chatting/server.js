var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
server.listen(8084);
var username;
var usernames = [];
var socket_id = [];
app.get('/', function (req, res) {
	  
	  res.sendfile(__dirname + '/chatting.html');
	  
});
app.get('/client',function(req, res){
	username = req.param("username");
	res.sendfile(__dirname + '/client.html');
	
});
app.use('/script',express.static(__dirname));

io.sockets.on('connection', function (socket) {

	socket.emit('sendusername',username);
	
	socket.on('sendchat',function(data,user){
		io.sockets.to(socket_id[user]).emit('hiden',socket.username,data);
		console.log(user+' : '+socket_id[user]);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		if(username == null){
			return;
		}
		for(var i in usernames){
			if(usernames[i]==username){
				delete usernames[i];
				usernames.splice(i,1);
			}
		}
		usernames.push(username);
/*		console.log(socket_id[username]+"이거와: ");*/
		socket_id[username] = socket.id;
		console.log(socket_id[username]+"-"+username);
/*		console.log(socket.id+"이거랑은 같아야지");*/
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