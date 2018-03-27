<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="s" uri="/struts-tags" %>
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

//显示数据网格的方法
function add(){
	//var uname=$("#uname").val();
	var astudentno=$("#astudentno").val();
	var aname=$("#aname").val();
	var teacher=$("#teacher").val();
	//alert("学生编号"+astudentno);
	//alert("学生姓名"+aname);
	//alert("老师姓名"+teacher);
	
	//数据显示
	$('#tab').datagrid({
		
		toolbar: [{
			text:"添加",
			iconCls: 'icon-add',
			handler: function(){
				adddata();
			}
		}],
		
		url:"seldistance?astudentno="+astudentno+"&aname="+aname+"&teacher="+teacher,
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
			{field : "did", title : "did",width:50,hidden:true},
			{field : "dstudentno", title : "学生编号" ,width:80 },
			{field : "dname", title :"学生姓名" ,width:80},
			{field : "username", title :"老师名称" ,width:80},
			{field : "idnumber", title :"身份证号码",width:150},
			{field : "dphone", title : "手机号码",width:150},
					
			{field : "acaname", title : "报考院校",width:100},
			{field : "specname", title : "专业",width:80},
			{field : "dgradation", title : "报考层次",width:80},
			{field : "dsystem", title : "学制",width:80},
			{field : "dtype", title : "报名类型",width:80,
				  formatter : function(value, row, index) {
	                    if (value == 0) {
	                        return '远程教育';
	                    } 
	                } 
			
			},	
			{field : "cityname", title : "城市",width:50},
			{field : "countyname", title : "县/区",width:50},
			{field : "ddata", title : "报名时间",width:150},
			{field : "caozuo", title :"操作"  ,width:150 ,
				formatter : function(value,row, rec) {
				var btn ='' ;
				btn+="<a class='edit'  href='#' onclick='edits("+row.did+")'>编辑</a>";
				
				btn+=" | <a class='del'  href='#' onclick='del("+row.did+")'>删除</a>";
					
				return btn;
			}}
		
	  ]],
		onLoadSuccess : function(data) {
			$('.edit').linkbutton({
				text : '编辑',
				plain : true,
				iconCls : 'icon-edit'
			});
			$('.del').linkbutton({
				text : '删除',
				plain : true,
				iconCls : 'icon-remove'
				
			});
		}
	  
	  
	});
}


//添加学生信息
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','distanceadd.action');
}

//编辑学生信息(打开编辑窗口)
function edits(id){
	  //alert("进了编辑");
	  $('#winedit').window('open');
	  $('#winedit').window('refresh','beforedistanceedit.action?id='+id);
}

//删除远程教育报名信息
function del(id){
	
	 $.messager.confirm('删除数据', '您确定要删除此数据?', function(r){
			if (r){
				
				 $.ajax({
					 async:true,
				 	 cache:true,
				 	 url:'deldis',
				 	 type:'post',
				 	 data:{
				 		 'id':id,
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


//模糊查询
function serach(){
	
	
	add();
}

//清空文本框
function clears(){

	$("#astudentno").val("");
	$("#aname").val("");
	$("#teacher").val("");
}

</script>


</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:28px">
	<form action="">
		<b>学生编号:</b><input type="text" id="astudentno" name="astudentno" placeholder="请输入学生编号" style="height:15px">
		<b>学生姓名:</b><input type="text" id="aname" name="aname" placeholder="请输入学生姓名" style="height:15px">
		<!-- s标签的if 取session 要加#后面+session名称+字段 -->
		<s:if test="#session.user.rid ==1">
		<b>老师姓名:</b><input type="text" id="teacher" name="teacher" placeholder="请输入老师名称" style="height:15px"> 
		</s:if> 
		<a href="#" onclick="serach()" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
		<a href="#" onclick="clears()" class="easyui-linkbutton" plain="true" iconCls="icon-clear">清空</a>
	</form>
	</div>	
	
	<div data-options="region:'center'" style="height:50px">
		<table id="tab" fit="true" class="easyui-datagrid" style="padding:0px" title="学生信息表"></table>
	</div>
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:300px;padding:5px;">
		
	</div>
	
		<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:500px;height:280px;padding:5px;">
		</div>

</body>
</html>