<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!doctype html>
<html>
<head>
	<meta charset="utf-8"> 
	 <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Bootstrap 实例 - 轮播（Carousel）插件的标题</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%-- <base href="<%=basePath%>"> --%>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/highcharts.js" type="text/javascript"></script>
<script src="resources/js/jquery.highchartTable.js"
	type="text/javascript"></script>
<script language="javascript">
$(document).ready(function() {
  $('table.highchart').highchartTable();
});
</script>
<style type="text/css">
   #myCarousel  .carousel-inner > .item > img {
   height:50%;
   width:830px;
}

</style>
</head>
<body>

<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000" style="  height:100%;  width:100%;">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
		<li data-target="#myCarousel" data-slide-to="4"></li>
		<li data-target="#myCarousel" data-slide-to="5"></li>
	</ol>   
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner">
		<div class="item active" style="text-align:center;">
			<img src="../resources/imgs/1.jpg"  style="display:inline-block;" alt="First slide">
			<div class="carousel-caption" style = "font-size:6vw">想客户之所想!</div>
		</div>
		<div class="item" style="text-align:center;">
			<img src="../resources/imgs/2.jpg" style="display:inline-block;" alt="Second slide">
			<div class="carousel-caption" style = "font-size:6vw">思客户之所思！</div>
		</div>
		<div class="item" style="text-align:center;">
			<img src="../resources/imgs/3.jpg" style="display:inline-block;" alt="Third slide">
			<div class="carousel-caption" style = "font-size:6vw">引领时代技术！</div>
		</div>
		<div class="item" style="text-align:center;">
			<img src="../resources/imgs/4.jpg" style="display:inline-block;" alt="Third slide">
			<div class="carousel-caption" style = "font-size:6vw">走在时代前沿！</div>
		</div>
				<div class="item" style="text-align:center;">
			<img src="../resources/imgs/17.jpg" style="display:inline-block;" alt="Third slide">
			<div class="carousel-caption" style = "font-size:6vw">引领时代技术！</div>
		</div>
		<div class="item" style="text-align:center;">
			<img src="../resources/imgs/20.jpg" style="display:inline-block;" alt="Third slide">
			<div class="carousel-caption" style = "font-size:6vw">走在时代前沿！</div>
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev" >
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	</a>
	<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	</a>
</div>
	<div class="main-content" id="mains" >
		<iframe id="mainframe" name="mainframe" src="bootm1.jsp" style="width: 100%; height:388px; border: 0px;"> </iframe>
	</div>



</body>
</html>