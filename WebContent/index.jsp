<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

	<!-- 弹出层 -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- 主题 style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	
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

<!-- 轮播功能样式 -->
<style type="text/css">
body,ul,li,div{margin:0;padding:0;}
img{border:0;}
li{list-style:none;}
html{width:100%;height:100%;}
#pic{position:relative;overflow:hidden;height:330px;width:1020px;z-index:0;margin:400 auto 10px ;}
#pic ul{width:100%;height:100%;position:absolute;top:0;left:0;}
#pic ul li{position:absolute;}
#pic ul img{position:relative;top:0;left:0;}
/*图片位置*/
#pic ul .pic1{top:-80px;left:2px;z-index:1;}
#pic ul .pic2{top:110px;left:100px;z-index:2;}
#pic ul .pic3{top:-1px;left:0px;z-index:3;}
#pic ul .pic4{top:10px;left:70px;z-index:4;}
#pic ul .pic5{top:80px;left:420px;z-index:3;}
#pic ul .pic6{top:110px;left:700px;z-index:2;}
#pic ul .pic7{top:-180px;left:500px;z-index:1;}
/*图片A标签width和height*/
#pic ul .pic1 a{height:60px;width:96px;}
#pic ul .pic2 a{height:180px;width:288px;}
#pic ul .pic3 a{height:240px;width:384px;}
#pic ul .pic4 a{height:300px;width:480px;}
#pic ul .pic5 a{height:240px;width:384px;}
#pic ul .pic6 a{height:180px;width:288px;}
#pic ul .pic7 a{height:180px;width:288px;}
/*图片明暗*/
#pic ul li.pic1{opacity:0.2;filter:alpha(opacity:20);}
#pic ul li.pic2{opacity:0.6;filter:alpha(opacity:60);}
#pic ul li.pic3{opacity:0.9;filter:alpha(opacity:90);}
#pic ul li.pic4{opacity:1;filter:alpha(opacity:100);}
#pic ul li.pic5{opacity:0.9;filter:alpha(opacity:90);}
#pic ul li.pic6{opacity:0.6;filter:alpha(opacity:60);}
#pic ul li.pic7{opacity:0.2;filter:alpha(opacity:20);}
/*图片width*/
#pic ul li.pic1 img{width:96px;}
#pic ul li.pic2 img{width:288px;}
#pic ul li.pic3 img{width:384px;}
#pic ul li.pic4 img{width:480px;}
#pic ul li.pic5 img{width:384px;}
#pic ul li.pic6 img{width:288px;}
#pic ul li.pic7 img{width:288px;}
/*箭头部分*/
#pic span{display:inline-block;*display:inline;*zoom:1;width:80px;height:80px;position:absolute;top:160px;z-index:30;cursor:pointer;opacity:0.7;filter:alpha(opacity=70);}
#pic:hover span{opacity:1;filter:alpha(opacity=100);}
#pic span img{width:80px;height:80px;display:block;}
#pic span.prev{left:-20px;}
#pic span.next{right:80px;}
</style>

<script type="text/javascript" src="move3.js"></script>
<script type="text/javascript">
  window.onload=function()
  {
	 var oPic=document.getElementById('pic');
	 var oPrev=getByClass(oPic,'prev')[0];
	 var oNext=getByClass(oPic,'next')[0];
	 
	 var aLi=oPic.getElementsByTagName('li');
	 
	 var arr=[];
	 
	 for(var i=0;i<aLi.length;i++)
	 {
	   var oImg=aLi[i].getElementsByTagName('img')[0];
	   
	 	 arr.push([parseInt(getStyle(aLi[i],'left')),parseInt(getStyle(aLi[i],'top')),
		           getStyle(aLi[i],'zIndex'),oImg.width,parseFloat(getStyle(aLi[i],'opacity')*100)]);
	 }
	 
	 
	 oPrev.onclick=function()
	 {
	     arr.push(arr[0]);
		 arr.shift();
		     for(var i=0;i<aLi.length;i++)
	         {
			     var oImg=aLi[i].getElementsByTagName('img')[0];
					
					aLi[i].style.zIndex=arr[i][2];
					startMove(aLi[i],{left:arr[i][0],top:arr[i][1],opacity:arr[i][4]});
					startMove(oImg,{width:arr[i][3]});
			 }
			
	 }
	 
	oNext.onclick=function()
	 {
	      arr.unshift(arr[arr.length-1]);
		  arr.pop();
		     for(var i=0;i<aLi.length;i++)
	         {
			     var oImg=aLi[i].getElementsByTagName('img')[0];
					
					aLi[i].style.zIndex=arr[i][2];
					startMove(aLi[i],{left:arr[i][0],top:arr[i][1],opacity:arr[i][4]});
					startMove(oImg,{width:arr[i][3]});
			 }
	 }
	 
	 function getStyle(obj,name)
	 {
	       if(obj.currentStyle){ return obj.currentStyle[name]; }
		   else{ return getComputedStyle(obj,false)[name]; }
	 }
  }
  
