package ${basepackage}.dao.impl;
<#include "/custom.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#--   assign pkJavaType = table.idColumn.javaType  ---> 
/*******************************************************************************
曹文平欢迎你使用次模板
 *******************************************************************************/
import ${basepackage}.model.${className};
import ${basepackage}.dao.${className}Dao;

import cn.com.oa.common.dao.impl.BaseDAOHibernate;
import java.util.List;


public class ${className}DaoImpl extends BaseDAOHibernate< ${className}> implements  ${className}Dao {

	@Override
	protected Class getEntityClass() {
		
		return  ${className}.class;
	}
}