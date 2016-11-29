var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

router.get('/', function(req, res, next) {
	console.log("session中的userId:"+req.session.userId;
	var userId = req.session.userId;
	if(userId){
		var data = {
			userId: userId
		};
		var url = "/study-example-web/e/queryUser.do?user="+JSON.stringify(data);
		httpUtil.get("127.0.0.1", "8080", url).then(function(data){
			data = JSON.parse(data);
			if(data && data.status && data.content){
				res.send(data);
			}else {
				res.render('index', { msg: "进入用户绑定界面" });
			}
		}).catch(function (err) {
	  		console.log('获取用户信息失败:'+err);
	  		res.send({status:false, msg:"获取用户信息失败"});
		});
	}else {
		console.log('session中的userId不存在');
	  		res.send({status:false, msg:"系统出现异常"});
	}
	
});

module.exports = router;