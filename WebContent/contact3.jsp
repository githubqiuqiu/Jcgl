<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="s"  uri="/struts-tags"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>明志教育</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	

	

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<script src="sss/jquery-1.5.2.js"></script>
	
	<!-- QQ在线咨询导入文件 -->
<!--需要其它风格，可导入“style/”目录下的其它样式表文件-->
<link rel="stylesheet" type="text/css" href="style/default_blue.css"/>
<script src="sss/jquery-1.10.2.js"></script>
<!--低版本jQuery可以不调用jquery-migrate-1.2.1.min.js-->
<script src="sss/jquery-migrate-1.2.1.min.js"></script>
<script language="javascript" src="js/sonline.js"></script>

<script type="text/javascript">
<!-- QQ在线咨询 -->
$(function(){
	$("body").Sonline({		
		Position:"right",//left或right
		Top:320,//顶部距离，默认200px
		Effect:true, //滚动或者固定两种方式，布尔值：true或false
		DefaultsOpen:false, //默认展开：true,默认收缩：false
		Qqlist:"267335141|客服01,823234797|客服02,461202797|客服03,1010851542|客服04,790271961|客服05" //多个QQ用','隔开，QQ和客服名用'|'隔开
			
	});
})	
</script>
 <!-- 触发JS刷新-->
 <script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img"); 
        img.src = "/project/yzm?date=" + new Date();
    }
</script>

<script type="text/javascript">
//数据提交
var ss="${yzfh2}";
if(ss.length==1){
	<%
	session.removeAttribute("yzfh2");
 	%> 
	alert("验证码输入错误请重新填写！");

}else if(ss.length==2){
	alert("报名成功！");
	
}

      
 //账号验证      
        function yz() {
        	var obj="&nbsp;";
			$("#infos1").html(obj);
			setTimeout("$('#infos1').html('&nbsp;')",2000);
        	var uname=$("#name").val();
        	
			if(uname.length==0){
				var obj="名称不能为空！";
				$("#infos1").html(obj);	
				setTimeout("$('#infos1').html('&nbsp;')",2000);
			}
 }
 
//验证专业 
       function yz2() {
    	   var obj="&nbsp;";
			$("#infos3").html(obj);
			setTimeout("$('#infos3').html('&nbsp;')",2000);
    	   var uzname=$("#zname").val();
   
		if(uzname.length>4){    	   
			var obj="专业不能为空！";
			$("#infos3").html(obj);
			setTimeout("$('#infos3').html('&nbsp;')",2000);
		}
	}
	
	