function getByClass(oParent,sClass)
  {
      var aResult=[];
	  var aEle=oParent.getElementsByTagName('*');
	  
		  for(var i=0;i<aEle.length;i++)
		  {
			 if(aEle[i].className==sClass)
			 {
				aResult.push(aEle[i]);
			 }
		  }
	  return aResult;
  }

</script>

<!-- 功能隐藏样式 -->
<link rel="stylesheet" href="css/reset3.css"> <!-- CSS reset -->
<link rel="stylesheet" href="css/style3.css"> <!-- Resource style -->
<script src="js/modernizr3.js"></script> <!-- Modernizr -->
<script src="js/main3.js"></script> <!-- Resource jQuery -->

<!-- 风琴导航 -->
 <link rel="stylesheet" type="text/css" href="css/style5.css">
 <script type="text/javascript">
$(function() {
    $('.xinxi_solution_main ul li:eq(0)').addClass('on');
    $('.xinxi_solution_main ul li:eq(1)').addClass('b2');
    $('.xinxi_solution_main ul li:eq(2)').addClass('b3');
    $('.xinxi_solution_main ul li:eq(3)').addClass('b4');
    $('.xinxi_solution_main ul li:eq(4)').addClass('b5');
    $('.xinxi_solution_main ul li:eq(5)').addClass('b6');
    $('.xinxi_solution_main ul li:gt(3)').hide();
    //当三级分类大于7个的是，成两排显示
    $('.xinxi_solution_main ul li').each(function() {
        var len = $(this).find('.right dl a').length;
        if (len > 6) {
            $(this).find('.right dl a').addClass('yichu');
        }
    });

    //解决方案效果
    $('.xinxi_solution_main ul li').each(function() {
        var left_h = $(this).find('.left_top').height();
        $(this).find('.left_top').css({
            'top': '50%',
            'margin-top': -left_h / 2
        });

        var dl_h = $(this).find('.right dl').height();
        $(this).find('.right dl').css({
            'margin-top': -dl_h / 2
        });
    });
    $('.xinxi_solution_main ul li').click(function() {
        $(this).addClass('on').siblings().removeClass('on');
    });
    $('.xinxi_solution_main_mobile ul li:first-child').addClass('on');

    $('.xinxi_solution_main_mobile ul li').click(function() {
        $(this).addClass('on').siblings().removeClass('on');
    });

    $(".solu-category .solu-description").each(function() {
        var maxwidth = 60;
        if ($(this).text().length > maxwidth) {
            $(this).text($(this).text().substring(0, maxwidth));
            $(this).html($(this).html() + '...');
        }
    });

});
</script>
 
  
 <!-- 修改密码 -->
 <script type="text/javascript">
	function edit() {
		window
				.open(
						'editpassword.jsp',
						'newwindow',
						'height=180, width=400,top=300,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
	}
	
	//生成二维码
	function terweima(){
		
		 $.ajax({
			 async:true,
		 	 cache:true,
		 	 url:'terweima',
		 	 type:'post',
		 	// data:$('#organizationEditForm').serialize(),
		 	// datatype:'json',
		 	 success:function(result){
				alert("二维码网址:"+result);
				window.location.href="downloaderweima.action";
		 	
		 	 },
		 	 error:function(XMLHttpRequest,textStatus){
		 		 alert("错误");
		 	 }
		 });
		
	}
	
</script>
 
<!-- 步骤图 -->
<script src="js/jquery.step.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/jquery.step.css" />
<style>
			button {
				display: inline-block;
				padding: 6px 12px;
				font-size: 14px;
				line-height: 1.42857143;
				text-align: center;
				cursor: pointer;
				border: 1px solid transparent;
				border-radius: 4px;
				color: #fff;
				background-color: #5bc0de;
			}
			
			.maina {
				width: 1000px;
				margin: 100px auto;
			}
			
			#stepa {
				margin-bottom: 60px;
			}
			
			.btnsa {
				float: left;
			}
			
			.infoa {
				float: left;
				height: 34px;
				line-height: 34px;
				margin-left: 40px;
				font-size: 28px;
				font-weight: bold;
				color: #928787;
			}
			
			.infoa span {
				color: red;
			}
		</style>
		
		
