#FROM命令告诉docker我们构建的镜像是以哪个(发行版)镜像为基础的
FROM centos:7

#RUN命令后面接要执行的命令，比如，我们想在镜像中安装vim，只需在Dockfile中写入RUN yum install -y vim
#安装wget
RUN yum install -y wget

#tar命令的-C参数作用：解压到指定目录，其有效期在下一次-C命令之前
#安装jdk
RUN mkdir /opt/software
RUN mkdir /opt/java
#--no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie":wget避免用户校验,如果不加则下载的压缩包有问题
RUN wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" -P /opt/software http://download.oracle.com/otn-pub/java/jdk/8u152-b16/aa0333dd3019491ca4f6ddbe78cdb6d0/jdk-8u152-linux-x64.tar.gz
#RUN tar -xzf jdk-8u152-linux-x64.tar.gz -C /opt/softwore && rm -rf jdk-8u152-linux-x64.tar.gz
RUN tar -zxvf /opt/software/jdk-8u152-linux-x64.tar.gz -C /opt/java

#安装tomcat
RUN mkdir /opt/tomcat
RUN wget -P /opt/software http://archive.apache.org/dist/tomcat/tomcat-8/v8.5.9/bin/apache-tomcat-8.5.9.tar.gz
RUN tar -zxvf /opt/software/apache-tomcat-8.5.9.tar.gz -C /opt/tomcat

#设置jdk环境变量
ENV JAVA_HOME /opt/java/jdk1.8.0_152
ENV PATH $PATH:$JAVA_HOME/bin
#开启tomcat端口
EXPOSE 8080
#启动tomcat
CMD ["/opt/tomcat/apache-tomcat-8.5.9/bin/catalina.sh","run"]
