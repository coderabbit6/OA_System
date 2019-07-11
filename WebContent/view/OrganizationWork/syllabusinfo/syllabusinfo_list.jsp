<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://beifengwang.com" %>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>日程管理</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>日程管理</a></li>
        <li>日程安排</li>
    </ul>
</div>
<form action="syllabusinfo/list.do" method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

    <div class="form-group">
         <label class="" for="syllabusName">员工名称：</label>
        <input type="text" name="syllabusName" class="form-control" id="syllabusName" placeholder="请输入员工名称">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
   <!--  <a  class="btn btn-success"  href="view/classinfo/syllabusinfo/syllabusinfo_add.jsp">添加日程</a> -->
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">${info }</p>
	</div>	
</div>
<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<display:table class="table table-bordered table-hover table-condensed table-striped" name="list"  pagesize="10" requestURI="syllabusinfo/list.do">

		<display:column property="syllabusDate" format="{0,date,yyyy年MM月dd日}" title="日期" />
		<display:column property="isUesd" title="员工编号"/>
		<display:column  property="syllabusName" title="员工名称"/>
		<display:column  property="syllabusYi" title="8:30~10:00"/>
		<display:column property="syllabusEr" title="10:00~11:30"/>
		<display:column  property="syllabusSan" title="1.00~2.30"/>
		<display:column property="syllabusSi" title="2.30~4.00"/>
		<display:column  property="syllabusWu" title="4:00~5:30"/>
		<display:column property="syllabusLiu" title="5:30~7:00"/>
		<display:column property="syllabusQi" title="7:00~#"/>	
		<display:column href="syllabusinfo/load.do" paramId="syllabusId" paramProperty="syllabusId" value="修改"  title="修改"/>
		<display:column href="syllabusinfo/delete.do"  paramId="syllabusId" paramProperty="syllabusId"  value="删除"  title="删除"/>
	</display:table>
</div>

</form>
</body>
</html>