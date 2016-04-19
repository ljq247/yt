<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>


<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" style="width:100%;height:100%;" fit=true>
		<div region='north' title='North Title' split=true
			style="height:100px;"></div>
		<!-- 		<div region='south' title='South Title' split=true -->
		<!-- 			style="height:100px;"></div> -->
		<!-- 		<div -->
		<!-- 			 region='east' iconCls='icon-reload' title='East' split:true  -->
		<!-- 			style="width:100px;"></div> -->
		<div region='west' title='West' split:true style="width:300px;">
			<div id="aa" class="easyui-accordion" fit=true
				style="width:300px;height:200px;">
				<div title="Title1" data-options="iconCls:'icon-save'"
					style="overflow:auto;padding:10px;">
					<h3 style="color:#0099FF;">Accordion for jQuery</h3>
					<p>Accordion is a part of easyui framework for jQuery. It lets
						you define your accordion component on web page more easily.</p>
				</div>
				<div title="Title2"
					data-options="iconCls:'icon-reload',selected:true"
					style="padding:10px;">
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br><a href="javascript:void(0)">content2</a><br>
									
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br><a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>
									<a href="javascript:void(0)">content2</a><br>

									
					
					
					</div>
				<div title="Title3">content3</div>
			</div>

		</div>
		<div region='center' href="index.jsp" title='center title'
			style="padding:5px;"></div>
	</div>


</body>
</html>
