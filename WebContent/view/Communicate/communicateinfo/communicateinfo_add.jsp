<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="http://beifengwang.com" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script  type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>通讯录</a></li>
        <li>个人通讯录</li>
        <li>添加通讯录</li>
    </ul>
</div>

<form action="communicateinfo/add.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-7">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="addressId" readonly="readonly" class="form-control" placeholder="自动生成"/>
                </div>
            </div>
    </div>
    <div class="row">
    	<div class="col-sm-7">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                	<input type="text" name="staffName" class="form-control">
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-7">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">电话</label>
                <div class="col-sm-9">
                	<input type="text" name="staffPhone" class="form-control">
                </div>
            </div>
        </div>
    </div>
 </div>
  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">操作</h5>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保 存"/>

              <a class="btn btn-warning" href="communicateinfo/list.do">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>