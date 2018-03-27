<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
 <script type="text/javascript">
//修改密码
function updatepwds(){
	//alert("进了修改密码");
	var nowpwd=$("#nowpwd").val();
	var newpwd=$("#newpwd").val();
	var againpwd=$("#againpwd").val();
	var uid=$("#uid").val();
	
	$("#nowpwd").focus(function(){
		$("#p1").html("");
		});
	
	if(nowpwd==""){
		alert("请输入密码");
		$("#nowpwd").focus();
		return;
	}
	if(newpwd==""){
		alert("请输入新密码");
		$("#newpwd").focus();
		return;
	}
	if(againpwd==""){
		alert("请输入确认密码");
		$("#againpwd").focus();
		return;
	}
	if(newpwd!=againpwd){

		alert("两次密码不一致 请重新填写");
		$("#againpwd").val("");
		return;
	}
	
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'updateuserpwd',
	 	 type:'post',
	 	data:{
	 		"nowpwd":nowpwd,
	 		"newpwd":newpwd,
	 		"againpwd":againpwd,
	 		"uid":uid
	 	},
	 	 //datatype:'json',
	 	 success:function(result){
	 		if(result==1){
	 			alert("修改成功");
	 			$('#winupdate').window('close');
	 			window.location.href="login.jsp";
	 		}
	 		else{
	 			$("#p1").html("您输入的密码有误,请重新填写");
	 			$("#nowpwd").val("");
	 			$("#newpwd").val("");
	 			$("#againpwd").val("");
	 		}
	 		 
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 });
	
	
}


</script>
 
</head>



<body>

<form action="">
<input type="hidden" id="uid" name="uid" value="${param.id }">
<table align="center">
	
	<tr>
	<td align="right">请输入当前密码:</td>
	<td><input type="password" id="nowpwd" name="nowpwd"></td>
	</tr>
	
	<tr>
	<td align="right">请输入新的密码:</td>
	<td><input type="password" id="newpwd" name="newpwd"></td>
	</tr>
	
	<tr>
	<td align="right">请确认新的密码:</td>
	<td><input type="password" id="againpwd" name="againpwd"></td>
	</tr>
	
</table>
<p id="p1" align="center"></p>

<div align="center" ><a href="#" onclick="updatepwds()"  class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
</form>

</body>
</html>