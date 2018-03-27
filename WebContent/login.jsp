<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <title>登录</title>
        <link rel="SHORTCUT ICON" href="img/tu.ico"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
<!--         <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'> -->
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">
			
		
        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
        	
		<style type="text/css">
			a{
				text-decoration: none
			}
			
		
		</style>
		
		
		<script type="text/javascript">
		$(function(){
			
			 //账号框获得焦点
			 $("#loginname").focus(function(){
				 var loginname=$("#loginname").val();
						$("#d1").html("");
				 });
				//账号框失去焦点
				 $("#loginname").blur(function(){
					 var loginname=$("#loginname").val();
						if(loginname==""){
							$("#d1").html("账号不能为空");
						}
				 });
				
				//密码框获得焦点
				 $("#password").focus(function(){
					 var pwd=$("#password").val();
						if(pwd==""){
							$("#d2").html("");
						}
					 });
				//密码框失去焦点
				 $("#password").blur(function(){
					 var pwd=$("#password").val();
					 
						if(pwd==""){
							$("#d2").html("密码不能为空");
						}
				 });
				
				//验证码框获得焦点
				 $("#yzm").focus(function(){
					 var yzm=$("#yzm").val();
						if(yzm==""){
							$("#d3").html("");
						}
						
					 });
				
				//验证码框失去焦点
				 $("#yzm").blur(function(){
					 var yzm=$("#yzm").val();
					 
						if(yzm==""){
							$("#d3").html("验证码不能为空");
						}
				 });
				
		});
		
		
		
		 //换验证码
		 function changeImg(){
		        var img = document.getElementById("img"); 
		        img.src = "/project/yzm?date=" + new Date();;
		    }
		 
		 
		 //登录
		function login(){
			 var loginname=$("#loginname").val();
			 var pwd=$("#password").val();
			 var yzm=$("#yzm").val();
			 //alert("进了登录");
			 //alert(loginname);
			 //alert(pwd);
			 //alert(yzm);
			 
			$.ajax({
				 async:true,
			 	 cache:true,
			 	 url:'SignUp',
			 	 type:'post',
			 	 data:{
			 		 "loginname":loginname,
			 		 "pwd":pwd,
			 		 "yzm":yzm
			 	 },
			 	 //datatype:'json',
			 	 success:function(result){
			 		 if(result=="1"){
			 			window.location.href="Backstage";
			 		 }
			 		 if(result=="2"){
			 			$("#d2").html("密码不正确");
			 			$("#password").val("");
			 		 }
			 		 if(result=="3"){
			 			 $("#d1").html("账号不存在");
			 			$("#loginname").val("");
			 		 }
			 		 if(result=="4"){
			 			 $("#d3").html("验证码不正确");
			 			 $("#yzm").val("");
			 		 }
			 		 if(result=="5"){
			 			 $("#d1").html("该账号已停用");
			 			$("#loginname").val("");
			 			// $("#yzm").val("");
			 			$("#password").val("");
			 		 }
			 		 
			 		 
					
			 	 },
			 	 error:function(XMLHttpRequest,textStatus){
			 		 alert("错误");
			 	 }
			 });

		 }
		</script>      

<!-- 背景 -->
<style>
		
		body{background-color: #2D2D2D}
	</style>
    </head>

    <body>

        <div class="page-container">
         
            <form action="" method="post">
                <input type="text" id="loginname" name="user.loginname" placeholder="请输入账号"><br/> <div id="d1"></div>
                <input type="password" id="password" name="user.password"  placeholder="请输入密码"><br/><div id="d2"></div>
                 <input type="text" id="yzm" name="yzm"  placeholder="请输入验证码"><br/><div id="d3"></div>
                	&nbsp;
                 <div id="div2" >
                 	&nbsp;
                 	<img id="img" src="/project/yzm" />
      			  <a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:red;">看不清？</label></a>
                 	
                 </div>
                 
            <button onclick="login()" type="button">登录</button> 
             <!--   <input type="button" onclick="login()" value="登入">  -->
               <div class="error"><span>+</span></div>
             </form>
             
            <div class="connect">
                <p>
                    <a class="facebook" href="index.action"></a>
                    <a class="twitter" href="courses.jsp"></a>
                </p>
            </div>
<!-- 背景div -->
	<div id="mydiv" style="height:500px;"></div>
	<script type="text/javascript">
		window.onload = function() {
		    //配置
		    var config = {
		        vx: 4,	//小球x轴速度,正为右，负为左
		        vy: 4,	//小球y轴速度
		        height: 2,	//小球高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 200,		//点个数
		        color: "121, 162, 185", 	//点颜色
		        stroke: "130,255,255", 		//线条颜色
		        dist: 6000, 	//点吸附距离
		        e_dist: 20000, 	//鼠标吸附加速距离
		        max_conn: 10 	//点到点最大连接数
		    }

		    //调用
		    CanvasParticle(config);
		}
	</script>
	<script type="text/javascript" src="canvas-particle.js"></script>
        </div>



    </body>

</html>


