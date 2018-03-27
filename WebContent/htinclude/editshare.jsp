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
		var pho = $("#pho").val();
		var nr = $("#nr").val();
		var pic = $("#pic").val();
		if(bt==""){
			$("#msg").html("<font color='red'>请输入标题</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(pho==""){
			$("#msg").html("<font color='red'>请选择图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(nr==""){
			$("#msg").html("<font color='red'>请输入内容</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(pic==""){
			$("#msg").html("<font color='red'>请选择图片</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#m").submit();
		}
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 180px">
		<form action="editshare" method="post" id="m" enctype="multipart/form-data">
			<input type="hidden" name="share.shareid" value="${share.shareid}"/>
			标题：<input class="easyui-textbox" name="share.sharetitle" value="${share.sharetitle}" id="bt"><br/>
			图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#pho').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:60%" value="${share.sharephoto}"><br/>
			内容：<textarea rows="" cols="" name="share.sharecontent" id="nr">${share.sharecontent}</textarea><br/>
			图片：<input class="easyui-filebox" name="myFile" data-options="onChange:function(){$('#pic').val($(this).filebox('getValue'))},prompt:'Choose a file...'" style="width:60%" value="${share.sharepicture}"><br/>
			<input type="hidden" name="pic" id="pic" value="b"/>
			<input type="hidden" name="pho" id="pho" value="a"/>
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