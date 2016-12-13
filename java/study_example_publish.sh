#!/bin/bash
source /etc/profile

cd /data/github/study/java
git checkout -f
git pull

cd /data/github/study/java/study-example
mvn clean install -Dmaven.test.skip=true -Pdevelopment

sh /data/webservers/tomcat-8080-study-example/bin/catalina.sh stop --force

kill -9 `netstat -nlp | grep 8080 | awk '{print $7}'|awk -F/ '{print $1}'`

rm -rf /data/webservers/tomcat-8080-study-example/webapps/*

cp -r /data/github/study/java/study-example/study-example-web/target/study-example-web.war /data/webservers/tomcat-8080-study-example/webapps/ROOT.war
sh /data/webservers/tomcat-8080-study-example/bin/catalina.sh start
tail -f /data/webservers/tomcat-8080-study-example/logs/catalina.out
