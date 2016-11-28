var express = require('express');
var router = express.Router();

var userInfoUtil = require('../lib/system/userInfo');

function User(phone, pwd, openid){
	this.phone = phone;
	this.pwd = pwd;
	this.openid = openid;
}

router.get('/:id', function(req, res, next) {
	console.log("bind===================");
	console.log("id:"+req.params.id);
	var id = req.params.id;
	if(id == "center"){
		res.render('center', { msg: "进入用户中心界面" });
	}else if(id == "submit"){
		var phone = req.query.phone;
		var validCode = req.query.validCode;
		var pwd = req.query.pwd;
		console.log("session中的openid:"+req.session.openid);
		if(validCode == "888888"){
			var user = new User(phone, pwd, req.session.openid);
			userInfoUtil.saveUserInfo(user).then(function(status){
				if(status){
					req.session.user = user;
					res.send({status:true, msg:"绑定成功"});
				}else {
					res.send({status:false, msg:"绑定失败"});
				}
			}).catch(function (err) {
		  		console.log('写入用户信息失败:'+err);
		  		res.send({status:false, msg:"写入用户信息失败"});
			});
			
		}else {
			res.send({status:false, msg:"验证码错误"});
		}
	}
});

module.exports = router;