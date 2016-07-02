<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.InputStream" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLConnection" %>

<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>

<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%
  String html = "";
  String count = "0";
  try {
    String queryURL = "www.career.go.kr/cnet/openapi/getOpenApi?apiKey=701eb0e5533f950953a9e92ec4b65744&svcType=api&svcCode=SCHOOL&contentType=xml&gubun=elem_list";

    URL url = new URL(queryURL);
    URLConnection connection = url.openConnection();
    InputStream is = connection.getInputStream();

    // 3. 질의결과 받기
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(is);

    // 4. 파싱
    Element root = doc.getDocumentElement();

    if ("jobSearch".equals(root.getNodeName())) {
      NodeList nodelist = root.getChildNodes();

      for (int i = 0; i < nodelist.getLength(); i++) {
        // root node중 item node만  처리
        Node item = nodelist.item(i);

        if ("list".equals(item.getNodeName())) {
          // list만 처리
          NodeList itemList = item.getChildNodes();

          count = item.getAttributes().getNamedItem("totalCount").getNodeValue();

          html = "<table class=\"table_t5\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"540\" height=\"34\" background=\"http://career.go.kr/images/01_job/1_dic/01_list_bg_t_1.gif\">"
              + "<tr>" + "<td width=\"44\">" + "<p align=\"center\"><font color=\"white\">학교명</font></p>" + "</td>"
              + "<td width=\"135\">" + "<p align=\"center\"><font color=\"white\">학교종류</font></p>" + "</td>"
              + "<td width=\"120\">" + "<p align=\"center\"><font color=\"white\">학교유형</font></p>" + "</td>"
              + "<td width=\"241\">" + "<p align=\"center\"><font color=\"white\">지역</font></p>" + "</td>" + "</tr>"
              + "</table>";

          html += "<table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"540\" height=\"34\">";
          for (int j = 0; j < itemList.getLength(); j++) {

            Node items = itemList.item(j);

            if ("content".equals(items.getNodeName())) {
              // content만 처리
              NodeList itemList2 = items.getChildNodes();

              Node rnum = itemList2.item(1);
              Node schoolName = itemList2.item(3);
              Node schoolGubun = itemList2.item(5);
              Node schoolType = itemList2.item(7);
              Node region = itemList2.item(9);

              html += "<tr>" + "<td width=\"44\" class=\"board_td_sky\">" + "<p align=\"center\">"
                  + rnum.getTextContent() + "</p>" + "</td>" + "<td width=\"135\" class=\"board_td_sky\">"
                  + "<p align=\"left\"><a onclick=\"javascript:getDetail(" + schoolName.getTextContent()
                  + ",'','');\" title=\"상세보기\" style=\"cursor:pointer\">" + schoolGubun.getTextContent()
                  + "</a></p>" + "</td>" + "<td width=\"120\" class=\"board_td_sky\">" + "<p align=\"left\">"
                  + schoolType.getTextContent() + "</p>" + "</td>" + "<td width=\"241\" class=\"board_td_sky\">"
                  + "<p align=\"left\">" + region.getTextContent() + "</p>" + "</td>" + "</tr>";
            }
          }

          if (itemList.getLength() == 0) {
            html += "<tr>" + "<td width=\"540\" height=\"150\">"
                + "<p><font color=\"#FF320A\"><strong>검색결과</strong></font>가  없습니다.</p>" + "</td>" + "</tr>";

          }
          html += "</table>";
        }
      }
    }

  } catch (Exception e) {
    e.printStackTrace();
  }
%>

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
<link rel="stylesheet" type="text/css" href="../../css/zabuto_calendar.css">
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
                data-toggle="modal" href="../wecando.html#myModal2"> Forgot
                  Password?</a>
            </span>
            </label>
            <button class="btn btn-theme btn-block" href="../wecando.html"
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
        tabwecando="-1" id="myModal2" class="modal fade">
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
      <a href="wecando.html" class="logo"> <img id="wecando_white"
        src="../../img/wecando_white.png">
      </a>
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" data-toggle="modal"
            href="../../wecando.html#myModal1">Logout</a></li>
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
          <!-- INLINE FORM ELELEMNTS -->

          <div class="row mt">
            <div class="col-lg-12">
              <div class="form-panel-email">
                <h1 class="email">
                  <i class="fa fa-angle-right"></i> 회원가입
                </h1>
                <form class="form-horizontal style-form" method="post">
                  <div class="form-group">
                    <label class="col-lg-2 col-sm-2 control-label"> 이메일</label>
                    <div class="col-lg-10">
                      <p class="form-control-static" style="color: #777;"><%= request.getParameter("m_email") %></p>
                    </div>
                  </div>
                  <input type='hidden' id="m_email" value=<%= request.getParameter("m_email") %>>
                  <input type='hidden' id='m_grade' value=<%= request.getParameter("m_grade") %>>
                  <input type='hidden' id='email_ava' value="1">
                  <input type='hidden' id="email_code" value=<%= request.getParameter("email_code") %>>
                  <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label"> 비밀번호</label>
                    <div class="col-sm-10">
                      <input type="password" id='password' onchange="check(this.id);" 
                                                class="form-control" placeholder="">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label"> 비밀번호 확인</label>
                    <div class="col-sm-10">
                      <input type="password" id="password2" onchange="check(this.id);" 
                                                class="form-control" placeholder="">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label"> 이름</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="m_name">
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label"> 닉네임</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control col-sm-3" id="m_nick">
                      <button type="button" class="btn btn-default col-sm-2">중복확인</button>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-sm-2 col-sm-2 control-label"> 전화번호</label>
                    <div class="col-sm-10">
                      <input type="text" class="form-control" id="m_tel">
                    </div>
                  </div>

                  <input type="button" class="btn btn-theme04" value="취소"
                    onclick="javascript:history.back()">
                  <button type="button" class="btn btn-theme" id="create">가입하기</button>
                </form>
              </div>
            </div>
            <!-- col-lg-12-->
          </div>
          <!-- /row -->
        </div>
        <!-- /row mt -->
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
  $(document).on("click", '#create', function(e) {
	    var form_data = new FormData();
	    form_data.append("m_email", $('#m_email').val());
	    form_data.append("m_grade", $('#m_grade').val());
	    form_data.append("m_name", $('#m_name').val());
	    form_data.append("m_tel", $('#m_tel').val());
	    form_data.append("m_nick", $('#m_nick').val());
	    form_data.append("email_ava", $('#email_ava').val());
	    form_data.append("m_password", $('#password').val());
	    form_data.append("email_code", $('#email_code').val());
	    
	    if(form_data.m_grade == 1) {
	    $.ajax({
	      url: contextRoot + '/member/ajax/create.do', 
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
	          swal("Good job!", "회원 가입이 완료되었습니다.", "success")
	          e.preventDefault();
	        } else {
	          sweetAlert("Oops...","다시 시도해 주세요","error");
	          e.preventDefault();
	        }
	        setTimeout('go_url()', 5000);
	      }
	    })
	    }
	    else {
	        $.ajax({
	            url: contextRoot + '/member/ajax/create.do', 
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
	                swal("Good job!", "회원 가입이 완료되었습니다.", "success");
	              } else {
	                sweetAlert("Oops...","다시 시도해 주세요","error");
	                e.preventDefault();
	              }
	              setTimeout('go_register()', 5000);
	            }
	          })
	    }
	    
	  });
  
  function go_url() {
	    location.replace("{http://localhost:8080/wecando/wecando.html}");
	  };
  function go_register() {
      location.replace("{http://localhost:8080/wecando/register_school.html}");
    };
  </script>
</body>
</html>
