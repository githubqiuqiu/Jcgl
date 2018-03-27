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
			$("#om").submit();
		}
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 170px">
		<form action="hotmajoredit" method="post" id="om" enctype="multipart/form-data">
			<input type="hidden" name="hotmajor.hmid" value="${hotmajor.hmid}">
			标题：<input type="text" class="easyui-textbox" name="hotmajor.hmtitle" value="${hotmajor.hmtitle }" id="bt"/><br/>
			图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#p1').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:80%"  value="${hotmajor.hmpicture}"><br/>
			内容：<textarea rows="" cols="" name="hotmajor.hmcontent" id="nr">${hotmajor.hmcontent}</textarea>
		</form>
		<input type="hidden" value="${hotmajor.hmtitle }" id="p1">
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