<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<%@ taglib prefix="s" uri="http://beifengwang.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>c</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
<script  type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">

	function setText(obj){
	
		$("#emailTitle").val($(obj).find("option:selected").text());
		$("#emailContent").val(obj.value);
		if(obj.value ==''){
			$("#emailTitle").val('')
		}
	}

</script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>公告管理</a></li>
        <li>公告管理</li>
        <li>修改公告</li>
    </ul>
</div>

<form action="informActive/update.do" method="post" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">公告编号</label>
                <div class="col-sm-9">
                	<input type="text" readonly="readonly" name="activeId" value="${market.activeId }" class="form-control input-sm" />
                </div>
            </div>
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">公告名称</label>
                <div class="col-sm-9">
                	<input type="text" name="activeName" value="${market.activeName }"  class="form-control input-sm" />
                </div>
            </div>
        </div>
    </div>
  

  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">公告内容</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<!-- <label class="col-sm-5 col-sm-offset-1 ">描述信息</label> -->
                <div class="col-sm-9 col-sm-offset-2">
                	<textarea name="activeContent" rows="5" class="form-control">${market.activeContent }</textarea>
                </div>
            </div>
        </div>
    </div>
 
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
            <a class="btn btn-warning" href="informActive/list.do">返回上一级</a>
        </div>
    </div>
</form>


</body>
</html>