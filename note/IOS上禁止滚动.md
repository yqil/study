作用：
     addEventListener()与removeEventListener()用于处理指定和删除事件处理程序操作。

     它们都接受3个参数：事件名、事件处理的函数和布尔值。

     布尔值参数是true，表示在捕获阶段调用事件处理程序；如果是false，表示在冒泡阶段调用事件处理程序。

示例：

环境：移动端，界面禁止触摸事件
要在body上添加事件处理程序，可以使用下列代码：
document.body.addEventListener('touchmove', function (event) {
    event.preventDefault();
},false)；

通过addEventListener()添加的事件处理程序只能使用removeEventListener()来移除；移除时传入的参数与添加处理程序时使用的参数相同。这也意味着通过addEventListener()添加的匿名函数无法移除，错误用法示例：
document.body.addEventListener('touchmove', function (event) {
    event.preventDefault();
},false);

document.body.removeEventListener('touchmove', function (event) {
    event.preventDefault();
},false);

这个例子中，我使用addEventListener()添加一个事件处理程序。虽然调用removeEventListener(0是看似使用了相同的参数，但实际上，第二个参数与传入addEventListener()中的那一个完全不同的函数。而传入removeEventListener()中的事件处理程序函数必须与传addEventListener()中的相同。
正确用法示例：
function bodyScroll(event){
    event.preventDefault();
}
document.body.addEventListener('touchmove',bodyScroll,false);
document.body.removeEventListener('touchmove',bodyScroll,false);

重写后的这个例子没有问题，是因为在addEventListener()和removeEventListener()中用来相同的函数。共用函数不能带参数，错误用法示例：
function bodyScroll(event){
    event.preventDefault();
}
document.body.addEventListener('touchmove',bodyScroll(event),false);
document.body.removeEventListener('touchmove',bodyScroll(event),false);

总结：
一：相同事件绑定和解除，需要使用共用函数；
二：共用函数不能带参数；
