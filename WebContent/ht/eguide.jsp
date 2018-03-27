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
		var type = $("#type").val();
		var url='?type='+type+'';
		$("#dog").datagrid(
				{
					url : 'seleguide'+url+'',
					title : '热门专业信息',
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							$('#w').window('open');
							$('#w').window('refresh',
									'../htinclude/addeguide.jsp');
						}
					} ],
					columns : [ [
							{
								field : 'id',
								title : 'id',
								width : 40,
								order : 'asc'
							},
							{
								field : 'log',
								title : '学校图标',
								width : 100
							},
							{
								field : 'school',
								title : '学校介绍',
								width : 100
							},
							{
								field : 'picture1',
								title : '学校图片',
								width : 100
							},
							{
								field : 'title',
								title : '学校简介',
								width : 100
							},
							{
								field : 'picture2',
								title : '专业图片',
								width : 100
							},
							{
								field : 'picture3',
								title : '毕业证书图片',
								width : 100
							},
							{
								field : 'type',
								title : '学院',
								width : 100
							},
							{
								field : "cz",
								title : "操作",
								width : 160,
								align : 'left',
								formatter : function(value, row, index) {
									var btn = '<a class="edit" onclick="bj('
											+ row.id
											+ ')" >编辑</a>';
									btn += ' | <a class="del"  onclick="sc('
											+ row.id + ')" >删除</a>';
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
	function bj(id) {
		$('#ws').window('open');
		$('#ws').window('refresh',
				'eguideeditsel?id='+id+'');
	};
	function sc(id) {
		alert("即将删除");
		$.ajax({
			async : 'true',
			cache : 'true',
			url : 'deleguide',
			type : 'post',
			data : {
				'id' : id
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
				学院：<input type="text"  id="type"/>
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
		style="width: 400px; height: 400px; padding: 5px;"></div>
	<div id="ws" class="easyui-window" title="编辑"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 400px; height: 400px; padding: 5px;"></div>
</body>
</html>