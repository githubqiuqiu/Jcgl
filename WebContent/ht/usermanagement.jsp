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
	var uname=$("#uname").val();
	
	//数据显示
	$('#tab').datagrid({
		
		toolbar: [{
			text:"添加",
			iconCls: 'icon-add',
			handler: function(){
				adddata();
			}
		}],
		
		url:"findusermanagement?uname="+uname,
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
			{field : "id", title : "ID",width:50},
			{field : "loginname", title : "登录名" ,width:100 },
			{field : "name", title :"用户名" ,width:100},
			{field : "organizationname", title :"所属部门" ,width:100},
			{field : "createtime", title :"创建时间",width:150},
			{field : "sex", title : "性别",width:70,
				formatter : function(value, row, index) {
                    if (value == 0) {
                        return '男';
                    } else {
                        return '女';
                    }
                }			
			},
			{field : "age", title : "年龄" ,width:70},
			{field : "phone", title : "电话" ,width:100},
			{field : "rname", title :"角色名" ,width:100},
			{field : "usertype", title : "用户类型",width:100,
				 formatter : function(value, row, index) {
	                    if (value == 0) {
	                        return '管理员';
	                    } else {
	                        return '用户';
	                    }
	                }	
			
			},
			{field : "status", title : "状态" ,width:60 ,
				 formatter : function(value, row, index) {
	                    if (value == 0) {
	                        return '正常';
	                    } else {
	                        return '停用';
	                    }
	                }	
			
			},
			{field : "caozuo", title :"操作"  ,width:150 ,
				formatter : function(value,row, rec) {
				var btn ='' ;
				btn+="<a class='editcls'  href='#' onclick='edituser("+row.id+")'>编辑</a>";
				 if(row.rname!='超级管理员'){
						btn+=" | <a class='resert'  href='#' onclick='resert("+row.id+")'>重置密码</a>";
					} 
				return btn;
			}}
		
	  ]],
		onLoadSuccess : function(data) {
			$('.editcls').linkbutton({
				text : '编辑',
				plain : true,
				iconCls : 'icon-edit'
			});
			$('.resert').linkbutton({
				text : '重置密码',
				plain : true,
				iconCls : 'icon-remove'
				
			});
		}
	  
	  
	});
}

//点击添加 弹出窗口
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','beforeadduser');
}


 
 //重置密码
 function resert(id){
	 
	 $.messager.confirm('重置密码', '您确定要重置密码么?', function(r){
			if (r){
				
				
				 $.ajax({
					 async:true,
				 	 cache:true,
				 	 url:'resertpwd',
				 	 type:'post',
				 	 data:{
				 		 'user.id':id,
				 	 },
				 	 datatype:'json',
				 	 success:function(result){
						add();
				 	 },
				 	 error:function(XMLHttpRequest,textStatus){
				 		 alert("错误");
				 	 }
				 });
				 alert("重置成功");
			}
		});
 }
 
 //点击弹出编辑框
 function edituser(id){
	 
	$('#winedit').window('open');
	$('#winedit').window('refresh','beforeuseredit.action?id='+id);
	
 }
 
 //模糊查询
 function serach(){
	 add();
 }
 
 //清空查询框
 function clears(){
	
	 $("#uname").val("");
 }
 


</script>



</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:28px">
	<form action="">
		<b>用户名:</b><input type="text" id="uname" name="uname" placeholder="请输入姓名" style="height:15px">
		<a href="#" onclick="serach()" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
		<a href="#" onclick="clears()" class="easyui-linkbutton" plain="true" iconCls="icon-clear">清空</a>
	</form>
	</div>	
	
	<div data-options="region:'center'" style="height:50px">
		<table id="tab" fit="true" class="easyui-datagrid" style="padding:0px" title="用户列表"></table>
	</div>
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:500px;height:250px;padding:5px;">
		
	</div>
	
		<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:480px;height:260px;padding:5px;">
		</div>

</body>
</html> 

