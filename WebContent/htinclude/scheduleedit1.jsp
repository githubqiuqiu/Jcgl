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


//编辑窗口里面的提交 把数据插入数据库
function addschedule(){
	var sctitle=$("#sctitle").val();
	var sccontent=$("#sccontent").val();
	if(sctitle==""){
		$("#mg").html("<font color='red'>请输入标题</font>");
		 setTimeout("$('#mg').html('');",2000);
		 return;
	}
	if(sccontent==""){
		$("#mg").html("<font color='red'>请输入内容</font>");
		 setTimeout("$('#mg').html('');",2000);
		 return;
	}
	
	
	$('#winedit').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editschedule',
	 	 type:'post',
	 	 data:$('#editsche').serialize(),
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


		<form method="post" action="" id="editsche" >
		<input type="hidden" name="schedule.sid" value="${sche.sid }">
	 		<input type="hidden" name="schedule.sdate" value="${sche.sdate }">
	 		<input type="hidden" name="schedule.sfinishdate" value="${sche.sfinishdate }">
	 		<input type="hidden" name="schedule.userid" value="${user.id }">
            <table class="grid">
                <tr>
                <td>主题：</td>
                 <td><input name="schedule.stitle" id="sctitle" type="text" placeholder="请输入主题" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${sche.stitle }"></td> 
                </tr>
            
            	<tr>
            	<td>内容：</td>
                <td colspan="3" >
              	<textarea name="schedule.scontent" id="sccontent">${sche.scontent }</textarea>
                </td>
            	</tr>
              
              <tr>
              <td>状态</td>
              <td>
              <select name="schedule.sflag" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
              	<option value="0"  selected >未完成</option>
              	<option value="1"  >已完成</option>
              </select>
              </td>
              </tr>
            </table>
  
			</form>
		 <center><span id="mg"></span></center> 
			<div align="center" ><a href="#" onclick=" addschedule()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			


</body>
</html>