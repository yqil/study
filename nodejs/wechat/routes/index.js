var express = require('express');
var router = express.Router();
var wechatOAuth = require('../lib/wechat/wechatOAuth');
var httpUtil = require('../lib/util/httpUtil');

var dealUserInfo = function(req, openid){
	return new Promise(function(resolver, reject) {
		var url = "/e/getUserIdByOpenid.do?appId="+openid;
		httpUtil.get("127.0.0.1", "8080", url).then(function(data){
			req.session.openid = openid;
			resolver(data);
		}).catch(function (err) {
	  		reject(err);
		});
	});
};

router.get('/', function(req, res, next) {
	console.log(req.query);
	if(!req.query || !req.query.code){
		res.render('error', { msg: "从腾讯服务器获取认证信息失败" });
	}
	if(req.session.opencode){
		dealUserInfo(req, req.session.openid).then(function(data){
			data = JSON.parse(data);
			if(data && data.status && data.content){
				req.session.userId = data.content;
				res.render('center', { msg: "进入用户中心界面" });
			}else {
				res.render('index', { msg: "进入用户绑定界面" });
			}
		}).catch(function (err) {
	  		console.log('校验用户是否绑定出现异常:'+err);
	  		res.render('error', { msg: "系统出现异常" });
		});
	}else {
		wechatOAuth.getOpenid(req.query.code).then(function(openid){
			req.session.opencode = req.query.code;
			console.log("获取openid为："+openid);
			if(openid){
				dealUserInfo(req, openid).then(function(data){
					data = JSON.parse(data);
					if(data && data.status && data.content){
						req.session.userId = data.content;
						res.render('center', { msg: "进入用户中心界面" });
					}else {
						res.render('index', { msg: "进入用户绑定界面" });
					}
				}).catch(function (err) {
			  		console.log('校验用户是否绑定出现异常:'+err);
			  		res.render('error', { msg: "系统出现异常" });
				});
			}else {
				res.render('error', { msg: "从腾讯获取openid失败" });
			}
		}).catch(function (err) {
	  		console.log('获取access_token出现异常:'+err);
	  		res.render('error', { msg: "系统出现异常" });
		});
	}
});

module.exports = router;