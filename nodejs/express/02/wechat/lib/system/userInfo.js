var fs = require('fs'); // 载入fs模块

var sysProperties = require('../../config/sysProperties');

var readFile = function(){
	return new Promise(function(resolver, reject) {
		fs.readFile(sysProperties.userInfo, 'utf-8', function(err, data) {
		    // 读取文件失败/错误
		    if (err) {
		        reject(err);
		    }
		    // 读取文件成功
		    data = data.toString();
			if(data == null || data == ''){
				resolver(null);
			}
		    var users = data.split("\r\n");
		    if(!users || users.length == 0){
		    	resolver(null);
		    }else {
		    	resolver(users);
		    }
		});
	});
};

var getUserInfoByOpenid = function(openid){
	return new Promise(function(resolver, reject) {
		readFile().then(function(data){
			var rs = null;
			if(data && data.length > 0){
				for(var i = 0; i < data.length; i++){
					var row = data[i];
					var user = JSON.parse(row);
					if(user.openid == openid){
						rs = user;
						break;
					}
				}
			}
			console.log("从文件中获取的用户信息:"+rs);
			resolver(rs);
		}).catch(function (data) {
			reject(err);
		});
	});
};

//var saveUserInfo = function(user){
//	return new Promise(function(resolver, reject) {
//		fs.writeFile(sysProperties.userInfo, "\r\n"+JSON.stringify(user), { 'flag': 'a' }, function(err) {
//		    if (err) {
//		        reject(err);
//		    }
//			resolver(true);
//		});
//	});
//};

var saveUserInfo = function(user){
	return new Promise(function(resolver, reject) {
		fs.open(sysProperties.userInfo, 'a', function (err, fd) {
			if (err) {
		        reject(err);
		    }
		    console.log("开始保存用户信息"+JSON.stringify(user));
		  	fs.write(fd, "\r\n"+JSON.stringify(user), function (err, written, buffer) {
		    	fs.fsync(fd);
		      	fs.close(fd);
		      	resolver(true);
		  	});
		});
	});
	
};

module.exports = {
	getUserInfoByOpenid: getUserInfoByOpenid,
	saveUserInfo: saveUserInfo
};

