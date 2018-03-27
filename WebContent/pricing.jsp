<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>网上学习</title>
	<link rel="SHORTCUT ICON" href="img/tu.ico"/>
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

<!-- 图片导航 --------------------------------------------------------------------------------------------->
<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">
	<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
	<link href="css/effects.css" rel="stylesheet">
	
	<!-- 旋转木马-------------------------------------------------------------------------------------- -->
			<style>
			*{
				padding: 0;
				margin: 0;
			}
			img{
				width:200px;
				height: 300px;
			}
			body{ background-color: #ffffff; }
			@keyframes fn{
				0% {transform:rotateX(-15deg) rotateY(0deg);}
			    100%{transform:rotateX(-15deg) rotateY(360deg);}

			}
			@-moz-keyframes fn{
				0% {transform:rotateX(-15deg) rotateY(0deg);}
			    100%{transform:rotateX(-15deg) rotateY(360deg);}
			}
			@-ms-keyframes fn{
				0% {transform:rotateX(-15deg) rotateY(0deg);}
			    100%{transform:rotateX(-15deg) rotateY(360deg);}
			}
			@-webkit-keyframes fn{
				0% {transform:rotateX(-15deg) rotateY(0deg);}
			    100%{transform:rotateX(-15deg) rotateY(360deg);}
			}
			.box{				
		    	width:200px;
            	height:300px;
            	position:relative;
            	margin:auto;
            	margin-top:150px;
            	transform-style:preserve-3d;
            	transform:rotateX(-10deg);
            	animation: fn 10s;
            	animation-iteration-count: infinite;
		    	animation-timing-function: linear;
		    	position: relative
			}
			.box:hover{
				animation-play-state: paused;
			}
			.box>div{
				width:200px;
				height:300px;
				position: absolute;
				left:0;
				top:0;
				
			}
		</style>
		
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
<!--					<img src="images/zy.png"> -->
						</a></div>
					</div>
					
					<div class="col-xs-11 text-right menu-1">
												<ul>
							<li><a href="index.action">首页</a></li>
							
							<li class="has-dropdown"><!-- 下拉显示 -->
							<a href="courses.jsp">课程详细</a>
								<ul class="dropdown">
									<li><a href="contact1.jsp">成人教育</a></li>
									<li><a href="contact01.jsp">会计培训</a></li>
									<li><a href="contact2.jsp">国家开放</a></li>
									<li><a href="contact3.jsp">远程教育</a></li>
									<li><a href="contact02.jsp">艺考培训</a></li>
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
							<li class="btn-cta"><a href="login.jsp"><span>后台登录</span></a></li>
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

<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/wsxx.png);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
<!-- 			<div class="row"> -->
				<div class="col-md-8 col-md-offset-2 text-center">
<!-- 					<div class="display-t"> -->
<!-- 						<div class="display-tc animate-box" data-animate-effect="fadeIn"> -->
							<h1>网上学习</h1>
			<div class="box">
			<div style="transform: rotateY(0deg) translateZ(275px);">
				<a href="http://www.jxck168.com/web/kaochang.jsp"><img src="img/1x.png" ></a>
			</div>
			
			<div style="transform: rotateY(40deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/dhlg/Home?schoolCategory=1"><img src="img/2x.png"></a>
			</div>
			
			<div style="transform: rotateY(80deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/gnnu/Majors"><img src="img/3x.png"></a>
			</div>
			
			<div style="transform: rotateY(120deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jxzyy/"><img src="img/4x.png"></a>
			</div>
			
			<div style="transform: rotateY(160deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jxsf/Home"><img src="img/5x.png"></a>
			</div>
			
			<div style="transform: rotateY(200deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jxstnu/Home?schoolCategory=1"><img src="img/6x.png"></a>
			</div>
			<div style="transform: rotateY(240deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jgs/Home?schoolCategory=1"><img src="img/7x.png"></a>
			</div>
			<div style="transform: rotateY(280deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jxddc/Home"><img src="img/8x.png"></a>
			</div>
			<div style="transform: rotateY(320deg) translateZ(275px);">
				<a href="http://degree.qingshuxuetang.com/jxsf/Home"><img src="img/9x.png" ></a>
			</div>					
		</div>
						</div>
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
	</header>

	<div id="fh5co-pricing">
	
	<div class="container">

		    <div class="row">

		        <div class="col-lg-12 text-center">
		            <h1 class="page-header">网上学习平台</h1>
		            <p class="titlep">网络学习的方式是指通过PC和网络，在网上浏览网络资源，在线交流，在线讲堂等方式，从而获得知识，解决相关的问题，达到提升自己的目的</p>
		        </div>
	
	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx1.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">入学测试模考</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://www.jxck168.com/web/kaochang.jsp"><font color="#ffffff"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx2.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">东华理工<br/>学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/dhlg/Home?schoolCategory=1"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx3.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">赣南师范<br/>学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/gnnu/Majors"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx4.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">江西中医药<br/>学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/jxzyy/"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        
		     
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx5.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">江西师范<br/>学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/jxsf/Home"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx6.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">江西科技<br/>师范大学</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/jxstnu/Home?schoolCategory=1"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx7.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">井冈山大学<br/>学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/jgs/Home?schoolCategory=1"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
		        </div>
		        
		           	<div class="clearfix visible-md-block"></div>
		        <div class="col-lg-3 col-md-4 col-sm-6 col-xs-12">
		            <div class="hover ehover14">
		                <img class="img-responsive" src="images/xx8.jpg" alt="">
		                <div class="overlay">
		                    <h2><font color="#ffffff" size="4">江西广播电视<br/>大学学习平台</font></h2>
		                    <button class="info nullbutton" data-toggle="modal" data-target="#modal14"><a href="http://degree.qingshuxuetang.com/jxddc/Home"><font color="#ffffff">了解详情</font></a>
		                    </button>
		                </div>
		            </div>
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
	
	<!-- 页面分享到QQ -->
<script>
window._bd_share_config = {
"common" : {
"bdSnsKey" : {},
"bdText" : "",
"bdMini" : "2",
"bdPic" : "",
"bdStyle" : "0",
"bdSize" : "16"
},
"share" : {},
"image" : {
"viewList" : [ "qzone", "tsina",
"tqq", "renren", "weixin" ],
"viewText" : "分享到：",
"viewSize" : "16"
},
"selectShare" : {
"bdContainerClass" : null,
"bdSelectMiniList" : [ "qzone",
"tsina", "tqq", "renren",
"weixin" ]
}
};
with (document)0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+ ~(-new Date() / 36e5)];
</script>
	
	</body>
</html>

