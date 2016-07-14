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

	//	@RequestMapping(value="searchSchool", method=RequestMethod.GET)
	//	public String register() throws Exception {
	//		return "redirect:../../error.html";
	//	}
	@RequestMapping(value="searchSchool", method=RequestMethod.GET)
	public String register() throws Exception {
		return "/info/searchSchool";
	}

	@RequestMapping(value="searchSchool", method=RequestMethod.POST)
	public String register_school() throws Exception {
		return "/info/searchSchool";
	}

	@RequestMapping(value="member", method=RequestMethod.POST)
	public Object infoMember(String m_password,
			HttpServletResponse response, 
			HttpSession session) throws Exception {

		Member loginUser = (Member)session.getAttribute("loginUser");
		Member member = new Member();
		HashMap<String, Object> resultMap = new HashMap<>();

		try {
			if (!(loginUser.getM_password().equals(m_password))) {
				resultMap.put("status", "failure");
				return resultMap;
			}
			int no = loginUser.getM_no();
			member = memberService.retrieve(no);
		} catch (Exception e) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		System.out.println(member);
		resultMap.put("status", "success");
		resultMap.put("loginUser", member);
		return resultMap;
	}
	
	@RequestMapping(value="member", method=RequestMethod.GET)
	public Object infoMember1(String m_password,
			HttpServletResponse response, 
			HttpSession session) throws Exception {

		Member member = (Member)session.getAttribute("loginUser");

		System.out.println(member);

		HashMap<String, Object> resultMap = new HashMap<>();

		if (!(member.getM_password().equals(m_password))) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		resultMap.put("loginUser", member);
		return resultMap;
	}

}
