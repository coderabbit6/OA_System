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
<base href="<%=basePath%>">

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
   height:60%;
   width:80%;
}
</style>
</head>
<body>
	<div style="padding: 1px; height:100%; margin: 10px; margin-top:30px" >
		<div class="row">
			<div class="col-sm-8">
				<div class="panel panel-default">
					<div class="panel-heading" style="padding: 3px; height: 100%;">
						<span class="glyphicon glyphicon-refresh"></span>部门状态
					</div>
					<div class="panel-body">
						<table class="highchart" style="display: none;"
							data-graph-container-before="1" data-graph-height="250"
							data-graph-type="column">

							<thead>
								<tr>
									<th>类别</th>
									<th>部门人数</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${reportInfo.getSateList() }"
									var="sate">
									<tr>
										<td>${sate.data_content }</td>
										<td>${sate.total }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading" style="padding: 3px; height: 100%;">
						<span class="glyphicon glyphicon-refresh"></span>部门成员数量
					</div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>部门名称</th>
								<th>人数</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reportInfo.getSateList()}"
								var="sate">
								<tr>
									<td>${sate.data_content }</td>
									<td>${sate.total }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


</body>
</html>