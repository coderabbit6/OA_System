<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.bfw.po.AnthortyInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="resources/css/dtree.css">
<script src="resources/js/dtree.js"></script>
</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>系统管理</a></li>
        <li>权限管理</li>
    </ul>
</div>

<div class="row">

	<div class="col-sm-2"  style=" padding-left:30px;">
    	<script type="text/jscript">
		
        	 d = new dTree('d');
        	 
        	 <%List<AnthortyInfo> list =  (List<AnthortyInfo>)request.getAttribute("list");
        	 if(list!=null && list.size()>0){
        	 for(AnthortyInfo anth :list){

        	 %>
        	
			d.add(<%=anth.getAnthortyId()%>,<%=anth.getAnthortyPid()%>,'<%=anth.getAnthortyName()%>','anthorty/show.do?anthortyId=<%=anth.getAnthortyId()%>','','mainiframe');
			<%}}%>
           /*  d.add(1,0,'系统管理','','提示','');
			d.add(2,1,'员工管理','anthorty_show.html','提示','mainiframe');
			d.add(3,1,'角色管理','view/system/anthorty/anthorty_add.jsp','提示','mainiframe');
			d.add(4,1,'角色变更','anthorty_add.html','提示','mainiframe');
			d.add(5,0,'招生管理','','提示','mainiframe');
			d.add(6,5,'学生线索','anthorty_add.html','提示','mainiframe'); */
			document.write(d);
        </script>
    </div>
    <div class="col-sm-10">
    	<iframe id="mainframe" name="mainiframe"  style="width:100%; border:0px; " ></iframe>
        <script type="text/javascript">
        	var height = jQuery(window).height()-50;
			jQuery("#mainframe").attr("height",height+"px");
        	jQuery("#mainframe").attr("src","view/system/anthorty/anthorty_show.jsp");
        </script>
        
    </div>

</div>


</body>
</html>