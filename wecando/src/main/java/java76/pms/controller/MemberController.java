package java76.pms.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.domain.Member;
import java76.pms.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController { 

	public static final String SAVED_DIR = "/attachfile";

	@Autowired MemberService memberService;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align,
			Model model) throws Exception {

		List<Member> members = memberService.getMemberList(
				pageNo, pageSize, keyword, align);

		model.addAttribute("members", members);
		return "member/MemberList";
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form() {
		return "member/MemberForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(Member member) throws Exception {
		memberService.register(member);
		return "redirect:list.do";
	}

	@RequestMapping("detail")
	public String detail(int m_no, Model model) throws Exception {
		Member member = memberService.retieve(m_no);
		model.addAttribute("member", member);
		return "member/MemberDetail";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(Member member) throws Exception {
		memberService.change(member);
		return "redirect:list.do";
	}

	@RequestMapping("delete.do")
	public String delete(int m_no, String password) throws Exception {
		memberService.remove(m_no, password);
		return "redirect:list.do";
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST)
	public String create(Member member) throws Exception {
		memberService.create(member);
		return "redirect:list.do";
	}
}
