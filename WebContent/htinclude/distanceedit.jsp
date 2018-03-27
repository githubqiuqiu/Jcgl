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
	//点击触发城市 联动改变 县/区
	$("#city").combobox({
		onChange: function (n,o) {
			var cid=$("#city").val();
		//	alert("城市id="+cid);
			//当改变了城市  清空县/区的值
			$("#county option").remove();
			
			if(cid!=null&& cid!=""){
				$('#county').combobox({
					valueField:'coid', //值字段
			        textField:'coname', //显示的字段
			        url:'selcounty?cid=' + cid,
			        panelHeight:'auto',
			        required:true,
			        editable:true,//不可编辑，只能选择  
			     });
			  }
		  }
	   });
	
});		
	
	
//提交编辑按钮
 function editadult(){

	/* $('#winedit').window('close');
	
	  $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editadult',
	 	 type:'post',
	 	data:$('#adultedit').serialize(),
	 	 datatype:'json',
	 	 success:function(result){
	 		alert("返回成功"); 
			add();
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 }); */ 
	 
	 var names=$("#namess").val();
	 var phone=$("#phoness").val();
	 var idnum=$("#idnumss").val();
	 
	 if(names==""){

		 $("#namess").focus();
		 $("#msgs").html("<font color='red'>请输入学生姓名</font>");
		 setTimeout("$('#msgs').html('');",2000);
		 return;
	 }
	 
	 if(phone==""){
	
		 $("#phoness").focus();
		 $("#msgs").html("<font color='red'>请输入学生手机号码</font>");
		 setTimeout("$('#msgs').html('');",2000);
		 return;
	 }
	 
	 if(isNaN(phone)||phone.length!=11){//手机号不为数字或者长度不等于11
	
		$("#phoness").val("");
		$("#phoness").focus();
		 $("#msgs").html("<font color='red'>手机号码为11位数字</font>");
		 setTimeout("$('#msgs').html('');",2000);
		return;
		}
	 
	 if(idnum==""){
		
		 $("#idnumss").focus();
		 $("#msgs").html("<font color='red'>请填写学生身份证号码</font>");
		 setTimeout("$('#msgs').html('');",2000);
		 return;
	 }
	 
	if(idnum.length!=18){
		$("#idnumss").val("");
		$("#idnumss").focus();
		 $("#msgs").html("<font color='red'>身份证号码为18位</font>");
		 setTimeout("$('#msgs').html('');",2000);
		return ;
	}
	 
	 
	 $("#distanceedit").submit();
	
} 

</script>


</head>
<body>


<form action="editdistance" method="post" id="distanceedit">

<input type="hidden" name="distanceapplybean.did" value="${db.did}">
<input type="hidden" name="distanceapplybean.ddata" value="${db.ddata}">
<input type="hidden" name="distanceapplybean.dtype" value="${db.dtype}">
<input type="hidden" name="distanceapplybean.userid" value="${db.userid}">
<input type="hidden" name="distanceapplybean.acaid" value="${db.acaid}">
<input type="hidden" name="distanceapplybean.specid" value="${db.specid}">


<table class="grid">

<tr>
<td>学生编号</td>
<td><input name="distanceapplybean.dstudentno" type="text" placeholder="请输入学生编号" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.dstudentno }" readonly="readonly"></td>
<td>学生姓名</td>
<td><input name="distanceapplybean.dname" id="namess"  type="text" placeholder="请输入学生姓名" class="easyui-validatebox" data-options="required:true" value="${db.dname }"></td>
</tr>

<tr>
<td>老师姓名</td>
<td>
	<input name="distanceapplybean.username" readonly="readonly" type="text" placeholder="请输入老师姓名" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.username }">
</td>
<td>手机号码</td>
<td><input name="distanceapplybean.dphone" id="phoness" type="text" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true" value="${db.dphone }"></td>
</tr>

<tr>
<td>身份证号码</td>
<td><input name="distanceapplybean.idnumber" id="idnumss" type="text" placeholder="请输入身份证号码" class="easyui-validatebox" data-options="required:true" value="${db.idnumber }"></td>
<td>报考层次</td>
<td>
<input name="distanceapplybean.dtypename" readonly="true" type="text" placeholder="请输入报考层次" class="easyui-validatebox" data-options="required:true,novalidate:true" value="远程教育">
</td>
</tr>


<tr>
	<td>报考院校</td>
	<td>
<input name="distanceapplybean.acaname" readonly="true" type="text" placeholder="请输入报考院校" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.acaname }">
	</td>
	<td>报考专业</td>
	<td>
	<input name="distanceapplybean.specname" readonly="true" type="text" placeholder="请输入报考专业" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.specname }">	
	</td>
</tr>

<tr>
<td>城市</td>
<td>
 <select  name="distanceapplybean.cityid" id="city"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  
		<s:iterator value="listcity">
		
		<option value="${cid }" ${cid==db.cityid?'selected':'' } >${cname }</option>
		
		</s:iterator>
		
	</select>

</td>
<td>县/区</td>
<td>

<select  name="distanceapplybean.countyid" id="county"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	   	
		<s:iterator value="listcounty">
		
		<option value="${coid }" ${coid==db.countyid?'selected':'' } >${coname }</option>
		
		</s:iterator> 
		
	</select>

</td>
</tr>

<tr>
<td>学制</td>
<td>	    
<input name="distanceapplybean.dsystem" readonly="true" type="text" placeholder="请输入学制" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.dsystem }">
</td>
<td>报考层次</td>
<td>
<input name="distanceapplybean.dgradation" readonly="true" type="text" placeholder="请输入报考层次" class="easyui-validatebox" data-options="required:true,novalidate:true" value="${db.dgradation }">
</td>
</tr>

</table>
<center><span id="msgs"></span></center> 
<div align="center" ><a href="#" onclick=" editadult()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>

</form>




</body>
</html>