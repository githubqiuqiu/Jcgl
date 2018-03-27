<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="s" uri="/struts-tags" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="link.jsp"></s:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">


//添加窗口里面的提交 把数据插入数据库
function adduser(){
	var loginname=$("#loginname").val();
	var name=$("#name").val();
	var pwd=$("#pwd").val();
	var sex=$("#sex").val();
	var age=$("#age").val();
	var usertype=$("#usertype").val();
	var organizationid=$("#organizationid").val();
	var rid=$("#rid").val();
	var phone=$("#phone").val();
	var status=$("#status").val();
	
	if(loginname==""){
		
		 $("#loginname").focus();
		 $("#msg").html("<font color='red'>请填写登录名</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(name==""){
		$("#name").focus();
		 $("#msg").html("<font color='red'>请填写用户名</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(pwd==""){
		$("#pwd").focus();
		 $("#msg").html("<font color='red'>密码不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(sex==""){
		 $("#msg").html("<font color='red'>请选择性别</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(age==""){
		$("#age").focus();
		 $("#msg").html("<font color='red'>请输入年龄</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(isNaN(age)||age<=0||age>150){
		$("#age").val("");
		$("#age").focus();
		 $("#msg").html("<font color='red'>请输入正确的年龄</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	
	if(usertype==""){
		 $("#msg").html("<font color='red'>请选择用户类型</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(organizationid==""){
		 $("#msg").html("<font color='red'>请选择部门</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	if(rid==""){
		 $("#msg").html("<font color='red'>请选择角色</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	if(phone==""){

		$("#phone").focus();
		 $("#msg").html("<font color='red'>请输入电话</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(phone.length!=11){
		$("#phone").val("");
		$("#phone").focus();
		 $("#msg").html("<font color='red'>电话号码长度为11位</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(isNaN(phone)){
		$("#phone").val("");
		$("#phone").focus();
		 $("#msg").html("<font color='red'>请输入正确的电话号码</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	

	if(status==""){
		 $("#msg").html("<font color='red'>请选择状态</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	$('#winadd').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'adduser',
	 	 type:'post',
	 	 data:$('#addfrom').serialize(),
	 	 datatype:'json',
	 	 success:function(result){
			add();
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 });
 }

</script>


</head>
<body>


		<form method="post" action="addrole" id="addfrom" >
	 
            <table class="grid">
                <tr>
                    <td>登录名</td>
                    <td><input name="user.loginname" id="loginname" type="text" placeholder="请输入登录名称" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>用户名</td>
                    <td><input name="user.name" id="name" type="text" placeholder="请输入姓名" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="user.password" id="pwd" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true"></td>
                    <td>性别</td>
                    <td>
                        <select name="user.sex" id="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                        <option value="" selected="selected">请选择性别</option>
                            <option value="0" >男</option>
                            <option value="1" >女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" id="age" name="user.age" placeholder="请输入年龄" class="easyui-validatebox" data-options="required:true"/></td>
                    <td>用户类型</td>
                    <td>
                        <select name="user.usertype" id="usertype" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                         <option value="" selected="selected">请选择用户类型</option>
                            <option value="0">管理员</option>
                            <option value="1" >用户</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>部门</td>
                    <td>
                    	<select  name="user.organizationid" id="organizationid" style="width: 140px; height: 29px;" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" >
                    		<option value="">请选择部门</option>
                    		<s:iterator value="listorg">
                    		<option value="${id }">${name }</option>
                    		</s:iterator>
                    	
                    		
                    	</select>
                    </td>
                    <td>角色</td>
                    <td>
                    	<select  name="user.rid" id="rid" style="width: 140px; height: 29px;" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" >
    	                	<option value="">请选择角色</option>
                    		<s:iterator value="listrole">
                    		<option value="${id }">${name }</option>
                    		</s:iterator>
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>
                        <input type="text" name="user.phone" id="phone" placeholder="请输入电话"  class="easyui-validatebox" data-options="required:true"/>
                    </td>
                    <td>用户状态</td>
                    <td>
                        <select name="user.status" id="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                                <option value="0">正常</option>
                                <option value="1">停用</option>
                        </select>
                    </td>
                </tr>
            </table>
  
			</form>
		  <center><span id="msg"></span></center>   
			<div align="center" ><a href="#" onclick=" adduser()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			


</body>
</html>