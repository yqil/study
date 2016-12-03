var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

router.get('/', function(req, res, next) {
	console.log("session中的userId:"+req.session.userId);
	res.render('person', { msg: "进入个人信息界面" });
});

module.exports = router;