<!-- 		隐藏域显示卡 -->
<style type="text/css">
*{margin:0;padding:0;font-family:"Arial";}

#main{width:962px;height:473px;margin:10px auto;}
#main ul{list-style:none;}
#main ul li{width:320px;height:490px;float:left;position:relative;}
#main ul li img{border:5px solid #F5F5F5;-webkit-transition:1s ease;-moz-transition:1s ease;}
#main .info{width:130px;height:60px;border:5px solid #F5F5F5;background:#deddcd;position:absolute;bottom:130px;right:0;-webkit-transition:1s ease;-moz-transition:1s ease;-moz-transform:rotatey(30deg);-webkit-transform:rotatey(30deg);}

/* #main .info h2{text-align:center;line-height:0px;color:#7a3f3a;font-weight:normal;font-size:20px;} */
/* #main .info p{padding:0 20px;font-size:14px;} */

#main .info a{display:block;width:120px;height:50px;background:#7a3f3a;color:#FFF;border-radius:15px;text-decoration:none;text-align:center;line-height:45px;margin:0px auto;}

#main ul li:hover .info{-webkit-transform:rotatey(0deg);-moz-transform:rotatey(0deg);right:10px;bottom:210px;}
#main ul li:hover img{-webkit-transform:rotatey(360deg);-moz-transform:rotatey(0deg);}
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
<!-- 主页图片 -->						<img src="images/zy.png">
						</a></div>
					</div>
					<div class="col-xs-11 text-right menu-1">
												<ul>
							<li><a href="http://localhost:8080/project/wheel">首页</a></li>
							
							<li class="has-dropdown"><!-- 下拉显示 -->
       							<a href="courses.jsp">报名平台</a>
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
		<!-- 轮播 -->		<div class="owl-carousel owl-carousel-fullwidth">	
		
		
<div class="item" id="i1">
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(upload/${home.pictureone});" data-stellar-background-ratio="0.5">		
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>教学是协助发展的艺术！</h1>
<!-- 							<h2>陶峰教育<a href="http://www.baidu.com/" target="_blank" title="陶峰网 ">.</a>名师辅导<a href="http://www.yousezyz.com/" title="陶峰网" target="_blank">.</a></h2> -->
<!--链接-->						<p><a class="btn btn-primary btn-lg btn-learn" href="beforelogin">后台登录</a> <a class="btn btn-primary btn-lg popup-vimeo btn-video" href="NewFile.jsp">报名地址</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
			
	</header>
</div>
		
								<div class="item" id="i2">
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(upload/${home.picturetwo});" data-stellar-background-ratio="0.5">

		
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>学生报名</h1>
							<h2>陶峰招生管理公共平台，助你平步青云！</h2>
<!--链接-->						<p><a class="btn btn-primary btn-lg btn-learn" href="courses.jsp">了解详情</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
			
	</header>
</div>
		
												
	<div class="item" id="i3">
	<header id="fh5co-header" class="fh5co-cover fh5co-cover-sm" role="banner" style="background-image:url(upload/${home.picturethree});" data-stellar-background-ratio="0.5">		
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>网上学习</h1>
					
<!--链接-->						<p><a class="btn btn-primary btn-lg btn-learn" href="pricing.jsp">了解详情</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>			
	</header>
	
</div>
</div>	


	<div id="fh5co-counter" class="fh5co-counters">
		<div class="container">
			<div class="row">
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="40356" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">学生</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="30290" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">课程</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="2039" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">老师</span>
				</div>
				<div class="col-md-3 text-center animate-box">
					<span class="fh5co-counter js-counter" data-from="0" data-to="997585" data-speed="5000" data-refresh-interval="50"></span>
					<span class="fh5co-counter-label">公司收益</span>
				</div>
			</div>
		</div>
	</div>
				
