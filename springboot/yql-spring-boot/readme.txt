yql-spring-boot-autoģ�飺
1��mybatis�Զ����ɴ���ģ��
2���Զ�����model��mapper�ӿڡ�sql�ļ�
   model����·��Ϊ��yql-spring-boot-commonģ���yql.spring.boot.common.model.auto����
   mapper�ӿ�����·��Ϊ��yql-spring-boot-bizģ���yql.spring.boot.biz.dao.auto����
   sql�ļ�����·��Ϊ��yql-spring-boot-bizģ���resources��
3���Զ����ɴ���ķ������£�
   һ���ο�t_user_plugin��Ĵ����дjava��
   �����ο�resources�е�t_user-generatorConfig.xml�ļ���д����һ����java�ļ���Ӧ��xml��
       ע�⣺xml��ע���Զ����ɵĴ���·������Ŀ�ڱ��ش��̵�·������һ��
   ����ִ�е�һ���е�java�ļ����ɣ������Զ�����������ɡ�

yql-spring-boot-commonģ�飺����ģ�飬��Ҫ�����Զ��������ɵ�model���Լ���д��model��service�ӿ��ࡢutil��
yql-spring-boot-bizģ�飺ҵ��ģ�飬��Ҫ�����Զ��������ɵ�mapper��sql�ļ����Լ���д��mybatis��Ӧ��dao��sql�ļ���serviceʵ����
						 ע�⣺�Զ����ɵ�mapper���Լ���д��dao��Ҫ����@Mapper
yql-spring-boot-webģ�飺webģ�飬��Ҫ����controller�ࡢspringboot�����࣬ע��springboot���������yql.spring.boot���У�������controller��service��mapper��dao��ע���ļ�����һ��Ŀ¼��
                         �����������������ã�����Ŀ�����ûᵼ���޷�ɨ���Ӧ��ע���࣬��Ȼ�������Ľ�������������Ŀ��������