<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
$(function(){
	//运行数据显示方法
	selstu();
	
	
	
	
});

function selstu(){
	//数据显示
	 $('#tabs').datagrid({
		
		url:'seladultstu',
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
			{field : "aid", title : "aid",width:50,hidden:true},
			{field : "astudentno", title : "学生编号" ,width:80 },
			{field : "aname", title :"学生姓名" ,width:80},
			{field : "username", title :"老师名称" ,width:80},
			{field : "caozuo", title :"操作"  ,width:150 ,
				formatter : function(value,row, rec) {
				var btn ='' ;
				btn+="<a class='editcls'  href='#' onclick='sel("+row.astudentno+")'>编辑</a>";
					
				
						
					
				return btn;
			}}
			
		
	  ]],
	  onLoadSuccess : function(data) {
			$('.editcls').linkbutton({
				text : '选择',
				plain : true,
				iconCls : 'icon-edit'
			});
		
		}
	  
	  
	}); 

}

function sel(id,name){
	
	 $('#winsel').window('close');
	 $("#winadd").window('close');
	 
	$('#winadd').window('open');
	$('#winadd').window('refresh',"back?id="+id);
}


</script>



</head>

<body class="easyui-layout">
	
	
	
		<table id="tabs"  width="100%" height="100%" class="easyui-datagrid" style="padding:0px"></table>

	
</body>
</html>