<#include "/macro.include"/> 
<#include "/custom.include"/> 
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case>
<%@ page contentType="text/html; charset=UTF-8" errorPage="/base/jsp/common/CommonError.jsp"%>
<jsp:directive.page import="cn.com.oa.core.util.StringUtil"/>
<%@page import="java.util.List"%>
<%@page import="cn.com.oa.base.role.model.RoleView"%>
<%@page import="cn.com.oa.base.merge.model.Role"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="/bdp-html" %>
<%@taglib prefix="bdp" uri="/bdp-base" %>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/base/jsp/common/CommonEditTop.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统管理-修改人员信息</title>
<link href="<@jspEl 'ctx' />/base/css/base.css" rel="stylesheet" type="text/css" />
<link href="<@jspEl 'ctx' />/base/css/common.css" rel="stylesheet" type="text/css" />
<link href="<@jspEl 'ctx' />/base/css/<@jspEl 'customTheme'/>.css" rel="stylesheet" type="text/css" />
<link href="<@jspEl 'ctx' />/base/calendar/calendar-blue.css" rel="stylesheet" type="text/css">
<link href="<@jspEl 'ctx' />/base/datepicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" 
 	src="<@jspEl 'ctx' />/base/datepicker/WdatePicker.js" charset="utf-8"></script> <!-- 时间 ,还有上面css-->	
<script type="text/javascript" src="<@jspEl 'ctx' />/base/calendar/calendar.js"></script>
<script type="text/javascript" src="<@jspEl 'ctx' />/base/calendar/lang/calendar-zh.js"></script>
<script type="text/javascript" src="<@jspEl 'ctx' />/base/calendar/calendar-setup.js"></script>

<script src="<@jspEl 'ctx' />/base/js/jquery/jquery.js" type="text/javascript"></script>
<script src="<@jspEl 'ctx' />/base/js/jquery/jquery.metadata/jquery.metadata.js" type="text/javascript"></script><!--加载jquery扩展属性-->
<script src="<@jspEl 'ctx' />/base/js/jquery/jquery.validate/jquery.validate.js" type="text/javascript"></script><!-- 加载jquery-validate  -->
<script src="<@jspEl 'ctx' />/base/js/jquery/jquery.validate/localization/messages_cn.js" type="text/javascript"></script><!-- 加载jquery-validate语言  -->
<script src="<@jspEl 'ctx' />/base/js/base.js" type="text/javascript"></script>
<script src="<@jspEl 'ctx' />/base/js/validate/FormValidate.js" type="text/javascript"></script><!-- 加载通用验证  -->
<script type="text/javascript" src="<@jspEl 'ctx' />/base/js/common/FormFunction.js"></script><!-- 公用的按钮函数 -->
<script type="text/javascript" src="<@jspEl 'ctx' />/base/js/do.js"></script>
</head>
<body class="rightBody">
<form id="form2" name="form2" method="post" action="<@jspEl 'ctx' />/sys/person!addPerson.action">
    <table class="location" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr><td class="icon"></td><td>您现在所在的位置是：生日祝福语 &gt;&gt; 临时人员管理</td></tr>
    </table>
    <div class="tableH2">临时人员管理-新增</div>
    
    <table id="baseInfo" width="100%" class="list" border="0" cellpadding="0" cellspacing="0" >
    
    	<#list table.columns as c>
			<#if c.sqlName="id">
				<#-- id不输出 -->
			<#else>										
				<tr  class="check_r">
					<td width="43%" class="tdBg"><span class="fRed">*</span>${r"${"}pm.${c.columnNameLower}${r"}"}：</td>
					<td colspan="3">
						<#if c.javaType="java.util.Date">
							<s:textfield   name="bean.${c.columnNameLower}" id="${c.columnNameLower}" cssStyle="border:1px solid #e4e4e4;width:200px;" cssClass="Wdate" size="15"
                        									onfocus="WdatePicker({isShowClear:false,isShowClear:true,readOnly:true,dateFmt:'yyyy-MM-dd'})">
		                            <s:param name="value" >
		                            		<fmt:formatDate pattern="yyyy-MM-dd" value="${r"${"}bean.${c.columnNameLower}${r"}"}"/>    
                           			 </s:param>
							</s:textfield>
						<#else>
							<s:textfield   name="bean.${c.columnNameLower}" id="${c.columnNameLower}" cssClass="input" cssStyle="width:200px;"/>
						</#if>
					</td>
				</tr>
			</#if>
		</#list>
	</table>
	<div class="tc mt10">
		<input type="button" onClick="defaultEvent('save')" id="save" value="保存" class="btnB2" /> 
		&nbsp;&nbsp;<input type="button" name="Submit4" class="btnB2" value="返回" onClick="defaultEvent('exit')">
   </div>
</form>
<script>
var saveUrl = "<@jspEl 'ctx' />/${modelname}/${classNameLower}!create.action?pageNo=<@jspEl 'pageNo'/>";//表单列表save的url地址
var listUrl = "<@jspEl 'ctx' />/${modelname}/${classNameLower}!showListBySerachMap.action?pageNo=<@jspEl 'pageNo'/>";//表单列表list 的url地址,用来作为搜索地址

function check(){  // 验证函数	
	$(".check_r").each(function(){	
	 	var msg= $(this).children("td")[0].innerText;
		var textarea=  $(this).find("textarea,input");//验证的输入框!
		if(textarea.val()==""){
				alert(msg+"不能为空 ");
				throw "Err"; 	
		}	
	});
}
/**
*所有按钮JS函数的入口
*
*/
function defaultEvent(eventType) {
	if(eventType=='save') {
		check();
	}
	
	FormFunction.defaultEvent(eventType);//默认的处理函数，需自定义时自己写 在PublicFunction.js里
}
var  pm= ${r"${jsonPm}"}[0]; //后台转换json对象
</script>
<%@ include file="/base/jsp/common/CommonEditFoot.jsp"%>
</body>
</html>
