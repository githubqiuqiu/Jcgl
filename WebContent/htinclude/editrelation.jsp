<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub() {
		var qq = $("#qq").val();
		var dh = $("#dh").val();
		var mc = $("#mc").val();
		
		if(qq==""){
			$("#msg").html("<font color='red'>请输入QQ</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(isNaN(qq)){
			$("#msg").html("<font color='red'>请输入正确的QQ号</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(dh==""){
			$("#msg").html("<font color='red'>请输入电话</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(dh.length!=11||isNaN(dh)){
			$("#msg").html("<font color='red'>请输入正确的电话号码</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(mc==""){
			$("#msg").html("<font color='red'>请输入名称</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#m").submit();
		}
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 120px">
		<form action="editrelation" method="post" id="m">
			<input type="hidden" name="relation.rid" value="${relation.rid }">
			QQ：&nbsp;<input class="easyui-textbox" name="relation.rqq" value="${relation.rqq }" id="qq"><br/>
			电话：<input class="easyui-textbox" name="relation.rphone" value="${relation.rphone }" id="dh"><br/>
			名称：<input class="easyui-textbox" name="relation.rcontent" value="${relation.rcontent}" id="mc"><br/>
			负责类型：    <select name="relation.reffect" class="easyui-combobox">
						<option value="成考" ${relation.reffect=='成考'?'selected':''}>成考</option>
						<option value="远程" ${relation.reffect=='远程'?'selected':''}>远程</option>
						<option value="财务" ${relation.reffect=='财务'?'selected':''}>财务</option>
						<option value="学籍" ${relation.reffect=='学籍'?'selected':''}>学籍</option>
					</select>
		</form>
	</div>
	<div data-options="region:'north',split:true">

		<div align="right">
		<hr/>
		<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">修改</a>
		</div>
	</div>
</body>
</html>