var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

var bindSubmit = function(req, res){
	var validCode = req.query.validCode;
	if(validCode == "888888"){
		var data = {
			phone: req.query.phone,
			pwd: req.query.pwd,
			appId: req.session.openid,
			type: 1
		};
		var url = "/e/bindUser.do";
		httpUtil.post("127.0.0.1", "8080", url, JSON.stringify(data)).then(function(data){
			data = JSON.parse(data);
			if(data && data.status && data.content){
				req.session.userId = data.content;
				res.send({status:true, msg:"绑定成功"});
			}else{
				res.send({status:false, msg: data.msg});
			}
		}).catch(function (err) {
	  		console.log('绑定失败:'+err);
	  		res.send({status:false, msg:"绑定失败"});
		});
	}else {
		res.send({status:false, msg:"验证码错误"});
	}
};

router.get('/:id', function(req, res, next) {
	console.log("session中的openid:"+req.session.openid);
	var id = req.params.id;
	if(id == "center"){
		res.render('center', { msg: "进入用户中心界面" });
	}else if(id == "submit"){
		bindSubmit(req, res);
	}
});

module.exports = router;