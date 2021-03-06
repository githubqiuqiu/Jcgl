<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:include value="link.jsp"></s:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
<script type="text/javascript">
	$(function(){
		add();
	});
	
	//点击添加 弹出窗口
	
//点击添加 弹出窗口
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','../htinclude/depadd.jsp');
}
	
	

	function add(){
		$("#dg").datagrid({
			url:'department',
			toolbar: [{
				text:'添加',
				iconCls: 'icon-add',
				handler: function(){
					adddata();
				}
			}],
			
			rownumbers:true,//设置为 true，则显示带有行号的列。
		    columns:[[
		    	{field:'id',title:'ID',width:40,hidden:true},
				{field:'code',title:'编号',width:40},
				{field:'name',title:'部门名称',width:100},
				
				{field:'address',title:'地址',width:160},				
				{field:'seq',title:'排序',width:100},
				{field:'createtime',title:'创建时间',width:160}, 
				{field:'icon',title:'图标',width:140},
				{
					field : "cz",
					title : "操作",
					width : 160,
					align : 'left',
					formatter : function(value, row,index) {
						var btn = "<a class='edit'  href='#' onclick='edit("+row.id+")'>编辑</a>";
					
						btn+=" | <a class='del'  href='#' onclick='del("+row.id+")'>删除</a>"
						return btn;
					},
				}
		    ]],
		    pagination:true,
		    striped:true,
		    singleSelect:true,
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
	
	//删除
	function del(id){	
		$.messager.confirm('删除数据', '您确定要删除此数据?', function(r){
			if (r){
				
				$.ajax({
					 async:true,
				 	 cache:true,
				 	 url:'delorg',
				 	 type:'post',
				 	 data:{
				 		 'organization.id':id,
				 	 },
				 	 datatype:'json',
				 	 success:function(result){
						add();
				 	 },
				 	 error:function(XMLHttpRequest,textStatus){
				 		 alert("错误");
				 	 }
				 });
			}
		});
		
		 
	}
	
	//编辑
	function edit(id){
		$('#winedit').window('open');
		$('#winedit').window('refresh','beforedepedit.action?id='+id);
	}
	
	
	
	
</script>
</head>
<body class="easyui-layout">
<div data-options="region:'center'">
	<table id="dg" class="easyui-datagrid" fit="true"></table>
</div>

<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:200px;padding:5px;">
		
	</div>
	
	
    	<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:500px;height:200px;padding:5px;">
		</div>	
	

</body>
</html>