//验证身份证
      function yz3() {
   	   var obj="&nbsp;";
		$("#infos2").html(obj);
		setTimeout("$('#infos2').html('&nbsp;')",2000);
	   var usfz=$("#sfz").val();
       if(usfz.length==0){
    	   var obj="身份证不能为空！";
			$("#infos2").html(obj);
			setTimeout("$('#infos2').html('&nbsp;')",2000);
       }else if(isNaN(usfz)){
    	   var obj="身份证只能是数字！";
			$("#infos2").html(obj);
			setTimeout("$('#infos2').html('&nbsp;')",2000);
       }else if(usfz.length<18){
    	   var obj="身份证不能小于18位！";
			$("#infos2").html(obj); 
			setTimeout("$('#infos2').html('&nbsp;')",2000);
       }
	    
	}
		
    //根据院校返回专业数据
      function yz4() {
       var yxz=$("#yx").val();
   	   var sContent = $("#zname").get(0);
 
   	   $.ajax({  
   	        type: "post",  
   	        url: "Acaspe.action",
   	        data: {"yxz":yxz},  
   	        dataType:"json",  
   	        async:true,  
   	        cache:true,  
   	        success: function(data){
   	        	var aa=data;	
   	        	sContent.options.length=0;
   	        	sContent.options.add(new Option("---请选择---",""));
   	        	for(var i=0;i<aa.length;i++){
   	        		//后面是id的值
   					sContent.options.add(new Option(aa[i].sname,aa[i].sid));
   		 }
   	        } 	        	
   	});
   	   
	}	
    
      //验证手机号
      function yz5() {
   	   var obj="&nbsp;";
		$("#infos4").html(obj);
		setTimeout("$('#infos4').html('&nbsp;')",2000);
	   var usjh=$("#sjh").val();
       if(usjh.length==0){
    	   var obj="手机号不能为空！";
			$("#infos4").html(obj);
			setTimeout("$('#infos4').html('&nbsp;')",2000);
       }else if(usjh.length<5){
    	   var obj="手机号填写有误！";
			$("#infos4").html(obj);
			setTimeout("$('#infos4').html('&nbsp;')",2000);
       }else if(isNaN(usjh)){
    	   var obj="手机号只能是数字！";
			$("#infos4").html(obj);
			setTimeout("$('#infos4').html('&nbsp;')",2000);
       }
	    
	}
      
      //验证层次类型
      function yz6() {
   	   var obj="&nbsp;";
		$("#infos4").html(obj);
		setTimeout("$('#infos4').html('&nbsp;')",2000);
	   var uxxn=$("#xzc").val();
      if(uxxn.length>3||uxxn.length==0){
    	   var obj="请选择层次！";
			$("#infos4").html(obj);
			setTimeout("$('#infos4').html('&nbsp;')",2000);
       }
	    
	}
      
      //验证验证码
      function yz7() {
   	   var obj="&nbsp;";
		$("#infos5").html(obj);
		setTimeout("$('#infos5').html('&nbsp;')",2000);
	   var uxxn=$("#yzm").val();
       if(uxxn.length==0){
    	   var obj="验证码不能为空！";
			$("#infos5").html(obj);
			setTimeout("$('#infos5').html('&nbsp;')",2000);
       }
	    
	}
      
      //城市验证
      function yz8() {
	   var csb=$("#city").val();
	   var sContent = $("#County").get(0);
	   $.ajax({  
	        type: "post",  
	        url: "sele.action",
	        data: {"csb":csb},  
	        dataType:"json",  
	        async:true,  
	        cache:true,  
	        success: function(data){
	        	var aa=data;	
	        	sContent.options.length=0;
	        	sContent.options.add(new Option("---请选择---",""));
	        	for(var i=0;i<aa.length;i++){
	        		//后面是id的值
					sContent.options.add(new Option(aa[i].coname,aa[i].coid));
		 }
	     }
	        	
	});
      }
      
      //表单验证
      function yz9() {    
	   var name=$("#name").val();//姓名
	   var zname=$("#zname").val();//专业
	   var sfz=$("#sfz").val();//身份证
	   var yx=$("#yx").val();//院校
	   var sjh=$("#sjh").val();//手机号
	   var xzc=$("#xzc").val();//层次
	   var city=$("#city").val();//市区
	   var County=$("#County").val();//县城
	   var lsc=$("#lsc").val();//招生老师
	   var yzm=$("#yzm").val();//验证码
	   
	   var sjyzm=$("#dx").val();//用户输入的短信验证码
	   var ycyzm=$("#ycyzm").val();//隐藏域获取的手机验证码
//姓名判断	   
	   if(!isNaN(name)){
		   alert("姓名填写有误！");
		   var obj="姓名填写有误！";
			$("#infos1").html(obj);	
			setTimeout("$('#infos1').html('&nbsp;')",2000);
			return;
	   }
	   
	 //身份证判断   
	   if(sfz.length==0||isNaN(sfz)||sfz.length<18){
		   alert("身份证填写有误！");  
		   return;
	   }
	  
	 if(sjh.length<5||isNaN(sjh)){
		  alert("手机号填写有误！");	
		  return;
	   } 
	
	 if(yzm.length<4||yzm.length>4){
    	  alert("请输入正确验证码！");
    	  return;
      }
    
	  if(sjyzm.trim()!=ycyzm.trim()){
		  alert("手机验证码有误,请重新输入");
		  return;
	  }else if(ycyzm.length==0||sjyzm.length==0){
		  alert("手机验证码有误,请重新输入");
		  return;
	  }
	 
  	   	$("#dt").submit();  
    
	 
	  }
      
    //短信发送
      function yz10() {
 
    	   var obj="&nbsp;";
   		$("#infos7").html(obj);		
   	        var usjh=$("#sjh").val();//手机号值
          if(usjh.length==0){
       	   var obj="手机号不能为空！";
   			$("#infos7").html(obj);
   			setTimeout("$('#infos7').html('&nbsp;')",2000);
   			return;
   			
          }else if(usjh.length<5){
       	   var obj="手机号填写有误！";
   			$("#infos7").html(obj);
   			setTimeout("$('#infos7').html('&nbsp;')",2000);
   			return;
   			
          }else if(isNaN(usjh)){
       	   var obj="手机号只能是数字！";
   			$("#infos7").html(obj);
   			setTimeout("$('#infos7').html('&nbsp;')",2000);
   			return;
          }
          alert("信息发送成功，请注意查收！");	  

	   $.ajax({  
	        type: "post",  
	        url: "dx?sjh="+usjh,
	       // data: {"usjh":usjh},  
	       // dataType:"json",  
	        async:true,  
	        cache:true,  
	        success: function(data){
	        	var aa=data;//返回值	
	        	//alert("短信验证码返回了"+aa);
	        	$("#ycyzm").val(aa);
		 }
	     
	        	
	});
      }
        
      //验证短信
      function yz11() {
   	   var obj="&nbsp;";
		$("#infos7").html(obj);
	   var uxxn=$("#dx").val();
       if(uxxn.length==0){
    	   var obj="短信验证码不能为空！";
			$("#infos7").html(obj);
			setTimeout("$('#infos7').html('&nbsp;')",2000);
       }else if(uxxn.length<4){
    	   var obj="短信验证码输入有误！";
			$("#infos7").html(obj);
			setTimeout("$('#infos7').html('&nbsp;')",2000);
       }
	    
	}
    
