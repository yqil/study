! function() {
	var vm = new Vue({
		el: "body",
		data: {
			phone: null,
			validCode: null,
			pwd: null
		},
		methods: {
			bindUser: function() {
				var phone = this.phone;
				var validCode = this.validCode;
				var pwd = this.pwd;
				var data = {
					phone: this.phone,
					validCode: this.validCode,
					pwd: this.pwd
				};
				console.log(data);
				/**
				 * 注意：后台必须返回json格式的数据
				 */
				$.getJSON('/bind/submit', data, function(data, status, xhr){
					console.log(data);
					if(data && data.status == true){
						window.location.href="/bind/center";
					}else {
						alert(data.msg);
					}
				});
			}
		}
	});
}();