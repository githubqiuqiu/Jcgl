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
function editfile(){

	/* var photo=$('#photo').val();
	var pz=$('#pz').val();
	var lw=$('#lw').val();
	
 	var pp=$("input[name='stufile.sfphoto']").val();
	var vv=$("input[name='stufile.sfvoucher']").val();
	var pa=$("input[name='stufile.sfpaper']").val();
	
	alert(photo);
	alert(pz);
	alert(lw);
	
	alert(pp);
	alert(vv);
	alert(pa); 
	
	if(photo==pp){//如果相片没改
		$("#changephoto").val("a");
	}
	else{
		$("#changephoto").val("b");
	}
	
	
	if(pz==vv){//如果凭证没改
		$("#changevoucher").val("a");
	}
	else{
		$("#changevoucher").val("b");
	}
	
	if(lw==pa){
		$("#changepaper").val("a");
	}else{
		$("#changepaper").val("b");
	}
	
	
	var cphoto=$("#changephoto").val();
	var cvoucher=$("#changevoucher").val();
	var cpaper=$("#changepaper").val();
	alert(cphoto);
	alert(cvoucher);
	alert(cpaper); */
	/* 
	var xx=$('#changephoto').val();
	alert(xx);
	
	var yy=$('#changevoucher').val();
	alert(yy);
	
	var zz=$('#changepaper').val();
	alert(zz); */
	
	
	
	
	
	$("#editform").submit();
	
}	

	
	
</script>
</head>
<body >

		<form action="editfile" method="post" id="editform" enctype="multipart/form-data">
			<input type="hidden" name="stufile.sfid" value="${sf.sfid}">
			<input type="hidden"  name="stufile.sfphoto" value="${sf.sfphoto}">
			<input type="hidden"  name="stufile.sfvoucher" value="${sf.sfvoucher}">
			<input type="hidden"  name="stufile.sfpaper" value="${sf.sfpaper}">
			<input type="hidden" name="stufile.sfdate" value="${sf.sfdate}">
			
			<input type="hidden"  id="changephoto" name="changephoto" value="">
			
			<input type="hidden"  id="changevoucher" name="changevoucher" value="">
			
			<input type="hidden"  id="changepaper" name="changepaper" value="">
			
			<table  width="100%">
			
			<tr>
			<td align="right">学生编号:</td>
			<td><input type="text" readonly="readonly" name="stufile.stuid" value="${sf.stuid}"></td>
			</tr>
			
			<tr>
			<td align="right">学生姓名:</td>
			<td><input type="text" readonly="readonly" name="stufile.stuname" value="${sf.stuname}"></td>
			</tr>
			
			
			  <tr>
                <td align="right">相片：</td>
                 <td><input class="easyui-filebox"  data-options="onChange:function(){$('#changephoto').val($(this).filebox('getValue'))}" id="photo" style="width:96%" name="myfile" value="${sf.sfphoto }"></td> 
                </tr>
            
            	<tr>
            	<td align="right">缴费凭证：</td>
                <td>
              	<input class="easyui-filebox"  data-options="onChange:function(){$('#changevoucher').val($(this).filebox('getValue'))}" id="pz" style="width:90%" name="myfile" value="${sf.sfvoucher }">
                </td>
            	</tr>
            	
            	<tr>
            	<td align="right">论文：</td>
                <td>
              	<input class="easyui-filebox" data-options="onChange:function(){$('#changepaper').val($(this).filebox('getValue'))}" id="lw" style="width:90%" name="myfile" value="${sf.sfpaper }">
                </td>
            	</tr>
			
			</table>
			
		</form>

	<div data-options="region:'south',split:true">
		
		<hr/>
	<div align="center" ><a href="#" onclick=" editfile()" class="easyui-linkbutton" icon="icon-ok">Ok</a></div>

		
	</div>
</body>
</html>