</script>

<!-- 魔方拖动 -->
<style>
	h3{
	text-align: center;
	color: #5A5A5A;
}
		body{
			background: #ffffff;
		}
		#box{
			width: 200px;
			height: 200px;
			margin:70px auto;
			background: #ccc;
			position: relative;
			transform:perspective(800px) rotateY(-60deg) rotateX(45deg);
			transform-style:preserve-3d;
		}
		#box div{
			width:100%;
			height:100%;
			position: absolute;
			top:0;
			left: 0;
			background-size:cover; 
			-webkit-box-shadow:0 0 100px #5fbcff;
			opacity: .8;
		}
		.front{
			transform:translateZ(100px);
			background: url(images/a5.png);
		}
		.back{
			transform:translateZ(-100px);
			background: url(images/a1.png);
		}
		.left{
			transform:translateX(-100px) rotateY(90deg);
			background: url(images/a2.png);
		}
		.right{
			transform:translateX(100px) rotateY(90deg);
			background: url(images/a3.png);
		}
		.top{
			transform:translateY(-100px) rotateX(90deg);
			background: url(images/a4.png);
		}
		.bottom{
			transform:translateY(100px) rotateX(90deg);
			background: url(images/a8.png);
		}
	</style>
		<script>
		window.onload=function()
		{
			var oBox=document.querySelector('#box');

			var y=-60;
			var x=45;
			oBox.onmousedown=function(ev)
			{
				var oEvent=ev||event;
				var disX=oEvent.clientX-y;
				var disY=oEvent.clientY-x;
				document.onmousemove=function(ev)
				{
					var oEvent=ev||event;
					x=oEvent.clientY-disY;
					y=oEvent.clientX-disX;
					oBox.style.transform='perspective(800px) rotateX('+x+'deg) rotateY('+y+'deg)';
				};
				document.onmouseup=function()
				{
					document.onmousemove=null;
					document.onmouseup=null;
				};
				return false;
			};
		};
	</script>
	
	<script>
		window.onload=function()
		{
			var oBox=document.querySelector('#box');

			var y=-60;
			var x=45;
			oBox.onmousedown=function(ev)
			{
				var oEvent=ev||event;
				var disX=oEvent.clientX-y;
				var disY=oEvent.clientY-x;
				document.onmousemove=function(ev)
				{
					var oEvent=ev||event;
					x=oEvent.clientY-disY;
					y=oEvent.clientX-disX;
					oBox.style.transform='perspective(800px) rotateX('+x+'deg) rotateY('+y+'deg)';
				};
				document.onmouseup=function()
				{
					document.onmousemove=null;
					document.onmouseup=null;
				};
				return false;
			};
		};
	</script>

</head>
<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
	
		<div class="top">

			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">

						<ul class="fh5co-social">
<!-- QQ分享功能 -->						
<div class="bdsharebuttonbox">
<a href="javascript:void(0)" class="bds_more" data-cmd="more"></a>
<a href="javascript:void(0)" class="bds_qzone" data-cmd="qzone"></a>
<a href="javascript:void(0)" class="bds_tsina" data-cmd="tsina"></a>
<a href="javascript:void(0)" class="bds_tqq" data-cmd="tqq"></a>
<a href="javascript:void(0)" class="bds_renren" data-cmd="renren"></a>
<a href="javascript:void(0)" class="bds_weixin" data-cmd="weixin"></a>
</div>
						</ul>

					</div>
				</div>
			</div>
		</div>
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-xs-1">
						<div id="fh5co-logo"><a href="index.action">
