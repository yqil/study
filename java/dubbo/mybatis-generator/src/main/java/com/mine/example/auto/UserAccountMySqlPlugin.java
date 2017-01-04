package com.mine.example.auto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;

import com.mine.example.util.NameFormator;

public class UserAccountMySqlPlugin {
 
	public static void main(String[] args) throws IOException, XMLParserException {
		
        String configfile = "D:/mine/github/study/java/mybatis-generator/src/main/resources/userAccount-generatorConfig.xml";
        File configurationFile = new File(configfile);
        
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configurationFile);
        
        Context context = config.getContext("userAccount");
        List<TableConfiguration> tables = context.getTableConfigurations();
        for(TableConfiguration table : tables){
        	System.out.println(table.getTableName());
        }
        
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = context.getJavaModelGeneratorConfiguration();
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = context.getSqlMapGeneratorConfiguration();
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = context.getJavaClientGeneratorConfiguration();
        
        
		String tableName = tables.get(0).getTableName();
		String className = NameFormator.toUUCase(tableName);
		try{
			String fileName = sqlMapGeneratorConfiguration.getTargetProject()+"\\"+sqlMapGeneratorConfiguration.getTargetPackage().replaceAll("\\.", "\\\\");
			System.out.println(fileName);
			 File[] dels = new File(fileName).listFiles();
			 {
				 if(dels != null){
					 for(File del : dels){
						 if(del.getName().equals(className+"Mapper.xml")){
						     System.out.println(del.getName()+"删除了.");
							 del.delete();
						 }
					 }
				 }
			 }
			 dels = new File(javaClientGeneratorConfiguration.getTargetProject()+"\\"+javaClientGeneratorConfiguration.getTargetPackage().replaceAll("\\.", "\\\\")).listFiles();
			 {
				 if(dels != null){
					 for(File del : dels){
						 if(del.getName().equals(className+"Mapper.java") ){
						     System.out.println(del.getName()+"删除了.");
							 del.delete();
						 }
					 }
				 }
			 }		 
			 dels = new File(javaModelGeneratorConfiguration.getTargetProject()+"\\"+javaModelGeneratorConfiguration.getTargetPackage().replaceAll("\\.", "\\\\")).listFiles();
			 {
				 if(dels != null){
					 for(File del : dels){
						 if(del.getName().equals(className+".java") || del.getName().equals(className+"Example.java") ){
						     System.out.println(del.getName()+"删除了.");
							 del.delete();
						 }
					 }
				 }
			 }			 
		}catch(Exception e){
			e.printStackTrace();
		}
         String[] arg = { "-configfile", configfile};  
         System.out.println();
         ShellRunner.main(arg);  
	}
}
