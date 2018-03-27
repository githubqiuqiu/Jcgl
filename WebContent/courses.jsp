<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

<!-- 照片分布------------------------------------------------------------------------------------------- -->
<link rel="stylesheet" type="text/css" href="css/popup.css">
<script type="text/javascript" src="js/fragment.js"></script>
<script type="text/javascript">
$(function() {
	var fragmentConfig = {
		container : '.img-flex',//显示容器
		line : 10,//多少行
		column : 24,//多少列
		width : 1350,//显示容器的宽度
		animeTime : 5000,//最长动画时间,图片的取值将在 animeTime*0.33 + animeTime*0.66之前取值 
		img : 'images/1.jpg'//图片路径
	};
	fragmentImg(fragmentConfig);
});
</script>

<!-- 切换显示图片-------------------------------------------------------------------------------------------------- -->
	<style>
			*{margin:0;padding:0;list-style: none;}
			img.bg{min-width: 10px;min-height: 0%;width: 0%;height: auto!important;height: 0%;position: fixed;top: 0;left: 0;z-index: 1;}
			@media screen and (max-width: 1024px) {
				img.bg{
					left: 50%;
					margin-left: -512px;
				}
			}
			.slider{
				position: absolute;
				width: 100%;
				text-align: center;
				z-index: 999;
				bottom: 100px;
			}
			.slider li{
				display: inline-block;
				width: 170px;
				height: 60px;
				margin-right: 15px;
			}
			.slider a{
				display: inline-block;
				width: 170px;
				padding-top:0px;
				padding-bottom:0px;
				position: relative;
				cursor: pointer;
				border:2px solid #fff;
				border-radius: 5px;
				vertical-align: top;/*设置元素的垂直对齐方式。*/
				color: #ffffff;
				text-decoration: none;
				font-size: 22px;
				font-family: "楷体";
				text-shadow: -1px -1px 1px rgba(0,0,0,0.8),
				-2px -2px 1px rgba(0, 0, 0, 0.3),
				 -3px -3px 1px rgba(0, 0, 0, 0.3);
			}
			.slider li:nth-of-type(1) a{
				background-color: #02646e;
			}
			.slider li:nth-of-type(2) a{
				background-color: #eb0837;
			}
			.slider li:nth-of-type(3) a {
				background-color: #67b374;
			}
			.slider li:nth-of-type(4) a {
				background-color: #e6674a;
			}
			.slider li:nth-of-type(5) a {
				background-color: #e61061;
			}
			.slider li:nth-of-type(6) a {
				background-color: #33ffff;
			}
			.slider a::after{/*:after 选择器在被选元素的内容后面插入内容。*/
				content: "";
				display: block;
				height: 180px;
				width: 180px;
				border:5px solid #fff;
				border-radius: 50%;
				position: absolute;
				left: 50%;
				margin-left: -60px;
				z-index: 9999;
				top: -1680px;
			}
			.slider li:nth-of-type(1) a::after {
				/*:nth-of-type(n) 选择器匹配属于父元素的特定类型的第 N 个子元素的每个元素.*/
				background: url(img/sbg1.jpg) no-repeat center;
			}
			.slider li:nth-of-type(2) a::after {
				background: url(img/sbg2.jpg) no-repeat center;
			}
			.slider li:nth-of-type(3) a::after {
				background: url(img/sbg3.jpg) no-repeat center;
			}
			.slider li:nth-of-type(4) a::after {
				background: url(img/sbg4.jpg) no-repeat center;
			}
			.slider li:nth-of-type(5) a::after {
				background: url(img/sbg5.jpg) no-repeat center;
			}.slider li:nth-of-type(6) a::after {
				background: url(img/sbg6.jpg) no-repeat center;
			}
			.slider a::before{
				content: "";
				display: block;
				height: 180px;
				width: 180px;
				border:5px solid #fff;
				border-radius: 50%;
				position: absolute;
				left: 50%;
				margin-left: -60px;
				z-index: 99999;
				top: -1680px;
				background:rgba(0,0,0,0.3);
			}
			.slider a:hover::before{
				opacity: 0;
			}
			@-webkit-keyframes 'slideLeft'{
				0%{
					left:-500px;
				}
				100%{
					left:0;
				}
			}
			.slideLeft:target{
				/*:target 选择器可用于选取当前活动的目标元素*/
				z-index: 100;
				animation: slideLeft 1s 1;
				-webkit-animation: slideLeft 1s 1;
			}
			@-webkit-keyframes 'slideBottom'{
				0%{
					top:350px;
				}
				100%{
					top:0;
				}
			}
			.slideBottom:target{
				/*:target 选择器可用于选取当前活动的目标元素*/
				z-index: 100;
				animation: slideBottom 1s 1;
				-webkit-animation: slideBottom 1s 1;
			}
			@-webkit-keyframes 'zoomIn' {
			 0% {
			-webkit-transform: scale(0.1);
			}
			 100% {
			-webkit-transform: none;
			}
			}
			.zoomIn:target {
				z-index: 100;
				-webkit-animation: zoomIn 1s 1;
				animation: zoomIn 1s 1;
			}
			/* Zoom Out */
			@-webkit-keyframes 'zoomOut' {
			 0% {
			-webkit-transform: scale(2);
			}
			 100% {
			-webkit-transform: none;
			}
			}
			
			.zoomOut:target {
				z-index: 100;
				-webkit-animation: zoomOut 1s 1;
				animation: zoomOut 1s 1;
			
			}
			 
			/* Rotate */
			 
			@-webkit-keyframes 'rotate' {
			 0% {
			-webkit-transform: rotate(-360deg) scale(0.1);
			}
			 100% {
			-webkit-transform: none;
			}
			}
			.rotate:target {
				z-index: 100;
				-webkit-animation: rotate 1s 1;
				animation: rotate 1s 1;
				
			}
			@-webkit-keyframes 'notTarget' {
				 0% {
				z-index: 75;
			}
				 100% {
				z-index: 75;
			}
			}
			.bg:not(:target) {
					-webkit-animation: notTarget 1s 1;
					animation: notTarget 1s 1
				}
				.page {
					text-align:left;
			}
		</style>

