#���Ŷ˿�:8080
/sbin/iptables -I INPUT -p tcp --dport 8080 -j ACCEPT
#��������ǽ�Ա�Ķ���Ч:(����ֱ������ϵͳ)
/etc/init.d/iptables restart
#�����Ľ��б���
/etc/rc.d/init.d/iptables save

Ҳ������/etc/sysconfig/iptables������һ�У�
-A RH-Firewall-1-INPUT -m state �Cstate NEW -m tcp -p tcp �Cdport 8080 -j ACCEPT
#���ùرշ���ǽ
chkconfig �Clevel 35 iptables off 

#�رշ���ǽ
/etc/init.d/iptables stop
service iptables stop # ֹͣ����
#�鿴����ǽ��Ϣ
/etc/init.d/iptables status