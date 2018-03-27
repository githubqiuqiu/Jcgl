<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- <script type="text/javascript" src="sss/jquery-1.6.2.min.js"></script> -->
<script type="text/javascript">
$(function(){
	$.ajax({
		cache:true,
		async:true,
		url:'selfooter.action',
		type:'post',
		dataType:'json',
		success:function(result){
			$("#img1").html("<img src='upload/"+result.home[0].qrcodeone+"' width='300px' height:'300px'></img>");
			$("#img2").html("<img src='upload/"+result.home[0].qrcodetwo+"' width='300px' height:'300px'></img>");
			$("#s1").html(""+result.home[0].hcphone+"");
			$("#s2").html(""+result.home[0].hcaddress+"");
			$("#p1").html("<a href='"+result.home[0].interlinkageone+"' target='_blank'>培考网</a>");
			$("#p2").html("<a href='"+result.home[0].interlinkagetwo+"' target='_blank'>会计网</a>");
			$("#p3").html("<a href='"+result.home[0].interlinkagethree+"' target='_blank'>艺考网</a>");
			$("#p4").html("<a href='"+result.home[0].interlinkagefour+"' target='_blank'>学籍网</a>");
		},
		error:function(XMLHttpRequset,textStates){
			alert("意外的错误发生了!");
		}
	});
});
</script>
</head>
<body>
			<div align="center">
				<table  width="80%" >
					<tr align="center">
						<td style="padding: 2px"><div id="img1"></div></td>
						<td><div id="img2"></div></td>
					</tr>
					<tr><td style="height:20px">&nbsp;</td></tr>
					<tr align="center">
						<td>
							<b>电话：</b><span id="s1"></span><br/>
							<b>地址：</b><span id="s2"></span>
						</td>
						<td>
							友情链接<br/>
							<span id="p1"></span>&nbsp;&nbsp;<span id="p2"></span><br/>
							<span id="p3"></span>&nbsp;&nbsp;<span id="p4"></span><br/>
						</td>
					</tr>
				</table>
			</div>
</body>
</html>