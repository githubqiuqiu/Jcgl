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
 function addrole(){
 	/* $("#winadd").window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'addrole',
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
  */
  var id=$("#name").val();
  var seq=$("#seq").val();
  var status=$("#status").val();
  var des=$("#des").val();
  if(id==""){
	  
	  $("#name").focus();
	  $("#msg").html("<font color='red'>请填写角色名称</font>");
		setTimeout("$('#msg').html('');",2000);

	  return;
  }
  if(seq==""){
	  $("#msg").html("<font color='red'>排序不能为空</font>");
		setTimeout("$('#msg').html('');",2000);

	  return;
  }
  if(status==""){
	  $("#msg").html("<font color='red'>状态不能为空</font>");
		setTimeout("$('#msg').html('');",2000);

	  return;
  }
  if(des==""){
	  $("#msg").html("<font color='red'>请选择权限</font>");
		setTimeout("$('#msg').html('');",2000);

	  return;
  }
  
  
  
$("#addfrom").submit();
}
</script>


</head>
<body>
	<form method="post" action="addrole" id="addfrom" >
            <table class="grid">
                <tr>
                    <td>角色名称</td>
                    <td><input name="role.name" id="name" type="text" placeholder="请输入角色名称" class="easyui-validatebox" data-options="required:true" ></td>
                </tr>
                <tr>
                    <td>排序</td>
                    <td><input name="role.seq" id="seq" value="0" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false"></td>
                </tr>
                <tr>
                    <td>状态</td>
                    <td >
                        <select name="role.status" id="status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0">正常</option>
                            <option value="1">停用</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>权限</td>
                   <!--  <textarea name="role.description"></textarea> -->
                    <td colspan="3">
                    <select name="role.description" id="des" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                    <option value="" selected>请选择权限</option>
					<option value="最高权限" >最高权限</option>
					<option value="中权限" >中权限</option>
					<option value="低权限" >低权限</option>
					<option value="最低权限" >最低权限</option>
                    </select>
                    </td>
                </tr>
                
            </table>
           
			</form>
			  <center><span id="msg"></span></center>   
			<div align="center"><a href="#"   onclick=" addrole()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>

</body>
</html>