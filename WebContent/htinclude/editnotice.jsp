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
		var bt = $("#bt").val();
		var nr = $("#nr").val();
		var rq = $("#rq").val();
		
		if(bt==""){
			$("#msg").html("<font color='red'>请输入标题</font>");
			setTimeout("$('#msg').html('')",2000);
		}else if(nr==""){
			$("#msg").html("<font color='red'>请输入内容</font>");
			setTimeout("$('#msg').html('')",2000);
		}else{
			if(rq.trim()==""){
				$("#msg").html("<font color='red'>请输入日期</font>");
				setTimeout("$('#msg').html('');",2000);
				return;
			}
				var r=rq.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
			    if(r==null){
			      alert("请输入格式正确的日期\n\r日期格式：yyyy-mm-dd\n\r例    如：2008-08-08\n\r");
			      return;
			    }
			    var d=new Date(r[1],r[3]-1,r[4]);   
			    var num = (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
			    if(num==0){
			      alert("请输入格式正确的日期\n\r日期格式：yyyy-mm-dd\n\r例    如：2008-08-08\n\r");
			      return;
			    }
			    $("#m").submit();
		}
		
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 120px">
		<form action="editnotice" method="post" id="m">
			<input type="hidden" name="notice.nid" value="${notice.nid }">
			标题：<input class="easyui-textbox" name="notice.ntitle" value="${notice.ntitle}" id="bt"><br/>
			内容：<input class="easyui-textbox" name="notice.ncontent" value="${notice.ncontent}" id="nr"><br/>
			日期：<input class="easyui-datebox" name="notice.ndate" value="${notice.ndate}" id="rq"><br/>
		</form>
	</div>
	<div data-options="region:'north',split:true">

		<div align="right">
		<hr/>
		<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">修改</a>
		</div>
	</div>
</body>
</html>