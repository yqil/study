var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

var queryUserInfo = function(userId){
	return new Promise(function(resolver, reject) {
		var data = {
			userId: userId
		};
		var url = "/e/queryUser.do?userId="+userId;
		httpUtil.get("127.0.0.1", "8080", url).then(function(data){
			data = JSON.parse(data);
			if(data && data.status && data.content){
				resolver(data);
			}else {
				resolver({status:false, msg:"获取用户信息失败"});
			}
		}).catch(function (err) {
	  		console.log('获取用户信息失败:'+err);
	  		reject(err);
		});
	});
};

var queryUserAccount = function(userId){
	return new Promise(function(resolver, reject) {
		var url = "/e/queryAccount.do?type=JIFEN&userId="+userId
		httpUtil.get("127.0.0.1", "8080", url).then(function(data){
			data = JSON.parse(data);
			if(data && data.status && data.content){
				resolver(data);
			}else {
				resolver({status:false, msg:"获取用户积分信息失败"});
			}
		}).catch(function (err) {
	  		console.log('获取用户积分信息失败:'+err);
	  		reject(err);
		});
	});
};

router.get('/', function(req, res, next) {
	console.log("session中的userId:"+req.session.userId);
	var userId = req.session.userId;
	if(userId){
		queryUserInfo(userId).then(function(userInfo){
			if(userInfo && userInfo.status){
				queryUserAccount(userId).then(function(accountInfo){
					if(accountInfo && accountInfo.status){
						res.send({
							userInfo: userInfo.content,
							accountInfo: accountInfo.content
						});
					}else {
						res.send(accountInfo);
					}
				}).catch(function(err){
					console.log('获取用户积分信息失败:'+err);
			  		res.send({status:false, msg:"获取用户积分信息失败"});
				});
			}else {
				res.send(userInfo);
			}
		}).catch(function(err){
			console.log('获取用户信息失败:'+err);
	  		res.send({status:false, msg:"获取用户信息失败"});
		});
	}else {
		console.log('session中的userId不存在');
	  		res.send({status:false, msg:"系统出现异常"});
	}	
});

module.exports = router;