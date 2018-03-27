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
	$("#fe").submit();
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 100px">
		<form id="fe" method="post" enctype="multipart/form-data" action="Readart">
			<input class="easyui-filebox" id="myFile" name="myFile" data-options="prompt:'Choose a Excelfile...'" style="width:60%"/>
		</form>
		<a class="easyui-linkbutton" onclick="sub()">添加</a>
	</div>
</body>
</html>