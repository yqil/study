yql-spring-boot-auto模块：
1、mybatis自动生成代码模块
2、自动生成model、mapper接口、sql文件
   model生成路径为：yql-spring-boot-common模块的yql.spring.boot.common.model.auto包中
   mapper接口生成路径为：yql-spring-boot-biz模块的yql.spring.boot.biz.dao.auto包中
   sql文件生成路径为：yql-spring-boot-biz模块的resources中
3、自动生成代码的方法如下：
   一：参考t_user_plugin类的代码编写java类
   二：参考resources中的t_user-generatorConfig.xml文件编写上面一步中java文件对应的xml。
       注意：xml中注意自动生成的代码路径与项目在本地磁盘的路径保持一致
   三：执行第一步中的java文件即可，至此自动代码生成完成。

yql-spring-boot-common模块：公共模块，主要包含自动代码生成的model和自己编写的model、service接口类、util类
yql-spring-boot-biz模块：业务模块，主要包含自动代码生成的mapper、sql文件、自己编写的mybatis对应的dao和sql文件、service实现类
						 注意：自动生成的mapper和自己编写的dao需要加上@Mapper
yql-spring-boot-web模块：web模块，主要包含controller类、springboot启动类，注意springboot启动类放在yql.spring.boot包中，即放在controller、service、mapper、dao等注解文件的上一层目录。
                         启动类如果不如此配置，该项目的配置会导致无法扫描对应的注解类，当然有其他的解决，这里后续项目单独配置