package java76.pms.controller.ajax;

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
  public AjaxResult login(
      String m_email,
      String m_password,
      HttpServletResponse response, 
      HttpSession session) {

    Cookie emailCookie = null;
//    if (saveEmail != null) { // 이메일 저장을 체크했으면,
//      emailCookie = new Cookie("email", m_email);
//      emailCookie.setMaxAge(60 * 60 * 24 * 15);
//    } else {
//      emailCookie = new Cookie("email", "");
//      emailCookie.setMaxAge(0); // 웹브라우저에게 email 쿠키 삭제를 명령한다.
//    }
    response.addCookie(emailCookie);

    Member member = memberService.retrieve(m_email, m_password);

    if (member == null) { // 로그인 실패!
      session.invalidate(); // 세션을 무효화시킴. => 새로 세션 객체 생성!
      return new AjaxResult("failure", null);
    }

    session.setAttribute("loginUser", member);
    return new AjaxResult("success", null);
  }
  
  @RequestMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:../../wecando.html";
  }
}

