package ${basepackage}.model;
<#include "/custom.include">
<#assign className = table.className>
<#assign classNameFirstLower = className?uncap_first>
<#assign classNameLowerCase =className?lower_case>
<#--   assign pkJavaType = table.idColumn.javaType  ---> 
//曹文平欢迎你使用本程序
import java.io.Serializable;
import cn.com.oa.cwputil.annotation.Th;
import java.util.Date;
/**
 *   
 */
public class ${className}  implements Serializable
{
	
	
	//columns START
	<#list table.columns as column>
	@Th(chinaName="${column.remark}")
	private ${column.javaType} ${column.columnNameLower};// ${column.remarks}
	</#list>
	//columns END
	
	// 构造函数
	public ${className}()
	{
	}
	
	<#list table.columns as column>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
		
	</#list>
	

}