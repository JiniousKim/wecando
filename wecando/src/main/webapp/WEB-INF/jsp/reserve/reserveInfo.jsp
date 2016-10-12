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
  <div id="login-page">
    <div class="container">
      <!-- Modal -->
      <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
        id="myModal1" class="modal fade">
        <form class="form-login">
          <div class="modal-header" style="background-color: #2b4e55;">
            <h2 style="background-color: #2b4e55;" class="form-login-heading">sign
              in now</h2>
          </div>
          <div class="login-wrap">
            <div class="input-ikon">
              <i class='fa fa-user sc'></i>
            </div>
            <input type="text" id="m_email" class="f-c i-t"
              placeholder="User ID" autofocus> <br>
            <div class='input-ikon2'>
              <i class='fa fa-lock sc'></i>
            </div>
            <input type="password" id="m_password" class="f-c i-t"
              placeholder="Password">
            <div style='margin-top: 30px;'>
              <div class='b-s'>
                <button class="btn btn-block bh" type="button"
                  onclick="login();">LOGIN</button>
              </div>
              <div class="b-s1">
                <button type='button' class="btn bh btn-block" onclick="join();">SIGN
                  UP</button>
              </div>
              <hr>
            </div>
          </div>
        </form>
      </div>
      <!-- modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
        id="dateModal1" class="modal fade">
              <div class="col-lg-3 ds">
          <!-- CALENDAR-->
                    <h3>날짜 선택</h3>
          <div id="calendar" class="mb">
            <div class="panel green-panel">
              <div class="panel-body">
                <div id="date-popover" class="popover top"
                  style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
                  <div class="arrow"></div>
                  <h3 class="popover-title" style="disadding: none;"></h3>
                  <div id="date-popover-content" class="popover-content"></div>
                </div>
                <div id="my-calendar"></div>
                                <button id='modal_close' type="button" style='display:none;' class="close" data-dismiss="modal">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Close</span>
                              </button>
              </div>
            </div>
          </div>
        </div>
                
      </div>

    </div>
  </div>

  <section id="container" class="sidebar-closed">
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
          <li class="sub-menu"><a href="../../javascript:;"> <i
              class="fa fa-calendar"></i> <span>예약 정보</span>
          </a>
            <ul class="sub" id='sub_m'>
              <li><a href="../../general.html">내 예약정보</a></li>
            </ul></li>

          <li class="sub-menu"><a href="../../javascript:;"> <i
              class="fa fa-user"></i> <span>마이 페이지</span>
          </a>
            <ul class="sub" id='sub_menu'>
              <li><a href="memberInfo.html">내 정보</a></li>
            </ul></li>
        </ul>
      </div>
    </aside>
    <section id="main-content">
      <section class="wrapper">
                <div class="col-lg-3 ds dj">
                  <div class='wecando'>
                    <img style='margin-top:30px; width:400px; height:100px;' src="../../img/black_logo.png">
                  </div>
                  <hr>
                  <div id='sch_list'>
                    <div class='defaultDate'>
              <a class='logout' data-toggle='modal'
              href='../../wecando.html#dateModal1'><input id='chooseDate' value=<%=request.getParameter("event_date") %> readonly></a>
              </div>
            <div style='width:100%; height:180px; margin-top:30px;'>
            <div class="row mt">
            <div class="col-lg-12" style='left:-10px; top:25px;'>
              <div class="form-panel-email" style='width:100%;'>
                <form class="form-horizontal style-form" method="post">
                  <div class="form-group" id='result'>
                    <input type='hidden' class='form-control-static' id='sch_no' value='' readonly="readonly" >
                    <label class='col-lg-2 col-sm-2 control-label'> 학교 이름</label>
                    <div class='col-lg-10'>
                    <input class='form-control-static' id='school_name' readonly="readonly" value=<%=request.getParameter("sch_name")%> > 
                    </div>
                    <label class='col-lg-2 col-sm-2 control-label'> 학교 위치</label>
                    <div class='col-lg-10'> 
                    <input class='form-control-static' id='school_location' readonly="readonly" value=<%=request.getParameter("sch_location") %>>
                    </div>
                    <label class='col-lg-2 col-sm-2 control-label'> 전화 번호</label>
                    <div class='col-lg-10'>
                    <input class='form-control-static' id='school_tel' readonly="readonly" value=<%=request.getParameter("sch_tel") %>>
                    </div>
                  </div>
                </form>
              </div>
                <div id='map' style='width:320px; height:200px; position: absolute; right:0px; top:-50px; background-color:black; z-index:1'>
                    
                  </div>
            </div>
            <!-- col-lg-12-->
          </div>
                  </div>
                  <div class="btn-group" id='eventlist' style='top:30px;'>
                    <select id='event_list' name='ec' class='dropdown-toggle' data-toggle='dropdown' name='event_code'>
                      <option class='dropdown-menu' selected>종목 선택</option>
                    </select>
                      <div>
                          <div class='card_title'>
                                  <div class='card_name'><i class='fa fa-university'>&nbsp;  askldfjlks  </i></div> 
                         </div>
                      <div class='card'>
                          
                          <div class='card_photo'> 
                              
                          <div class='card_time'><table class='time_table'> 
                                <thead>
                                <tr>
                                <th>이용가능 시간</th><th>대관비용</th><th colspan='5px;'>사용가능 여부</th> 
                                </tr></thead><tbody>  
                                <tr> 
                                  <td>&nbsp;&nbsp;&nbsp;06:00 ~ 08:00</td> 
                                  <td>&nbsp;&nbsp;&nbsp;5000원</td> 
                                      <td>&nbsp;&nbsp;&nbsp;<a href="#">사용 가능</a></td> 
                                </tr> 
                                <tr> 
                                  <td>08:00 ~ 10:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>10:00 ~ 12:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>12:00 ~ 14:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>14:00 ~ 16:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>16:00 ~ 18:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>18:00 ~ 20:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr> 
                                <tr> 
                                  <td>20:00 ~ 22:00</td> 
                                  <td>   </td> 
                                  <td>   </td> 
                                </tr></tbody></table></div></div>
                  </div></div>
                </div>
               </div>
                <div style='width:100%; text-align:left; margin-top:-70px; margin-left:50px; margin-bottom:30px;'>
                   <button class='btn btn-theme04' type="reset">예약 취소</button>
                   <button class='btn btn-theme03' type='button'>예약 하기</button> 
                </div>
                   
        <!-- /col-lg-3 -->
                </div>
      </section> 
    </section>
    <footer class="site-footer">
    </footer>
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

  <script type="text/javascript" src="../../js/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="../../js/gritter-conf.js"></script>

  <script src="../../js/sparkline-chart.js"></script>
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
            content: '<div style="width:150px;text-align:center;padding:6px 0; color:black">원당초등학교</div>'
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
        $("#date-popover").popover({html: true, trigger: "manual"});
        $("#date-popover").hide();
        $("#date-popover").click(function (e) {
            $(this).hide();
        });
        $("#my-calendar").zabuto_calendar({
            action: function () {
                var day = this.id.split('_');
                var selectedDay = day[3];
                document.getElementById('chooseDate').value = selectedDay;
                $('#modal_close').trigger('click');
                //return myDateFunction(this.id, false);
            },
            action_nav: function () {
                return myNavFunction(this.id);
            }
        });
        
     $.ajax({
        url : contextRoot + '/info/ajax/eventList.do',
        type : 'post',
        dataType : 'json',
        cache : false,
        processData : false,
        contentType : false,
        async : false,
        success : function(resultObj) {
          var list = $('#event_list');
          for(var event of resultObj.eventList) {
             list.append("<option value='" + event.event_code + "'>" + event.event_name + "</option>")
          }
        }
      })
    });
    
    function myNavFunction(id) {
        $("#date-popover").hide();
        var nav = $("#" + id).data("navigation");
        var to = $("#" + id).data("to");
        console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
    
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
          if (ajaxresult.status == 'failure') {
            loginAva.append("<ul class='nav pull-right top-menu'>"
             + "<li><a class='logout' data-toggle='modal'"
             + "href='wecando.html#myModal1'>Login</a></li>"
             + "</ul>")
          } else {
             loginAva.append("<ul class='nav pull-right top-menu'>"
                 + "<li><a class='logout'"
                 + "href='' onclick='logout();'>Logout</a></li>"
                 + "</ul>")
          } 
          if (ajaxresult.grade == 2) {
              sM.append(
               "<li><a href='info/register_school.html'>학교 정보</a></li>"   
              )
              sub.append(
              "<li><a href='buttons.html'>신청된 정보</a></li>"
            		  )
          }
        }
      })
     
  
  </script>
  <script>
    $(document).on("click", "#dddd", function() {
        date = 'asdf';
        $('#sch_list').append(date);
        document.getElementById('chooseDate').value = date;
    })
    
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
  </script>
</body>
</html>

