package java76.pms.controller.ajax;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String infoMember() {
		return "/info/memberInfo.html";
	}

}
