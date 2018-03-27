<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:include value="link.jsp"></s:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub() {
		var mc = $("#mc").val();
		var zy = $("#zy").val();
		
		if(mc==""){
			$("#msg").html("<font color='red'>请输入学院</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(zy==""){
			$("#msg").html("<font color='red'>请输入专业</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			$("#frm").submit();
		}
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 70px">
		<form action="edit" method="post" id="frm">
			<input type="hidden" name="acaspeBean.aid" value="${acaspeBean.aid }">
			<input type="hidden" name="acaspeBean.asid"
				value="${acaspeBean.asid }" > 学校名称：<input type="text"
				class="easyui-textbox" style="width: 120px"
				name="acaspeBean.aschool" value="${acaspeBean.aschool}" id="mc"/><br />
			隶属种类：<select style="width: 120px;" class="easyui-combobox"
				name="acaspeBean.aflag" data-options="editable:false,panelHeight:'auto'">
				<option value="1" ${acaspeBean.aflag==1?'selected':''}>国家开发大学</option>
				<option value="0" ${acaspeBean.aflag==0?'selected':''}>成人教育</option>
			</select><br /> 专业：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" class="easyui-textbox" style="width: 120px"
				name="acaspeBean.sname" value="${acaspeBean.sname }" id="zy"/>
		</form>
	</div>
	<div data-options="region:'north',split:true">
		<div align="right">
		<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">修改</a>
		</div>
	</div>
</body>
</html>