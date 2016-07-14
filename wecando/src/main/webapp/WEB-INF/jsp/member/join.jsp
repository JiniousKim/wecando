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

<title>Wecando</title>

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
<script src="../../js/dj_check.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css"
	href="../../lib/sweetalert/sweetalert.css">
</head>
<body>
	<section id="container" class="sidebar-closed">
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<a href="../../wecando.html" class="logo"> <img
				id="wecando_white" src="../../img/wecando_white.png">
			</a>
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
							<li><a href="../../info/memberInfo.html">내 정보</a></li>
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
					<!-- INLINE FORM ELELEMNTS -->

					<div class="row mt">
						<div class="col-lg-12">
							<div class="form-panel-email">
								<h1 class="email">
									<i class="fa fa-angle-right"></i> 회원가입
								</h1>
								<div class="form-group join">
									<label class="col-lg-2 col-sm-2 control-label"> 이메일</label>
									<div class="col-lg-10">
										<p class="form-control-static" style="color: #777;">
											<%=request.getParameter("m_email")%></p>
									</div>
								</div>
								<input type='hidden' id="m_email"
									value=<%=request.getParameter("m_email")%>> <input
									type='hidden' id='m_grade'
									value=<%=request.getParameter("m_grade")%>> <input
									type='hidden' id='email_ava' value="1"> <input
									type='hidden' id="email_code"
									value=<%=request.getParameter("email_code")%>>
								<div id='passwordForm' class="form-group has-feedback">
									<label class="col-sm-2 col-sm-2 control-label"> 비밀번호</label>
									<div class="col-sm-10">
										<input type="password" id='password'
											onchange="check(this.id);" class="form-control"
											placeholder="">
										<div class="control-label" id="passwordMsg"
											style="display: none;">숫자, 영문 대/소문자, 특수문자 각 한자이상 필수
											최대8~20자입니다.</div>
									</div>
								</div>
								<div id='password2Form' class="form-group">
									<label class="col-sm-2 col-sm-2 control-label"> 비밀번호 확인</label>
									<div class="col-sm-10">
										<input type="password" id="password2"
											onchange="check(this.id);" class="form-control"
											placeholder="">
										<div class="control-label" id="password2Msg"
											style="display: none;">필수 정보입니다.</div>
									</div>
								</div>
								<div id='nameForm' class="form-group">
									<label class="col-sm-2 col-sm-2 control-label"> 이름</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="m_name">
									</div>
								</div>
								<div id='nickForm' class="form-group">
									<label class="col-sm-2 col-sm-2 control-label"> 닉네임</label>
									<div class="col-sm-10">
										<input type="text" class="form-control col-sm-3" id="m_nick">
										<button value='0' type="button" id='checknick'
											class="btn btn-default col-sm-2" onclick='check_nick();'>중복확인</button>
									</div>
								</div>
								<div id="telForm" class="form-group">
									<label class="col-sm-2 col-sm-2 control-label"> 전화번호</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="m_tel">
									</div>
								</div>

								<input type="button" class="btn btn-theme04" value="취소"
									onclick="javascript:history.back()">
								<button type="button" class="btn btn-theme" id="create">가입하기</button>
							</div>
						</div>
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
	<script src="../../lib/sweetalert/sweetalert.min.js"></script>

	<script>
  <!-- 회원 가입 동작 -->
    $(document).on("click",'#create',function(e) {
      var form_data = new FormData();
      form_data.append("m_email", $('#m_email').val());
      form_data.append("m_grade", $('#m_grade').val());
      form_data.append("m_name", $('#m_name').val());
      form_data.append("m_tel", $('#m_tel').val());
      form_data.append("m_nick", $('#m_nick').val());
      form_data.append("email_ava", $('#email_ava').val());
      form_data.append("m_password", $('#password').val());
      form_data.append("email_code", $('#email_code').val());
      
      if ($('#password').val() == "") {
        sweetAlert("Oops...", "비밀번호를 입력해 주세요!", "error");
        return false;
      } else if ($('#password2').val() == "") {
        sweetAlert("Oops...", "비밀번호를 확인해 주세요!", "error");
        return false;
      } else if ($('#m_name').val() == "") {
        sweetAlert("Oops...", "이름을 입력해 주세요!", "error");
        return false;
      } else if ($('#m_nick').val() == "") {
        sweetAlert("Oops...", "닉네임을 입력해 주세요!", "error");
        return false;
      } else if ($('#checknick').val() == 0) {
        sweetAlert("Oops...", "중복확인을 완료해 주세요!", "error");
      }   else if ($('#m_tel').val() == "") {
        sweetAlert("Oops...", "전화번호를 입력해 주세요!", "error");
        return false;
      } else {
        if ($('#m_grade').val() == 1) {
          $.ajax({
            url : contextRoot + '/member/ajax/create.do',
            type : 'post',
            dataType : 'json',
            async : false,
            cache : false,
            contentType : false,
            processData : false,
            data : form_data,
            success : function(resultObj) {
              var ajaxResult = resultObj.ajaxResult;
              if (ajaxResult.status == 'success') {
                swal("Good job!",  "회원 가입이 완료되었습니다.","success")
                e.preventDefault();
              } else {
                sweetAlert("Oops...","다시 시도해 주세요","error");
                e.preventDefault();
              }
              setTimeout('go_url()', 5000);
            }
          })
        } else {
          $.ajax({
            url : contextRoot + '/member/ajax/create.do',
            type : 'post',
            dataType : 'json',
            async : false,
            cache : false,
            contentType : false,
            processData : false,
            data : form_data,
            success : function(resultObj) {
              var ajaxResult = resultObj.ajaxResult;
              if (ajaxResult.status == 'success') {
                swal("Good job!","회원 가입이 완료되었습니다.","success");
              } else {
                sweetAlert("Oops...","다시 시도해 주세요","error");
                e.preventDefault();
              }
              setTimeout('go_register()',5000);
            }
          })
        }
      }
    });
    
    function go_url() {
      location.replace("http://localhost:8080/wecando/wecando.html");
    };
    function go_register() {
      location.replace("http://localhost:8080/wecando/register_school.html");
    };
    
    function check_nick() {
      var nick = new FormData();
      nick.append("m_nick", $('#m_nick').val());
      if ($('#m_nick').val() == "") {
    	      $('#checknick').val(0);
          sweetAlert("Oops...", "닉네임을 입력해 주세요!", "error");
          return false;
        } else {
          $.ajax({
            url : contextRoot + '/member/ajax/check_nick.do',
            type : 'post',
            dataType : 'json',
            cache : false,
            contentType : false,
            processData : false,
            data : nick,
            success : function(resultObj) {
              var ajaxResult = resultObj.ajaxResult;
              if (ajaxResult.status == 'success') {
                $('#checknick').val(1);
                swal("Good job!",  "이용 가능한 닉네임입니다.","success")
              } else {
                $('#checknick').val(0);
                sweetAlert("Oops...","중복된 닉네임입니다!","error");
              }
            }
          })
        }
    }
  </script>
</body>
</html>
