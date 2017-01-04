#!/bin/bash
source /etc/profile

cd /data/github/study/java/dubbo
git checkout -f
git pull

cd /data/github/study/java/dubbo/dubbo-example
mvn clean install -Dmaven.test.skip=true -Pdevelopment

cd /data/github/study/java/dubbo/dubbo-example/dubbo-example-dsc
mvn clean install -Dmaven.test.skip=true -Pdevelopment

#sh /data/webservers/tomcat-9025-dubbo-example/bin/catalina.sh stop --force

kill -9 `netstat -nlp | grep 9025 | awk '{print $7}'|awk -F/ '{print $1}'`

rm -rf /data/webservers/tomcat-9025-dubbo-example-dsc/webapps/*

cp -r /data/github/study/java/dubbo-example/dubbo-example-dsc/target/dubbo-example-dsc.war /data/webservers/tomcat-9025-dubbo-example-dsc/webapps/ROOT.war
sh /data/webservers/tomcat-9025-dubbo-example-dsc/bin/catalina.sh start
tail -f /data/webservers/tomcat-9025-dubbo-example-dsc/logs/catalina.out