<!-- 主页图片 -->						<img src="images/zy.png">
						</a></div>
					</div>
					<div class="col-xs-11 text-right menu-1">
												<ul>
							<li><a href="index.action">首页</a></li>
							
							<li class="has-dropdown"><!-- 下拉显示 -->
							<a href="courses.jsp">课程详细</a>
								<ul class="dropdown">
									<li><a href="http://localhost:8080/project/select">成人教育</a></li>
									<li><a href="http://localhost:8080/project/select2">会计培训</a></li>
									<li><a href="http://localhost:8080/project/select5">国家开放</a></li>
									<li><a href="http://localhost:8080/project/select6">远程教育</a></li>
									<li><a href="http://localhost:8080/project/select3">艺考培训</a></li>
									<li><a href="contact03t.jsp">职业资格</a></li>
								</ul>
							</li>
							
							<li class="has-dropdown">
							<a href="pricing.jsp">学习平台</a>
								<ul class="dropdown">
									<li><a href="http://www.jxck168.com/web/kaochang.jsp">模考测试</a></li>
									<li><a href="http://degree.qingshuxuetang.com/dhlg/Home?schoolCategory=1">华东理工</a></li>
									<li><a href="http://degree.qingshuxuetang.com/gnnu/Majors">赣南师范</a></li>
									<li><a href="http://degree.qingshuxuetang.com/jxsf/Home">江西师范</a></li>
									<li><a href="http://degree.qingshuxuetang.com/jxzyy/">江西中医</a></li>
									<li><a href="http://degree.qingshuxuetang.com/jxstnu/Home?schoolCategory=1">江西科技</a></li>
									<li><a href="http://degree.qingshuxuetang.com/jxddc/Home">江西广播</a></li>
								</ul>
							</li>
                            <li id="qq"><a href="javascript:void(0);">联系我们</a></li>
							<li class="btn-cta"><a href="beforelogin"><span>后台登录</span></a></li>
							<c:if test="${teacher!=null}">
								<li class="btn-cta"><a href="#" onclick="edit()"><span>修改密码</span></a></li>
							</c:if>
							<c:if test="${teacher==null}">
								<li class="btn-cta"><a href="login2.jsp"><span>合作招生</span></a></li>
							</c:if>
							<c:if test="${teacher!=null}">
								<li class="btn-cta"><a href="tloginout.action"><span>退出登陆</span></a></li>
							</c:if>
							<c:if test="${teacher!=null}">
								<li class="btn-cta"><a href="#" onclick="terweima()"><span>生成二维码</span></a></li>
							</c:if>
							
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>


<!-- 触发联系窗口 -->	
<script type="text/javascript">

