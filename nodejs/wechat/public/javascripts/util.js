Vue.prototype.getQueryString = function(name){
	if(!name){
		return null;
	}
	
	var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)','i');
	var r = window.location.search.substr(1).match(reg);
	
	if (r !== null){
		return (r[2]); 
	} 
	
	return null;
};