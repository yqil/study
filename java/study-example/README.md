spring mvc+mybatis的简单maven工程，主要包含以下内容:<br>
1、不同部署环境不同配置：\r\n
	a.不同部署环境配置不同的数据库连接，参见study-example-web的pom.xml；
	b.有时候我们可能会调用其他系统的api，然而不同部署环境下，该api的url地址不同，参见PropertiesUtil.java
2、aop事务配置
3、定时任务

