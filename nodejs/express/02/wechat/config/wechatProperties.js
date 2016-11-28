var wechatProperties = {
	account: {
		appId: "wx70b5a64e0dea5eeb",
		appSecret: "d4624c36b6795d1d99dcf0547af5443d"
	}
};

wechatProperties.memberUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+wechatProperties.account.appId
	+"&redirect_uri=http%3a%2f%2fyql66.6655.la&response_type=code&scope=snsapi_base&state=123#wechat_redirect";

wechatProperties.getAccessToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" +
	wechatProperties.account.appId + "&secret=" + wechatProperties.account.appSecret;
	
wechatProperties.createMenu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
	
wechatProperties.getOpenidUrl = function(code){
	return "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+wechatProperties.account.appId
	+"&secret="+wechatProperties.account.appSecret+"&code="+code+"&grant_type=authorization_code";
}



module.exports = wechatProperties;