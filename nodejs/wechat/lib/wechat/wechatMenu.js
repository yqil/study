/**
 * https模块
 */
var https = require('https');
/**
 * 微信常量
 */
var wechatProperties = require('../../config/wechatProperties');

var wechatAccessToken = require('.//wechatAccessToken');

/**
 * wechat-api模块
 */
var API = require('wechat-api');

var api = new API(wechatProperties.account.appId, wechatProperties.account.appSecret);

var menu = {
	"button": [{
		"type": "view",
		"name": "会员中心",
		"url": wechatProperties.memberUrl
	}]
};

module.exports = {
	createMenu: function() {
		return new Promise(function(resolver, reject) {
			wechatAccessToken.getAccessToken().then(function(data) {
				console.log("获取access_token为：" + data);
				var url = wechatProperties.createMenu + data;
				api.createMenu(menu, function(err, result) {
					console.log("创建菜单错误消息:" + err);
					if(!err) {
						console.log("创建菜单返回消息:" + result);
						resolver(result);
					} else {
						reject(err);
					}
				});
			}).catch(function(data) {
				reject('获取access_token出现异常:' + data);
			});
		});
	}
};