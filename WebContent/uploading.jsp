<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传文件</title>
<link rel="SHORTCUT ICON" href="img/tu.ico"/>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	
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
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Google Map -->
	<%-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="js/google_map.js"></script> --%>
	<!-- Main -->
	<script src="js/main.js"></script>
 
	

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

<style type="text/css">
*{margin:0;padding:0;}

.slideshow {
  position: absolute;
  width: 100vw;
  height: 120vh;
  overflow: hidden;
}

.slideshow-image {
  position: absolute;
  width: 100%;
  height: 100%;
  background: no-repeat 50% 50%;
  background-size: cover;
  -webkit-animation-name: kenburns;
          animation-name: kenburns;
  -webkit-animation-timing-function: linear;
          animation-timing-function: linear;
  -webkit-animation-iteration-count: infinite;
          animation-iteration-count: infinite;
  -webkit-animation-duration: 16s;
          animation-duration: 16s;
  opacity: 1;
  -webkit-transform: scale(1.2);
          transform: scale(1.2);
}
.slideshow-image:nth-child(1) {
  -webkit-animation-name: kenburns-1;
          animation-name: kenburns-1;
  z-index: 3;
}
.slideshow-image:nth-child(2) {
  -webkit-animation-name: kenburns-2;
          animation-name: kenburns-2;
  z-index: 2;
}
.slideshow-image:nth-child(3) {
  -webkit-animation-name: kenburns-3;
          animation-name: kenburns-3;
  z-index: 1;
}
.slideshow-image:nth-child(4) {
  -webkit-animation-name: kenburns-4;
          animation-name: kenburns-4;
  z-index: 0;
}

@-webkit-keyframes kenburns-1 {
  0% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  1.5625% {
    opacity: 1;
  }
  23.4375% {
    opacity: 1;
  }
  26.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  98.4375% {
    opacity: 0;
    -webkit-transform: scale(1.21176);
            transform: scale(1.21176);
  }
  100% {
    opacity: 1;
  }
}

