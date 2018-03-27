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

$(document).ready(function () {

	//触发改变easyui的下拉框的方法(触发院校  联动专业)
	$("#acas").combobox({
	onChange: function (n,o) {
		var aid=$("#acas").val();
		//alert("院校id="+aid);
		//当改变了院校  清空专业表的值
		$("#spes option").remove();
		
		if(aid!=null&& aid!=""){
			$('#spes').combobox({
				valueField:'sid', //值字段
		        textField:'sname', //显示的字段
		        url:'selsep?academyid=' + aid,
		        panelHeight:'auto',
		        required:true,
		        editable:true,//不可编辑，只能选择  
		     });
		  }else{
			  $("#spes").clear();
		  }
	  }
   });  
	
	//点击触发城市 联动改变 县/区
	$("#citys").combobox({
		onChange: function (n,o) {
			var cid=$("#citys").val();
		//	alert("城市id="+cid);
			//当改变了院校  清空专业表的值
			$("#countys option").remove();
			
			if(cid!=null&& cid!=""){
				$('#countys').combobox({
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

//添加成人高考表的数据到数据库
function addstate(){
	var astudentnos=$("#astudentnos").val();
	var anames=$("#anames").val();
	var userids=$("#userids").val();
	var aphones=$("#aphones").val();
	var idnumbers=$("#idnumbers").val();
	var agradations=$("#agradations").val();
	var acas=$("#acas").val();
	var spes=$("#spes").val();
	var citys=$("#citys").val();
	var countys=$("#countys").val();
	var asystems=$("#asystems").val();
	
	if(astudentnos==""){
	
		$("#astudentnos").focus();
		 $("#msg").html("<font color='red'>请填写学生编号</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(isNaN(astudentnos)){
	
		$("#astudentnos").val("");
		$("#astudentnos").focus();
		 $("#msg").html("<font color='red'>请填写正确的学生编号</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	if(anames==""){

		$("#anames").focus();
		 $("#msg").html("<font color='red'>请填写学生姓名</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(idnumbers==""){

		$("#idnumbers").focus();
		 $("#msg").html("<font color='red'>请填写学生身份证号码</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	if(idnumbers.length!=18){

		$("#idnumbers").val("");
		$("#idnumbers").focus();
		 $("#msg").html("<font color='red'>身份证号码为18位</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	if(aphones==""){

		$("#aphones").focus();
		 $("#msg").html("<font color='red'>请填写学生手机号码</font>");
		 setTimeout("$('#msg').html('');",2000);
		return ;
	}
	
	if(isNaN(aphones)||aphones.length!=11){//手机号不为数字或者长度不等于11

		$("#aphones").val("");
		$("#aphones").focus();
		 $("#msg").html("<font color='red'>手机号码为11位数字</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(userids==""){

		 $("#msg").html("<font color='red'>请选择您的介绍老师</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(agradations==""){
	
		 $("#msg").html("<font color='red'>请选择您的报考层次</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(acas==""){

		 $("#msg").html("<font color='red'>请选择您的报名院校</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(spes==""){

		 $("#msg").html("<font color='red'>请选择您的报名专业</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(citys==""){
	
		 $("#msg").html("<font color='red'>请选择您的城市</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	if(countys==""){
	
		 $("#msg").html("<font color='red'>请选择您的县/区</font>");
		 setTimeout("$('#msg').html('');",2000);
		return;
	}
	
	
	
	
	$('#winadd').window('close');
	
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'addstate',
	 	 type:'post',
	 	 data:$('#statedata').serialize(),
	 	 datatype:'json',
	 	 success:function(result){
	 		//添加成功 调用刷新数据网格的方法 
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

<form action="" method="post" id="statedata">

<table class="grid">

<tr>
<td>学生编号</td>
<td><input name="stateapply.sstudentno" id="astudentnos" type="text" placeholder="请输入学生编号" class="easyui-validatebox" data-options="required:true" value=""></td>
<td>学生姓名</td>
<td><input name="stateapply.sname" id="anames" type="text" placeholder="请输入学生姓名" class="easyui-validatebox" data-options="required:true" value=""></td>
</tr>

<tr>
<td>身份证号码</td>
<td>
<input name="stateapply.idnumber" id="idnumbers" type="text" placeholder="请输入身份证号码" class="easyui-validatebox" data-options="required:true" value="">
	
</td>
<td>手机号码</td>
<td><input name="stateapply.sphone" id="aphones" type="text" placeholder="请输入手机号码" class="easyui-validatebox" data-options="required:true" value=""></td>
</tr>

<tr>
<td>老师姓名</td>
<td>
 <select name="stateapply.userid" id="userids" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  <option value="" selected>请选择介绍老师</option>
		<s:iterator value="listuser">
		
		<option value="${id }" >${name }</option>
		
		</s:iterator>
		
	</select>
	
</td>
<td>报考层次</td>
<td>
	<select name="stateapply.sgradation" id="agradations" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	<option value="" selected>请选择报考层次</option>
	<option value="高达专" >高达专</option>
	<option value="高达本" >高达本</option>
	<option value="专升本" >专升本</option>
	</select>
</td>
</tr>


<tr>
	<td>报考院校</td>
	<td>
	     <select  name="stateapply.acaid"   id="acas" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  	<option value="" selected>请选择报考院校</option>
		<s:iterator value="listacademy">
		
		<option value="${aid }" >${aid }${aschool }</option>
		
		</s:iterator>
		
	</select> 
	
	
	</td>
	<td>报考专业</td>
	<td>
	
 	  <select  name="stateapply.specid"   id="spes" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'" >
		<option value="" selected>请选择专业</option>
	 </select>	 
	
	</td>
</tr>

<tr>
<td>城市</td>
<td>
 <select  name="stateapply.cityid" id="citys"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  	<option value="" selected>请选择城市</option>
		<s:iterator value="listcity">
		
		<option value="${cid }" >${cid }${cname }</option>
		
		</s:iterator>
		
	</select>

</td>
<td>县/区</td>
<td>

<select  name="stateapply.countyid" id="countys"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  	<option value="" selected>请选择县/区</option>
		
		
	</select>

</td>
</tr>

<tr>
<td>学制</td>
<td>	    
<select  name="stateapply.ssystem" id="asystems"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	<option value="两年" >两年</option>
	<option value="三年" >三年</option>
	<option value="四年" >四年</option>
</select>
</td>
<td></td>
<td></td>
</tr>

</table>
 <center><span id="msg"></span></center> 
<div align="center" ><a href="#" onclick=" addstate()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>

</form>



</body>
</html>