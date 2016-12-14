! function() {
	var vm = new Vue({
		el: "#wxCenter",
		data: {
			photo: null,
			nickName: null,
			integral: 0
		},
		mounted: function(){
//			this.getUserById();
			var that = this;
			$.getJSON('/center', null, function(data, status, xhr){
				that.nickName = data.content.nickName;
			});
		},
		methods: {
			accessPerson: function(){
				window.location.href="/person/index";
			}
		}
	});
}();