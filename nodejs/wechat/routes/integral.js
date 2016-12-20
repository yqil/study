var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

router.get('/:id', function(req, res, next) {
    console.log("session中的openid:"+req.session.openid);
    var id = req.params.id;
    if(id == "index"){
        res.render('integral', { msg: "进入用户积分界面" });
    }else if(id == "submit"){
        // bindSubmit(req, res);
    }
});

module.exports = router;