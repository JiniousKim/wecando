package java76.pms.controller.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.dao.MemberDao;
import java76.pms.domain.AjaxResult;
import java76.pms.domain.Member;

@Controller("ajax.MemberController")
@RequestMapping("/member/ajax/*")
public class MemberController { 

	public static final String SAVED_DIR = "/attachfile";

	@Autowired MemberDao memberDao;
	@Autowired ServletContext servletContext;

	@RequestMapping("list")
	public Object list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			@RequestParam(defaultValue="no") String keyword,
			@RequestParam(defaultValue="desc") String align) throws Exception {

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("length", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("align", align);

		List<Member> members = memberDao.selectList(paramMap);

		HashMap<String,Object> resultMap = new HashMap<>();
		resultMap.put("status", "success");
		resultMap.put("data", members);

		return resultMap;
	}

	@RequestMapping(value="add", method=RequestMethod.GET)
	public String form() {
		return "member/MemberForm";
	}

	@RequestMapping(value="add", method=RequestMethod.POST)
	public AjaxResult add(Member member) throws Exception {
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();

		for (int i = 0; i < 20; i++) {
			if (rnd.nextBoolean()) {
				buf.append((char)((int)(rnd.nextInt(26)) + 97));
			} else {
				buf.append((rnd.nextInt(10)));
			}
		}
		member.setEmail_code(buf.toString());

		memberDao.insert(member);

		return new AjaxResult("success", null);
	}

	@RequestMapping("detail")
	public Object detail(int m_no) throws Exception {
		Member member = memberDao.selectOne(m_no);
		return new AjaxResult("success", member);
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public AjaxResult update(Member member) throws Exception {
		if (memberDao.update(member) <= 0) {
			return new AjaxResult("failure", null);
		} 

		return new AjaxResult("success", null);
	}

	@RequestMapping("delete.do")
	public AjaxResult delete(int m_no, String m_password) throws Exception {
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("no", m_no);
		paramMap.put("password", m_password);

		if (memberDao.delete(paramMap) <= 0) {
			return new AjaxResult("failure", null);
		} 
		return new AjaxResult("success", null);
	}
}
