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

function upload(){
	//easyui file框获值
	var files=$('#files').textbox('getValue');
	var index=files.lastIndexOf(".");
	//后缀
	var hz=files.substring(index);
	//判断后缀的格式正不正确
	if(hz==".xlsx"){
		$("#addmany").submit();
	}
	else{
		alert("请选择xls格式的文件");
		return;
	}
}







</script>


</head>
<body>

<form action="adultapplyaddmanyfileupload" id="addmany" method="post" enctype="multipart/form-data">

<input class="easyui-filebox" id="files" style="width:100%" name="myfile" data-options="prompt:'请选择格式为.xlsx格式的文件'">
<div style="height: 10px"></div>
<center><a href="downloadmoban.action"   class="easyui-linkbutton" icon="icon-print">下載模板</a></center>
<div style="height: 10px"></div>
<center><a href="#" onclick="upload()" class="easyui-linkbutton" icon="icon-ok">Ok</a></center>
</form>


</body>
</html>