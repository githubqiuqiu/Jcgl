<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
<!-- 引入JQuery -->
 <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.min.js"></script>
 <!-- 引入EasyUI -->
 <script type="text/javascript" src="../jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
 <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
 <script type="text/javascript" src="../jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
 <!-- 引入EasyUI的样式文件-->
 <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"/>
 <!-- 引入EasyUI的图标样式文件-->
 <link rel="stylesheet" href="../jquery-easyui-1.5.2/themes/icon.css" type="text/css"/>

<style type="text/css">
a{
	text-decoration: none;
}
</style>

<script type="text/javascript">
	
$(function(){
	//运行数据显示方法
	add();
	
});

function add(){
	//数据显示
	$('#tab').datagrid({
		toolbar: [{
			text:"添加",
			iconCls: 'icon-add',
			handler: function(){
				adddata();
				
			}
		}],
		
		url:"findrole",
		nowrap:true,//设置为 true，则把数据显示在一行里。设置为 true 可提高加载性能。
		rownumbers:true,//设置为 true，则显示带有行号的列。
		singleSelect:true,//设置只能选中单行
		striped:true,//设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
		idField:"id",//指示哪个字段是标识字段。
		pagination:true,//设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
		pageSize:10,//当设置了 pagination 属性时，初始化页面尺寸（设置分页页数）
		fitColumns:true,//设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		sortName:"id",//定义可以排序的列。
		sortOrder:"asc",//
		columns:[[
			{field : "id", title : "ID",width:100},
			{field : "name", title : "角色名" ,width:100 },
			{field : "seq", title :"排序号" ,width:100},
			{field : "description", title :"权限" ,width:100},
			{field : "status", title : "状态" ,width:100 ,
				 formatter : function(value, row, index) {
	                    if (value == 0) {
	                        return '正常';
	                    } else {
	                        return '停用';
	                    }
	                }	
			
			},
			{field : "action", title :"操作"  ,width:100 ,
				formatter : function(value,row, rec) {
				var btn ='';
				var id = row.id;
				
				
				 if(row.name!='超级管理员'){
					 btn+="<a class='grant'  href='#' onclick='grant("+row.id+")'>授权</a>"
					 btn+=" |  <a class='editcls'  href='#' onclick='edit("+row.id+")'>编辑</a>";

					 btn+=" | <a class='delstyle'  href='#' onclick='del("+id+")'>删除</a>";
				 } 
				return btn;
			}}
		
	  ]],
		onLoadSuccess : function(data) {
			$('.grant').linkbutton({
				text : '授权',
				plain : true,
				iconCls : 'icon-edit'
			});
			
			$('.editcls').linkbutton({
				text : '编辑',
				plain : true,
				iconCls : 'icon-edit'
			});
			$('.delstyle').linkbutton({
				text : '删除',
				plain : true,
				iconCls : 'icon-remove'
				
			});
		}
	  
	  
	});
}

//点击添加 弹出窗口
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','../htinclude/roleadd.jsp');
}
//添加窗口里面的提交 把数据插入数据库
function addrole(){
	
	$('#winadd').window('close');
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'addrole',
	 	 type:'post',
	 	 data:$('#addfrom').serialize(),
	 	 datatype:'json',
	 	 success:function(result){
			add();
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 });
 }
 
 //删除角色信息
 function del(id){
	 
	 $.messager.confirm('删除数据', '您确定要删除此数据?', function(r){
			if (r){
				
				 $.ajax({
					 async:true,
				 	 cache:true,
				 	 url:'delrole',
				 	 type:'post',
				 	 data:{
				 		 'role.id':id,
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
	  $('#winedit').window('refresh','beforeroleedit.action?id='+id);	
 }
 
 //授权
 function grant(id){

	  $('#wingrant').window('open');
	  $('#wingrant').window('refresh','../findgrant.action?rid='+id);
 }

	
 
</script>



</head>
<body class="easyui-layout">
	
	<div data-options="region:'center'" style="height:50px">
		<table id="tab" fit="true" class="easyui-datagrid" style="padding:0px" title="用户列表"></table>
	</div>
	
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:300px;height:220px;padding:5px;">
		
	
		
	</div>
    	
    	
    	<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:300px;height:200px;padding:5px;">
		</div>
    	
    	<!-- 授权窗口 -->
    	<div id="wingrant" class="easyui-window" 
		title="授权" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:400px;height:300px;padding:5px;">
		</div>
    	
	
</body>
</html>