<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>员工管理</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
	
	function  query(condititon){
		$("#keyword").attr("name",condititon.value);
	}
	

</script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a >系统管理</a></li>
        <li>员工管理</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form action="system/list.do" method="post" class="form-horizontal">
	<div class="col-sm-1" >条件:</div>
    <div class="col-sm-3">
    	<select onchange="query(this)" name="condititon" class="form-control  input-sm">
    		<option value="">请选择</option>
        	<option value="staffId">编号</option>
            <option value="staffName">姓名</option>
            <option value="staffMobilePhone">移动电话</option>
            <option value="dataName">部门</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  id="keyword" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    <a href="datadictionary/list1.do" class="btn btn-warning">添加</a>
    </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">员工信息-${info }</p>
	</div>	
</div>
	
<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<display:table class="table  table-condensed table-striped table-bordered table-hover" name="list"  pagesize="10" requestURI="system/list.do">
		<display:column property="staffId" title="编号"/>
		<display:column href="system/show.do"  paramId="staffId" paramProperty="staffId" property="staffName" title="姓名"/>
		<display:column property='dataName' title="部门"/>
		<display:column property="staffSex" title="性别"/>
		<display:column property="staffAge" title="年龄"/>
		<display:column property="staffMobilePhone" title="移动电话"/>
		<display:column property="staffEamil" title="电子邮箱"/>
		<display:column property="staffEntryTime" format="{0,date,yyyy年MM月dd日}"    title="入职时间"/>
		<display:column property="staffEductionLevel" title="教育水平"/>
		<display:column href="system/load.do" paramId="staffId" paramProperty="staffId" value="修改"  title="修改"/>
		<display:column href="system/delete.do"  paramId="staffId" paramProperty="staffId" value="删除"  title="删除"/>
	</display:table>
</div>
</body>
</html>