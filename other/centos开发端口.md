#开放端口:8080 <br />
/sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT <br />
#将更改进行保存 <br />
/etc/rc.d/init.d/iptables save <br />
#重启防火墙以便改动生效:(或者直接重启系统) <br />
/etc/init.d/iptables restart <br />
<br />
也可以在/etc/sysconfig/iptables中增加一行： <br />
-A RH-Firewall-1-INPUT -m state –state NEW -m tcp -p tcp –dport 8080 -j ACCEPT <br />
#永久关闭防火墙 <br />
chkconfig –level 35 iptables off  <br />
<br />
#关闭防火墙 <br />
/etc/init.d/iptables stop <br />
service iptables stop # 停止服务 <br />
#查看防火墙信息 <br />
/etc/init.d/iptables status <br />