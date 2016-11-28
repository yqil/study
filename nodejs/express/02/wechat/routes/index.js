var express = require('express');
var router = express.Router();

//var wechatAccessToken = require('../lib/wechat/wechatAccessToken');

//var wechatMenu = require('../lib/wechat/wechatMenu');

var wechatOAuth = require('../lib/wechat/wechatOAuth');

var userInfoUtil = require('../lib/system/userInfo');

router.get('/', function(req, res, next) {
	console.log(req.query);
	if(!req.query || !req.query.code){
		res.render('error', { msg: "从腾讯服务器获取认证信息失败" });
	}
	wechatOAuth.getOpenid(req.query.code).then(function(openid){
		console.log("获取openid为："+openid);
		if(openid){
			console.log("获取用户信息");
			userInfoUtil.getUserInfoByOpenid(openid).then(function(user){
				console.log("获取用户信息111"+user);
				req.session.openid = openid;
				if(user){
					console.log("获取用户信息222");
					req.session.user = user;
					res.render('center', { msg: "进入用户中心界面" });
				}else {
					console.log("获取用户信息3333");
					res.render('index', { msg: "进入用户绑定界面" });
				}
			}).catch(function (err) {
		  		console.log('获取access_token出现异常:'+err);
		  		res.render('error', { msg: "系统出现异常" });
			});
		}else {
			res.render('error', { msg: "从腾讯获取openid失败" });
		}
	}).catch(function (err) {
  		console.log('获取access_token出现异常:'+err);
  		res.render('error', { msg: "系统出现异常" });
	});
//	res.render('index', {  });
	/*wechatAccessToken().then(function(data){
		console.log("获取access_token为："+data);
  		res.render('index', {  });
	}).catch(function (data) {
  		console.log('获取access_token出现异常:'+data);
	});*/
	
	/*wechatMenu.createMenu().then(function(data) {
		console.log("创建菜单返回的消息=======");
		console.log(data);
		res.render('index', {  });
	}).catch(function(data) {
		console.log('创建菜单出现异常:' + data);
	});*/
});

module.exports = router;