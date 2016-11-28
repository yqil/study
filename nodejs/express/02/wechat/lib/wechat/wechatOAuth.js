/**
 * https模块，有wechat-api模块，这样更方便调用微信的接口
 */
var https = require('https');

var wechatProperties = require('../../config/wechatProperties');

console.log(wechatProperties.account.appId);

var getOpenid = function(code){
	return new Promise(function(resolver, reject) {
		var req = https.get(wechatProperties.getOpenidUrl(code), function(res) {
			var bodyChunks = '';
			res.on('data', function(chunk) {
				bodyChunks += chunk;
			}).on('end', function() {
				var body = JSON.parse(bodyChunks);
				var openid = body.errcode ? null : body.openid;
				resolver(openid);
			})
		});

		req.on('error', function(e) {
			console.log('ERROR: ' + e.message);
			reject(e);
		});
	});
}

module.exports = {getOpenid:getOpenid};
