<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>WECANDO</title>

<!-- Bootstrap core CSS -->
<link href="../../css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="../../font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="../../css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
  href="../../js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css" href="../../lineicons/style.css">
<link rel="shortcut icon" type="image/x-icon" href="../../img/logo.png" />

<!-- Custom styles for this template -->
<link href="../../css/style.css" rel="stylesheet">
<link href="../../css/style-responsive.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
  href="../../lib/sweetalert/sweetalert.css">
<script src="../../js/chart-master/Chart.js"></script>
</head>
<body>
  <section id="container" class="sidebar">
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right"
          data-original-title="Toggle Navigation"></div>
      </div>
      <a href="../../wecando.html" class="logo"> <img id="wecando_white"
        src="../../img/wecando_white.png">
      </a>
      <!-- login 버튼 스크립트로 내려서 login and logout 구현 -->
      <div class="top-menu" id='login_ava'></div>
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
        <div class="col-lg-3 ds dj" style='padding-bottom: 15px;'>
          <div class='reserveDiv'>
            <img src="../../img/reserveimage.png">
          </div>
          <hr>
          <div class='sch_info'>
            <div class='school'>
              <div class='field'>
                <label> 학교 이름 :</label>
                <input id='school_name' readonly="readonly" value='<%=request.getParameter("select_sch_name") %>' >
                <input type='hidden' id='school_num' readonly value=<%= request.getParameter("select_sch_num") %>>         
              </div> 
              <div class='field'>
                <label> 학교 위치 :</label>
                <input id='school_location' style='width: 85%; display: block;margin-left: 30px;' readonly="readonly" value='<%=request.getParameter("select_sch_location") %>' >
              </div> 
              <div class='field' style='margin-top: 18px;'>
                <label> 학교 번호 :</label>
                <input id='school_tel' readonly="readonly" value='<%=request.getParameter("select_sch_tel") %>' >
              </div> 
            </div>
            <div class='map_border'>
                <div id='map'></div>
            </div>
        </div>
        <hr style='margin: 30px 0;'>
       <div class='reserve_info'>
         <div class='field' style='margin-top: 18px;'>
            <input type="hidden" id="member_num" readonly>
            <label> 종목 명 :&nbsp&nbsp&nbsp</label>
            <input type='hidden' id='event_name' readonly="readonly" value='<%=request.getParameter("select_event_code") %>' >
            <input id='event_n' readonly>         
          </div>
         <div class='field' style='margin-top: 18px;'>
            <label> 코트 번호 :</label>
            <input type='hidden' id='court_code' readonly="readonly" value='<%=request.getParameter("select_court_code") %>' >
            <input id='event_c' readonly>
          </div>
         <div class='field' style='margin-top: 18px;'>
            <label> 이용 날짜 :</label>
            <input id='event_date' readonly="readonly" value='<%=request.getParameter("select_event_date") %>' >
         </div> 
         <div class='field' style='margin-top: 18px;'>
            <label> 이용 시간 :</label>
            <input type='hidden' id='event_time' readonly="readonly" value='<%=request.getParameter("select_Time") %>' >
            <input id='event_t' readonly>
          </div>
         <div class='field' style='margin-top: 18px;'>
            <label> 이용 금액 :</label>
            <input id='court_price' readonly="readonly" value='<%=request.getParameter("select_court_price") %>' >
          </div>
         <div class='field' style='margin-top: 18px;'>
            <label> 최대 인원 :</label>
            <input id='court_max' readonly="readonly" value='<%=request.getParameter("select_court_max") %>' >
          </div>
         <div class='field' style='margin-top: 18px;'>
            <label> 신청 이용자 수</label>
            <input id='court_cnt' type="number" name="points" min="0" max="<%= request.getParameter("select_court_max") %>" step="1" value="1">
          </div>
        <div class='reserveBtn'>
           <button style='margin-left:250px;' class='btn btn-theme04'>예약 취소</button>
           <button id='reserveButton' class='btn btn-theme03' type='button'>예약 하기</button> 
        </div>
        <img src='../../img/link.png'>
        <img src='../../img/link.png' style='left: 320px;'>
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
  <script src="../../js/common-scripts.js"></script>

  <script type="text/javascript" src="../../js/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="../../js/gritter-conf.js"></script>

  <script src="../../js/zabuto_calendar.js"></script>
  <script src="../../lib/sweetalert/sweetalert.min.js"></script>
  <script type="text/javascript"
    src="//apis.daum.net/maps/maps3.js?apikey=90d863ade026cac74762f5c9d8c37284&libraries=services">
  
  </script>
  <script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
      mapOption = {
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };  

    // 지도를 생성합니다    
    var map = new daum.maps.Map(mapContainer, mapOption); 
    
    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new daum.maps.services.Geocoder();
    
    // 주소로 좌표를 검색합니다
    geocoder.addr2coord($('#school_location').val(), function(status, result) {

    // 정상적으로 검색이 완료됐으면 
     if (status === daum.maps.services.Status.OK) {

        var coords = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new daum.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new daum.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0; color:black">' + $('#school_name').val() + '</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
      } 
    });    
  </script>

  <script type="application/javascript">
    var date;
    
    $(document).ready(function () {
        var time = $('#event_time').val();
        switch(time) {
          case "T6_8" : document.getElementById('event_t').value = "06:00 ~ 08:00";break;
          case "T8_10" : document.getElementById('event_t').value = "08:00 ~ 10:00";break;
          case "T10_12" : document.getElementById('event_t').value = "10:00 ~ 12:00";break;
          case "T12_14" : document.getElementById('event_t').value = "12:00 ~ 14:00";break;
          case "T14_16" : document.getElementById('event_t').value = "14:00 ~ 16:00";break;
          case "T16_18" : document.getElementById('event_t').value = "16:00 ~ 18:00";break;
          case "T18_20" : document.getElementById('event_t').value = "18:00 ~ 20:00";break;
          case "T20_22" : document.getElementById('event_t').value = "20:00 ~ 22:00";break;
        }
        
      var form_data = new FormData();
      form_data.append("event_code", $('#event_name').val());
     $.ajax({
        url : contextRoot + '/info/ajax/eventName.do',
        type : 'post',
        dataType : 'json',
        cache : false,
        data : form_data,
        processData : false,
        contentType : false,
        async : false,
        success : function(resultObj) {
            document.getElementById('event_n').value = resultObj.event_name;
        }
      })
      var code = $('#court_code').val();
        code = code.substring(code.length-1, code.length);
        document.getElementById('event_c').value = code;
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
          document.getElementById('member_num').value = resultObj.m_no;
          var ajaxresult = resultObj;
          if (ajaxresult.status == 'failure') {
        	    location.replace("http://localhost:8080/wecando/wecando.html");
          } else {
             loginAva.append("<ul class='nav pull-right top-menu'>"
                 + "<li><a class='logout'"
                 + "href='' onclick='logout();'>Logout</a></li>"
                 + "</ul>")
          } 
          if (ajaxresult.grade == 2) {
              sM.append(
               "<li><a href='../../info/register_school.html'>학교 정보</a></li>"   
              )
              sub.append(
              "<li><a href='../../info/ClientReserveList.html'>신청된 정보</a></li>"
                  )
          }
        }
      })
    });
    
     
  
  </script>
  <script>
    function logout() {
      $.ajax({
        url : contextRoot + '/auth/ajax/logout.do',
        type : 'post',
        dataType : 'json',
        cache : false,
        success : function(resultObj) {
          var ajaxresult = resultObj.AjaxResult;
          if (ajaxresult.status == 'success') {
            location  .replace("http://localhost:8080/wecando/login.html");
          } else {
            sweetAlert("Oops...", "Logout에 실패하였습니다.", "error");
          }
        }
      })
    }
    
    $(document).on("click", "#reserveButton", function() {
          var form_data = new FormData();
          console.log($('#member_num').val());
          console.log($('#school_num').val());
          console.log($('#event_name').val());
          console.log($('#event_date').val());
          console.log($('#court_code').val());
          console.log($('#court_cnt').val());
          console.log($('#event_time').val());
          form_data.append("m_no", $('#member_num').val());
          form_data.append("sch_num", $('#school_num').val());
          form_data.append("event_code", $('#event_name').val());
          form_data.append("event_date", $('#event_date').val());
          form_data.append("court_code", $('#court_code').val());
          form_data.append("user_cnt", $('#court_cnt').val());
          form_data.append("event_time", $('#event_time').val());
          $.ajax({
            url : contextRoot + '/reserve/ajax/doReserve.do',
            type : 'post',
            dataType : 'json',
            cache : false,
            processData : false,
            contentType : false,
            data : form_data,
            success : function(resultObj) {
              var ajaxResult = resultObj.AjaxResult;
              if (ajaxResult.status == 'success') {
                swal('Good', '예약에 성공하였습니다.', 'success');
              } else {
                swal('Oops', '예약에 실패했습니다.', 'error');
              }
            }
          }) 
    })
  </script>
</body>
</html>

