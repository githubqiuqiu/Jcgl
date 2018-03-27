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
		var sm = $("#sm").val();
		var xh = $("#xh").val();
		var dh = $("#dh").val();
		var nr = $("#nr").val();
		var cs = $("#sel1").val();
		var xc = $("#sel2").val();
		var rq = $("#rq").val();
		
		if(sm==""){
			$("#msg").html("<font color='red'>姓名为空</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(xh==""){
			$("#msg").html("<font color='red'>学号为空</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(isNaN(xh)){
			$("#msg").html("<font color='red'>请正确输入学号</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(dh==""){
			$("#msg").html("<font color='red'>电话为空</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(isNaN(dh)){
			$("#msg").html("<font color='red'>请输入正确号码</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(dh.length!=11){
			$("#msg").html("<font color='red'>请输入正确号码</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(nr==""){
			$("#msg").html("<font color='red'>学习内容为空</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(cs==""){
			$("#msg").html("<font color='red'>城市为空</font>");
			setTimeout("$('#msg').html('');",2000);
		}else if(xc==""){
			$("#msg").html("<font color='red'>县城为空</font>");
			setTimeout("$('#msg').html('');",2000);
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
	 			$("#fo").submit();
		}
	}
	$(function() {
		$("#sel1").combobox({
			onChange : function(n, o) {
				var cid = $("#sel1").val();
				//当改变了院校  清空专业表的值
				// 				$("#sel2 option").remove();

				$('#sel2').combobox({
					valueField : 'coid', //值字段
					textField : 'coname', //显示的字段
					url : 'selcounty2?cityid=' + cid + '',
					panelHeight : 'auto',
					required : true,
					editable : true,//不可编辑，只能选择  
				});
			}
		});
	});
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'center',split:true" style="height: 200px">
		<form action="artadd" method="post" id="fo">
			姓名：<input type="text" class="easyui-textbox" name="abean.aname" id="sm"/>&nbsp;&nbsp;&nbsp;&nbsp;学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
				type="text" class="easyui-textbox" name="abean.astudentno" id="xh"/><br />
			<br />电话：<input type="text" class="easyui-textbox"
				name="abean.aphone"  id="dh"/>&nbsp;&nbsp;&nbsp;&nbsp;学习内容：<input
				type="text" class="easyui-textbox" name="abean.acontent" id="nr"/><br />
			<br />所属城市：<select id="sel1" class="easyui-combobox"
				name="abean.cid" style="width: 100px">
				<option value="" selected>请选择城市</option>
				<s:iterator value="citylist">
					<option value="${cid }">${cname }</option>
				</s:iterator>
			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所属地区：<select
				id="sel2" class="easyui-combobox" name="abean.coid"
				style="width: 100px">
				<option value="" selected>请选择县城</option>
				<s:iterator value="countylist">
					<option value="${coid }">${coname }</option>
				</s:iterator>
			</select><br /> <br />报名日期：<input type="text" class="easyui-datebox"
				name="abean.adata" id="rq"/>&nbsp;&nbsp;&nbsp;&nbsp; 老师：<select
				class="easyui-combobox" style="width: 100px" id="sel3" name="abean.id">
				<s:iterator value="userlist">
					<option value="${id}" ${name=='admin'?'selected':'' }>${name}</option>
				</s:iterator>
			</select>
		</form>
	</div>
	<div data-options="region:'north',split:true">
		<div align="right">
			<hr />
			<span id="msg"></span>
			<a class="easyui-linkbutton" onclick="sub()">修改</a>
		</div>
	</div>

</body>
</html>