$(document).ready(function(){
$('#qq').click(function (){
window.open ('relation', 'newwindow', 'height=460, width=500, top=120, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
});});

$(document).ready(function(){
	$('#q2').click(function (){
	window.open ('relation', 'newwindow', 'height=460, width=500, top=120, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
	});});
</script>

<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/ycbm.png);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
<!-- 							<h1>资料填写</h1> -->
 <div id="box">			
		<a href="http://localhost:8080/project/select2"><div class="front"></div></a>
		<a href="http://localhost:8080/project/select"><div class="back"></div></a>
		<a href="http://localhost:8080/project/select5"><div class="top"></div></a>
		<a href="http://localhost:8080/project/select6"><div class="bottom"></div></a>
		<a href="http://localhost:8080/project/select3"><div class="left"></div></a>
		<a href="contact03t.jsp"><div class="right"></div></a>
	</div>
							<img src="images/z3.png" width="20%" height="20%">
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	        <div class="container">
        &nbsp;
        </div>
			<center>
			<img  src="images/ycjy.png" width="100%" height="70%">
			<img  src="images/yc2.png" width="90%" height="10%">
        </center>

        
		<div class="container">
         &nbsp;	&nbsp;	&nbsp;	&nbsp;		
					
                 <img src="images/wsx.png" height="50%" width="45%">
			

		
				<div class="col-md-6 animate-box">
					<center><h1>提交报名信息资料</h1></center>
<!-- 提交 -->					
<form action="data6" method="post" id="dt">
                       
						<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="text" id="name" name="name" class="form-control" placeholder="姓名" onblur="yz()">
							<!-- 老师招生隐藏域  -->
                                <input type="hidden" name="lsc" id="lsc" value="${lsc}">
							</div>
							<!-- 验证结果1 -->						
				
							<div class="col-md-6">
								<select  id="yx" name="yx"  placeholder="报考的院校" onchange="yz4()" style="width:250px;height:52px" >
							    <option selected="selected">---请选择---</option>	
							    <s:iterator value="ys">
							    <option value="${aid}">${aschool}</option>
							    </s:iterator>
							    </select>						
							</div>
							</div>							
				<center>
				<font size="4" color="red" >								
						<span id="infos1">&nbsp;</span>
				</font>			
				</center>	
					
						
				<div class="row form-group">	
				<div class="col-md-12">
				<!-- <label for="lname">Last Name</label> -->
				<select id="zname" name="zname" placeholder="专业" onblur="yz2()" style="width:535px;height:52px" >
				<option value="1" selected="selected">---请选择---</option>	
				</select>
				</div>		
<!-- 专业验证 -->						
				<center>
				<font size="4" color="red">				
						<span id="infos3">&nbsp;</span>
	
				</font>		
				</center>
				</div>



				<div class="row form-group">
					<div class="col-md-12">
						<!-- <label for="email">Email</label> -->
						<input type="text" id="sfz" name="sfz" class="form-control" placeholder="身份证号码" onblur="yz3()">
				</div>
<!-- 验证结果2 -->						
				<center>
				<font size="4" color="red">				
				
						<span id="infos2">&nbsp;</span>
				
				</font>		
				</center>							
						</div>
						
						

						<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="text" id="sjh" name="sjh" class="form-control" placeholder="手机号码" onblur="yz5()">
							</div>
							
							<div class="col-md-6">
								<select id="xzc"  name="xzc"  placeholder="选择层次" onblur="yz6()" style="width:250px;height:52px">
							    <option>层次选择</option>
							    <option>专达本</option>
							    <option>高达专</option>
							    <option>高达本</option>						   
							</select>	
							</div>
							</div>	
							
						
<!-- 验证结果4 -->							
				<center>
				<font size="4" color="red">				
				
						<span id="infos4">&nbsp;</span>
				
				</font>		
				</center>
					
						
						<div class="row form-group">
							<div class="col-md-6">
							<select id="city"  name="city"  placeholder="选择市区" onchange="yz8()" style="width:250px;height:52px">
							    <option selected="selected">---请选择---</option>	
							  	<s:iterator value="ls">
							  	<option value="${cid}">${cname}</option>	
							  	</s:iterator>			   
							</select>	
							</div>								
					
							<div class="col-md-6">
							
							<select id="County"  name="County"  placeholder="选择县城" " style="width:250px;height:52px">
							<option selected="selected">---请选择---</option>	  				   
							</select>	
							</div>								
						</div>
						
<!-- 验证结果6 -->							
				<center>
				<font size="4" color="red">				
				
						<span id="infos6">&nbsp;</span>
				
				</font>		
				</center>
						
						
						<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="text" id="yzm" name="yzm" class="form-control" placeholder="请输入对应的验证码" onblur="yz7()">
							</div>
							
			<!-- 验证码-->				
							<div class="col-md-6">
							<img id="img" src="/project/yzm" />
                            <a onclick="javascript:changeImg()" style="color:white;"><label style="color:red;">看不清？</label></a>
							</div>
							</div>
<!-- 验证结果5 -->						
				<center>
				<font size="4" color="red">				
				
						<span id="infos5">&nbsp;</span>
				
				</font>		
				</center>
				
				
<!-- 短信 -->
							<div class="row form-group">
							<div class="col-md-6">
								<!-- <label for="fname">First Name</label> -->
								<input type="hidden" id="ycyzm" value="">
								<input type="text" id="dx" name="dx" class="form-control" placeholder="请输入短信验证码" onblur="yz11()">
							</div>
							&nbsp;&nbsp;&nbsp;
							<input type="button" onclick="yz10()" value="发送短信验证码" class="btn btn-primary">	
						</div>
<!-- 短信验证结果 -->						
				<center>
				<font size="4" color="red">				
				
						<span id="infos7">&nbsp;</span>
				
				</font>		
				</center>	
						
						<div class="form-group">
						<center>

                            <input type="button" onclick="yz9()" value="提交" class="btn btn-primary">
						</center>
						</div>

					</form>		
				</div>
		</div>
		<div>&nbsp;</div>
	<footer id="fh5co-footer" role="contentinfo">
		<div class="container">
			<div class="row row-pb-md">
				
<jsp:include page="footer.jsp"></jsp:include>				
			</div>


		</div>
	</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<!-- jQuery -->
<!-- 	<script src="js/jquery.min.js"></script> -->
	
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	
	<!-- Bootstrap -->
<%-- 	<script src="js/bootstrap.min.js"></script> --%>
	
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>	
</body>
</html>