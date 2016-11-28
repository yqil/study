$.extend({
	myAjax: function(url, data, type, complete, success, beforeSend, error) {
		$.ajax({
			url: url,
			data: data || {},
			type: type || "get",
			async: true,
			success: success || function(res) {},
			timeout: 60000,
			beforeSend: beforeSend || function() {},
			dataType: "json",
			complete: complete || function(XMLHttpRequest, status) {　　　　},
			error: error || function(XMLHttpRequest, status) {
				//超时,status还有success,error等值的情况
				if(XMLHttpRequest.status == '504') {　　　　　
					ext.my_prompt.showCustomInfo(null, "请求超时，请在更好的环境下重新尝试！");
					ext.my_prompt.close();　　　　
				}
			}
		});
	},
});