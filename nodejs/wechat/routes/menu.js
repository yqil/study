var express = require('express');
var router = express.Router();
var wechatMenu = require('../lib/wechat/wechatMenu');


router.get('/', function(req, res, next) {
    wechatMenu.createMenu().then(function(data){
        console.log(data);
        if(data && data.errcode == 0){
            res.send("创建菜单成功");
        }
    }).catch(function (err) {
        console.log('创建菜单出现异常:'+err);
        res.render('error', { msg: "创建菜单出现异常" });
    });
});

module.exports = router;