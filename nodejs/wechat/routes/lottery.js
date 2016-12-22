var express = require('express');
var router = express.Router();
var httpUtil = require('../lib/util/httpUtil');

router.get('/:id', function(req, res, next) {
    console.log("session中的openid:"+req.session.openid);
    var id = req.params.id;
    if(id == "roundabout"){
        res.render('roundabout', { msg: "进入大转盘界面" });
    }else if(id == "scratchCard"){
        res.render('scratchCard', { msg: "进入刮刮乐界面" });
    }else if(id == "goldEgg"){
        res.render('goldEgg', { msg: "进入砸金蛋界面" });
    }
});

module.exports = router;