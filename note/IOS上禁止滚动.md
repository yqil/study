���ã�
     addEventListener()��removeEventListener()���ڴ���ָ����ɾ���¼�������������

     ���Ƕ�����3���������¼������¼�����ĺ����Ͳ���ֵ��

     ����ֵ������true����ʾ�ڲ���׶ε����¼�������������false����ʾ��ð�ݽ׶ε����¼��������

ʾ����

�������ƶ��ˣ������ֹ�����¼�
Ҫ��body������¼�������򣬿���ʹ�����д��룺
document.body.addEventListener('touchmove', function (event) {
    event.preventDefault();
},false)��

ͨ��addEventListener()��ӵ��¼��������ֻ��ʹ��removeEventListener()���Ƴ����Ƴ�ʱ����Ĳ�������Ӵ������ʱʹ�õĲ�����ͬ����Ҳ��ζ��ͨ��addEventListener()��ӵ����������޷��Ƴ��������÷�ʾ����
document.body.addEventListener('touchmove', function (event) {
    event.preventDefault();
},false);

document.body.removeEventListener('touchmove', function (event) {
    event.preventDefault();
},false);

��������У���ʹ��addEventListener()���һ���¼����������Ȼ����removeEventListener(0�ǿ���ʹ������ͬ�Ĳ�������ʵ���ϣ��ڶ��������봫��addEventListener()�е���һ����ȫ��ͬ�ĺ�����������removeEventListener()�е��¼���������������봫addEventListener()�е���ͬ��
��ȷ�÷�ʾ����
function bodyScroll(event){
    event.preventDefault();
}
document.body.addEventListener('touchmove',bodyScroll,false);
document.body.removeEventListener('touchmove',bodyScroll,false);

��д����������û�����⣬����Ϊ��addEventListener()��removeEventListener()��������ͬ�ĺ��������ú������ܴ������������÷�ʾ����
function bodyScroll(event){
    event.preventDefault();
}
document.body.addEventListener('touchmove',bodyScroll(event),false);
document.body.removeEventListener('touchmove',bodyScroll(event),false);

�ܽ᣺
һ����ͬ�¼��󶨺ͽ������Ҫʹ�ù��ú�����
�������ú������ܴ�������
