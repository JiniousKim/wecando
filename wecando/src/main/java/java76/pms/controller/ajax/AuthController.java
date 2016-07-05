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

    if (member == null) { // 로그인 실패!
      session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
      resultMap.put("status", "failure");
      resultMap.put("loginUser", null);
      return resultMap;
    }
    	
    session.setAttribute("loginUser", member);
    resultMap.put("loginUser", member);
    resultMap.put("status", "success");
    return resultMap;
  }
  
  @RequestMapping(value="logout", method=RequestMethod.POST )
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:../../login.html";
  }
  
  @RequestMapping(value="logout", method=RequestMethod.GET )
  public String logout_get(HttpSession session) {
    session.removeAttribute("loginUser");
    return "redirect:../../login.html";
  }
}

