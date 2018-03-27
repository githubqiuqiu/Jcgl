<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>明志教育</title>
		<link rel="SHORTCUT ICON" href="img/tu.ico"/>
		<meta name="description" content="A simple slideshow component with individual slide layouts and effects" />
		<meta name="keywords" content="slideshow, images, layout, asymmetric, css, html, javascript, template" />
       <link rel="stylesheet" type="text/css" href="./css/index.css">
		<link href="https://fonts.googleapis.com/css?family=Gochi+Hand" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/normalize.css" />
		
<!-- 界面样式 --><link rel="stylesheet" type="text/css" href="css/demo.css" />
<!-- 图片排布样式 --><link rel="stylesheet" type="text/css" href="css/slideshow.css" />
<!-- 切换样式 --><link rel="stylesheet" type="text/css" href="css/slideshow_layouts.css" />
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  		<style>
			.ie-message { display: inline-block; }
  		</style>
		<![endif]-->
		
<style>


object { margin: 0px; display: block; }

</style>
		<script>document.documentElement.className = 'js';</script>
	</head>
	<body>

		<svg class="hidden">
			<defs>
				<symbol id="icon-arrow" viewBox="0 0 24 24">
					<title>arrow</title>
					<polygon points="6.3,12.8 20.9,12.8 20.9,11.2 6.3,11.2 10.2,7.2 9,6 3.1,12 9,18 10.2,16.8 "/>
				</symbol>
				<symbol id="icon-drop" viewBox="0 0 24 24">
					<title>drop</title>
					<path d="M12,21c-3.6,0-6.6-3-6.6-6.6C5.4,11,10.8,4,11.4,3.2C11.6,3.1,11.8,3,12,3s0.4,0.1,0.6,0.3c0.6,0.8,6.1,7.8,6.1,11.2C18.6,18.1,15.6,21,12,21zM12,4.8c-1.8,2.4-5.2,7.4-5.2,9.6c0,2.9,2.3,5.2,5.2,5.2s5.2-2.3,5.2-5.2C17.2,12.2,13.8,7.3,12,4.8z"/><path d="M12,18.2c-0.4,0-0.7-0.3-0.7-0.7s0.3-0.7,0.7-0.7c1.3,0,2.4-1.1,2.4-2.4c0-0.4,0.3-0.7,0.7-0.7c0.4,0,0.7,0.3,0.7,0.7C15.8,16.5,14.1,18.2,12,18.2z"/>
				</symbol>
				<symbol id="icon-prev" viewBox="0 0 100 50">
					<title>prev</title>
					<polygon points="5.4,25 18.7,38.2 22.6,34.2 16.2,27.8 94.6,27.8 94.6,22.2 16.2,22.2 22.6,15.8 18.7,11.8"/>
				</symbol>
				<symbol id="icon-next" viewBox="0 0 100 50">
					<title>next</title>
					<polygon points="81.3,11.8 77.4,15.8 83.8,22.2 5.4,22.2 5.4,27.8 83.8,27.8 77.4,34.2 81.3,38.2 94.6,25 "/>
				</symbol>
				<symbol id="icon-octicon" viewBox="0 0 24 24">
					<title>octicon</title>
					<path d="M12,2.2C6.4,2.2,1.9,6.7,1.9,12.2c0,4.4,2.9,8.2,6.9,9.6c0.5,0.1,0.7-0.2,0.7-0.5c0-0.2,0-0.9,0-1.7c-2.8,0.6-3.4-1.4-3.4-1.4C5.6,17.1,5,16.8,5,16.8C4.1,16.2,5,16.2,5,16.2c1,0.1,1.5,1,1.5,1c0.9,1.5,2.4,1.1,2.9,0.8c0.1-0.7,0.4-1.1,0.6-1.3c-2.2-0.3-4.6-1.1-4.6-5c0-1.1,0.4-2,1-2.7C6.5,8.8,6.2,7.7,6.7,6.4c0,0,0.8-0.3,2.8,1C10.3,7.2,11.1,7.1,12,7c0.9,0,1.7,0.1,2.5,0.3c1.9-1.3,2.8-1,2.8-1c0.5,1.4,0.2,2.4,0.1,2.7c0.6,0.7,1,1.6,1,2.7c0,3.9-2.4,4.7-4.6,5c0.4,0.3,0.7,0.9,0.7,1.9c0,1.3,0,2.4,0,2.8c0,0.3,0.2,0.6,0.7,0.5c4-1.3,6.9-5.1,6.9-9.6C22.1,6.7,17.6,2.2,12,2.2z" />
				</symbol>
				<clipPath id="polygon-clip-rhomboid" clipPathUnits="objectBoundingBox">
					<polygon points="0 1, 0.3 0, 1 0, 0.7 1" />
				</clipPath>
			</defs>
		</svg>
		<main>
	
			<header class="codrops-header">
