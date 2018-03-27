<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
<!-- Custom Theme files -->
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="后台登录" />
<!--Google Fonts-->
<!--<link href='//fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
--><!--Google Fonts-->
<script type="text/javascript" src="sss/jquery-1.5.2.js"></script>
<script type="text/javascript">
	$(function(){
		var msg = $("#m").val();
		if(msg=="yes"){
			alert("密码错误！");
		}
	});
</script>
</head>
<body>
<!--header start here-->
<div class="login-form">
			<div class="top-login">
				<span><img src="images/group.png" alt=""/></span>
			</div>
			<h1>登录</h1>
			<div class="login-top">
			<form action="tlogin" method="post">
				<div class="login-ic">
					<i ></i>
					<input type="text" name="user.loginname"/>
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
					<i class="icon"></i>
					<input type="password" name="user.password"/>
					<div class="clear"> </div>
				</div>
			
				<div class="log-bwn">
					<input type="submit"  value="Login" >
				</div>
				</form>
				<input type="hidden" value="${msg}" id="m">
			</div>
			<p class="copy">© 明志教育</p>
</div>		
<!--header start here-->
</body>
</html>