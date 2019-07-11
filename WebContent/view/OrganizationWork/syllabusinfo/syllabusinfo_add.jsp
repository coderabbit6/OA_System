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
<title>管理</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>

<script  type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>
        <script type="text/javascript">
        	$(document).ready(function() {
        		//身份证验证
        		$("#p1").focus(function() {
        			$("#p1").css("background-color", "#FFFFCC");
        		});
        		$("#p1").blur(function() {
        			var regid =  /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        			var id = $("#p1").val();
        			$("#p1").css("background-color", "white");
        			if (id.length <= 0 || !regid.test(id)) {
            			 alert('请填写正确身份证号!!身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X ');		  
         		  		document.getElementById("p1").value="";	
        			} 
        		});
        		$("#p2").focus(function() {
        			$("#p2").css("background-color", "#FFFFCC");
        		});
        		$("#p2").blur(function() {
        			var regbphone = /^\d{4}-\d{7,8}$/;
        			var bp = $("#p2").val();
        			$("#p2").css("background-color", "white");
        			if (bp.length <= 0 || !regbphone.test(bp)) {
            			 alert('请填写正确办公电话号码!!例：XXXX-XXXXXXX');		  
         		  		document.getElementById("p2").value="";	
        			} 
        		});
        		$("#p3").focus(function() {
        			$("#p3").css("background-color", "#FFFFCC");
        		});
        		$("#p3").blur(function() {
        			var regemail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        			var email = $("#p3").val();
        			$("#p3").css("background-color", "white");
        			if (email.length <= 0 || !regemail.test(email)) {
            			 alert('请填写正确电子邮件!!');		  
         		  		document.getElementById("p3").value="";	
        			} 
        		});
        		
        		$("#p4").focus(function() {
        			$("#p4").css("background-color", "#FFFFCC");
        		});
        		$("#p4").blur(function() {
        			var regphone = /^[1-9]{1}[0-9]{10}$/;
        			var p = $("#p4").val();
        			$("#p4").css("background-color", "white");
        			if (p.length <= 0 || !regphone.test(p)) {
            			 alert('请填写正确移动电话号码!!11位');		  
         		  		document.getElementById("p4").value="";	
        			} 
        		});
        		
        		$("#p5").focus(function() {
        			$("#p5").css("background-color", "#FFFFCC");
        		});
        		$("#p5").blur(function() {
        			var regqq = /^[1-9]\d{4,9}$/;
        			var qq = $("#p5").val();
        			$("#p5").css("background-color", "white");
        			if (qq.length <= 0 || !regqq.test(qq)) {
            			alert('请填写正确qq号码!!5-10位');		  
         		  		document.getElementById("p5").value="";	
        			} 
        		});
        	});
        </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>日程管理</a></li>
        <li>日程安排</li>
        <li>添加日程</li>
    </ul>
</div>

<form action="syllabusinfo/add.do" method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" readonly="readonly" name="syllabusId" class="form-control input-sm" placeholder="自动生成"/>
                </div>
            </div>
        
        </div>
        
         <div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">出生日期</label>
                <div class="col-sm-5">
                	<input   type="text" name="syllabusdate" onClick="WdatePicker()"  class="form-control input-sm" placeholder="请输入出生日期"/>
                </div>
            </div>
        
        </div>
        
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">员工名称</label>
                <div class="col-sm-9">
                	<input type="text" name="syllabusName" class="form-control input-sm" placeholder="请输入员工名称"/>
                </div>
            </div>
        </div>

    </div>
    
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">8:30~10:00</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusYi" class="form-control input-sm" placeholder="上午"/>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">10:00~11:30</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusEr" class="form-control input-sm" placeholder="上午"/>
                </div>
            </div>
        </div>
    </div>
        <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">1.00~2.30</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusSan" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>       
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">2.30~4.00</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusSi" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">4:00~5:30</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusWu" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>    
    <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">5:30~7:00</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusLiu" class="form-control input-sm" placeholder="下午"/>
                </div>
            </div>
        </div>
    </div>    
     <div class="row">
    	<div class="col-sm-8">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">7:00~#</label>
                <div class="col-sm-9">
               			<input type="text" name="syllabusQi" class="form-control input-sm" placeholder="下午"/>
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