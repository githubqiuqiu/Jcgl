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
//添加窗口里面的提交 把数据插入数据库
function adddep(){
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
		$("#msg").html("<font color='red'>排序不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(icon==""){
		$("#msg").html("<font color='red'>菜单图标不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		$("#icon").focus();
		return ;
	}
	if(address==""){
		$("#msg").html("<font color='red'>地址不能为空</font>");
		 setTimeout("$('#msg').html('');",2000);
		$("#address").focus();
		return;
	}
	
	
	
	$('#winadd').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'adddep',
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

<form id="addfrom" method="post">
        <table class="grid">
            <tr>
                <td>编号</td>
                <td><input name="organization.code" id="code" type="text" placeholder="请输入部门编号" class="easyui-validatebox" data-options="required:true"  ></td>
                <td>部门名称</td>
                <td><input name="organization.name" id="name" type="text" placeholder="请输入部门名称" class="easyui-validatebox" data-options="required:true" ></td>
                
            </tr>
            <tr>
                <td>排序</td>
                <td><input name="organization.seq" id="seq" class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false" value="0"></td>
                <td>菜单图标</td>
                <td><input name="organization.icon" id="icon" placeholder="请输入菜单图标" value="fi-folder" class="easyui-validatebox" data-options="required:true" /></td>
            </tr>
            <tr>
                <td>地址</td>
                <td colspan="4"><input name="organization.address" id="address" placeholder="请输入部门地址" style="width: 300px;" class="easyui-validatebox" data-options="required:true" /></td>
            </tr>
           
        </table>
    </form>
      <center><span id="msg"></span></center> 
			<div align="center" ><a href="#" onclick=" adddep()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			


</body>
</html>