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
 <script type="text/javascript" src="jquery-easyui-1.5.2/jquery.min.js"></script>
 <!-- 引入EasyUI -->
 <script type="text/javascript" src="jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
 <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
 <script type="text/javascript" src="jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
 <!-- 引入EasyUI的样式文件-->
 <link rel="stylesheet" href="jquery-easyui-1.5.2/themes/default/easyui.css" type="text/css"/>
 <!-- 引入EasyUI的图标样式文件-->
 <link rel="stylesheet" href="jquery-easyui-1.5.2/themes/icon.css" type="text/css"/>

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
	var userid=$("#userid").val();
	var stitle=$("#stitle").val();
	var sdate=$("#sdate").val();
	var finishdate=$("#finishdate").val();
	var status=$("#status").val();
	
	
	//数据显示
	$('#tab').datagrid({
		
		toolbar: [{
			text:"添加",
			iconCls: 'icon-add',
			handler: function(){
				adddata();
			}
		}],
		
		url:"selschedules?userid="+userid+"&stitle="+stitle+"&sdate="+sdate+"&finishdate="+finishdate+"&statu="+status,
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
			{field : "sid", title : "sid",width:50,hidden:true},
			{field : "username", title : "用户名称" ,width:80 },
			{field : "stitle", title :"主题" ,width:80},
			{field : "scontent", title :"内容" ,width:80},
			{field : "sdate", title :"创建时间",width:150},
			{field : "sfinishdate", title : "完成时间",width:150},
			{field : "sflag", title : "状态",width:150,
				 formatter : function(value, row, index) {
	                    if (value == 0) {
	                        return '未完成';
	                    } 
	                    else{
	                    	return '已完成';
	                    }
	                } 	
			
			},
					
			
			{field : "caozuo", title :"操作"  ,width:150 ,
				formatter : function(value,row, rec) {
				var btn ='' ;
				
				if(row.sflag==0){
				btn+="<a class='edit'  href='#' onclick='editschedule("+row.sid+")'>编辑</a>  | ";
				}
				
				btn+=" <a class='del'  href='#' onclick='del("+row.sid+")'>删除</a>";
					
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


//添加工作安排
function adddata(){
	$('#winadd').window('open');
	$('#winadd').window('refresh','addschedule.action');
}

//编辑工作安排
function editschedule(id){
	  $('#winedit').window('open');
	  $('#winedit').window('refresh','beforescheduleedit.action?id='+id);
}

//删除工作安排
function del(id){
	
	 $.messager.confirm('删除数据', '您确定要删除此数据?', function(r){
			if (r){
				
				 $.ajax({
					 async:true,
				 	 cache:true,
				 	 url:'delschedule',
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

	$("#userid").val("");
	$("#stitle").val("");
	$("#sdate").val("");
	$("#finishdate").val("");
	$("#status").val("");
}

</script>


</head>
<body class="easyui-layout">

	<div data-options="region:'north'" style="height:30px">
	<form action="" id="zz">
	
	
	<!-- s标签中使用el表达式需要加一个% -->
	<s:if test="%{rolename=='超级管理员'}">
	
		<b>用户姓名:</b>
		
	 <select id="userid" name="userid"  data-options="width:140,height:29,editable:false,panelHeight:'auto'">
	  <option value="" selected>请选择用户</option>
		<s:iterator value="listuser">
		
		<option value="${id }" >${name }</option>
		
		</s:iterator>
		
	</select>
	
	</s:if>
	
	
		
		
		
		<b>主题:</b><input type="text" id="stitle" name="stitle" placeholder="请输入主题" style="height:15px">
		<b>创建时间:</b><input class="easyui-datebox" type="text" id="sdate" name="sdate" placeholder="请输入创建时间" style="height:15px">
		<b>完成时间:</b><input class="easyui-datebox" type="text" id="finishdate" name="finishdate" placeholder="请输入完成时间" style="height:15px">
		<b>状态:</b>
		<select id="status" name="status"  data-options="width:140,height:29,editable:false,panelHeight:'auto'">
		 <option value="" selected>请选择状态</option>
		 <option value="0" >未完成</option>
		 <option value="1" >已完成</option>
		</select>
		
		<a href="#" onclick="serach()" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
		<a href="#" onclick="javascript:$('#zz')[0].reset()" class="easyui-linkbutton" plain="true" iconCls="icon-clear">清空</a>
	</form>
	</div>	
	
	<div data-options="region:'center'" style="height:50px">
		<table id="tab" fit="true" class="easyui-datagrid" style="padding:0px" title="工作助手"></table>
	</div>
	
	<!-- 添加窗口 -->
	<div id="winadd" class="easyui-window" 
		title="添加" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
						style="width:300px;height:200px;padding:5px;">
		
	</div>
	
		<!-- 编辑窗口 -->
    	<div id="winedit" class="easyui-window" 
		title="编辑" 
		data-options="modal:true,closed:true,collapsible:false,minimizable:false,maximizable:false,border:false" 
		style="width:300px;height:230px;padding:5px;">
		</div>

</body>
</html>