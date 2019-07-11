<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="resources/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="resources/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="resources/assets/css/ace.min.css" />
<link rel="stylesheet" href="resources/assets/css/ace-rtl.min.css" />

<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />

<link rel="stylesheet" href="resources/css/tabris.css">
<link rel="stylesheet" href="resources/css/lib.css">
</head>

<body>
	<div class="bg0 pa">
<!--  	<div class="bg1"></div>  -->
	</div>
<div class="hx-box pa">
	<ul class="pr">
		<li class="hx-k1 pa0">
			<span></span>
		</li>
		<li class="hx-k2 pa0">
			<span></span>
		</li>
		<li class="hx-k3 pa0">
			<span></span>
		</li>
	</ul>
</div>
		<div class="main-content center">
			<div class="row">
				<div class="col-lg-9 col-lg-offset-1">
				<br></br>
				<br></br>
				<br></br>
					<div class="login-container">
						<div class="center" >
							<h1  style="font-size:25px">
								<i class="icon-leaf green"></i> <span class="red">智慧OA系统</span>
							</h1>
							<p></p>
							<span class="white"  style="font-size:15px">自动化办公</span>
						</div>
						
						<div class="space-6"></div>
						<div class="position-relative">
						
							<div class="widget-body" style="background-color: rgba(255,255,255,0.7);border-radius: 12px;    top: 48%;">
								<div class="widget-main">
									<h4 class="header blue lighter bigger"
										style="display:${info!=null?'none':'block' } ">
										<i class="icon-coffee green"></i> 请输入您的账号和密码
									</h4>
									<h4 class="header red lighter bigger"
										style="display:${info!=null?'block':'none' } ">
										<i class="icon-coffee red"></i> ${info }
									</h4>
									<div class="space-6"></div>
									<form action="login.do" method="post" onsubmit="return check()">
										<fieldset>
											<label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <input
													id="userId" name="userNumber" type="text"
													class="form-control" placeholder="请输入账号" /> <i
													class="icon-user"></i>
											</span>
											</label> <label class="block clearfix"> <span
												class="block input-icon input-icon-right"> <input
													id="userPw" name="userPassowrd" type="password"
													class="form-control" placeholder="请输入密码" /> <i
													class="icon-lock"></i>
											</span>
											</label>

											<div class="clearfix">
												<button type="submit"
													class="width-35 pull-right btn btn-sm btn-primary">
													<i class="icon-key"></i> 登陆
												</button>
											</div>

											<div class="space-4"></div>
										</fieldset>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>	
</body>
</html>