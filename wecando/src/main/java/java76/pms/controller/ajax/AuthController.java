package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Member;
import java76.pms.service.MemberService;

@Controller("ajax.AuthController")
@RequestMapping("/auth/ajax/*")
public class AuthController {  
	
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping(value="login", method=RequestMethod.GET)
  public String loginform() {
    return "redirect:../../error.html";
  }
      
  @RequestMapping(value="login", method=RequestMethod.POST)
  public Object login(
      String m_email,
      String m_password,
      String saveEmail,
      HttpServletResponse response, 
      HttpSession session) {

    Cookie emailCookie = null;
    if (saveEmail != null) { // 이메일 저장을 체크했으면,
      emailCookie = new Cookie("m_email", m_email);
      emailCookie.setMaxAge(60 * 60 * 24 * 15);
    } else {
      emailCookie = new Cookie("m_email", "");
      emailCookie.setMaxAge(0); // 웹브라우저에게 email 쿠키 삭제를 명령한다.
    }
    response.addCookie(emailCookie);

    Member member = memberService.retrieve(m_email, m_password);
    HashMap<String, Object> resultMap = new HashMap<>();
    
    try {
    	  if (!(member.equals(null))) {}
    } catch (Exception e) {
	    	session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
	    	resultMap.put("status", "failure");
    	  return resultMap;
    }
    	
    session.setAttribute("loginUser", member);
    resultMap.put("loginUser", member);
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping(value="logout", method=RequestMethod.POST )
  public AjaxResult logout(HttpSession session) {
  	  try {
  	  		session.removeAttribute("loginUser");
  	  }
  	  catch (Exception e) {
  	  	  return new AjaxResult("failure", null);
  	  }
    return new AjaxResult("success", null);
  }
  
  @RequestMapping(value="logout", method=RequestMethod.GET )
  public String logout_get(HttpSession session) {
    return "redirect:../../error.html";
  }
  
  @RequestMapping(value="check_session", method=RequestMethod.POST)
  public Object check_session(HttpSession session) throws Exception {
  		Member member = (Member)session.getAttribute("loginUser");
  		HashMap<String, Object> resultMap = new HashMap<>();
  		try {
  			if (!(member.equals(null))) {}
  		} catch (Exception e) {
  			resultMap.put("status", "failure");
  			return resultMap;
  		}
  		member = memberService.retrieve(member.getM_email(), member.getM_password());
  		resultMap.put("status", "success");
  		resultMap.put("m_no", member.getM_no());
  		resultMap.put("grade", member.getM_grade());
  		return resultMap;
  }
  
  @RequestMapping(value="loginInfo", method=RequestMethod.POST)
  public Object loginInfo(HttpSession session) {
  		HashMap<String,Object> resultMap = new HashMap<>();
  		
  		return resultMap;
  }
}

