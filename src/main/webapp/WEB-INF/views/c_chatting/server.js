var express = require('express')
  , app = express()
  , http = require('http')
  , server = http.createServer(app)
  , io = require('socket.io').listen(server)
server.listen(8000);
var username;
var numUsers = 0;
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
	
	console.log("emit되는거지?"+username);
	socket.emit('sendusername',username);
	
	socket.on('sendchat',function(data){
		io.sockets.emit('updatechat',socket.username,data);
		console.log(data+': '+socket.username);
	});
	
	socket.on('adduser',function(username){
		socket.username = username;
		usernames[numUsers] = username;
		socket_id[username] = socket.id;
		
		var list = findClientsSocket();
		console.log(list.pop+"이거 걸리지?");
		
		for(var i=0;i<list.length;i++){
			console.log(list+"이거야?");
		}
		++numUsers;
		socket.emit('join','SERVER', username+'님 환영합니다.');
	});
	
	socket.on('alllist',function(){
		console.log("여기 들어 오는거지?");
		socket.emit('userlist',usernames);
	});
	
	function findClientsSocket(roomId, namespace) {
	    var res = []
	    // the default namespace is "/"
	    , ns = io.of(namespace ||"/");

	    if (ns) {
	        for (var id in ns.connected) {
	            if(roomId) {
	                var index = ns.connected[id].rooms.indexOf(roomId);
	                if(index !== -1) {
	                    res.push(ns.connected[id]);
	                }
	            } else {
	                res.push(ns.connected[id]);
	            }
	        }
	    }
	    return res;
	}
});