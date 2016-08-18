function check(id) {
    var oid = $("#" + id).val();
    var oMsg = $("#" + id + "Msg");
    var oDiv = $("#" + id + "Form");

    if (oid == "") {
        oDiv.removeClass("has-success");
        oDiv.addClass("has-error");
        oMsg.css("display", "block");
        oMsg.html("필수 정보입니다.");
        return false;
    }
    
    if (id == "m_e") {
        var isEmail = /[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/
        if (!isEmail.test(oid)) {
            oDiv.removeClass("has-success");
            oDiv.addClass("has-error");
            oMsg.css("display", "block");
            oMsg.html("이메일 형식이 아닙니다.");
            return false;
        }
        oDiv.removeClass("has-error");
        oDiv.addClass("has-success");
        oMsg.css("display", "block");
        oMsg.html("");
    }
    
    if (id == "password") {
        var isPassword = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#%^&*_+.?]).{8,20}$/;
        if (!isPassword.test(oid)) {
            oDiv.removeClass("has-success");
            oDiv.addClass("has-error");
            oMsg.css("display", "block");
            oMsg.html("최소 1개의 숫자 혹은 특수문자를 포함하는 8~20 영문으로 입력해주세요");
            return false;
        }
        oDiv.removeClass("has-error");
        oDiv.addClass("has-success");
        oMsg.css("display", "block");
        oMsg.html("사용 가능한 비밀번호입니다.");
        return true;
    }
    
    if (id == "password2") {
        var oPW = $("#password").val();
        if (oPW == "" || oPW != oid) {
            oDiv.removeClass("has-success");
            oDiv.addClass("has-error");
            oMsg.css("display", "block");
            oMsg.html("비밀번호가 일치하지 않습니다.");
            return false;
        }
        oDiv.removeClass("has-error");
        oDiv.addClass("has-success");
        oMsg.css("display", "block");
        oMsg.html("비밀번호가 일치합니다.");
        return true;
    }
    
    if (id == "mName") {
        var isName = /^[가-힝a-zA-Z]{2,}$/;
        if (!isName.test(oid)) {
            oDiv.removeClass("has-success");
            oDiv.addClass("has-error");
            oMsg.css("display", "block");
            oMsg.html("이름을 입력해주세요");
            return false;
        }
        oDiv.removeClass("has-error");
        oDiv.addClass("has-success");
        oMsg.css("display", "block");
        oMsg.html("");
        return true;
    }
    
    if ((id == "court_price") || id == "court_max") {
    	  var isNum = /^[0-9]/;
    	  if (!isNum.test(oid)) {
    		  oDiv.removeClass("has-success");
    		  oDiv.addClass("has-error");
    		  oMsg.css("display", "block");
    		  oMsg.html("숫자만 입력 가능합니다.");
    		  return false;
    	  }
    	  oDiv.removeClass("has-error");
    	  oDiv.addClass("has-success");
	  oMsg.css("display", "block");
	  oMsg.html("");
	  return true;
    }
};