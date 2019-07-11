<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.bfw.po.*,com.bfw.system.dto.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>    
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<base href="<%=basePath%>">
<title>权限变更</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="resources/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
$().ready(function(){
	
	//全选
	$("input[id=all]").click(function(){
		var allchecked = this.checked;
		var arr = $(this).parent().parent().parent().find("input");
		for(var i=1;i<arr.length;i++){
			arr[i].checked = allchecked;
		}
	});
	
	// 
	$("input[id=anthortyId]").click(function(){
		var arr = $(this).parent().parent().parent().find("input");
		for(var i=1;i<arr.length;i++){
			if(arr[i].checked){
				arr[0].checked = true;
				return;
			}
		}
		
		var arr2 = $(this).parent().parent().parent().find("input[checked=true]");
		if(arr2.length == 0){
			arr[0].checked = false;
		}
	});
	
});


</script>

</head>
<body>
<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style="  margin:0px; " >
    	<li><a>系统管理</a></li>
        <li>权限变更</li>
    </ul>
<form action="anthotychange/add.do"  method="post" class="form-horizontal">

    <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
	<div class="row">
    	<div class="col-sm-5">
        	<div class="form-group">
            	<label class="col-sm-3 control-label">角色编号</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${roleinfo.roleId }</p>
                	<input type="hidden" name="roleId" value="${roleinfo.roleId }"/>
                </div>
            </div>
        
        </div>
        <div class="col-sm-5">
            <div class="form-group">
            	<label class="col-sm-3 control-label">角色名称</label>
                <div class="col-sm-9">
                	<p class="form-control-static">${roleinfo.roleName }</p>
                </div>
            </div>
        </div>

    </div>
  <h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">菜单信息</h5> 
  <table class="table">
  	<tr>
    	<th>一级菜单</th>
        <th>二三...级菜单</th>
    </tr>
  
    <% List<AnthortyDTO> dtolist = (List<AnthortyDTO>)request.getAttribute("dtolist"); 
    
    if(dtolist!=null && dtolist.size()>0){
    	for(AnthortyDTO dto:dtolist){
    		
    	
    %>
     <tr>
    	<td>
        	<label class="checkbox-inline">
            	<input type="checkbox" id="all" name="anthortyId" <%if(dto.getAnth().getChecked()){ out.print("checked"); } %>  value="<%=dto.getAnth().getAnthortyId() %>"><%=dto.getAnth().getAnthortyName() %>
             </label>
        </td>
    	<td>
    		<%  List<AnthortyInfo> anthlist =dto.getList();
    		
    		 if(anthlist!=null && anthlist.size()>0){
    		  for(AnthortyInfo anth:anthlist){
    			  
    		  
    		 %>
	        	 <label class="checkbox-inline">
	            	<input type="checkbox" id="anthortyId" <%if(anth.getChecked()){ out.print("checked"); } %>  name="anthortyId" value="<%=anth.getAnthortyId()%>"><%=anth.getAnthortyName() %>
	             </label>
         <%}} %>
        </td>
    </tr> 
	<%}} %>
	  
  </table>   
       	<div class="row">
    	<div class="col-sm-5 col-sm-offset-4">
          	<input type="submit" class="btn btn-success" value="权限变更"/>
            <a  href="anthotychange/list.do" class="btn btn-warning">返回上一级</a>
          
        </div>
    </div>
    
</form>        
</div>
</body>
</html>