package ${basepackage}.service.impl;
<#include "/custom.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#--   assign pkJavaType = table.idColumn.javaType  ---> 
/**
 * 
 * 曹文平欢迎你使用本模板
 *
 */
import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.service.${className}Service;


import cn.com.oa.common.service.impl.BaseServiceImpl;
import javax.annotation.Resource;  //注解
import org.springframework.stereotype.Service;  //注解


@Service("${className?uncap_first}Serivce")
public class ${className}ServiceImpl extends BaseServiceImpl<${className}> implements ${className}Service {
	
		private ${className}Dao  dao;		
		
		@Resource
		public void set${className}Dao( ${className}Dao dao) {		
			super.setDAO(dao); //注入父类
			this.dao = dao;
		}	
		
}


