<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<title></title>
		<script src="sss/jquery-1.10.2.js"></script>
  <link rel="stylesheet" href="style6.css">
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Hy39puRjkD52O5l2T0ne7ZpSepVNY3fN"></script>
    <script src="main6.js"></script>
</head>
<body>
<div id="myPageTop">
    <a href="javascript:void(0);" id="show">
        点击试试———路线工具（展开/收缩）
    </a>
    <div class="pageShow">
        <h3>搜索地址</h3>
        <input id="local" placeholder="模糊地址搜索">
        <span>—&nbsp;—</span>
        <a id="city" href="javascript:void(0);">
            点击搜索
        </a>

        <h3>搜索行车路径</h3>
        <input id="star" placeholder="行车开始地址">
        <span>—&nbsp;—</span>
        <input id="end" placeholder="行车结束地址">
        <span>—&nbsp;—</span>
        <a id="car" href="javascript:void(0);">
            点击搜索
        </a>

        <h3>搜索公交路径</h3>
        <input id="bStar" placeholder="公交开始地址">
        <span>—&nbsp;—</span>
        <input id="bEnd" placeholder="公交结束地址">
        <span>—&nbsp;—</span>
        <a id="bus" href="javascript:void(0);">
            点击搜索
        </a>

        <h3>搜索步行路径</h3>
        <input id="wStar" placeholder="步行开始地址">
        <span>—&nbsp;—</span>
        <input id="wEnd" placeholder="步行结束地址">
        <span>—&nbsp;—</span>
        <a id="walk" href="javascript:void(0);">
            点击搜索
        </a>
    </div>
</div>
<div id="container"></div>
<div id="panel"></div>
</body>
</html>