<!-- 				<h1 class="codrops-header__title"><a href="http://localhost:8080/project/wheel">陶峰教育网</a></h1> -->
				<a href="index.action">
				<!-- -------------------------------------------------------------------------播放器				 -->
<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="150" height="-30"
    codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab">
    <param name="movie" value="singlemp3player.swf?showDownload=false" />

    <param name="wmode" value="transparent" />
    <embed wmode="transparent" width="150" height="20" src="singlemp3player.swf?showDownload=false"

    type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" />
</object>
<!-- 主页图片 -->	<img src="images/zy.png"></a>



				<p class="codrops-header__tagline">才须学也。非学无以广才，非志无以成学</p>



				<nav class="dummy-links">
				
					<a class="dummy-links__link dummy-links__link--current" href="http://localhost:8080/project/wheel"><img src="imgs/s3.png" width="60" height="60"></a>
					<a class="dummy-links__link" href="login.jsp"><img src="imgs/s2.png" width="45" height="45"></a>
					<a class="dummy-links__link" href="courses.jsp"><img src="imgs/s1.png" width="50" height="50"></a>
				</nav>
				
			</header>
			<div class="slideshow" tabindex="0">
				<div class="slide slide--layout-1" data-layout="layout1">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/1.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/2.png);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/3.png);"></div></div>
					</div>
					<div class="slide__title">
						<h5 class="slide__title-main">教育管理平台</h5>
						<p class="slide__title-sub">陶峰教育平台利用一切工具进行教育活动皆以提高效率为前提。利用网络先进的技术改变师生的交流方式上课，进一步提高学生掌握知识的效率、进一步培养能力是网络教育研究的实质。<a href="index.action">进入首页</a></p>
					</div>
				</div><!-- /slide -->
				<div class="slide slide--layout-2" data-layout="layout2">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/6.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/5.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/6.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/7.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/9.jpg);"><h4 class="slide__img-caption">Today is someday</h4></div></div>
					</div>
					<div class="slide__title">
						<h6 class="slide__title-main">网上报名平台</h6>
						<p class="slide__title-sub">网上报名系统满足了考试的基本流程的要求.设置―考生报名‖功能模块,提供在线报名功能,满足考生通过网络直接报名的要求.提高了考试的运行效率,方便考生报名.</p>
					</div>
				</div><!-- /slide -->
				
				<div class="slide slide--layout-3" data-layout="layout3">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/9.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/10.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/11.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/15.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/13.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/14.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/12.jpg);"></div></div>
					</div>
					<div class="slide__title">
						<h5 class="slide__title-main">网上学习</h5>
						<p class="slide__title-sub">网络学习她打破了传统教育模式的时间和空间条件的限制，是传统学校教育功能的延伸。由于教学组织过程具有开放性、交互性、协作性、自主性等特点，她是一种以学生为中心的教育形式。</p>
					</div>
				</div><!-- /slide -->
				<div class="slide slide--layout-4" data-layout="layout4">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/10.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/8.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/11.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/13.jpg);"></div></div>
					</div>
					<div class="slide__title">
						<h5 class="slide__title-main">平台管理</h5>
						<p class="slide__title-sub">管理平台能从根本上解决了各个系统间数据不兼容的问题，避免了用户在使用过程中多系统间切换、多次录入数据的繁琐，各个功能系统间互相关联，全程无缝管理，使整个企业的运作纳入到统一的管理中，真正实现全程实时监控，数据实时汇总，智能化管理，一体化操作的现代企业信息化管理.</p>
					</div>
				</div><!-- /slide -->
				<div class="slide slide--layout-5" data-layout="layout5">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/1.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/2.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/3.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/4.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/5.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/6.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/7.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/8.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/9.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/10.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/11.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/12.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/13.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/14.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/15.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/16.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/17.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/small/18.jpg);"></div></div>
					</div>
					<div class="slide__title">
						<h3 class="slide__title-main">学生报名</h3>
						<p class="slide__title-sub">在线报名是领先的招生报名教育培训信息网站,秉持与诚信的教育培训机构和老师共同成长的理念,不断创新自我。</p>
					</div>
				</div><!-- /slide -->
				<div class="slide slide--layout-6" data-layout="layout6">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/14.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/19.png);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/3.jpg);"></div></div>
					</div>
					<div class="slide__title">
						<h3 class="slide__title-main">合作招生</h3>
						<p class="slide__title-sub">平台提供老师用户合作招生系统</p>
					</div>
				</div><!-- /slide -->
				<div class="slide slide--layout-7" data-layout="layout7">
					<div class="slide-imgwrap">
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/16.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/20.jpg);"></div></div>
						<div class="slide__img"><div class="slide__img-inner" style="background-image: url(img/4.jpg);"></div></div>
					</div>
					<div class="slide__title">
						<h3 class="slide__title-main">轻松拿证</h3>
						<p class="slide__title-sub">资格证书是劳动就业制度的一项重要内容，也是一种特殊形式的国家考试制度。它是指按照国家制定的职业技能标准或任职资格条件，通过政府认定的考核鉴定机构，对劳动者的技能水平或职业资格进行客观公正、科学规范的评价和鉴定，对合格者授予相应的国家职业资格证书。</p>
					</div>
				</div><!-- /slide -->
				
				<div class="slide slide--layout-7" data-layout="layout7">
				<center>
				<div class="slide__img-inner" style="background-image: url(img/21.png);"></div>
				</center>	
					<div class="slide-imgwrap">
						
	<div class="nav-bak-inner">					
	<div class="nav-item">
