#开放端口:8080
/sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
#重启防火墙以便改动生效:(或者直接重启系统)
/etc/init.d/iptables restart
#将更改进行保存
/etc/rc.d/init.d/iptables save

也可以在/etc/sysconfig/iptables中增加一行：
-A RH-Firewall-1-INPUT -m state –state NEW -m tcp -p tcp –dport 8080 -j ACCEPT
#永久关闭防火墙
chkconfig –level 35 iptables off 

#关闭防火墙
/etc/init.d/iptables stop
service iptables stop # 停止服务
#查看防火墙信息
/etc/init.d/iptables status