<main class="cd-main-content">
<!-- 旋转功能轮播图 -->

<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
<!-- 头部图 -->				
<div align="center">
<img alt="" src="img/jygl.png" width="40%"></div>
<div><br/></div>
				
				
      <div class="pic" id="pic">
	<span class="prev"><img src="image/arrow1.png" alt="arrow" /></span>
	<span class="next"><img src="image/arrow2.png" alt="arrow" /></span>
	<ul>
		<li class="pic1"><a href="seleguidelog.action" target="_blank"><img src="image/f1.png" /></a></li>
		<li class="pic2"><a href="allstu" target="_blank"><img src="image/f2.png" /></a></li>
		<li class="pic3"><a href="gzzs.action" target="_blank"><img src="image/f3.png" /></a></li>
		<li class="pic4"><a href="index.action" target="_blank"><img src="image/f4.png" /></a></li>
		<li class="pic5"><a href="courses.jsp" target="_blank"><img src="image/f5.png" /></a></li>
		<li class="pic6"><a href="http://112.74.115.92/" target="_blank"><img src="image/f6.png" /></a></li>
		<li class="pic7"><a href="uploading.jsp" target="_blank"><img src="image/f7.png" /></a></li>
		<li class="pic7"><a href="allshare.action" target="_blank"><img src="image/f9.png" /></a></li>		
		<li class="pic7"><a href="pricing.jsp" target="_blank"><img src="image/f8.png" /></a></li>
	</ul>
                  </div>
				</div>
			</div>
		</div>
		
	<div>
		<a href="#0" class="cd-btn cd-modal-trigger">进入管理平台</a><br><br><br>		
	</div>
	
</main> <!-- .cd-main-content -->

<div class="cd-modal">
	<div class="modal-content">
		<h1>教育管理平台</h1>
		<div class="container-fluid proj-bottom">
<!-- 功能导航隐藏	 -->
<div id="main">
   <ul>
<li> 
<!-- 		网上报名 -->
	   <img src="images/project-1.jpg" alt="Iron Man 1" width="100%" height="58%" />
		  <div class="info">
			 <a href="courses.jsp" target="_blank">了解详情</a>
		  </div>
	   </li>
	   
<li> 
<!-- 		学籍查询	 -->
	   <img src="images/tf1.png" alt="Iron Man 2" width="100%" height="58%" />
		  <div class="info">			
			 <a href="http://112.74.115.92/" target="_blank">了解详情</a>
		  </div>
</li>

<li> 
<!-- 		文件上传 -->
     <img src="images/project-3.jpg" alt="Iron Man 3" width="100%" height="58%" />
		  <div class="info">			
			 <a href="uploading.jsp" target="_blank">了解详情</a>
		  </div>
</li>


<li> 
<!-- 		网上学习 -->
      <img src="images/project-9.jpg" alt="Iron Man 1" width="100%" height="58%" />
		  <div class="info">
			<a href="pricing.jsp" target="_blank">了解详情</a>		
		  </div>
		
</li>

<li>
<!--        招生简介 -->
	   <img src="images/project-5.jpg" alt="Iron Man 2" width="100%" height="58%"/>
		  <div class="info">
			 <a href="seleguidelog.action" target="_blank">了解详情</a>
		  </div>
</li>
<li>
<!-- 	联系我们 --> 
	   <img src="images/project-6.jpg" alt="Iron Man 3" width="100%" height="58%"/>
		  <div class="info">		
			 <a href="relation.action" target="_blank">了解详情</a>
		  </div>
</li>

<li> 
<!-- 		缴费查询	 -->
      <img src="images/ym2.png" alt="Iron Man 1" width="100%" height="58%"/>
		  <div class="info">
			<c:if test="${teacher!=null}">
			 <a href="allstu" target="_blank">了解详情</a>
			 </c:if>
			 	
			 <c:if test="${teacher==null}">
			 <a href="#">了解详情</a>
			 </c:if>			
		  </div>
		
</li>

