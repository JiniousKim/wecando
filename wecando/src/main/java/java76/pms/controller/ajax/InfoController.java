package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.Member;
import java76.pms.service.MemberService;

@Controller("ajax.InfoController")
@RequestMapping("/info/ajax/*")
public class InfoController { 
	@Autowired MemberService memberService;
	@Autowired ServletContext servletContext;

	@RequestMapping(value="member", method=RequestMethod.POST)
	public Object infoMember(String m_password,
			HttpServletResponse response, 
			HttpSession session) throws Exception {

		Member loginUser = (Member)session.getAttribute("loginUser");
		HashMap<String, Object> resultMap = new HashMap<>();

		if (!(loginUser.getM_password().equals(m_password))) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		try {
			loginUser = memberService.retrieve(
					loginUser.getM_email(), loginUser.getM_password());
		} catch (Exception e) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		resultMap.put("loginUser", loginUser);
		return resultMap;
	}
	
	@RequestMapping(value="member", method=RequestMethod.GET)
	public String infoMember1() throws Exception {
		return "redirect:../../error.html";
	}
}
