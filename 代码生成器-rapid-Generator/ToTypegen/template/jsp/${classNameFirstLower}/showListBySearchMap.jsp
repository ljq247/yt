<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case>
<%@ page contentType="text/html; charset=UTF-8" errorPage="/base/jsp/common/CommonError.jsp"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="h" uri="/bdp-html" %>
<%@taglib prefix="bdp" uri="/bdp-base" %>
<%
response.setHeader("Pragma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/base/jsp/common/CommonListTop.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模块-表名</title>
<link href="<@jspEl 'ctx' />/base/css/base.css" rel="stylesheet" type="text/css" />
<link href="<@jspEl 'ctx' />/base/css/common.css" rel="stylesheet" type="text/css" />
<link href="<@jspEl 'ctx' />/base/css/<@jspEl 'customTheme' />.css" rel="stylesheet" type="text/css" />
<script src="<@jspEl 'ctx' />/base/js/jquery/jquery.js" type="text/javascript"></script>
<script src="<@jspEl 'ctx' />/base/js/base.js" type="text/javascript"></script>
<script src="<@jspEl 'ctx' />/base/js/common/FormFunction.js" type="text/javascript"></script><!-- 公用的按钮函数 -->
</head>
<body class="rightBody">
<form name="searchForm" method="post" action="">
<table width="100%" class="title" border="0" cellspacing="0" cellpadding="0">
<tr>
	<th colspan="2"><img src="<@jspEl 'ctx' />/base/images/public/titleicon.gif" width="16" height="16" alt="图标 " class="icon" /> 临时人员管理-主管理界面</th>
</tr>
	<tr>
		<td class="vm">
			<div class="" id="ord_sear">
				<span class="fl lh200 mr10">姓名：<s:textfield name="searchValue['name']" cssClass="input" style="width:90px"/>&nbsp;</span>
				<input class="fl btnSo mr10 vm" type="button" value="搜索" onclick="defaultEvent('search')">
				<input class="fl btn2 mr10 vm" type="button" value="重置" onclick="clearSearchKeyWord();" class="btn2">
			</div>
		</td>	
		<td align="right">
				<input name="add" type="button" class="btn2 mr10" value="新增" onClick="defaultEvent('add',750,500)">
				<input name="del" type="button" class="btn2" value="删除" onClick="defaultEvent('del')">
		</td>		
	</tr>
</table>
<!--搜索 end-->
<!-- 自定义 table -->
<h:table>
	<h:column headerTitle="<input type='checkbox' name='slectAll' value='checkbox' onclick='selectAll(this.checked);'>" align="center" width="32">
		<input type="checkbox" name="selectedRow" value="<s:property value="id"/>" >
	</h:column>
	<#list table.columns as c>
		<#if c.sqlName="id">
			<#-- id不输出 -->
		<#else>								
			<h:column headerTitle="${c.columnNameLower}" width="60" align="left">
				<s:property value="${c.columnNameLower}"/>
			</h:column>	
		</#if>
	</#list> 
	<h:column headerTitle="操作" width="60" align="center">			
			<a href="javascript:FormFunction.editSingle('<s:property value="id"/>',null,750,500);" class="linkorange">修改</a>&nbsp;
			<a href="javascript:FormFunction.viewSingle('<s:property value="id"/>');" class="linkorange">查看</a>&nbsp;
	</h:column>
</h:table>	
<!--   end自定义 table  -->
<table width="100%" class="pageDown" border="0" cellspacing="0" cellpadding="0">
  <tr><td align="right"><h:pager/></td></tr>
</table>
<!-- end页码 -->
</form>
<script>
	var addUrl =  "<@jspEl 'ctx' />/${modelname}/${classNameLower}!editForCreate.action?pageNo=<@jspEl 'pageNo'/>";//表单列表add 的url地址
	var delUrl =  "<@jspEl 'ctx' />/${modelname}/${classNameLower}!del.action";//表单列表del的url地址
	var viewUrl = "<@jspEl 'ctx' />/${modelname}/${classNameLower}!details.action?pageNo=<@jspEl 'pageNo'/>";//表单列表view的url地址
	var editUrl = "<@jspEl 'ctx' />/${modelname}/${classNameLower}!editForUpdate.action?pageNo=<@jspEl 'pageNo'/>";//表单列表edit的url地址
	var listUrl = "<@jspEl 'ctx' />/${modelname}/${classNameLower}!showListBySerachMap.action?pageNo=<@jspEl 'pageNo'/>";//表单列表list 的url地址,用来作为搜索地址
	
	/**
	*所有按钮JS函数的入口
	*
	*/
	function defaultEvent(eventType,width,height) {
		FormFunction.defaultEvent(eventType,width,height);//默认的处理函数，需自定义时自己写 在PublicFunction.js里
	}
	   //设置列表标题!
	var  pm= ${r"${jsonPm}"}[0]; //后台转换json对象
	 $('thead').find('th').each(function(){
		   var per=$(this).text();
		   var thtitle= pm[per]; 
			if(null!=thtitle){
				 $(this).text(thtitle);
	 		}	
	  });
	///end 设置 列表标题
</script>
<%@ include file="/base/jsp/common/CommonListFoot.jsp"%>
</body>
</html>
