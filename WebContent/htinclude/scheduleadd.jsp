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
function addschedule(){
	var userid=$("#uid").val();
	var title=$("#title").val();
	var content=$("#content").val();

	if(userid==""){
		 $("#msg").html("<font color='red'>请选择用户</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(title==""){
		 $("#msg").html("<font color='red'>请填写标题</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(content==""){
		 $("#msg").html("<font color='red'>请填写内容</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	$('#winadd').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'scheduleadd',
	 	 type:'post',
	 	 data:$('#addsche').serialize(),
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


		<form method="post" action="addschedule" id="addsche" >
	 
            <table class="grid">
                <tr>
                    <td>用户名称:</td>
                    <td>
     				 <select name="schedule.userid" id="uid" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	 				 <option value="" selected>请选择用户</option>
					 <s:iterator value="listuser">
		
					 <option value="${id }" >${name }</option>
	
					 </s:iterator>
		
					</select>
                   </td> 
                    
                </tr>
                
                
                <tr>
                <td>主题：</td>
                 <td><input name="schedule.stitle" id="title" type="text" placeholder="请输入主题" class="easyui-validatebox" data-options="required:true,novalidate:true" value=""></td> 
                </tr>
            
            	<tr>
            	<td>内容：</td>
                <td colspan="3" >
              	<textarea name="schedule.scontent" id="content"></textarea>
                </td>
            	</tr>
              
            </table>
  
			</form>
		 <center><span id="msg"></span></center> 
			<div align="center" ><a href="#" onclick=" addschedule()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			


</body>
</html>