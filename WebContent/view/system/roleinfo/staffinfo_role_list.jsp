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
        <li>角色变更</li>
    </ul>
</div>
<div class="row alert alert-info"  style="margin:0px; padding:3px;" >
<form action="roleinfo/staffinforolelist.do" method="post" class="form-horizontal">
	<div class="col-sm-1" >条件:</div>
    <div class="col-sm-3">
    	<select onchange="query(this)" name="condititon" class="form-control  input-sm">
    		<option value="">请选择</option>
        	<option value="staffId">编号</option>
            <option value="staffName">姓名</option>
            <option value="staffMobilePhone">移动电话</option>
        </select>
    </div>
    <div class="col-sm-3">
    	<input type="text"  id="keyword" class="form-control input-sm"/>
    </div>
    <input type="submit"   class="btn btn-danger"   value="查询"/>
    
    </form>
</div>
<div align="center">
	<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
		<button type="button" class="close" data-dismiss="alert">
			<span aria-hidden="true">&times;</span>
			
		</button>
		<p align="center" style="color: red;">角色信息-${info }</p>
	</div>	
</div>
	
<div class="row" style="padding:15px; padding-top:0px; " align="right">
	<display:table class="table table-bordered table-hover table-condensed table-striped" name="list"  pagesize="10" requestURI="roleinfo/staffinforolelist.do">
		<display:column property="staffId" title="编号"/>
		<display:column property="staffName" title="姓名"/>
		<display:column property="staffSex" title="性别"/>
		<display:column property="staffAge" title="年龄"/>
		<display:column property="staffMobilePhone" title="移动电话"/>
		<display:column property="staffEamil" title="电子邮箱"/>
		<display:column property="staffEntryTime" format="{0,date,yyyy年MM月dd日}"    title="入职时间"/>
		<display:column property="staffEductionLevel" title="教育水平"/>
		<display:column property="roleName" title="角色"/>
		<display:column href="roleinfo/laodchange.do" paramId="staffId" paramProperty="staffId" value="角色变更"  title="角色变更"/>
	</display:table>
</div>
</body>
</html>