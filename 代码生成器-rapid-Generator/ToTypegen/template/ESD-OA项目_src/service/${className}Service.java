package ${basepackage}.service;
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
import cn.com.oa.common.service.BaseService;



public interface ${className}Service extends BaseService<${className}> {


}