<li>
<!-- 		共享合作 -->
	   <img src="images/timg.jpg" alt="Iron Man 2" width="100%" height="58%"/>
		  <div class="info">
			 <a href="allshare.action" target="_blank">了解详情</a>
		  </div>
</li>
<li> 
<!-- 	工作助手 -->
<c:if test="${teacher!=null }">
	   <img src="images/tim9.png" alt="Iron Man 3" width="100%" height="58%"/>
		  <div class="info">		
			 <a href="gzzs.action" target="_blank">了解详情</a>
		  </div>
</c:if>	

<c:if test="${teacher==null }">
	   <img src="images/tim9.png" alt="Iron Man 3" width="100%" height="58%"/>
		  <div class="info">		
			 <a href="#">了解详情</a>
		  </div>
</c:if>	  
</li>
   </ul>
</div>	
				
				

				
			</div>
	</div> <!-- .modal-content -->

	<a href="#0" class="modal-close">Close</a>
</div> <!-- .cd-modal -->

<div class="cd-transition-layer"> 
	<div class="bg-layer"></div>
</div> <!-- .cd-transition-layer -->

	

<!-- 页面五 -->
	<div id="fh5co-steps">
		<div class="container">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>报名步骤</h2>
					<p>陶峰招生管理公共平台，助你平步青云！</p>
				</div>

			<div class="row bs-wizard animate-box" style="border-bottom:0;">
<!--步骤介绍 -->               
				
			
		
		
		<div class="maina">
			<div id="stepa"></div>
			<div class="btnsa">
				<button id="prevBtn">上一步</button>
				<button id="nextBtn">下一步</button>
			</div>
<!-- 			<div class="infoa">报名顺序：<span id="index"></span></div> -->
		</div>
		
<!-- 步骤图js内容 -->
		<script type="text/javascript">
			var $step = $("#stepa");
			var $index = $("#index");

			$step.step({
				index: 0,
				time: 500,
				title: ["选择报名", "资料填写", "上传资料", "对应缴费", "开始学习"]
			});

			$index.text($step.getIndex());

			$("#prevBtn").on("click", function() {
				$step.prevStep();
				$index.text($step.getIndex());
			});

			$("#nextBtn").on("click", function() {
				$step.nextStep();
				$index.text($step.getIndex());
			});

		</script>
		</div>
		</div>
	</div>



<!--专业介绍-->
<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>热门专业</h2>
						
