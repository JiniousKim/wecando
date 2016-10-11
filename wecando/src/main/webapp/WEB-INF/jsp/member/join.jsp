<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">

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
<link rel="shortcut icon" type="image/x-icon" href="../../img/logo.png" />
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
					
					<div class="nick">
            <div class="modal fade" id='nick' tabindex="-1"
              role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                      aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">닉네임 중복확인</h4>
                  </div>
                  <div class="modal-body">
                    <div class="form-group3 has-feedback">
                    <input type="text" class="form-control col-sm-3 inputbox"
                      onchange='check(this.id);' id="m_n">
                    <button type="button" class="btn btn-default"
                      onclick="nick_search();">중복 검사</button>
                  <div class="control-label" id="m_nMsg"
                      style='display:none;'>기호는 들어갈 수 없습니다.</div>
                  </div>
                  </div>
                  <button id='modal_close' type="button" style='display:none;' class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                              </button>
                </div>
              </div>
            </div>
          </div>
          <!-- 닉네임 중복확인 modal -->
					
					<div class="row mt">
						<div class="col-lg-12">
							<div class="form-panel-email">
								<h1 class="email">
									<i class="fa fa-angle-right"></i> 회원가입
								</h1>
								<div class="form-group3 join">
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
								<div id='passwordForm' class="form-group3 has-feedback">
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
								<div id='password2Form' class="form-group3 has-feedback">
									<label class="col-sm-2 col-sm-2 control-label"> 비밀번호 확인</label>
									<div class="col-sm-10">
										<input type="password" id="password2"
											onchange="check(this.id);" class="form-control"
											placeholder="">
										<div class="control-label" id="password2Msg"
											style="display: none;">필수 정보입니다.</div>
									</div>
								</div>
								<div id='m_nameForm' class="form-group3 has-feedback">
									<label class="col-sm-2 col-sm-2 control-label"> 이름</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" id="m_name"
										 onchange="check(this.id);">
									</div>
								</div>
								<div id='nickForm' class="form-group3 has-feedback">
									<label class="col-sm-2 col-sm-2 control-label"> 닉네임</label>
									<div class="col-sm-10">
										<input type="text" class="form-control col-sm-3" id="m_nick" readonly>
									  <button type="button" class="btn btn-default col-sm-2" 
                          style="margin: 0 0 0 10px;" data-toggle="modal" data-target="#nick">중복확인</button>
									</div>
								</div>
								<div id="m_telForm" class="form-group3 has-feedback">
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
	 $(document).ready(function(e) {
		 $.ajax({
       url : contextRoot + '/auth/ajax/logout.do',
       type : 'post',
       dataType : 'json',
       cache : false,
       success : function(resultObj) {}
     })
	 })
	 
   $('#nick').on('hide.bs.modal', function (e) {
       $('#m_n').html('');
       $('#m_n').val('');
   });
    
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
      
      if ($('#password').val() == ""
          || $('#passwordForm').attr('class') == 'form-group3 has-feedback has-error') {
        sweetAlert("Oops...", "비밀번호를 확인해 주세요!", "error");
        return false;
      } else if ($('#password2').val() == "" ||
          $('#password2Form').attr('class') == 'form-group3 has-feedback has-error') {
        sweetAlert("Oops...", "비밀번호를 확인해 주세요!", "error");
        return false;
      } else if ($('#m_name').val() == "" ||
           $('#m_nameForm').attr('class') == 'form-group3 has-feedback has-error') {
        sweetAlert("Oops...", "이름을 확인해 주세요!", "error");
        return false;
      } else if ($('#m_nick').val() == "" || 
    		     $('m_nickForm').attr('class') == 'form-group3 has-feedback has-error') {
        sweetAlert("Oops...", "닉네임을 확인해 주세요!", "error");
        return false;
      } else if ($('#m_tel').val() == "" ||
          $('#m_telForm').attr('class') == 'form-group3 has-feedback has-error') {
        sweetAlert("Oops...", "전화번호를 확인해 주세요!", "error");
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
              } else {
                sweetAlert("Oops...","다시 시도해 주세요","error");
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
    
    function nick_search() {
      var form_data = new FormData();
      form_data.append("m_n", $('#m_n').val());
      if ($('#m_n').val() == "") {
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
            data : form_data,
            success : function(resultObj) {
              var ajaxResult = resultObj.ajaxResult;
              if (ajaxResult.status == 'success') {
                  swal({
                    title: "잠깐!",   
                      text: "해당 닉네임으로 설정하시겠습니까?",   
                      type: "warning",   
                      showCancelButton: true,   
                      confirmButtonColor: "#7AC943",   
                      confirmButtonText: "네, 등록할래요!",   
                      cancelButtonText: "앗, 아니오!",   
                      closeOnConfirm: false,   
                      closeOnCancel: false 
                      }, 
                      function(isConfirm){   
                        if (isConfirm) {     
                          swal("등록성공!", "닉네임이 등록되었습니다.", "success");   
                      document.getElementById('m_nick').value = $('#m_n').val();
                      $('#modal_close').trigger('click');
                        } else {     
                          swal("등록취소", "다시 닉네임을 설정해주세요.", "error");   
                      }
                  })
              } else {
                  document.getElementById('m_nick').value = '';
                sweetAlert("Oops...","중복된 닉네임입니다!","error");
              }
            }
          })
        }
    }
  </script>
</body>
</html>
