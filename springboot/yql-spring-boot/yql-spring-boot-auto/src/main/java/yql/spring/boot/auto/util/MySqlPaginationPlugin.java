package yql.spring.boot.auto.util;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class MySqlPaginationPlugin extends PluginAdapter{

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {
		// add field, getter, setter for limit clause
		addPage(topLevelClass, introspectedTable, "page");
		return super.modelExampleClassGenerated(topLevelClass,introspectedTable);
	}
	
    /**
     * @param topLevelClass
     * @param introspectedTable
     * @param name
     */
    private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable,String name) {
        topLevelClass.addImportedType(new FullyQualifiedJavaType("yql.spring.boot.common.util.mybatis.Page"));
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(new FullyQualifiedJavaType("yql.spring.boot.common.util.mybatis.Page"));
        field.setName(name);
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(new FullyQualifiedJavaType("yql.spring.boot.common.util.mybatis.Page"), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(new FullyQualifiedJavaType("yql.spring.boot.common.util.mybatis.Page"));
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }
    
    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
            IntrospectedTable introspectedTable) {
        XmlElement page = new XmlElement("if");
        page.addAttribute(new Attribute("test", "page != null"));
        page.addElement(new TextElement("limit #{page.begin} , #{page.length}"));
        element.addElement(page);
 
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }    
    /**
     * @Description xml中insertSelective方法不生成selectKey,即不生成自动获取主键的cdata
     * @author bm
     * @date 2016年11月11日 下午6:16:39
     * @param element
     * @param introspectedTable
     * @return
     * @lastModifier
     */
    public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,IntrospectedTable introspectedTable) {
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);  
    }
    /**
     * @Description xml中insert方法不生成selectKey,即不生成自动获取主键的cdata
     * @author bm
     * @date 2016年11月11日 下午6:17:32
     * @param element
     * @param introspectedTable
     * @return
     * @lastModifier
     */
    public boolean sqlMapInsertElementGenerated(XmlElement element,IntrospectedTable introspectedTable){
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);  
    }
    
	public boolean validate(List<String> arg0) {
		return true;
	}
}
