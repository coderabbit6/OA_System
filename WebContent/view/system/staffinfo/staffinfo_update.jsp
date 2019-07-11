<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.bfw.po.DataDictionary"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
<script  type="text/javascript" src="resources/My97DatePicker/WdatePicker.js"></script>
	      <script type="text/javascript">
        	$(document).ready(function() {
        		//身份证验证
        		$("#p11").focus(function() {
        			$("#p11").css("background-color", "#FFFFCC");
        		});
        		$("#p11").blur(function() {
        			var regid =  /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        			var id = $("#p11").val();
        			$("#p11").css("background-color", "white");
        			if (id.length <= 0 || !regid.test(id)) {
            			 alert('请填写正确身份证号!!身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X ');		  
         		  		document.getElementById("p11").value="";	
        			} 
        		});
        		$("#p12").focus(function() {
        			$("#p12").css("background-color", "#FFFFCC");
        		});
        		$("#p12").blur(function() {
        			var regbphone = /^\d{4}-\d{7,8}$/;
        			var bp = $("#p12").val();
        			$("#p12").css("background-color", "white");
        			if (bp.length <= 0 || !regbphone.test(bp)) {
            			 alert('请填写正确办公电话号码!!例：XXXX-XXXXXXX');		  
         		  		document.getElementById("p12").value="";	
        			} 
        		});
        		$("#p13").focus(function() {
        			$("#p13").css("background-color", "#FFFFCC");
        		});
        		$("#p13").blur(function() {
        			var regemail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        			var email = $("#p13").val();
        			$("#p13").css("background-color", "white");
        			if (email.length <= 0 || !regemail.test(email)) {
            			 alert('请填写正确电子邮件!!');		  
         		  		document.getElementById("p13").value="";	
        			} 
        		});
        		
        		$("#p14").focus(function() {
        			$("#p14").css("background-color", "#FFFFCC");
        		});
        		$("#p14").blur(function() {
        			var regphone = /^[1-9]{1}[0-9]{10}$/;
        			var p = $("#p14").val();
        			$("#p14").css("background-color", "white");
        			if (p.length <= 0 || !regphone.test(p)) {
            			 alert('请填写正确移动电话号码!!11位');		  
         		  		document.getElementById("p14").value="";	
        			} 
        		});
        		
        		$("#p15").focus(function() {
        			$("#p15").css("background-color", "#FFFFCC");
        		});
        		$("#p15").blur(function() {
        			var regqq = /^[1-9]\d{4,9}$/;
        			var qq = $("#p15").val();
        			$("#p15").css("background-color", "white");
        			if (qq.length <= 0 || !regqq.test(qq)) {
            			alert('请填写正确qq号码!!5-10位');		  
         		  		document.getElementById("p15").value="";	
        			} 
        		});
        	});
        </script>
</head>
<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>系统管理</a></li>
        <li>员工管理</li>
        <li>修改员工信息</li>
    </ul>
</div>

