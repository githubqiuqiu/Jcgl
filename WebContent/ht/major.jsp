<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
<script type="text/javascript">
	$(function() {
		s();
	});
	function s() {
		var aschool = $("#aschool").val();
		var aflag = $("#aflag").val();
		var url = '?aschool=' + aschool + '&aflag=' + aflag + '';
		$("#dg")
				.datagrid(
						{
							url : 'selmajors' + url + '',
							title : '专业管理',
							toolbar : [ {
								text : '添加',
								iconCls : 'icon-add',
								handler : function() {
									$('#w').window('open');
									$('#w').window('refresh',
											'../htinclude/majorindex.jsp');
								}
							} ],
							columns : [ [
									{
										field : 'aid',
										title : 'id',
										width : 40,
										order : 'asc'
									},
									{
										field : 'aschool',
										title : '学校',
										width : 100
									},
									{
										field : 'aflag',
										title : '隶属种类',
										width : 100,
										formatter : function(value, row, index) {
											if (value == 0) {
												return "成人教育";
											} else {
												return "国家开发大学";
											}
										}
									},
									{
										field : 'sname',
										title : '专业',
										width : 100
									},
									{
										field : "cz",
										title : "操作",
										width : 160,
										align : 'left',
										formatter : function(value, row, index) {
											var btn = '<a class="edit" onclick="bj('
													+ row.aid
													+ ','
													+ row.sid
													+ ')" >编辑</a>';
											btn += ' | <a class="del"  onclick="sc('
													+ row.asid + ')" >删除</a>';
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

	};
	function bj(aid, sid) {
		$('#ws').window('open');
		$('#ws').window('refresh',
				'editmajor.action?aid=' + aid + '&sid=' + sid + '');
	};
	function sc(asid) {
		// 	alert("123");
		$.ajax({
			async : 'true',
			cache : 'true',
			url : 'del',
			type : 'post',
			data : {
				'asid' : asid
			},
			dataTape : 'json',
			success : function() {
				// 			alert("123!");
				s();
			},
			error : function(XMLHttpRequest, textStates) {

			}
		});
	};
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'">
		<div style="padding: 5px">
			<form method="post" id="fm">
				学校查询：<input type="text" class="easyui-input" name="academy.aschool"
					id="aschool" /> 隶属种类：<select style="width: 120px"
					name="academy.aflag" id="aflag" >
					<option value="x" selected="selected">-请选择-</option>
					<option value="1">国家开发大学</option>
					<option value="0">成人教育</option>
				</select> <a class="easyui-linkbutton" data-options="iconCls:'icon-add'"
					onclick="s()">查询</a> <a class="easyui-linkbutton"
					data-options="iconCls:'icon-add'"
					onclick="javascript:$('#fm')[0].reset()">清空</a>
			</form>
		</div>
	</div>
	<div data-options="region:'center'">
		<table id="dg" fit="true"></table>
	</div>
	<div id="w" class="easyui-window" title="添加"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 300px; height: 150px; padding: 5px;"></div>
	<div id="ws" class="easyui-window" title="编辑"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 300px; height: 150px; padding: 5px;"></div>
</body>
</html>