<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>权明峰教育网</title>

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
        img.src = "/jypt/authImg?date=" + new Date();;
    }
</script>

<!--提交 -->
<script type="text/javascript">
var ss="${yzfh}";
if(ss.length==1){
	<%
	session.removeAttribute("yzfh");
 	%> 
	alert("验证码输入错误！");

}else if(ss.length==2){
	alert("数据提交成功！");
}


      
 //账号验证      
        function yz() {
        	var obj="&nbsp;";
			$("#infos").html(obj);
			
        	var uname=$("#name").val();
        	
			if(uname.length==0){
				var obj="账号不能为空！";
				$("#infos").html(obj);		
			}
 }
 
//手机号码验证 
       function yz2() {
    	   var obj="&nbsp;";
			$("#infos").html(obj);
    	   var usjh=$("#sjh").val();

    	   
		if(usjh.length==0){    	   //判断手机号码不为空
			var obj="手机号码不能为空！";
			$("#infos").html(obj);
		}else if(usjh.length<5){
			var obj="手机号码填写有误！";
			$("#infos").html(obj);
		}else if(isNaN(usjh)){    	   //判断手机号码只能为数字
			var obj="手机号码只能是数字！";
			$("#infos").html(obj);
		}
	}
	
	
//验证学习内容
      function yz3() {
   	   var obj="&nbsp;";
		$("#infos2").html(obj);
	   var uxxn=$("#xxn").val();
       if(uxxn.length==0){
    	   var obj="学习内容不能为空！";
			$("#infos2").html(obj);
       }
	    
	}
		
    //验证验证码
      function yz4() {
   	   var obj="&nbsp;";
		$("#infos3").html(obj);
	   var uxxn=$("#yzm").val();
       if(uxxn.length==0){
    	   var obj="验证码不能为空！";
			$("#infos3").html(obj);
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
                            <li id="qq"><a>联系我们</a></li>
							<li class="btn-cta"><a href="beforelogin"><span>后台登录</span></a></li>
							<li class="btn-cta"><a href="selectzahlen.jsp"><span>合作招生</span></a></li>
							
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
window.open ('NewFile2.jsp', 'newwindow', 'height=460, width=500, top=120, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
});});

$(document).ready(function(){
	$('#q2').click(function (){
	window.open ('NewFile2.jsp', 'newwindow', 'height=460, width=500, top=120, left=450, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=n o, status=no');
	});});
</script>

<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/zg1.png);" data-stellar-background-ratio="0.5">
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
							<img src="images/z1.png" width="20%" height="20%">
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>


	<div id="fh5co-blog">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p1.png" alt=""></a>
						<div class="blog-text">
							<h3><a href=""#>中医师</a></h3>
							
							<a href="#" class="btn btn-primary">了解详情</a>
						</div> 
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p2.png" alt=""></a>
						<div class="blog-text">
							<h3><a href=""#>针灸师</a></h3>
						
							<a href="#" class="btn btn-primary">了解详情</a>
						</div> 
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p3.png" alt=""></a>
						<div class="blog-text">
							<h3><a href=""#>文饰师</a></h3>
							
							<a href="#" class="btn btn-primary">了解详情</a>
						</div> 
					</div>
				</div>

				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p4.png" alt=""></a>
							<div class="blog-text">
							<h3><a href=""#>健康调理师</a></h3>											
							<a href="#" class="btn btn-primary">了解详情</a>
							</div>
					</div>
				</div>
				
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p5.png" alt=""></a>
							<div class="blog-text">
							<h3><a href=""#>护理师</a></h3>			
							<a href="#" class="btn btn-primary">了解详情</a>
							</div>
						</div> 
					</div>
			
				
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p6.png" alt=""></a>
							<div class="blog-text">
							<h3><a href=""#>康复理疗师</a></h3>							
							<a href="#" class="btn btn-primary">了解详情</a>
							</div>
					</div>
				</div>
			
				
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p7.png" alt=""></a>
						<div class="blog-text">
							<h3><a href=""#>养生保健室</a></h3>								
							<a href="#" class="btn btn-primary">了解详情</a>
							</div>
					</div>
				</div>
				
				
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p8.png" alt=""></a>
							<div class="blog-text">
							<h3><a href=""#>中医美容师</a></h3>							
							<a href="#" class="btn btn-primary">了解详情</a>
				            </div>
				</div>
				</div>
				
				
				<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box">
						<a href="#"><img class="img-responsive" src="images/p10.png" alt=""></a>
							<div class="blog-text">
							<h3><a href=""#>催乳师</a></h3>							
							<a href="#" class="btn btn-primary">了解详情</a>
					        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	

        	<div id="fh5co-started" style="background-image:url(images/zg.png);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>职业资格培训</h2>
					<p>职业资格是对从事某一职业所必备的学识、技术和能力的基本要求。职业资格包括从业资格和执业资格。从业资格是指从事某一专业（工种）学识、技术和能力的起点标准。执业资格是指政府对某些责任较大，社会通用性强，关系公共利益的专业（工种）实行准入控制，是依法独立开业或从事某一特定专业（工种）学识、技术和能力的必备标准。职业资格分别由国务院劳动、人事行政部门通过学历认定、资格考试、专家评定、职业技能鉴定等方式进行评价，对合格者授予国家职业资格证书。从业资格通过学历认定或考试取得。执业资格通过考试取得。</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center">
					<p><a href="http://localhost:8080/project/select4" class="btn btn-default btn-lg">进入报名</a></p>
				</div>
			</div>
		</div>
	</div>
	
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