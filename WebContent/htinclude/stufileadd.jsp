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

$(function(){
	 //解决文件上传点击选择学生后 在此点击不出现的问题
	 //关闭选择学生窗口
	  $('#winsel').window({
			
	        onBeforeClose: function () { //当面板关闭之前触发的事件
	       		//先关闭添加窗口
	        	$('#winadd').window('close');
	       		
	        	//在打开添加窗口
	        	$('#winadd').window('open');
	        	$('#winadd').window('refresh','../htinclude/stufileadd.jsp');
	       		
	        }

	    });
	
	
});




//添加窗口里面的提交 把数据插入数据库
function addschedule(){
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
 
 //查询成人高考表的学生
 function selstu(){
	 	$('#winsel').window('open');
		$('#winsel').window('refresh','../htinclude/seladultstu.jsp');
 }
 
//表单提交验证
function upload(){
	

	var id=$("input[name='stufile.stuid']").val();
	var name = $("input[name='stufile.stuname']").val();

	//easyui file框获值
	var photo=$('#photo').textbox('getValue');
	var pz=$('#pz').textbox('getValue');
	var lw=$('#lw').textbox('getValue');
	
	if(name==null||name==""){
		 $("#msg").html("<font color='red'>请先选择学生</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(photo==null||photo==""){
	
		 $("#msg").html("<font color='red'>请先选择要上传的学生照片</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(pz==null||pz==""){
		
		 $("#msg").html("<font color='red'>请先选择要上传的缴费凭证</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(lw==null||lw==""){
		
		 $("#msg").html("<font color='red'>请先选择要上传的论文</font>");
		 setTimeout("$('#msg').html('');",2000);
		return
	}
	$("#addfile").submit();
}

 
 
</script>


</head>
<body>


		<form method="post" action="addfile" id="addfile" enctype="multipart/form-data">
	 		<input type="hidden" name="stufile.stuid" id="ids" value="${id }">
            <table class="grid" align="center" >
                <tr>
                   	<td align="right">学生姓名:</td> 
                    <td><input name="stufile.stuname" id="names" type="text" placeholder="请选择学生姓名"  value="${name }"><input type="button" onclick="selstu();" value="选择学生"></td>
                </tr>
                
                
                <tr>
                <td align="right">相片：</td>
                 <td><input class="easyui-filebox" id="photo" style="width:100%" name="myfile"></td> 
                </tr>
            
            	<tr>
            	<td align="right">缴费凭证：</td>
                <td>
              	<input class="easyui-filebox" id="pz" style="width:100%" name="myfile">
                </td>
            	</tr>
            	
            	<tr>
            	<td align="right">论文：</td>
                <td>
              	<input class="easyui-filebox" id="lw" style="width:100%" name="myfile">
                </td>
            	</tr>
              
            </table>
  
			</form>
			 <center><span id="msg"></span></center> 
			<div style="height:10px"></div>
			<div align="center" ><a href="#" onclick="upload();" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
			
<!-- 打开一个jsp页面 查询成人高考表的学生 -->
	<div id="winsel" class="easyui-window" 
		title="选择学生" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:300px;padding:5px;">
		
	</div>

</body>
</html>