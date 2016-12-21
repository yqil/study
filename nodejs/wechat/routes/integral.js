var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

router.get('/:id', function(req, res, next) {
    console.log("session中的openid:"+req.session.openid);
    var id = req.params.id;
    if(id == "index"){
        res.render('integral', { msg: "进入用户积分界面" });
    }else if(id == "detail"){
        res.render('integralDetail', { msg: "进入用户积分明细界面" });
    }else if(id == "exchange"){
        res.render('integralExchange', { msg: "进入用户积分兑换界面" });
    }
});

module.exports = router;