<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
<script type="text/javascript" src="sss/jquery-1.5.2.js"></script>
<script type="text/javascript">
function sub(){
	var title = $("#title").val();
	var content = $("#content").val();
	if(title==""||content==""){
		$("#msg").html("请输入内容!");
		setTimeout("$('#msg').html('')",2000);
	}else{
		$("#fm").submit();
		setTimeout("window.close()",10);
	}
}
</script>
</head>
<body>
<form method="post" action="addsche.action" id="fm">
<table>
	<tr><td>标题:<input type="text" name="schedule.stitle" id="title"/></td></tr>
	<tr><td>内容:<input type="text" name="schedule.scontent" id="content"/></td></tr>
	<tr><td><button id="btn" type="button" onclick="sub()">添加</button><p id="msg"></p></td></tr>
</table>
</form>
</body>
</html>