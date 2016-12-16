var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

/*router.get('/', function(req, res, next) {
	console.log("session中的userId:"+req.session.userId);
	res.render('person', { msg: "进入个人信息界面" });
});*/

var queryUser = function(req, res){
    var validCode = req.query.validCode;
    var data = {
        userId: req.session.userId
    };
    var url = "/e/queryUser.do";
    httpUtil.post("127.0.0.1", "8080", url, JSON.stringify(data)).then(function(data){
        // data = JSON.parse(data);
        res.send(data);
        /*if(data && data.status && data.content){
            res.send(data);
        }else{
            res.send({status:false, msg: data.msg});
        }*/
    }).catch(function (err) {
        console.log('获取用户个人信息失败:'+err);
        res.send({status:false, msg:"获取用户个人信息失败"});
    });
};

var saveUser = function(req, res){
    var data = req.query.data;
    data.userId = req.session.userId;
    var url = "/e/saveUser.do";
    httpUtil.post("127.0.0.1", "8080", url, JSON.stringify(data)).then(function(data){
        // data = JSON.parse(data);
        res.send(data);
        // if(data && data.status && data.content){
        //     res.send(data);
        // }else{
        //     res.send({status:false, msg: data.msg});
        // }
    }).catch(function (err) {
        console.log('保存失败:'+err);
        res.send({status:false, msg:"保存失败"});
    });
};

router.get('/:id', function(req, res, next) {
    console.log("session中的userId:"+req.session.userId);
    console.log("session中的openid:"+req.session.openid);
    var id = req.params.id;
    console.log("id:"+id);
    if(id == "index"){
        res.render('person', { msg: "进入个人信息界面" });
    }else if(id == "queryUser"){
        queryUser(req, res);
    }else if(id == "editNickName"){
        res.render('editNickName', { msg: "修改木木号" });
    }else if(id == "editMmh"){
        res.render('editMmh', { msg: "修改昵称" });
    }else if(id == "editPhone"){
        res.render('editPhone', { msg: "修改手机号码" });
    }else if(id == "editAddr"){
        res.render('editAddr', { msg: "修改地址" });
    }else if(id == "saveUser"){
        saveUser(req, res);
    }
});

module.exports = router;