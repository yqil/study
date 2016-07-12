页面ng-click中加入$event.target，如下：
"<div>属性名：<input type="text" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="移除" ng-click="remove($event.target)"/></div>"
对应click方法中的写法如下：
"$scope.remove = function(target){
	$(target);//获取当前元素
	$(target).parent();//获取父级元素
	$(target).parent().remove();//移除父级元素，当然当前元素也会被移除
};"