<!-- 查询 -->	
	<span class="nav-text"><img alt="" src="img/dh1.png" width="40" height="40"></span>
		<div class="nav-link">
			<div class="nav-item-link"><div class="nav-bg-link"><a href="selectzahlen.jsp"><span class="nav-text-link">缴费查询</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="http://112.74.115.92/"><span class="nav-text-link">学籍查询</span></a></div></div>
		</div>
	</div>
<!-- 报名1 -->
	<div class="nav-item">
	<span class="nav-text"><a href="courses.jsp"><img alt="" src="img/dh2.png" width="35" height="35"></a></span>
		<div class="nav-link">
			<div class="nav-item-link"><div class="nav-bg-link"><a href="http://localhost:8080/project/select"><span class="nav-text-link">成人高考</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="http://localhost:8080/project/select5"><span class="nav-text-link">国家开放</span></a></div></div>
	        <div class="nav-item-link"><div class="nav-bg-link"><a href="http://localhost:8080/project/select6"><span class="nav-text-link">远程教育</span></a></div></div>	
		</div>
	</div>
<!-- 报名2	 -->
	<div class="nav-item">
	<span class="nav-text"><a href="courses.jsp"><img alt="" src="img/dh2.png" width="35" height="35"></a></span>
		<div class="nav-link">
			<div class="nav-item-link"><div class="nav-bg-link"><a href="http://localhost:8080/project/select2"><span class="nav-text-link">会计</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="http://localhost:8080/project/select3"><span class="nav-text-link">艺考</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="contact03t.jsp"><span class="nav-text-link">职考</span></a></div></div>
		</div>
	</div>
<!-- 登录	 -->
	<div class="nav-item">
	<span class="nav-text"><img alt="" src="img/4.png" width="40" height="40"></span>
		<div class="nav-link">
			<div class="nav-item-link"><div class="nav-bg-link"><a href="login.jsp"><span class="nav-text-link">后台登录</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="login2.jsp"><span class="nav-text-link">合作招生</span></a></div></div>
		</div>
	</div>

<!-- 其他 -->	
	<div class="nav-item">
	<span class="nav-text"><img alt="" src="img/dh5.png" width="30" height="30"></span>
		<div class="nav-link">
			<div class="nav-item-link"><div class="nav-bg-link"><a href="uploading.jsp"><span class="nav-text-link">文件上传</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="pricing.jsp"><span class="nav-text-link">网上学习</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="into.jsp"><span class="nav-text-link">招生简介</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="share.jsp"><span class="nav-text-link">共享合作</span></a></div></div>
			<div class="nav-item-link"><div class="nav-bg-link"><a href="aide.jsp"><span class="nav-text-link">工作助手</span></a></div></div>
		</div>
	</div>			
	<div class="nav-center"></div>

</div>
</div>
					<div class="slide__title">
						<h3 class="slide__title-main"><a href="index.action">教育管理平台</a></h3>
						<p class="slide__title-sub">“教育管理平台”是让各种学生成功就业的学习平台，<br/>学历终身可查， 保证学生的就业，月拿高薪不是梦！</p>
					</div>
				</div><!-- /slide -->
				
				<nav class="slideshow__nav slideshow__nav--arrows">
<!-- button按钮--------------- -->				
					<button id="prev-slide" class="btn btn--arrow" aria-label="Previous slide"><svg class="icon icon--prev"><use xlink:href="#icon-prev"></use></svg></button>
					<button id="next-slide" class="btn btn--arrow" aria-label="Next slide"><svg class="icon icon--next"><use xlink:href="#icon-next"></use></svg></button>
				</nav>
			</div><!-- /slideshow -->

			
		</main>
		<script src="js/imagesloaded.pkgd.min2.js"></script>
		<script src="js/anime.min2.js"></script>
		<script src="js/main2.js"></script>
		<script>
		(function() {
			var slideshow = new MLSlideshow(document.querySelector('.slideshow'));

			document.querySelector('#next-slide').addEventListener('click', function() {
				slideshow.next();
			});

			document.querySelector('#prev-slide').addEventListener('click', function() {
				slideshow.prev();
			});
		})();
		</script>
		
		
	</body>
</html>