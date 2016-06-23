package ${basepackage}.action;
<#include "/custom.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#--   assign pkJavaType = table.idColumn.javaType  ---> 
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;

import java.util.Date;
import java.util.Map;

import cn.com.oa.birthdaybless_test.model.TemporaryPersonManger;
import cn.com.oa.common.action.BaseAction;
import cn.com.oa.common.config.SysProperties;
import cn.com.oa.common.util.SearchMap;
import cn.com.oa.core.exception.ServiceException;
import cn.com.oa.core.page.PageResult;
import cn.com.oa.core.util.StringUtil;
import cn.com.oa.cwputil.annotation.ThMap;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;


public class ${className}Action  extends   BaseAction{	
	
	@Autowired
	private ${className}Service service;
	
	// private CrudActionSupport  a;
	
	private ${className}  bean;
	private Map<String  ,String > pm=ThMap.getmap(${className}.class);
	private  JSONArray jsonPm = JSONArray.fromObject(pm);
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Map<String, String> getPm() {
		return pm;
	}
	public JSONArray getJsonPm() {
		return jsonPm;
	}
	public ${className} getBean() {
		return bean;
	}

	public void setBean(${className} bean) {
		this.bean = bean;
	}
	///自己创建的方法
	public String showListBySerachMap() throws ServiceException{
			
	     SearchMap searchMap = new SearchMap();
//	       searchMap.like("a.name", "%" + StringUtil.trimToEmpty((String)getSearchValue().get("name")) + "%");
//	       searchMap.addOrder("a.createTime",searchMap.ORDER_DESC);
		
	     PageResult pageResult = service.findObjectsForPage(getPageNo(), getPageSize(), searchMap);
	     setPageResult(pageResult);
	     
		return "showListBySerachMap";
	}
	
	public String details() throws ServiceException{
		bean= service.findObjectById(id);		
		return "details";
	}
	public String editForCreate(){

		return "editForCreate";
	}
	public String create() throws ServiceException{  //创建一个
		
		bean.setCreateTime(new Date());
		service.create(bean);
		return showListBySerachMap();
	}
	public String editForUpdate() throws ServiceException{
		
		bean = service.findObjectById(id);
		return "editForUpdate";
	}
	public String update()throws ServiceException{
		
		service.update(bean);
		return  showListBySerachMap();
	}
	
	public String del()throws ServiceException{  //删除
				
		String[] selectedRow2 = getSelectedRow();
		service.delete(selectedRow2);		
		return  showListBySerachMap();
	}
	
}
