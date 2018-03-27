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
					url : 'selhome',
					title : '热门专业信息',
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							$('#w').window('open');
							$('#w').window('refresh',
									'../htinclude/addhome.jsp');
						}
					} ],
					columns : [ [
							{
								field : 'hcid',
								title : 'id',
								width : 40,
								order : 'asc'
							},
							{
								field : 'pictureone',
								title : '轮播图1',
								width : 100
							},
							{
								field : 'picturetwo',
								title : '轮播图2',
								width : 100
							},
							{
								field : 'picturethree',
								title : '轮播图3',
								width : 100
							},
							{
								field : 'qrcodeone',
								title : '二维码1',
								width : 100
							},
							{
								field : 'qrcodetwo',
								title : '二维码2',
								width : 100
							},
							{
								field : 'hcphone',
								title : '电话',
								width : 100
							},
							{
								field : 'hcaddress',
								title : '地址',
								width : 100
							},
							{
								field : 'interlinkageone',
								title : '链接1',
								width : 100
							},
							{
								field : 'interlinkagetwo',
								title : '链接2',
								width : 100
							},
							{
								field : 'interlinkagethree',
								title : '链接3',
								width : 100
							},
							{
								field : 'interlinkagefour',
								title : '链接4',
								width : 100
							},
							{
								field : "cz",
								title : "操作",
								width : 160,
								align : 'left',
								formatter : function(value, row, index) {
									var btn = '<a class="edit" onclick="bj('
											+ row.hcid
											+ ')" >编辑</a>';
									btn += ' | <a class="del"  onclick="sc('
											+ row.hcid + ')" >删除</a>';
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
	function bj(hcid) {
		$('#ws').window('open');
		$('#ws').window('refresh',
				'homeeditsel?hcid='+hcid+'');
	};
	function sc(hcid) {
		alert("即将删除");
		$.ajax({
			async : 'true',
			cache : 'true',
			url : 'delhome',
			type : 'post',
			data : {
				'hcid' : hcid
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