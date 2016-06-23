package ${basepackage}.dao;
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


import java.util.List;

import ${basepackage}.model.${className};//引入model
import cn.com.oa.common.dao.BaseDAO;  ///基础包

public interface ${className}Dao extends BaseDAO<${className}> {


	
}
