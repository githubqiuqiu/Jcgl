<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
</head>
<script type="text/javascript">
	$(function(){
		s();
	});
	function s(){
		$("#dog").datagrid(
				{
					url : 'sellog',
					title : '登陆信息',
					columns : [ [
							{
								field : 'id',
								title : 'id',
								width : 40,
								order : 'asc'
							},
							{
								field : 'loginname',
								title : '登陆名',
								width : 100
							},
							{
								field : 'rolename',
								title : '用户名',
								width : 100
							},
							{
								field : 'optcontent',
								title : '内容',
								width : 300
							},
							{
								field : 'clientip',
								title : 'ip',
								width : 100
							},
							{
								field : 'createtime',
								title : '时间',
								width : 200
							}
					] ]	,
					pagination : true,
					striped : true,
					singleSelect : true,
				});
	}
	
</script>
<body class="easyui-layout">
	<div data-options="region:'center'">
		<table id="dog" fit="true"></table>
	</div>
</body>
</html>