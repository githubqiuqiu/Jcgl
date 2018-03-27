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
function editdep(){
	var code=$("#code").val();
	var name=$("#name").val();
	var seq=$("#seq").val();
	var icon=$("#icon").val();
	var address=$("#address").val();
	
	if(code==""){
		
		$("#code").focus();
		$("#msg").html("<font color='red'>请输入部门编号</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(name==""){
		$("#name").focus();
		$("#msg").html("<font color='red'>请输入部门名称</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(seq==""){
		$("#seq").focus();
		$("#msg").html("<font color='red'>排序不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(icon==""){
	
		$("#icon").focus();
		$("#msg").html("<font color='red'>菜单图标不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(address==""){
	
		$("#address").focus();
		$("#msg").html("<font color='red'>地址不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	
	 $('#winedit').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editdep',
	 	 type:'post',
	 	 data:$('#organizationEditForm').serialize(),
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


  <form id="organizationEditForm" method="post" action="editdep">
  <input name="organization.id" id="id" value="${organization.id }" type="hidden"  >
   <input name="organization.createtime" id="createtime"  value="${organization.createtime }" type="hidden"  >
        <table class="grid">
            <tr>
                <td>编号</td>
                <td><input name="organization.code" id="code" value="${organization.code }" type="text" placeholder="请输入部门编号" class="easyui-validatebox" data-options="required:true" ></td>
                
                
                <td>部门名称</td>
                <td><input name="organization.name" value="${organization.name }" id="name" type="text" placeholder="请输入部门名称" class="easyui-validatebox" data-options="required:true" ></td>
            </tr>
            <tr>
                <td>排序</td>
                <td><input type="text" value="${organization.seq }" id="seq" name="organization.seq" placeholder="请输入部门排序" class="easyui-validatebox" data-options="required:true"></td>
                <td>菜单图标</td>
                <td ><input id="icon" value="${organization.icon }" name="organization.icon" class="easyui-validatebox" placeholder="请输入部门图标" data-options="required:true"/></td>
            </tr>
            <tr>
                <td>地址</td>
                <td colspan="3"><input id="address" value="${organization.address }" name="organization.address" style="width: 300px;" placeholder="请输入部门地址" class="easyui-validatebox" data-options="required:true"/></td>
            </tr>
           
        </table>
          <center><span id="msg"></span></center> 
       <div align="center"><a href="#" onclick="editdep()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
        
    </form>


</body>
</html>