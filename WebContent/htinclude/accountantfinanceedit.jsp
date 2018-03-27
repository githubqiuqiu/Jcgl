<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <s:include value="link.jsp"></s:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

$(function(){
    $('#fstatu').combobox({    
         required:true,    
         multiple:true,
         disabled:true  
   });  
});

//提交修改的成人高考缴费表
function editaccfinance(){
	var ftest1=$("#ftest1").val();
	var fway=$("#fway").val();

	if(ftest1==""){
	$("#ftest1").focus();
	 $("#msgs").html("<font color='red'>请输入本次的缴费金额</font>");
		 setTimeout("$('#msgs').html('');",2000);
		 return;
	}
	if(isNaN(ftest1)){
		$("#ftest1").val("");
		$("#ftest1").focus();
		 $("#msgs").html("<font color='red'>请输入正确的缴费金额</font>");
			 setTimeout("$('#msgs').html('');",2000);
			 return;
		}
	if(fway==""){
		 $("#msgs").html("<font color='red'>请选择缴费方式</font>");
		 setTimeout("$('#msgs').html('');",2000);
		 return;
	}
	
	
	 $.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'editaccfinance',
	 	 type:'post',
	 	data:$('#updaccfinance').serialize(),
	 	 //datatype:'json',
	 	 success:function(result){
	 		 $('#winedit').window('close');
	 		//alert("返回成功"); 
			add();
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 });
}


</script>



</head>
<body>

<form action="" method="post" id="updaccfinance">
	<input type="hidden" name="accountantfinancebean.fid" id="fid" value="${afb.fid }">
	<input type="hidden" name="accountantfinancebean.sid" id="sid" value="${afb.sid }">
	
	<table>
		<tr>
			<td>学生ID/姓名:</td>
			<td><input name="sid" readonly="readonly"  id="sid" value="${afb.sid} / ${afb.sname}"   type="text" placeholder="请输入角色名称" class="easyui-validatebox"></td>
			<td>合作老师:</td>
			<td> <input name="accountantfinancebean.username"  id="username" value="${afb.username}" readonly="readonly"  type="text" placeholder="请输入合作老师名称" class="easyui-validatebox"></td>
		</tr>
		
		<tr>
			<td>需交金额:</td>
			<td> <input name="accountantfinancebean.needmoney"  id="needmoney" value="${afb.needmoney}" readonly="readonly"  type="text" placeholder="请输入需交金额" class="easyui-validatebox"></td>
			
			<td>实交金额:</td>
			<td> <input name="accountantfinancebean.practicalmoney"  id="practicalmoney" value="${afb.practicalmoney}" readonly="readonly"  type="text" placeholder="请输入实交金额" class="easyui-validatebox"></td>
			
		</tr>
		
			<tr>
			<td>本次缴费:</td>
			<td> <input name="accountantfinancebean.ftest1"  id="ftest1"   type="text" placeholder="请输入本次缴费金额" class="easyui-validatebox"></td>
			
			<td>缴费方式:</td>
			<td>
				<select name="accountantfinancebean.fway" id="fway"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                       <option  value="">请选择缴费方式</option>
                       <option value="支付宝">支付宝</option>
                       <option value="微信">微信</option>
                       <option value="银行转账">银行转账</option>
                       <option value="现金">现金</option>
                   </select>
			</td>
		</tr>
		
		<tr>
			<td>缴费状态</td>
			<td>
				<select name="accountantfinancebean.fstatu" id="fstatu"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                       <option value="0"  ${afb.fstatu=='0'?'selected':'' } >未缴费</option>
                       <option value="1"  ${afb.fstatu=='1'?'selected':'' }>未缴清</option>
                       <option value="2"  ${afb.fstatu=='2'?'selected':'' }>已缴清</option>
                   </select>
			</td>
			<td></td>
			<td></td>
		</tr>
		
	</table>
		<center><span id="msgs"></span></center> 
	  <div align="center"><a href="#" onclick="editaccfinance()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
</form>



</body>
</html>