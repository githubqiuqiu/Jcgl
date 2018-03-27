<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
//提交编辑按钮
function editusers(){
	
	var loginname=$("#loginname").val();
	var name=$("#name").val();
	var pwd=$("#password").val();
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
	
		$("#password").focus();
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
	
	
	
	
	
	$('#winedit').window('close');
	
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editusers',
	 	 type:'post',
	 	 data:$('#editu').serialize(),
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


<form method="post" action="editusers" id="editu" >
	 		<input type="hidden" name="user.id" id="id" value="${user.id }">
	 		<input type="hidden" name="user.createtime" id="createtime" value="${user.createtime }">
            <table class="grid">
                <tr>
                	
                    <td>登录名</td>
                    <td><input name="user.loginname"  value="${user.loginname }" id="loginname" type="text" placeholder="请输入登录名称" class="easyui-validatebox" data-options="required:true" value=""></td>
                    <td>用户名</td>
                    <td><input name="user.name" id="name"   value="${user.name }" type="text" placeholder="请输入姓名" class="easyui-validatebox" data-options="required:true" value=""></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input name="user.password"  value="${user.password }" id="password" type="password" placeholder="请输入密码" class="easyui-validatebox" data-options="required:true"></td>
                    <td>性别</td>
                    <td>
                    	
                        <select name="user.sex"  id="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0"  ${user.sex=='0'?'selected':'' }>男</option>
                            <option value="1" ${user.sex=='1'?'selected':'' }>女</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>年龄</td>
                    <td><input type="text" id="age"  value="${user.age }" name="user.age" placeholder="请输入年龄" class="easyui-validatebox" data-options="required:true"/></td>
                    <td>用户类型</td>
                    <td>
                   
                        <select name="user.usertype"  id="usertype" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0" ${user.usertype=='0'?'selected':'' }>管理员</option>
                            <option value="1" ${user.usertype=='1'?'selected':'' }>用户</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>部门</td>
                    <td>
              
                    	<select id="organizationid" name="user.organizationid" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" style="width: 140px; height: 29px;" class="easyui-validatebox" >
                    			<s:iterator value="listorg">
								<option value="${id }"   ${id==seq?'selected':'' }>${name }</option>
					
								</s:iterator> 
                    	</select>
                    </td>
                    <td>角色名</td>
                    <td>
                
                    	<select id="rid" name="user.rid" class="easyui-combobox"  data-options="width:140,height:29,editable:false,panelHeight:'auto'" style="width: 140px; height: 29px;">
    	                
                    	 	<s:iterator value="listrole">
								
						<option value="${id }"  ${id==seq?'selected':'' } >${name }</option>
	
							</s:iterator> 
                    		
                    	</select>
                    </td>
                </tr>
                <tr>
                    <td>电话</td>
                    <td>
                        <input type="text" value="${user.phone }" id="phone" name="user.phone" placeholder="请输入电话"  class="easyui-validatebox" data-options="required:true"/>
                    </td>
                    <td>用户状态</td>
                    <td>
                 
                        <select name="user.status" id="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                                <option value="0" ${user.status=='0'?'selected':'' }>正常</option>
                                <option value="1" ${user.status=='1'?'selected':'' }>停用</option>
                        </select>
                    </td>
                </tr>
            </table>
  
			</form>
			 <center><span id="msg"></span></center> 
			<div align="center" ><a href="#" onclick="editusers()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			

</body>
</html>