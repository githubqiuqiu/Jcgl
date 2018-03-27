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
function editdisfinance(){
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
	 	 url:'editdisfinance',
	 	 type:'post',
	 	data:$('#upddisfinance').serialize(),
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

<form action="" method="post" id="upddisfinance">
	<input type="hidden" name="disfinancebean.fid" id="fid" value="${dfb.fid }">
	<input type="hidden" name="disfinancebean.sid" id="sid" value="${dfb.sid }">
	
	<table>
		<tr>
			<td>学生ID/姓名:</td>
			<td> <input name="sid" readonly="readonly"  id="sid" value="${dfb.sid} / ${dfb.sname}"   type="text" placeholder="请输入角色名称" class="easyui-validatebox"></td>
			<td>合作老师:</td>
			<td> <input name="disfinancebean.username"  id="username" value="${dfb.username}" readonly="readonly"  type="text" placeholder="请输入合作老师名称" class="easyui-validatebox"></td>
		</tr>
		
		<tr>
			<td>需交金额:</td>
			<td> <input name="disfinancebean.needmoney"  id="needmoney" value="${dfb.needmoney}" readonly="readonly"  type="text" placeholder="请输入需交金额" class="easyui-validatebox"></td>
			
			<td>实交金额:</td>
			<td> <input name="disfinancebean.practicalmoney"  id="practicalmoney" value="${dfb.practicalmoney}" readonly="readonly"  type="text" placeholder="请输入实交金额" class="easyui-validatebox"></td>
			
		</tr>
		
			<tr>
			<td>本次缴费:</td>
			<td> <input name="disfinancebean.ftest1"  id="ftest1"   type="text" placeholder="请输入本次缴费金额" class="easyui-validatebox"></td>
			
			<td>缴费方式:</td>
			<td>
				<select name="disfinancebean.fway" id="fway"  class="easyui-combobox"    data-options="width:140,height:29,editable:false,panelHeight:'auto'">
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
				<select name="disfinancebean.fstatu" id="fstatu"   class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                       <option value="0"  ${dfb.fstatu=='0'?'selected':'' } >未缴费</option>
                       <option value="1"  ${dfb.fstatu=='1'?'selected':'' }>未缴清</option>
                       <option value="2"  ${dfb.fstatu=='2'?'selected':'' }>已缴清</option>
                   </select>
			</td>
			<td>报考层次</td>
			<td><input name="disfinancebean.gradation"  id="gradation" value="${dfb.gradation}" readonly="readonly"  type="text" placeholder="请输入报考层次" class="easyui-validatebox"></td>
		</tr>
		
	</table>
	<center><span id="msgs"></span></center> 
	  <div align="center"><a href="#" onclick="editdisfinance()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>
</form>



</body>
</html>