<div class="xinxi_solution_main">
        <div class="xinxi_solution_bg">
            <div class="main_mobile">
                <ul>
                    <li class="one on">
                        <div class="left"></div>
                        <div class="left_top">
                            <i>计算机类</i><img src="images/button1.png" alt="工业">
                        </div>
                        <div class="right">
                            <dl>
                    
                            </dl>
                        </div>
                    </li>
                    <li class="one">
                        <div class="left"></div>
                        <div class="left_top">
                            <i>工科类</i><img src="images/button1.png" alt="工业">
                        </div>
                        <div class="right">
                            <dl style="margin-top: -120px;">
                             
                            </dl>
                        </div>
                    </li>
                    <li class="one">
                        <div class="left"></div>
                        <div class="left_top">
                            <i>教育类</i><img src="images/button1.png" alt="工业">
                        </div>
                        <div class="right">
                            <dl>
  
                            </dl>
                        </div>
                    </li>
                    <li class="one">
                        <div class="left"></div>
                        <div class="left_top">
                            <i>合作院校</i><img src="images/button1.png" alt="工业">
                        </div>
                        <div class="right">
                            <dl>
 <a title="井冈山大学" target="_blank" href="http://degree.qingshuxuetang.com/jgs/Home?schoolCategory=1">井冈山大学</a>
 <a title="东华理工大学" target="_blank" href="http://degree.qingshuxuetang.com/dhlg/Home?schoolCategory=1">东华理工大学</a>
 <a title="赣南师范大学" target="_blank" href="http://degree.qingshuxuetang.com/gnnu/Majors">赣南师范大学</a>
 <a title="江西师范大学" target="_blank" href="http://degree.qingshuxuetang.com/jxsf/Home">江西师范大学</a>
 <a title="江西广播大学" target="_blank" href="http://degree.qingshuxuetang.com/jxddc/Home">江西广播大学</a>
   <a title="江西中医药大学" target="_blank" href="http://degree.qingshuxuetang.com/jxzyy/">江西中医药大学</a>
  <a title="江西科技师范大学" target="_blank" href="http://degree.qingshuxuetang.com/jxstnu/Home?schoolCategory=1">江西科技师范大学</a>
  <a title="江西科技师范大学" target="_blank" href="courses.jsp"><font color="red" size="4">报名入口</font></a>                         
                            </dl>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
	</div>

	


	
	



	<footer id="fh5co-footer" role="contentinfo">
				<div align="center" style="background-color: #eee">
			<table width="80%">
				<tr>
					<td><font size="5">最新动态</font></td>
					<td><a href="morenotice.action" target="_blank"><font size="5"><b>查看更多</b></font></a></td>
				</tr>
				<tr><td style="height:10px">&nbsp;</td></tr>
				<s:iterator value="nlist" begin="0" end="3">
					<tr>
						<td width="50%"><a href="selonenotice.action?nid=${nid }" target="_blank">${ntitle}</a></td>
						<td align="center">${ndate}</td>
					</tr>
					<tr><td style="height:10px">&nbsp;</td></tr>
				</s:iterator>
			</table>
		</div>
		<div align="center">
			<b>&nbsp;</b>&nbsp;<br/>&nbsp;<br/>
			<table align="center" width="80%">
			<tr><td>
				<ul>
					<s:iterator value="hlist">
						<li
							style="float: left; width: 50%; height: 400px; list-style-type: none">
							<table bordercolor="#7288ae" border="1">
								<tr>
									<td>

										<table  height="370" width="500" bgcolor="white">
											<tr align="center" valign="top">
												<td height="200px"><img src="upload/${hmpicture }" width="300px" height="200px"></img></td>
											</tr>

											<tr align="left">
												<td height="30px"><font size="5"><b>${hmtitle }</b></font></td>
											</tr>

											<tr align="left" valign="top">
												<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color="a6a6a9">${hmcontent }</font></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</li>
					</s:iterator>
				</ul>
				</td></tr>
			</table>
		</div>
		
		<!-- 页面六 -->
	<div id="fh5co-testimonial" class="fh5co-bg-section">
		<div class="container">
<!-- 			<div class="row animate-box"> -->
<!-- 				<div class="col-md-6 col-md-offset-3 text-center fh5co-heading"> -->
<!-- 				<h2>问题咨询 -->
<!-- 					<a class="btn btn-primary btn-lg popup-vimeo btn-video" href="NewFile.jsp"></i>地址</a> -->
<!-- 				</h2> -->
<!-- 				</div> -->
<!-- 			</div> -->
			
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="row animate-box">
<!-- 轮播 -->				<div class="owl-carousel owl-carousel-fullwidth">
												
						<div class="item">
								<div class="testimony-slide active text-center">
									<figure>
<!-- 图片路径 -->										<img src="images/person_1.jpg" alt="user">
									</figure>
<!-- 路径跳转 -->							    	<span><b>报名客服小明</b><a href="tencent://message/?uin=790271961" class="twitter">点击咨询</a></span>
									<blockquote>
										<p>&ldquo;报名遇到问题？</p><!--&ldquo换行-->
									</blockquote>
								</div>
							</div>
							
							
							<div class="item">
								<div class="testimony-slide active text-center">
									<figure>
<!-- 图片路径 -->										<img src="images/person_2.jpg" alt="user">
									</figure>
<!-- 路径跳转 -->									<span><b>账户客服陶峰</b><a href="tencent://message/?uin=823234797">点击咨询</a></span>
									<blockquote>
										<p>&ldquo;登陆遇到问题？</p>
									</blockquote>
								</div>
							</div>
							
							
							<div class="item">
								<div class="testimony-slide active text-center">
									<figure>
<!-- 图片路径 -->										<img src="images/person_3.jpg" alt="user">
									</figure>
<!-- 路径跳转 -->									<span><b>缴费客服邱权</b> <a href="tencent://message/?uin=863729971">点击咨询</a></span>
									<blockquote>
										<p>&ldquo;缴费遇到问题？</p>
									</blockquote>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		
		
		
		<jsp:include page="footer.jsp"></jsp:include>
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


	
	
	
<!-- 	<!-- jQuery --> -->
<!-- 	<script src="js/jquery.min.js"></script> -->
	
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	
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