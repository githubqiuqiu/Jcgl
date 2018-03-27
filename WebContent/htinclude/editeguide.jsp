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
		var log = $("#log").val();
		var p1 = $("#p1").val();
		var p2 = $("#p2").val();
		var p3 = $("#p3").val();
		var js = $("#js").val();
		var jj = $("#jj").val();
		var xx = $("#xx").val();
		
		if(log==""){
			$("#msg").html("<font color='red'>请选择图标</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(js==""){
			$("#msg").html("<font color='red'>学校介绍为空</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p1==""){
			$("#msg").html("<font color='red'>请选择学校图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(jj==""){
			$("#msg").html("<font color='red'>学校简介为空</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p2==""){
			$("#msg").html("<font color='red'>请选择专业图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p3==""){
			$("#msg").html("<font color='red'>请选择毕业证书图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(xx==""){
			$("#msg").html("<font color='red'>学校为空</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#om").submit();
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 300px">
		<form action="editeguide" method="post" id="om" enctype="multipart/form-data">
			<input type="hidden" name="eguide.id" value="${eguide.id}">
			学校图标：<input  name="myFile" class="easyui-filebox" data-options="onChange:function(){$('#log').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%" value="${eguide.log}" ><br/>
			学校介绍：<textarea rows="" cols="" name="eguide.school" id="js">${eguide.school}</textarea><br/>
			学校图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p1').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%" value="${eguide.picture1}" ><br/>
			学校简介：<textarea rows="" cols="" name="eguide.title" id="jj">${eguide.title}</textarea><br/>
			专业图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p2').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%" value="${eguide.picture2}" ><br/>
			毕业证书：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p3').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:50%" value="${eguide.picture3}" ><br/>
			学校：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="easyui-textbox" name="eguide.type" value="${eguide.type}" id="xx"><br/>
			<input type="hidden" name="log" id="log" value="a"/>
			<input type="hidden" name="p1" id="p1" value="b"/>
			<input type="hidden" name="p2" id="p2" value="c"/>
			<input type="hidden" name="p3" id="p3" value="d"/>
		</form>
	</div>
	<div data-options="region:'north',split:true">
		<div align="right">
		<hr/>
		<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">修改</a>
		</div>
	</div>
</body>
</html>