//express_demo.js 文件
var express = require('express');
var app = express();
/**
 * node.js 中间件，用于处理 JSON, Raw, Text 和 URL 编码的数据。
 */
var bodyParser = require('body-parser');
/**
 * fs模块用于对系统文件及目录进行读写操作
 */
var fs = require("fs");
/**
 * node.js 中间件，用于处理 enctype="multipart/form-data"（设置表单的MIME编码）的表单数据。
 */
var multer = require('multer');
/**
 * htpp模块
 */
var http = require('http');

// 创建 application/x-www-form-urlencoded 编码解析
var urlencodedParser = bodyParser.urlencoded({
	extended: false
})

/**
 * 设置静态文件路径
 */
app.use(express.static('public'));

app.use(multer({
	dest: '/tmp/'
}).array('image'));
/**
 * 进入getTest.html页面
 */
app.get('/getTest.html', function(req, res) {
	//	console.log(staticFilePath);
	res.sendFile(__dirname + "/public/view/" + "getTest.html");
});
/**
 * 处理getTest请求
 */
app.get('/getTest', function(req, res) {

	// 输出 JSON 格式
	response = {
		first_name: req.query.first_name,
		last_name: req.query.last_name
	};
	console.log(response);
	res.end(JSON.stringify(response));
});
/**
 * 处理post请求
 */
app.post('/postTest', urlencodedParser, function(req, res) {
	// 输出 JSON 格式
	response = {
		first_name: req.body.first_name,
		last_name: req.body.last_name
	};
	console.log(response);
	res.end(JSON.stringify(response));
});
/**
 * 文件上传
 */
app.post('/file_upload', function(req, res) {

	console.log(req.files[0]); // 上传的文件信息

	var des_file = __dirname + "/" + req.files[0].originalname;
	console.log(des_file);
	fs.readFile(req.files[0].path, function(err, data) {
		fs.writeFile(des_file, data, function(err) {
			if(err) {
				console.log(err);
			} else {
				response = {
					message: 'File uploaded successfully',
					filename: req.files[0].originalname
				};
			}
			console.log(response);
			res.end(JSON.stringify(response));
		});
	});
});

app.get('/sendHtppGetTest', function(reqq, ress) {
	var options = {
		hostname: '120.25.91.208',
		port: 28010,
		path: '/dg/getLocationValueById.do?id=110000',
		method: 'GET'
	};

	var req = http.request(options, function(res) {
		console.log('STATUS: ' + res.statusCode);
		console.log('HEADERS: ' + JSON.stringify(res.headers));
		res.setEncoding('utf8');
		res.on('data', function(chunk) {
			console.log('BODY: ' + chunk);
			//	        ress.setEncoding('utf8');
			ress.end(chunk);
		});
	});

	req.on('error', function(e) {
		console.log('problem with request: ' + e.message);
	});

	req.end();
});

app.get('/sendHtppPostTest', function(reqq, ress) {
	var data = {
		defaultAddress: {
			address: "导购测试222",
			receiver_name: "导购测试222",
			phone: null,
			province: "110",
			city: "11001",
			area: "1100101",
			street: "1100101001"
		},
		phone: "18617078889",
		user_id: null,
		nick_name: "导购测试999222",
		level: null,
		mmh: null
	}; //这是需要提交的数据

	var content = JSON.stringify(data);

	var options = {
		hostname: '120.25.91.208',
		port: 28010,
		path: '/dg/addOrUpdateUserInfo.do',
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
		}
	};

	var req = http.request(options, function(res) {
		console.log('STATUS: ' + res.statusCode);
		console.log('HEADERS: ' + JSON.stringify(res.headers));
		res.setEncoding('utf8');
		res.on('data', function(chunk) {
			console.log('BODY: ' + chunk);
			ress.end(chunk);
		});
	});

	req.on('error', function(e) {
		console.log('problem with request: ' + e.message);
	});

	// write data to request body  
	req.write("params=" + content);
	req.end();
});

var server = app.listen(8081, function() {

	var host = server.address().address
	var port = server.address().port

	console.log(server.address());
	console.log("应用实例，访问地址为 http://%s:%s", host, port)

});