! function() {
	var vm = new Vue({
		el: "#wxCenter",
		data: {
			photo: null,
			nickName: null,
			integral: 0,
            dialogMsg: "服务器开小差了，请稍后尝试~"
		},
		mounted: function(){
			var that = this;
			$.getJSON('/center', null, function(data, status, xhr){
				if(data && data.status){
					that.nickName = data.userInfo && data.userInfo.nickName;
					that.integral = (data.accountInfo || 0) && data.accountInfo.accountBalance;
				}else {
					that.myDialog.showDialog();
				}
			});
		},
		methods: {
			accessPerson: function(){
				window.location.href="/person/index";
			}
		}
	});
}();