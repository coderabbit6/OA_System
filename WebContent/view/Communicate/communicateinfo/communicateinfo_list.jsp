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
<title>通讯录</title>
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
    	<li><a>通讯录</a></li>
        <li>个人通讯录</li>
    </ul>
</div>
<form action="communicateinfo/list1.do"  method="post" class="form-inline">
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >

     <div class="form-group">
         <label class="" for="staffName">姓名：</label>
        <input type="text" class="form-control" name="staffName" id="staffName" placeholder="请输入联系人姓名">
      </div>

    <input type="submit"   class="btn btn-danger"     value="查询"/>
    <a  class="btn btn-success"  href="communicateinfo/loadadd.do">添加联系人</a>
    
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
	<display:table class="table-bordered table-hover table  table-condensed table-striped" name="list"  pagesize="10" requestURI="communicateinfo/list.do">
		<display:column property="addressId" title="编号" />
		<display:column  property="staffName" title="姓名"/>
		<display:column  property="staffPhone" title="电话"/>
		<display:column href="communicateinfo/loadupdate.do" paramId="addressId" paramProperty="addressId" value="修改"  title="修改"/>
		<display:column href="communicateinfo/delete.do"  paramId="addressId" paramProperty="addressId"  value="删除"  title="删除"/>
	</display:table>
</div>

</form>




</body>
</html>