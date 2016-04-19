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
		$.extend($.fn.validatebox.defaults.rules, {
			checkUsername : {
				validator : function(value, param) {
					//alert('你好');
					return value.length >= param[0] && value.length<=param[1];
				},
				message : '用户名必须在 {0}到{1}之间.'
			},
			checkPassword : {
				validator : function(value, param) {
					//alert('你好');
					return value.length == param[0];
				},
				message : '密码必须等于 {0}.'
			}
		});
		//数字验证组件
		$('#age').numberbox({
			min:18,
			max:150,
			required:true,
			missingMessage:'年龄必填',
			precision:0
		});
		$('#birthday').datebox({
			required:true,
			missingMessager:'日期必填',
			editable:false ,
			width:147
		});
		//薪水组件
		$('#salary').numberbox({
			min:1000,
			max:150000,
			required:true,
			missingMessage:'薪水必填',
			precision:2   //允许的小数点
		});
		//日期时间组件
		$('#startTime,#endTime').datetimebox({
			required:true,
			missingMessage:'时间必填!',
			editable:false
		});

		//添加事件
// 		$('#btn').click(function() {
//			手动提交
// 			$('#myform').form('submit', {
// 				url : 'UserServlet?method=save',
// 				onSubmit : function() {
// 					var bool = $('#myform').form('validate');
//					alert(bool);
// 					if (!bool) {
// 						$.messager.show({
// 							title : '提示信息',
// 							msg : '有些数据错误,求修改!'
// 						});
// 						return false; //if体内的返回,打断程序提交
// 					}
// 				},
// 				success : function(result) {
// 					var rul=$.parseJSON(result);
// 					$.messager.show({
// 						title:rul.status,
// 						msg:rul.message
// 					});
// 				}
// 			});
// 		});
		// 
		$('#myform').form({
				url : 'UserServlet?method=save',
				onSubmit : function() {
					var bool = $('#myform').form('validate');
// 					alert(bool);
					if (!bool) {
						$.messager.show({
							title : '提示信息',
							msg : '有些数据错误,求修改!'
						});
						return false; //if体内的返回,打断程序提交
					}
				},
				success : function(result) {
					var rul=$.parseJSON(result);
					$.messager.show({
						title:rul.status,
						msg:rul.message
					});
				}
		});
		$('#btn').click(function() {
			$('#myform').submit();
		});
		//为
		$('#myform').find('input').on('keyup',function(event){
			if(event.keyCode==13){
				//alert('hello');
				$('#myform').submit();
			}
		});


	});
</script>
</head>

<body>
	<div id="mydiv" class="easyui-panel" style="width:400px;height: 500px;"
		title="新增用户">
		<form id="myform" action="" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" class="easyui-validatebox" required=true validType="checkUsername[2,5]" missingMessage="用户名比写" value=""></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password"  class="easyui-validatebox" required=true validType="checkPassword[4]" value=""></td>
				</tr>
				<tr>
					<td>性别:</td>
					<td>男<input type="radio" checked="checked" name="sex" value="1">
					 	女<input type="radio" name="sex" value="2">
					</td>
				</tr>
				<tr>
					<td>年龄:</td>
					<td><input id="age" type="text" name="age" value=""></td>
				</tr>
				<tr>
					<td>出生日期:</td>
					<td><input id="birthday" type="text" name="birthday" value=""></td>
				</tr>
				<tr>
					<td>所属城市:</td>
					<td><input class="easyui-combobox" url="UserServlet?method=getCity" valueField="id"  textField="name" name="city" ></td>
				</tr>
				<tr>
					<td>薪水:</td>
					<td><input id="salary" type="text" name="salary" value=""></td>
				</tr>
				<tr>
					<td>开始时间:</td>
					<td><input id="startTime" type="text" name="startTime" value=""></td>
				</tr>
				<tr>
					<td>结束时间:</td>
					<td><input id="endTime" type="text" name="endTime" value=""></td>
				</tr>
				<tr>
					<td>个人描述:</td>
					<td><input type="text" name="description" value=""></td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn" class="easyui-linkbutton">保存</a></td>
				</tr>

			</table>

		</form>
	</div>


</body>
</html>