<!-- head --------------------------------------------------------------------------------------------------------->
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
		</div><!-- QQ分享功能----------------------------------------------------------------------------------------- -->	
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


<!-- 页面一 -->
	<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url();" data-stellar-background-ratio="0.5">
<!-- 	<div class="overlay"></div> -->
	
<!-- 图片分布		 -->
		<div class="img-flex"></div>
		
		
		
		<div class="container">		
			<div class="row">			
				<div class="col-md-8 col-md-offset-2 text-center">				
					<div class="display-t">					
						<div class="display-tc animate-box" data-animate-effect="fadeIn">						
							<h1>学生报名</h1>
							<h2>陶峰招生管理公共平台，助你平步青云！</h2>							
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

<!-- 内容--------------------------------------------------------------------------------------------- -->


		
		
		
 <div class="fh5co-explore">
          <div class="slider">
				<ul>
					<li><a href="http://localhost:8080/project/select">成人高考</a></li>
					<li><a href="http://localhost:8080/project/select2">会计</a></li>
					<li><a href="http://localhost:8080/project/select5">国家开放大学</a></li>
					<li><a href="http://localhost:8080/project/select6">远程教育 </a></li>
					<li><a href="http://localhost:8080/project/select3">艺术联考</a></li>
					<li><a href="contact03t.jsp">职业资格</a></li>
				</ul>
			</div>
			<div class="bg slideLeft" id="bg1"></div>
			<div class="bg slideBottom" id="bg2"></div>
			<div class="bg zoomIn" id="bg3"></div>
			<div class="bg zoomOut" id="bg4"></div>
			<div class="bg rotate" id="bg5"></div>
			<div class="bg rotate" id="bg5"></div>
			</div>
		
		<div class="container-fluid proj-bottom">

		<div>
		&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>
		&nbsp;<br/>&nbsp;<br/>&nbsp;<br/>
		</div>
		
			<div class="row">

				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="http://localhost:8080/project/select"><img src="images/ym1.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>成人教育报名</h3>
						<span>了解详情</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="http://localhost:8080/project/select2"><img src="images/kjcnm.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>会计培训报名</h3>
						<span>了解详情</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="http://localhost:8080/project/select5"><img src="images/ym3.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>国家开放报名</h3>
						<span>了解详情</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="http://localhost:8080/project/select6"><img src="images/ym6.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>远程教育报名</h3>
						<span>了解详情</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="http://localhost:8080/project/select3"><img src="images/ym4.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>艺考培训报名</h3>
						<span>了解详情</span>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 fh5co-project animate-box" data-animate-effect="fadeIn">
					<a href="contact03t.jsp"><img src="images/ym5.png" alt="Free HTML5 Website Template by FreeHTML5.co" class="img-responsive">
						<h3>职业资格培训</h3>
						<span>了解详情</span>
					</a>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="row">
				<div class="features">
					<div class="col-md-4 animate-box">
						<h4>学习</h4>
						<p>招生管理公共平台”是让各种学生成功就业的学习平台，学历终身可查， 保证学生的就业，月拿高薪不是梦！</p>
					</div>
					<div class="col-md-4 animate-box">
						<h4>考试</h4>
						<p>还在为自己拿不到高的学历而发愁？这里有专业的老师， 对你进行一对一的辅导。让你逢考必过，轻松愉悦高学历！</p>
					</div>
					<div class="col-md-4 animate-box">
						<h4>拿证</h4>
						<p>毕业证书国家承认，学信网可查，公司认可。让你职场 上优先坐上好职位！</p>
					</div>
				</div>
				<div class="col-md-12 text-center animate-box">
					<p><a class="btn btn-primary btn-lg btn-learn" href="pricing.jsp">网上学习</a></p>
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
