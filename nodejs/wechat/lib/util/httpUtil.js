/**
 * htpp模块
 */
var http = require('http');

var get = function(hostName, port, url){
	return new Promise(function(resolver, reject) {
		var options = {
			hostname: hostName,
			port: port,
			path: url,
			method: 'GET',
			headers: {
				'Content-Type': 'application/json; charset=UTF-8'
			}
		};
	
		var req = http.request(options, function(res) {
			res.setEncoding('utf8');
			res.on('data', function(data) {
				resolver(data);
			});
		});
	
		req.on('error', function(e) {
			reject(e);
		});
		
		req.end();
	});
};

var post = function(hostName, port, path, data){
	return new Promise(function(resolver, reject) {
		var options = {
			hostname: hostName,
			port: port,
			path: path,
			method: 'POST',
			headers: {
				'Content-Type': 'application/json; charset=UTF-8',
				"dataType": 'json',
			}
		};
		var req = http.request(options, function(res) {
			console.log('STATUS: ' + res.statusCode);
			console.log('HEADERS: ' + JSON.stringify(res.headers));
			res.setEncoding('utf8');
			res.on('data', function(chunk) {
				console.log(chunk);
				resolver(chunk);
			});
		});
	
		req.on('error', function(e) {
			reject(e);
		});
	
		// write data to request body  
		req.write(data);
		req.end();
	});
};


module.exports = {
	get : get,
	post: post
}
