<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>DASHGUM - FREE Bootstrap Admin Template</title>

<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="../../font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="../../css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="../../js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="../../lineicons/style.css">

<!-- Custom styles for this template -->
<link href="../../css/style.css" rel="stylesheet">
<link href="../../css/style-responsive.css" rel="stylesheet">

</head>
<body>

	<div id="login-page">
		<div class="container">
			<!-- Modal -->
			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				id="myModal1" class="modal fade">
				<form class="form-login" action="auth.html">
					<div class="modal-header">
						<h2 class="form-login-heading">sign in now</h2>
					</div>
					<div class="login-wrap">
						<input type="text" class="form-control" placeholder="User ID"
							autofocus> <br> <input type="password"
							class="form-control" placeholder="Password"> <label
							class="checkbox"> <span class="pull-right"> <a
								data-toggle="modal" href="../index.html#myModal2"> Forgot
									Password?</a>
						</span>
						</label>
						<button class="btn btn-theme btn-block" href="../index.html"
							type="submit">
							<i class="fa fa-lock"></i> SIGN IN
						</button>
						<hr>
						<div class="login-social-link centered">
							<p>or you can sign in via your social network</p>
							<button class="btn btn-facebook" type="submit">
								<i class="fa fa-facebook"></i> Facebook
							</button>
						</div>
						<div class="registration">
							Don't have an account yet?<br /> <a class="" href="#">
								Create an account </a>
						</div>
					</div>
				</form>
			</div>

			<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				tabindex="-1" id="myModal2" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Forgot Password ?</h4>
						</div>
						<div class="modal-body">
							<p>Enter your e-mail address below to reset your password.</p>
							<input type="text" name="email" placeholder="Email"
								autocomplete="off" class="form-control placeholder-no-fix">
						</div>
						<div class="modal-footer">
							<button data-dismiss="modal" class="btn btn-default"
								type="button">Cancel</button>
							<button class="btn btn-theme" type="button">Submit</button>
						</div>
					</div>
				</div>
			</div>
			<!-- modal -->

		</div>
	</div>

	<section id="container" class="sidebar-closed">
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<a href="index.html" class="logo"> <img id="wecando_white"
				src="../../img/wecando_white.png">
			</a>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" data-toggle="modal"
						href="../../index.html#myModal1">Logout</a></li>
				</ul>
			</div>
		</header>
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<ul class="sidebar-menu" id="nav-accordion">
					<li class="sub-menu"><a href="../../javascript:;"> <i
							class="fa fa-calendar"></i> <span>예약 정보</span>
					</a>
						<ul class="sub">
							<li><a href="../general.html">General</a></li>
							<li><a href="../buttons.html">Buttons</a></li>
							<li><a href="../panels.html">Panels</a></li>
						</ul></li>

					<li class="sub-menu"><a href="../../javascript:;"> <i
							class="fa fa-user"></i> <span>마이 페이지</span>
					</a>
						<ul class="sub">
							<li><a href="../calendar.html">Calendar</a></li>
							<li><a href="../gallery.html">Gallery</a></li>
							<li><a href="../todo_list.html">Todo List</a></li>
						</ul></li>
				</ul>
			</div>
		</aside>
		<section id="main-content">
			<section class="wrapper">
				<div id="auth">
					<img id="joinus" src="../../img/joinus.png">
					<div class="row mtbox">
						<form action='http://localhost:8080/wecando/member/ajax/join.do'
							method="post" id='select_person'>
							<input type='hidden' name='m_email'
								value=<%=request.getParameter("m_email")%>> <input
								type='hidden' name='email_code'
								value=<%=request.getParameter("email_code")%>>
							<div class="col-md-4 col-md-offset-1 box0">
								<div class="box1">
									<span 	class="li_user"></span> 
									<a href="#" onclick='submit_person()'></a>
									<h3>개인 회원</h3>
								</div>
								<p>학교 시설을 예약하고 사용하실 수 있습니다.</p>
							</div>
						</form>
						<form action='http://localhost:8080/wecando/member/ajax/join.do'
							method="post" id='select_school'>
							<input type='hidden' name='m_email'
								value=<%=request.getParameter("m_email")%>> <input
								type='hidden' name='email_code'
								value=<%=request.getParameter("email_code")%>>
							<div class="col-md-4 box0">
								<div class="box1">
									 <span class="li_shop"></span>
									 <a href="#" onclick='submit_school()'></a>
									<h3>학교 관리자</h3>
								</div>
								<p>학교 시설을 등록하고 대관할 수 있습니다.</p>
							</div>
						</form>
					</div>
				</div>
			</section>
		</section>
	</section>
	<script src="../../js/jquery.js"></script>
	<script src="../../js/jquery-1.8.3.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="../../js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="../../js/jquery.scrollTo.min.js"></script>
	<script src="../../js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="../../js/jquery.sparkline.js"></script>
	<script src="../../js/common-scripts.js"></script>

	<script>
		function submit_person() {
			var pf = $('#select_person');
			
      var pi = document.createElement("input");
      pi.setAttribute("type", "hidden");
      pi.setAttribute("name", "m_grade");
      pi.setAttribute("value", 1);
      pf.append(pi);
      
			document.getElementById('select_person').submit();
		}
		function submit_school() {
			var pf = $('#select_school');
		      
      var pi = document.createElement("input");
      pi.setAttribute("type", "hidden");
      pi.setAttribute("name", "m_grade");
      pi.setAttribute("value", 2);
      pf.append(pi);
			document.getElementById('select_school').submit();
		}
	</script>
</body>
</html>






