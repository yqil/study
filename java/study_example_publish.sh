#!/bin/bash
source /etc/profile

cd /data/github/study/java
git pull .

cd /data/github/study/java/study-example
mvn clean install -Dmaven.test.skip=true

sh /data/webservers/tomcat-8080-study-example/bin/catalina.sh stop --force

rm -rf /data/webservers/tomcat-8080-study-example/webapps/*

cp -r /data/github/study/java/study-example/study-example-web/target/b2c-obs-web.war /data/webservers/tomcat-8080-study-example/webapps/ROOT.war
sh /data/webservers/tomcat-8080-study-example/bin/catalina.sh start
tail -f /data/webservers/tomcat-8080-study-example/logs/catalina.out
