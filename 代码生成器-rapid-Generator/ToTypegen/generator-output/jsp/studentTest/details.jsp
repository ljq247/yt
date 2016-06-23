<%@ page contentType="text/html; charset=UTF-8" errorPage="/base/jsp/common/CommonError.jsp"%>
<jsp:directive.page import="cn.com.oa.core.util.StringUtil"/>
<%@page import="java.util.List"%>
<%@page import="cn.com.oa.base.merge.model.Role"%>
<%@page import="cn.com.oa.base.role.model.RoleView"%>
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
<link href="${ctx}/base/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/base/css/common.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/base/css/${customTheme}.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/base/calendar/calendar-blue.css" rel="stylesheet" type="text/css">
<link href="$${ctx}/base/datepicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript" 
 	src="$${ctx}/base/datepicker/WdatePicker.js" charset="utf-8"></script> <!-- 时间 ,还有上面css-->	
<script type="text/javascript" src="${ctx}/base/calendar/calendar.js"></script>
<script type="text/javascript" src="${ctx}/base/calendar/lang/calendar-zh.js"></script>
<script type="text/javascript" src="${ctx}/base/calendar/calendar-setup.js"></script>

<script src="${ctx}/base/js/jquery/jquery.js" type="text/javascript"></script>
<script src="${ctx}/base/js/jquery/jquery.metadata/jquery.metadata.js" type="text/javascript"></script><!--加载jquery扩展属性-->
<script src="${ctx}/base/js/jquery/jquery.validate/jquery.validate.js" type="text/javascript"></script><!-- 加载jquery-validate  -->
<script src="${ctx}/base/js/jquery/jquery.validate/localization/messages_cn.js" type="text/javascript"></script><!-- 加载jquery-validate语言  -->
<script src="${ctx}/base/js/base.js" type="text/javascript"></script>
<script src="${ctx}/base/js/validate/FormValidate.js" type="text/javascript"></script><!-- 加载通用验证  -->
<script type="text/javascript" src="${ctx}/base/js/common/FormFunction.js"></script><!-- 公用的按钮函数 -->
<script type="text/javascript" src="${ctx}/base/js/do.js"></script>
</head>
<body class="rightBody">
<form id="form2" name="form2" method="post" action="${ctx}/sys/person!modPerson.action">
<s:hidden name="bean.id" />
    <table class="location" width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr><td class="icon"></td><td>您现在所在的位置是：临时人员管理-主管理界面</td></tr>
    </table>
	<div class="tableH2">临时人员管理-查看</div>
    <table id="baseInfo" width="100%" class="list" border="0" cellpadding="0" cellspacing="0">
	
			<tr>
				<td width="200" class="tdBg"><span class="fRed">*</span>${pm.name} </td>
				<td colspan="3">
					<s:property value="bean.name"/>
				</td>
			</tr>
			<tr>
				<td width="200" class="tdBg"><span class="fRed">*</span>${pm.age} </td>
				<td colspan="3">
					<s:property value="bean.age"/>
				</td>
			</tr>
			<tr>
				<td width="200" class="tdBg"><span class="fRed">*</span>${pm.createTime} </td>
				<td colspan="3">
					<s:property value="bean.createTime"/>
				</td>
			</tr>
			<tr>
				<td width="200" class="tdBg"><span class="fRed">*</span>${pm.status} </td>
				<td colspan="3">
					<s:property value="bean.status"/>
				</td>
			</tr>
			<tr>
				<td width="200" class="tdBg"><span class="fRed">*</span>${pm.interesting} </td>
				<td colspan="3">
					<s:property value="bean.interesting"/>
				</td>
			</tr>
	</table>
    <div class="tc mt10">	
	<input type="button" onClick="javascript:FormFunction.editSingle('<s:property value="id"/>',null,750,500);" id="edit" value="修改" class="btnB2" />&nbsp;&nbsp; 
	<input type="button" name="Submit4" class="btnB2" value="返回" onClick="defaultEvent('exit')">
	</div>
</form>
<script>
var addUrl =  "${ctx}/birthdaybless_test/studentTest!editForCreate.action?pageNo=${pageNo}";//表单列表add 的url地址
var delUrl =  "${ctx}/birthdaybless_test/studentTest!del.action";//表单列表del的url地址
var viewUrl = "${ctx}/birthdaybless_test/studentTest!details.action?pageNo=${pageNo}";//表单列表view的url地址
var editUrl = "${ctx}/birthdaybless_test/studentTest!editForUpdate.action?pageNo=${pageNo}";//表单列表edit的url地址
var listUrl = "${ctx}/birthdaybless_test/studentTest!showListBySerachMap.action?pageNo=${pageNo}";//表单列表list 的url地址,用来作为搜索地址

/**
*所有按钮JS函数的入口
*
*/
function defaultEvent(eventType) {
	FormFunction.defaultEvent(eventType);//默认的处理函数，需自定义时自己写 在PublicFunction.js里
}
var  pm= ${jsonPm}[0]; //后台转换json对象
</script>
<%@ include file="/base/jsp/common/CommonEditFoot.jsp"%>
</body>
</html>
