<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub() {
		var p1 = $("#p1").val();
		var p2 = $("#p2").val();
		var p3 = $("#p3").val();
		var p4 = $("#p4").val();
		var p5 = $("#p5").val();
		var dh = $("#dh").val();
		var dz = $("#dz").val();
		var l1 = $("#l1").val();
		var l2 = $("#l2").val();
		var l3 = $("#l3").val();
		var l4 = $("#l4").val();
		
		if(p1==""){
			$("#msg").html("<font color='red'>请选择轮播图</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p2==""){
			$("#msg").html("<font color='red'>请选择轮播图</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p3==""){
			$("#msg").html("<font color='red'>请选择轮播图</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p4==""){
			$("#msg").html("<font color='red'>请选择二维码</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p5==""){
			$("#msg").html("<font color='red'>请选择二维码</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(dh==""){
			$("#msg").html("<font color='red'>请输入电话</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(isNaN(dh)){
			$("#msg").html("<font color='red'>请输入正确的电话号码</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(dz==""){
			$("#msg").html("<font color='red'>请输入地址</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(l1==""){
			$("#msg").html("<font color='red'>请输入链接</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(l2==""){
			$("#msg").html("<font color='red'>请输入链接</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(l3==""){
			$("#msg").html("<font color='red'>请输入链接</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(l4==""){
			$("#msg").html("<font color='red'>请输入链接</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#frm").submit();
		}
		
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 300px">
		<form action="addhome" method="post" id="frm" enctype="multipart/form-data">
			轮播图1：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p1').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%"><br/>
			轮播图2：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p2').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%"><br/>
			轮播图3：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p3').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%"><br/>
			二维码1：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p4').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%"/><br/>
			二维码2：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p5').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%"/><br/>
			电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="home.hcphone" class="easyui-textbox" id="dh"/><br/>
			地址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="home.hcaddress" class="easyui-textbox" id="dz"/><br/>
			链接1：&nbsp;&nbsp;&nbsp;<input type="text" name="home.interlinkageone" class="easyui-textbox" id="l1"/><br/>
			链接2：&nbsp;&nbsp;&nbsp;<input type="text" name="home.interlinkagetwo" class="easyui-textbox" id="l2"/><br/>
			链接3：&nbsp;&nbsp;&nbsp;<input type="text" name="home.interlinkagethree" class="easyui-textbox" id="l3"/><br/>
			链接4：&nbsp;&nbsp;&nbsp;<input type="text" name="home.interlinkagefour" class="easyui-textbox" id="l4"/><br/>
		</form>
			<input type="hidden" name="p1" value="" id="p1"/>
			<input type="hidden" name="p2" value="" id="p2"/>
			<input type="hidden" name="p3" value="" id="p3"/>
			<input type="hidden" name="p4" value="" id="p4"/>
			<input type="hidden" name="p5" value="" id="p5"/>
	</div>
	<div data-options="region:'north',split:true">

		<div align="right">
		<hr/>
		<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">添加</a>
		</div>
	</div>
</body>
</html>