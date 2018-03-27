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
		var bt = $("#bt").val();
		var p1 = $("#p1").val();
		var nr = $("#nr").val();
		
		if(bt==""){
			$("#msg").html("<font color='red'>请输入标题</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(p1==""){
			$("#msg").html("<font color='red'>请选择图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(nr==""){
			$("#msg").html("<font color='red'>请输入内容</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#frm").submit();
		}
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 170px">
		<form action="addhotmajor" method="post" id="frm" enctype="multipart/form-data">
			标题：<input type="text" class="easyui-textbox" name="hotmajor.hmtitle" id="bt"/><br/>
			图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p1').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:80%"><br/>
			内容：<textarea rows="" cols="" name="hotmajor.hmcontent" id="nr"></textarea>
		</form>
		<input type="hidden" value="" id="p1">
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