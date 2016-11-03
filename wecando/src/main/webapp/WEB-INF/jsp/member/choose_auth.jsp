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
</head>
<body>
  <section id="container" class="sidebar-closed">
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right"
          data-original-title="Toggle Navigation"></div>
      </div>
      <a href="wecando.html" class="logo"> <img id="wecando_white"
        src="../../img/wecando_white.png">
      </a>
    </header>
    <aside>
      <div id="sidebar" class="nav-collapse">
        <ul class="sidebar-menu" id="nav-accordion">
          <li class="sub-menu"><a href="javascript:;"> <i
              class="fa fa-calendar"></i> <span>예약 정보</span>
          </a>
            <ul class="sub" id='sub_m'>
              <li><a href="../../info/ClientCurrentReserveList.html">내 예약정보</a></li>
              <li><a href="../../info/ClientLastList.html">지난 예약정보</a>
            </ul></li>

          <li class="sub-menu"><a href="javascript:;"> <i
              class="fa fa-user"></i> <span>마이 페이지</span>
          </a>
            <ul class="sub" id='sub_menu'>
              <li><a href="../../info/memberInfo.html">내 정보</a></li>
            </ul></li>
        </ul>
      </div>
    </aside>
    <section id="main-content">
      <section class="wrapper">
        <div id="auth">
          <img id="joinus" src="../../img/joinus.png">
          <div class="row mtbox">
            <input type='hidden' name='m_email' id='m_email'  
            value=<%=request.getParameter("m_email")%>> 
            <input type='hidden' name='email_code' id='email_code'
              value=<%=request.getParameter("email_code")%>>
            <div class="col-md-4 col-md-offset-1 box0">
              <div class="box1">
                <span class="li_user"></span> 
                <a href="javascript:submit_person()"></a>
                <h3>개인 회원</h3>
              </div>
              <p>학교 시설을 예약하고 사용하실 수 있습니다.</p>
            </div>
            <div class="col-md-4 box0">
              <div class="box1">
                <span class="li_shop"></span>
                <a href="javascript:submit_school()"></a>
                <h3>학교 관리자</h3>
              </div>
              <p>학교 시설을 등록하고 대관할 수 있습니다.</p>
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
  
  <script>
  $(document).ready(function(e) {
    var form_data = new FormData();
    form_data.append("m_email", $('#m_email').val());
    form_data.append("email_code", $('#email_code').val());
    $.ajax({
      url : contextRoot + '/auth/ajax/check_session.do',
      type : 'post',
      dataType : 'json',
      cache : false,
      processData : false,
      contentType : false,
      async : false,
      success : function(resultObj) {
        var loginAva = $('#login_ava');
        var sM = $('#sub_menu');
        var sub = $('#sub_m');
        var ajaxresult = resultObj;
        m_no = resultObj.m_no;
        if (ajaxresult.status == 'failure') {
            loginAva.append("<ul class='nav pull-right top-menu'>"
                     + "<li><a class='logout' data-toggle='modal'"
                     + "href='wecando.html#myModal1'>Login</a></li>"
                     + "</ul>")
        } else {
            location.replace("http://localhost:8080/wecando/wecando.html");
        } 
      }
    })
    $.ajax({
      url : contextRoot + '/member/ajax/check_ava.do',
       type : 'post',
       dataType : 'json',
       cache : false,
       contentType : false,
       processData : false,
       data : form_data,
       success : function(resultObj) {
         var ajaxResult = resultObj.ajaxResult;
         if(ajaxResult.status == 'failure') {
           location.replace("http://localhost:8080/wecando/error.html");
         }
       }
    })
    
  })
	  
  var m_email = $('#m_email').val();
  var email_code = $('#email_code').val();
  var form = document.createElement("form");
  form.setAttribute("method","post");
  form.setAttribute("action","join.do");
  var input_email = document.createElement("input");
  input_email.setAttribute("type", "hidden");
  input_email.setAttribute("name", "m_email");
  input_email.setAttribute("value", m_email);
  
  var input_code = document.createElement("input");
  input_code.setAttribute("type", "hidden");
  input_code.setAttribute("name", "email_code");
  input_code.setAttribute("value", email_code);
  
  form.appendChild(input_email);
  form.appendChild(input_code);
  
  function submit_person() {
    var pi = document.createElement("input");
    pi.setAttribute("type", "hidden");
    pi.setAttribute("name", "m_grade");
    pi.setAttribute("value", 1);
    form.appendChild(pi);
    
    document.body.appendChild(form);
    
    form.submit();
  }
  function submit_school() {
    var pi = document.createElement("input");
    pi.setAttribute("type", "hidden");
    pi.setAttribute("name", "m_grade");
    pi.setAttribute("value", 2);
    form.appendChild(pi);
    
    document.body.appendChild(form);
    
    form.submit();
  }
  </script>
</body>
</html>