<form action="system/update.do" method="post" class="form-horizontal">
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">编号</label>
                <div class="col-sm-9">
                	<input type="text" name="staffId" value="${staffInfo.staffId }" readonly="readonly" class="form-control input-sm" placeholder="自动产生编号"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">姓名</label>
                <div class="col-sm-9">
                	<input type="text" name="staffName" value="${staffInfo.staffName }" class="form-control input-sm" placeholder="请输入姓名"/>
                </div>
            </div>
        </div>

    </div>
    <!-- 开始2 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">年龄</label>
                <div class="col-sm-5">
                	<input type="text" name="staffAge" value="${staffInfo.staffAge }" oninput="if(value>100)value=100;if(value.length>2)value=value.slice(0,3);if(value<0)value=0" class="form-control input-sm" placeholder="请输入年龄"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">性别</label>
                <div class="col-sm-4">
                		<select name="staffSex" class="form-control input-sm" >
                        	<option>保密</option>
                            <option  ${staffInfo.staffSex=='男'?'selected':'' }>男</option>
                            <option ${staffInfo.staffSex=='女'?'selected':'' }>女</option>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束2 -->
    <!-- 开始3 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">籍贯</label>
                <div class="col-sm-6">
                	<input type="text" name="staffNativePlace" value="${staffInfo.staffNativePlace }" class="form-control input-sm" placeholder="请输入籍贯"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">身份证</label>
                <div class="col-sm-9">
                <input type="text" name="staffIdcard" id="p11" value="${staffInfo.staffIdcard }" class="form-control input-sm" placeholder="请输入身份证号码"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束3 -->
        <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">出生日期</label>
                <div class="col-sm-5">
                	<input   type="text" name="staffBrithday" value="<fmt:formatDate value="${staffInfo.staffBrithday }" type="both"  pattern="yyyy-MM-dd" />"  onClick="WdatePicker()" class="form-control input-sm" placeholder="请输入出生日期"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">办公电话</label>
                <div class="col-sm-9">
                <input type="text" name="staffOfficePhone" id="p12" value="${staffInfo.staffOfficePhone }" class="form-control input-sm" placeholder="请输入办公电话"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->
    <!-- 开始4 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">电子邮件</label>
                <div class="col-sm-9">
                	<input type="text" name="staffEamil" id="p13" value="${staffInfo.staffEamil }"  class="form-control input-sm" placeholder="请输入电子邮件"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">移动电话</label>
                <div class="col-sm-9">
                <input type="text" name="staffMobilePhone" id="p14" value="${staffInfo.staffMobilePhone }"  class="form-control input-sm" placeholder="请输入移动电话"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束4 -->    
    <!-- 开始5 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">家庭住址</label>
                <div class="col-sm-9">
                	<input type="text" name="staffAddr"  value="${staffInfo.staffAddr }"  class="form-control input-sm" placeholder="请输入家庭住址 "/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">QQ</label>
                <div class="col-sm-9">
                <input type="text" name="staffQq" value="${staffInfo.staffQq }" id="p15" class="form-control input-sm" placeholder="请输入QQ"/>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束5 -->    
    <!-- 开始6 -->
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">入职时间</label>
                <div class="col-sm-5">
                	<input type="text" name="staffEntryTime" value="<fmt:formatDate value="${staffInfo.staffEntryTime }" type="both"  pattern="yyyy-MM-dd" />"  onClick="WdatePicker()"   class="form-control input-sm" placeholder="请输入入职时间 "/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">教育水平</label>
                <div class="col-sm-6">
                		<select name="staffEductionLevel"  class="form-control input-sm" >
                        	<option>保密</option>
                            <option ${staffInfo.staffEductionLevel=='博士'?'selected':'' }>博士</option>
                            <option ${staffInfo.staffEductionLevel=='硕士'?'selected':'' }>硕士</option>
                            <option ${staffInfo.staffEductionLevel=='本科'?'selected':'' }>本科</option>
                        </select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束6 -->
    <!-- 开始7 -->
	<div class="row">

        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">员工类型</label>
                <div class="col-sm-6">
<%--                 		<select name="staffState"  class="form-control input-sm" >
                            <option value="1" ${staffInfo.staffState=='1'?'selected':'' }>事业部</option>
                            <option value="2" ${staffInfo.staffState=='2'?'selected':'' }>技术部</option>
                            <option value="3" ${staffInfo.staffState=='3'?'selected':'' }>后勤部</option>
                            <option value="4" ${staffInfo.staffState=='4'?'selected':'' }>销售部</option>              
                        </select> --%>
                        
                      <select  name="staffState" class="form-control input-sm"> <!-- 定义select下拉框标签 -->
							<%
							List<DataDictionary> data = (List<DataDictionary>)session.getAttribute("position");
							
							for(DataDictionary i:data){%> 
							<!-- 以for循环依次取出后台传值 -->
							<option value="<%=i.getDataId()%>"><%=i.getDataContent()%></option> 
							<!-- 将list取值设为option标签的实际值 -->
							<%}%>
					</select>
                </div>
            </div>
        </div>
    </div>
    <!-- 结束7 -->   
    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">备注信息</h5>
    	<div class="row">
    	<div class="col-sm-10">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">备注</label>
                <div class="col-sm-9">
                	<textarea name="staffRemark" class="form-control">${staffInfo.staffRemark } </textarea>
                </div>
            </div>
        
        </div>

    </div>
        <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">账号信息</h5>
    	<div class="row">
        	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">账号</label>
                <div class="col-sm-9">
                	<input type="text" name="userNumber" value="${staffInfo.userNumber }" class="form-control input-sm" placeholder="请输入账号 "/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">密码</label>
                <div class="col-sm-9">
                <input type="password" name="userPassowrd" value="${staffInfo.userPassowrd }" class="form-control input-sm" placeholder="请输入密码"/>
                </div>
            </div>
        </div>
    </div>
   	<div class="row">
    	<div class="col-sm-3 col-sm-offset-4">
        	<input  type="submit" class="btn btn-success" value="保存"/>
           <a href="system/list.do" class="btn btn-warning">返回</a>
        </div>
    </div>
</form>
</body>
</html>