@keyframes kenburns-1 {
  0% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  1.5625% {
    opacity: 1;
  }
  23.4375% {
    opacity: 1;
  }
  26.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  98.4375% {
    opacity: 0;
    -webkit-transform: scale(1.21176);
            transform: scale(1.21176);
  }
  100% {
    opacity: 1;
  }
}
@-webkit-keyframes kenburns-2 {
  23.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  26.5625% {
    opacity: 1;
  }
  48.4375% {
    opacity: 1;
  }
  51.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
}
@keyframes kenburns-2 {
  23.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  26.5625% {
    opacity: 1;
  }
  48.4375% {
    opacity: 1;
  }
  51.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
}
@-webkit-keyframes kenburns-3 {
  48.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  51.5625% {
    opacity: 1;
  }
  73.4375% {
    opacity: 1;
  }
  76.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
}
@keyframes kenburns-3 {
  48.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  51.5625% {
    opacity: 1;
  }
  73.4375% {
    opacity: 1;
  }
  76.5625% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
}
@-webkit-keyframes kenburns-4 {
  73.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  76.5625% {
    opacity: 1;
  }
  98.4375% {
    opacity: 1;
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}
@keyframes kenburns-4 {
  73.4375% {
    opacity: 1;
    -webkit-transform: scale(1.2);
            transform: scale(1.2);
  }
  76.5625% {
    opacity: 1;
  }
  98.4375% {
    opacity: 1;
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(1);
            transform: scale(1);
  }
}


h1 {
  position: absolute;
  top: 50%;
  left: 50%;
  -webkit-transform: translate3d(-50%, -50%, 0);
          transform: translate3d(-50%, -50%, 0);
  z-index: 99;
  text-align: center;
  font-family: Raleway, sans-serif;
  font-weight: 30s;
  text-transform: uppercase;
  background-color: rgba(255, 255, 255, 0.75);
  box-shadow: 0 1em 2em -1em rgba(0, 0, 0, 0.5);
  padding: 1em 2em;
  line-height: 1.5;
}
h1 small {
  display: block;
  text-transform: lowercase;
  font-size: .7em;
}
h1 small:first-child {
  border-bottom: 1px solid rgba(0, 0, 0, 0.25);
  padding-bottom: .5em;
}
h1 small:last-child {
  border-top: 1px solid rgba(0, 0, 0, 0.25);
  padding-top: .5em;
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
<!-- 主页图片 -->						<img src="images/zy.png">
						</a></div>
					</div>
					
					
					
					<div class="col-xs-11 text-right menu-1">
												<ul>
							<!-- <li><a href="index.action">首页</a></li> -->
							<li><a href="http://localhost:8080/project/">首页</a></li>
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

function checkform(){
	var photo=$("#photo").val();
	var voucher=$("#voucher").val();
	var paper=$("#paper").val();
	var id=$("#sid").val();
	var name=$("#sname").val();
	
	if(id==""){
		alert("学生id不能为空");
		return;
	}
	if(name==""){
		alert("学生姓名不能为空");
		return;
	}
	
	if(photo==""){
		alert("相片不能为空");
		return;
	}
	if(voucher==""){
		alert("缴费凭证不能为空");
		return;
	}
	if(paper==""){
		alert("论文不能为空");
		return;
	}
	
	if(isNaN(id)){
		alert("请输入正确的学生id");
		return;
	}
	
	$.ajax({
		 async:true,
	 	 cache:true,
	 	 url:'hasstu',
	 	 type:'post',
	 	data:{
	 		"id":id,
	 		"name":name
	 	},
	 	/* datatype:'json', */
	 	 success:function(result){
	 		//alert(result);
	 	
	 		
	 		
	 		 if(result=="1"){//可以上传
	 			alert("上传成功");
	 			$("#uploadfile").submit();
	 		 }
	 		 else{
	 			alert("您输入的学生信息有误 请重新填写");
	 			window.location.reload();
	 		 } 
	 		
	 		
	 	 },
	 	 error:function(XMLHttpRequest,textStatus){
	 		 alert("错误");
	 	 }
	 });
	
	
}	


</script>

<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url();" data-stellar-background-ratio="0.5">
	<!-- 	<div class="overlay"></div> -->
	        <h1>
	        
	        <small><img  src="images/sc.png" width="20%"></small>
	        <font size="6"><b>文件上传</b></font><small>
	      <form method="post" id="uploadfile" action="uploadfile" enctype="multipart/form-data" >
        
        <table  align="right" width="70%">
        	<tr>	
            	<td colspan="2" width="60" align="left">
                <b>学号:</b> 
                <input type="text"  name="stufile.stuid" placeholder="请输入学号" id="sid" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入学号';}"/>
            	</td>
            </tr>
          
            <tr>	
            	<td colspan="2" width="60" align="left">
                <b>姓名:</b> 
                <input type="text"  name="stufile.stuname" placeholder="请输入姓名" id="sname" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入姓名';}"/>
            	</td>
            </tr>
<!--             <tr><td>&nbsp;</td></tr> -->
            <tr>	
            	 <td width="60" align="left">
        		<b>相片:</b><input type="file" id="photo" name="myfile"/> 
            	</td>
            </tr>
<!--         	<tr><td>&nbsp;</td></tr> -->
            <tr>
                <td valign="top" align="left">
                <b>缴费凭证:</b>               
                	<input type="file" id="voucher" name="myfile" /> 
                </td>
            </tr>
<!--             <tr><td>&nbsp;</td></tr>       -->
             <tr>
                <td valign="top" align="left">
                <b>论文:</b>            
                	<input type="file" id="paper" name="myfile" />
                </td>
            </tr>
            
           
            <tr>
            	
            	<td align="left">
            		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            		
            		<input type="button" value="提交" id="b1" onclick="checkform();">
            	</td>
            </tr>
        </table>
        </form>
	        </small>
	        </h1>

<!-- 你可以添加个多“.slideshow-image”项目, 记得修改CSS -->
<div class="slideshow">
	<div class="slideshow-image" style="background-image: url('img/1b.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('img/2b.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('img/3b.jpg')"></div>
	<div class="slideshow-image" style="background-image: url('img/4b.jpg')"></div>
</div>	
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">	
							
					<div class="display-t">
<!-- 						<div class="display-tc animate-box" data-animate-effect="fadeIn"> -->
						
						<br/>
							
						
																	


        

        
					</div>
					</div>
					</div>
					
					
					
					
				</div>
			</div>
		
	</header>

				
     
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
	


	</body>
</html>