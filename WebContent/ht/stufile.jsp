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
	var id=$("#id").val();
	var name=$("#name").val();
	
	//数据显示
	$('#tab').datagrid({
		
		toolbar: [{
			text:"添加",
			iconCls: 'icon-add',
			handler: function(){
				adddata();
			}
		}],
		
		url:"selstufile?name="+name+"&id="+id,
		nowrap:true,//设置为 true，则把数据显示在一行里。设置为 true 可提高加载性能。
		rownumbers:true,//设置为 true，则显示带有行号的列。
		singleSelect:true,//设置只能选中单行
		striped:true,//设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
		idField:"id",//指示哪个字段是标识字段。
		pagination:true,//设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
		pageSize:10,//当设置了 pagination 属性时，初始化页面尺寸（设置分页页数）
		//fitColumns:true,//设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
		sortName:"id",//定义可以排序的列。
		sortOrder:"asc",//
		columns:[[
			{field : "sfid", title : "sfid",width:50,hidden:true},
			{field : "stuid", title : "学生编号" ,width:100 },
			{field : "stuname", title :"学生姓名" ,width:100},
			{field : "sfphoto", title :"相片" ,width:150},
			{field : "sfvoucher", title :"缴费凭证",width:150},
			{field : "sfpaper", title : "论文",width:150},
			{field : "sfdate", title : "上传时间",width:150},	
			{field : "caozuo", title :"操作"  ,width:370 ,
				formatter : function(value,row, rec) {
				var btn ='' ;
				btn+="<a class='editcls'  href='#' onclick='edit("+row.sfid+")'>编辑</a>";
				
				btn+=" | <a class='xp'  href='downloadphoto?sfid="+row.sfid+"' >下载相片</a>";
					
				btn+=" | <a class='pz' href='downloadvoucher?sfid="+row.sfid+"'>下载缴费凭证</a>";
				btn+=" | <a class='lw' href='downloadpaper?sfid="+row.sfid+"'>下载论文</a>";
				return btn;
			}}
		
	  ]],
		onLoadSuccess : function(data) {
			$('.editcls').linkbutton({
				text : '编辑',
				plain : true,
				iconCls : 'icon-edit'
			});
			$('.xp').linkbutton({
				text : '下载相片',
				plain : true,
				iconCls : 'icon-remove'
				
			});
			$('.pz').linkbutton({
				text : '下载缴费凭证',
				plain : true,
				iconCls : 'icon-remove'
				
			});
			$('.lw').linkbutton({
				text : '下载论文',
				plain : true,
				iconCls : 'icon-remove'
				
			});
		}
	  
	  
	});
}

//点击添加 弹出窗口
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','../htinclude/stufileadd.jsp');
}

 //点击弹出编辑框
 function edit(id){
	 
	$('#winedit').window('open');
	$('#winedit').window('refresh','beforeeditfile?id='+id);
	
 }
 
 //模糊查询
 function serach(){
	 add();
 }
 
 //清空查询框
 function clears(){
	 $("#id").val("");
	 $("#name").val("");
 }
 


</script>



</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:28px">
	<form action="">
		<b>学生编号:</b><input type="text" id="id" name="id" placeholder="请输入学生编号" style="height:15px">
		<b>学生姓名:</b><input type="text" id="name" name="name" placeholder="请输入学生姓名" style="height:15px">
		<a href="#" onclick="serach()" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
		<a href="#" onclick="clears()" class="easyui-linkbutton" plain="true" iconCls="icon-clear">清空</a>
	</form>
	</div>	
	
	<div data-options="region:'center'" style="height:50px">
		<table id="tab" fit="true" class="easyui-datagrid" style="padding:0px" title="文件上传"></table>
	</div>
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:400px;height:220px;padding:5px;">
		
	</div>
	
		<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:350px;height:220px;padding:5px;">
		</div>

</body>
</html> 

