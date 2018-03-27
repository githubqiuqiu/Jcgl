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
		var pname = $("#pname").val();
		var name = $("#name").val();
		var cname = $("#cname").val();
		var url='?pname='+pname+'&name='+name+'&cname='+cname+'';
		$("#dog").datagrid(
				{
					url : 'selpro'+url+'',
					title : '学生信息',
					toolbar : [ {
						text : '添加',
						iconCls : 'icon-add',
						handler : function() {
							$('#w').window('open');
							$('#w').window('refresh',
									'../htinclude/proindex.action');
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
								field : 'astudentno',
								title : '学生编号',
								width : 100
							},
							{
								field : 'aname',
								title : '名字',
								width : 100
							},
							{
								field : 'name',
								title : '老师',
								width : 100
							},
							{
								field : 'aphone',
								title : '电话',
								width : 100
							},
							{
								field : 'acontent',
								title : '学习内容',
								width : 100
							},
							{
								field : 'cname',
								title : '城市',
								width : 100
							},
							{
								field : 'coname',
								title : '县城',
								width : 100
							},
							{
								field : 'adata',
								title : '报名时间',
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
											+ ')" >编辑</a>';
									btn += ' | <a class="del"  onclick="sc('
											+ row.aid + ')" >删除</a>';
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
	function bj(aid) {
		$('#ws').window('open');
		$('#ws').window('refresh',
				'selproedit?pid='+aid+'');
	};
	function sc(aid) {
			
	 $.messager.confirm('删除数据', '您确定要删除此数据?', function(r){
				if (r){
					
					$.ajax({
						async : 'true',
						cache : 'true',
						url : 'delpro',
						type : 'post',
						data : {
							'pid' : aid
						},
						dataTape : 'json',
						success : function() {
							// 			alert("123!");
							 $("#dog").datagrid('reload');
						},
						error : function(XMLHttpRequest, textStates) {

						}
					});
					
				}
			});
	};
</script>
<body class="easyui-layout">
	<div data-options="region:'north'">
		<div style="padding: 5px">
			<form method="post" id="zz">
				姓名查询：<input type="text"  id="pname"/>
				老师查询：<input type="text"  id="name"/>
				城市查询：<select  id="cname">
						<option value="">请选择城市</option>
						<s:iterator value="citylist">
							<option value="${cname }">${cname }</option>
						</s:iterator>
					   </select>
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
		style="width: 500px; height: 300px; padding: 5px;"></div>
	<div id="ws" class="easyui-window" title="编辑"
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false"
		style="width: 500px; height: 300px; padding: 5px;"></div>
</body>
</html>