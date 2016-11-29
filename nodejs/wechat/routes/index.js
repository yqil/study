var express = require('express');
var router = express.Router();
var wechatOAuth = require('../lib/wechat/wechatOAuth');
var httpUtil = require('../lib/util/httpUtil');

router.get('/', function(req, res, next) {
	console.log(req.query);
	if(!req.query || !req.query.code){
		res.render('error', { msg: "从腾讯服务器获取认证信息失败" });
	}
	wechatOAuth.getOpenid(req.query.code).then(function(openid){
		console.log("获取openid为："+openid);
		if(openid){
			var url = "/study-example-web/e/getUserIdByOpenid.do?appId="+openid;
			httpUtil.get("127.0.0.1", "8080", url).then(function(data){
				req.session.openid = openid;
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
});

module.exports = router;