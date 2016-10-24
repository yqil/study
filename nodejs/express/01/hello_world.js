//express_demo.js 文件
var express = require('express');
var app = express();

/**
 * 设置静态文件路径
 */
app.use(express.static('public'));

app.get('/', function (req, res) {
   res.send('Hello World');
})

var server = app.listen(8081, function () {

  var host = server.address().address
  var port = server.address().port
	
	console.log(server.address());
  console.log("应用实例，访问地址为 http://%s:%s", host, port)

});