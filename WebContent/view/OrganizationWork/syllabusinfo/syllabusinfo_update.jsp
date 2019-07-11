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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    	<li><a >日程管理</a></li>
        <li>日程安排</li>
        <li>修改日程</li>
    </ul>
</div>

<form action="syllabusinfo/update.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" readonly="readonly"  name="syllabusId" value="${syllabus.syllabusId }" class="form-control input-sm" placeholder="请输入编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">员工名称</label>
                <div class="col-sm-9">
                	<input type="text" name="syllabusName" value="${syllabus.syllabusName }" class="form-control input-sm" placeholder="请输入员工名称"/>
                </div>
            </div>
        </div>

    </div>
<%-- <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">工作日期</label>
                <div class="col-sm-9">
               			<input type="text" readonly="readonly" name="syllabusDate" value="<fmt:formatDate value='${syllabus.syllabusDate }'  pattern='yyyy-MM-dd ' />"  class="form-control input-sm" placeholder="上午"/>
                </div>
            </div>
        </div>
    </div> --%>
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">8:30~10:00</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusYi" value="${syllabus.syllabusYi }"  class="form-control input-sm" placeholder="上午"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">10:00~11:30</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusEr }" name="syllabusEr" class="form-control input-sm" placeholder="上午"/>
                </div>
            </div>
        </div>
    </div>
        <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">1.00~2.30</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusSan }" name="syllabusSan" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>       
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">2.30~4.00</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusSi }" name="syllabusSi" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">4:00~5:30</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusWu }" name="syllabusWu" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>    
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">5:30~7:00</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusLiu }" name="syllabusLiu" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>    
     <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">7:00~#</label>
                <div class="col-sm-9">
               			<input type="text" value="${syllabus.syllabusQi }" name="syllabusQi" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>    
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>

              <a class="btn btn-warning" href="syllabusinfo/list.do">返回上一级</a>
        </div>
    </div>
</form>
</body>
</html>