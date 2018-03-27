<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>招生简介</title>
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


<!-- 輪播圖 -->	
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
	</head>
	<body>
		<div class="overlay"></div>
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
    <div id="fh5co-logo">
               <a href="index.action">
<!-- 主页图片 -->	<img src="images/zy.png">
			   </a>
	</div>
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

<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/timg02.jpg);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
						
						<h1>院校简介</h1>
	<div class="pic" id="pic">
	<span class="prev"><img src="image/arrow1.png" alt="arrow" /></span>
	<span class="next"><img src="image/arrow2.png" alt="arrow" /></span>
	<ul>
	
<!--图片路径 -->
<!-- 		<li class="pic1"><a href="referral.jsp"><img src="image/f1.jpg" /></a></li> -->
<!-- 		<li class="pic2"><a href="referral.jsp"><img src="image/f2.jpg" /></a></li> -->
<!-- 		<li class="pic3"><a href="referral.jsp"><img src="image/f3.jpg" /></a></li> -->
<!-- 		<li class="pic4"><a href="referral.jsp"><img src="image/f4.jpg" /></a></li> -->
<!-- 		<li class="pic5"><a href="referral.jsp"><img src="image/f5.jpg" /></a></li> -->
<!-- 		<li class="pic6"><a href="referral.jsp"><img src="image/f6.jpg" /></a></li> -->
<!-- 		<li class="pic7"><a href="referral.jsp"><img src="image/f7.jpg" /></a></li> -->
<!-- 		<li class="pic7"><a href="referral.jsp"><img src="image/f8.jpg" /></a></li> -->
		<% int i = 0; %>
		<s:iterator value="list" begin="0" end="7">
		<% i = i+1; %>
			<li class="pic<%=i %>"><a href="selmoreinfo?id=${id}" target="_blank"><img src="upload/${log}" /></a></li>
		</s:iterator>
	</ul>
</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</header>

	

        	<div id="fh5co-started" style="background-image:url(images/zg.png);">
		<div class="overlay"></div>
		<div class="container">
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>招生简介</h2>
					<p>招生管理公共平台”是让各种学生成功就业的学习平台，<br/>学历终身可查， 保证学生的就业，月拿高薪不是梦！</p>
				</div>
			</div>
			<div class="row animate-box">
				<div class="col-md-8 col-md-offset-2 text-center">
					<p><a href="http://localhost:8080/project/courses.jsp" class="btn btn-default btn-lg">进入报名</a></p>
				</div>
			</div>
		</div>
		
	</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>

	
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	
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