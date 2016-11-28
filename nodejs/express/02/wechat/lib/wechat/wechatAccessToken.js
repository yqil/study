/**
 * https模块，有wechat-api模块，这样更方便调用微信的接口
 */
var https = require('https');
/**
 * 时间操作模块
 */
var moment = require('moment');
/**
 * 微信常量
 */
var wechatProperties = require('../../config/wechatProperties');
/**
 * 缓存
 */
var cache = require('./cacheObj');

var getAccessToken = function() {
	return new Promise(function(resolver, reject) {
		console.log(cache.generateTime);
		console.log(Date.now());
		var isExpiress = true;
		if(cache.generateTime && (Date.now() - cache.generateTime < cache.expiress)){
			isExpiress = false;
		}
		if(!cache.accessToken && isExpiress) {
			var req = https.get(wechatProperties.getAccessToken, function(res) {
				var bodyChunks = '';
				res.on('data', function(chunk) {
					bodyChunks += chunk;
				}).on('end', function() {
					var body = JSON.parse(bodyChunks);
					cache.accessToken = body.errcode ? null : body.access_token;
//					cache.generateTime = moment().format('YYYY-MM-DD, hh:mm:ss');
					cache.generateTime = Date.now();
					resolver(cache.accessToken);
				})
			});

			req.on('error', function(e) {
				console.log('ERROR: ' + e.message);
				reject(e);
			});
		} else {
			console.log("从缓存中获取access_token:"+cache.accessToken);
			resolver(cache.accessToken);
		}
	});
};

module.exports = {getAccessToken:getAccessToken};