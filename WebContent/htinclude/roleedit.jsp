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
function editrole(){
	var rolename=$("#rolename").val();
	var roleseq=$("#roleseq").val();
	if(rolename==""){
		$("#msg").html("<font color='red'>角色名为空</font>");
		setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(roleseq==""){
		$("#msg").html("<font color='red'>排序不能为空</font>");
		setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	 $('#winedit').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editrole',
	 	 type:'post',
	 	 data:$('#editfrom').serialize(),
	 	 datatype:'json',
	 	 
	 	  beforeSend: function () {
	 		    $.messager.progress({ 
	 		       title: '提示', 
	 		       msg: '授权中，请稍候……', 
	 		       text: '' 
	 		    });
	 		    },
	 		    
	 	 success:function(result){
	 		  $.messager.progress('close');
			add();
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert($('#editfrom').serialize());
	 		 alert("错误");
	 	 }
	 });
	
}


</script>

</head>
<body>
	
	<form method="post" action="editrole" id="editfrom" >
	<input name="role.id" value="${role.id }"   type="hidden" id="roleid" >
		<input name="desp" value="${role.description }"   type="hidden"  >
	<table class="grid">
                <tr>
                
                    <td>角色名称</td>
                    <td>
                    <input name="role.name"  value="${role.name}"  id="rolename" type="text" placeholder="请输入角色名称" class="easyui-validatebox" data-options="required:true"></td>
                </tr>
                <tr>
                    <td>排序</td>
                    <td><input type="text" value="${role.seq}"   id="roleseq" name="role.seq" class="easyui-validatebox" data-options="required:true"></td>
                </tr>
                <tr>
                    <td>状态</td>
                    <td >
              		 
                        <select id="rolestatus" value="${role.status}"  name="role.status" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0"  ${role.status=='0'?'selected':'' }  >正常</option>
                            <option value="1"  ${role.status=='1'?'selected':'' }>停用</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>权限</td>
                    <td >
                     <select id="roledescription"   name="role.description" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="最高权限"  ${role.description=='最高权限'?'selected':'' }  >最高权限</option>
                            <option value="中权限"  ${role.description=='中权限'?'selected':'' }>中权限</option>
                            <option value="低权限"  ${role.description=='低权限'?'selected':'' }  >低权限</option>
                            <option value="最低权限"  ${role.description=='最低权限'?'selected':'' }>最低权限</option>
                        </select>
                   
                    </td>
                </tr>
            </table>
         <center><span id="msg"></span></center>   
            <div align="center"><a href="#" onclick="editrole()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
         </form>   
			
</body>
</html>