#���Ŷ˿�:8080 <br />
/sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT <br />
#�����Ľ��б��� <br />
/etc/rc.d/init.d/iptables save <br />
#��������ǽ�Ա�Ķ���Ч:(����ֱ������ϵͳ) <br />
/etc/init.d/iptables restart <br />
<br />
Ҳ������/etc/sysconfig/iptables������һ�У� <br />
-A RH-Firewall-1-INPUT -m state �Cstate NEW -m tcp -p tcp �Cdport 8080 -j ACCEPT <br />
#���ùرշ���ǽ <br />
chkconfig �Clevel 35 iptables off  <br />
<br />
#�رշ���ǽ <br />
/etc/init.d/iptables stop <br />
service iptables stop # ֹͣ���� <br />
#�鿴����ǽ��Ϣ <br />
/etc/init.d/iptables status <br />