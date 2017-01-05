#!/bin/bash
source /etc/profile

cd /data/github/study/java/dubbo
git checkout -f
git pull

cd /data/github/study/java/dubbo/dubbo-example
mvn clean install -Dmaven.test.skip=true -Pdevelopment

cd /data/github/study/java/dubbo/dubbo-example/dubbo-example-web
mvn clean install -Dmaven.test.skip=true -Pdevelopment

#sh /data/webservers/tomcat-9035-dubbo-example/bin/catalina.sh stop --force

kill -9 `netstat -nlp | grep 9035 | awk '{print $7}'|awk -F/ '{print $1}'`

rm -rf /data/webservers/tomcat-9035-dubbo-example-web/webapps/*

cp -r /data/github/study/java/dubbo/dubbo-example/dubbo-example-web/target/dubbo-example-web.war /data/webservers/tomcat-9035-dubbo-example-web/webapps/ROOT.war
sh /data/webservers/tomcat-9035-dubbo-example-web/bin/catalina.sh start
tail -f /data/webservers/tomcat-9035-dubbo-example-web/logs/catalina.out
