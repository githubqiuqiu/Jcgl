<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

 <!-- 触发JS刷新-->
 <script type="text/javascript">
    function changeImg(){
        var img = document.getElementById("img"); 
        img.src = "/cc/authImg?date=" + new Date();;
    }
</script>
</head>
<body>
<img id="img" src="/cc/authImg" />
        <a href='#' onclick="javascript:changeImg()" style="color:white;"><label style="color:red;">看不清？</label></a>
</body>
</html>