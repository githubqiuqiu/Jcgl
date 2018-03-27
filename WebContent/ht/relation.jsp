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
		var rcontent = $("#rcontent").val();
		var url='?rcontent='+rcontent+'';
		$("#dog").datagrid(
				{
					url : 'selrelation'+url+'',
					title : '热门专业信息',
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							$('#w').window('open');
							$('#w').window('refresh',
									'../htinclude/addrelation.jsp');
						}
					} ],
					columns : [ [
							{
								field : 'rid',
								title : 'id',
								width : 40,
								order : 'asc'
							},
							{
								field : 'rqq',
								title : 'qq',
								width : 100
							},
							{
								field : 'rphone',
								title : '电话',
								width : 100
							},
							{
								field : 'rcontent',
								title : '名称',
								width : 100
							},
							{
								field : 'reffect',
								title : '负责',
								width : 100
							},
							{
								field : "cz",
								title : "操作",
								width : 160,
								align : 'left',
								formatter : function(value, row, index) {
									var btn = '<a class="edit" onclick="bj('
											+ row.rid
											+ ')" >编辑</a>';
									btn += ' | <a class="del"  onclick="sc('
											+ row.rid + ')" >删除</a>';
									return btn;
								},
							} ] ],
					pagination : true,
					striped : true,
					singleSelect : true,
					onLoadSuccess : function(data) {
						$('.edit').linkbutton({
							text : '编辑',
							plain : true,
							iconCls : 'icon-edit'
						});
						$('.del').linkbutton({
							text : '删除',
							plain : true,
							iconCls : 'icon-edit'
						});
					}
				});
	}
	function bj(rid) {
		$('#ws').window('open');
		$('#ws').window('refresh',
				'relationeditsel?rid='+rid+'');
	};
	function sc(rid) {
		alert("即将删除");
		$.ajax({
			async : 'true',
			cache : 'true',
			url : 'delrelation',
			type : 'post',
			data : {
				'rid' : rid
			},
			dataTape : 'json',
			success : function() {
				// 			alert("123!");
				 $("#dog").datagrid('reload');
			},
			error : function(XMLHttpRequest, textStates) {

			}
		});
	};
</script>
<body class="easyui-layout">
	<div data-options="region:'north'">
		<div style="padding: 5px">
			<form method="post" id="zz">
				名称：<input type="text"  id="rcontent"/>
					<a class="easyui-linkbutton" data-options="iconCls:'icon-add'"
					onclick="s()">查询</a> <a class="easyui-linkbutton"
					data-options="iconCls:'icon-add'"
					onclick="javascript:$('#zz')[0].reset()">清空</a>
			</form>
		</div>
	</div>
	<div data-options="region:'center'">
		<table id="dog" fit="true"></table>
	</div>
	<div id="w" class="easyui-window" title="添加"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 300px; height: 200px; padding: 5px;"></div>
	<div id="ws" class="easyui-window" title="编辑"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 300px; height: 200px; padding: 5px;"></div>
</body>
</html>