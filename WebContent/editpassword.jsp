<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="sss/jquery-1.5.2.js"></script>
<script type="text/javascript">
function sub(pwd){
	var p1 = $("#p1").val();
	alert(pwd)
	alert(p1);
	var p2 = $("#p2").val();
	var p3 = $("#p3").val();
	if(p1==""||p2==""||p3==""){
		$("#q4").html("请正确的输入信息!");
		setTimeout("$('#q4').html('')",2000);
	}else
	if(p2!=p3){
		$("#q4").html("两次密码不一致!");
		setTimeout("$('#q4').html('')",2000);
		$("#p3").focus();
	}else
	if(pwd!=p1){
		$("#q4").html("原密码不一致");
		setTimeout("window.close()",2000);
	}else{
		$("#fm").submit();
		alert("密码修改成功！");
		setTimeout("window.close()",10);
	}
	
}
</script>
</head>
<body>
<form method="post" action="edituserpassword" id="fm">
<table>
	<tr><td>原密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="p1" id="p1"/></td></tr>
	<tr><td>新密码：&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="p2" id="p2"/></td></tr>
	<tr><td>再输一次：&nbsp;<input type="password" name="p3" id="p3"/></td></tr>
	<tr><td><button onclick="sub(${teacher.password})" type="button">修改</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="q4"></span></td></tr>
</table>
</form>
</body>
</html>