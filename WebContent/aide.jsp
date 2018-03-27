<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	
	<script src="sss/jquery-1.10.2.js"></script>
	<script src="swal/sweetalert2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="swal/sweetalert2.min.css">
	
	<script type="text/javascript">
// 		function add(){
// 			alert("添加！");
// 			window.open ('addschedule.jsp','newwindow','height=180, width=400,top=300,left=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
// 		}
		$(function(){
			$("#aca").click(function(){
				swal({
			    	  title: '',
			    	  html:
			    	    '标题<input id="sTitle" name="sTitle" type="text" class="swal2-input">' +
			    	    '内容 <textarea id="scontent" name ="scontent" class="form-control" rows="3"></textarea>',
			    	  preConfirm: function() {
			    		  var sTitle = $('#sTitle').val();
				          var scontent = $('#scontent').val();
				          return new Promise(function(resolve) {
				        	  $.post("addsche.action",{"stitle":sTitle,"scontent":scontent},function(data) {
				        		  window.location.href="gzzs.action";
							  });
				          });
			    	  }
			    })
			});
		});
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
<!-- 						<div id="fh5co-logo"><a href="index.action"> -->
<!-- 						<img src="images/zy.png"> -->
<!-- 						</a></div> -->
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
	<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/timg.jpg);" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<table  width="100%"  bgcolor="white">
						
						
						<tr height="10%">
							<td colspan="10">
								<img src="images/gzzs.png" width="55%">
							</td>
						</tr>
						
						
						<tr bgcolor="#333333">
							<td>
								<font color="white">
								计划标题
								</font>
							</td>
							<td>
								<font color="white">
								计划内容
								</font>
							</td>
							<td>
								<font color="white">
								是否完成
								</font>
							</td>
							<td>
								<font color="white">
								创建时间
								</font>
							</td>
							<td>
								<font color="white">
								完成时间
								</font>
							</td>
							<td>
								<font color="white">
								操作
								</font>
							</td>
							<td>
								<font color="white">
								&nbsp;&nbsp;
								</font>
							</td>
						</tr>
						
<!-- ----------------------------数据内容------------------------------------------ -->
				<s:iterator value="list">
           					<tr>
							<td>
								<font color="white">
									${stitle }
								</font>
							</td>
							<td>
								<font color="white">
									${scontent }
								</font>
							</td>
							<td>
								<font color="white">
									<c:if test="${sflag==0}">未完成</c:if>
									<c:if test="${sflag==1}">已完成</c:if>
								</font>
							</td>
							<td>
								<font color="white">
									${sdate }
								</font>
							</td>
							<td>
								<font color="white">
									${sfinishdate}
								</font>
							</td>
							<td>
								<font color="white">
									<c:if test="${sflag==1}"><a href="delsche.action?sid=${sid}">删除</a></c:if>
									<c:if test="${sflag==0}"><a href="editsch.action?sid=${sid }">已完成</a></c:if>
								</font>
							</td>
							<td>
								<font color="white">
									<a href="javascript:add()" id="aca">添加</a>
								</font>
							</td>
						</tr>
						</s:iterator>	
						</table>
					</div>
				</div>
			</div>
		</div>
	</header>


						
	<footer id="fh5co-footer" role="contentinfo">
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
	
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
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
	
	<!-- 弹出菜单 -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	
	<!-- 主要的 -->
	<script src="js/main.js"></script>

	</body>
</html>
