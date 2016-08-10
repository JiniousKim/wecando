package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.School;
import java76.pms.service.MemberService;
import java76.pms.service.SchoolService;
import java76.pms.util.SearchSchool;

@Controller("ajax.SchoolController")
@RequestMapping("/school/ajax/*")
public class SchoolController { 
	@Autowired SchoolService schoolService;
	@Autowired MemberService memberService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="addSchool", method=RequestMethod.POST)
	public Object addSchool(String sch_name, int m_no) {
		HashMap<String, Object> schoolMap = new HashMap<>();
		HashMap<String, Object> resultMap	= new HashMap<>();
		School school = new SearchSchool().getSchool(sch_name);
		schoolMap.put("sch_name", school.getSch_name());
		schoolMap.put("sch_location", school.getSch_location());
		schoolMap.put("sch_tel", school.getSch_tel());
		schoolMap.put("m_no", m_no);
		int mng_no = 0;
		try{
			mng_no = schoolService.get_sch(sch_name);
			if (mng_no > 0) {
				schoolService.sch_change(schoolMap);
				memberService.update_manage(mng_no, m_no);
			}
		} catch (Exception e) {
			try {
				schoolService.sch_register(schoolMap);
				mng_no = schoolService.get_sch(sch_name);
				System.out.println(mng_no);
				memberService.manage(mng_no, m_no);
			} catch (Exception te) {
				resultMap.put("status", "failure");
				return resultMap;
			}
			resultMap.put("status", "success");
			return resultMap;
		}
		
		resultMap.put("status", "success");
		resultMap.put("school", school);
		return resultMap;
	}
	
	@RequestMapping(value="addSchool", method=RequestMethod.GET)
	public String get_addSchool() {
		return "redirect:../../error.html";
	}
	
	@RequestMapping(value="searchSchool", method=RequestMethod.POST)
	public Object searchSchool(String sch_name) throws Exception {
		return new SearchSchool().searchForSchool(sch_name);
	}
	
	@RequestMapping(value="searchSchool", method=RequestMethod.GET)
	public String register() throws Exception {
		return "redirect:../../error.html";
	}
	
	@RequestMapping(value="changeSchool", method=RequestMethod.POST)
	public Object changeSchool(String sch_name, int m_no) throws Exception {
		HashMap<String, Object> schoolMap = new HashMap<>();
		HashMap<String, Object> resultMap	= new HashMap<>();
		School school = null;
		int mng_no = 0;
		try{
			school = new SearchSchool().getSchool(sch_name);
			schoolMap.put("sch_name", school.getSch_name());
			schoolMap.put("sch_location", school.getSch_location());
			schoolMap.put("sch_tel", school.getSch_tel());
			schoolMap.put("m_no", m_no);
			mng_no = schoolService.get_sch(sch_name);
			if (mng_no > 0) {
				schoolService.sch_change(schoolMap);
				memberService.update_manage(mng_no, m_no);
			}
		} catch (Exception e) {
			try {
				schoolService.sch_register(schoolMap);
				mng_no = schoolService.get_sch(sch_name);
				memberService.manage(mng_no, m_no);
			} catch (Exception te) {
				resultMap.put("status", "failure");
				return resultMap;
			}
			resultMap.put("status", "scuccess");
			return resultMap;
		}
		resultMap.put("status", "success");
		resultMap.put("school", school);
		return resultMap;
	}
	
	@RequestMapping(value="changeSchool", method=RequestMethod.GET)
	public String get_changeSchool() {
		return "redirect:../../error.html";
	}
	
	@RequestMapping(value="schManager", method=RequestMethod.POST)
	public Object schManager(int m_no) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			School school = schoolService.sch_Manager(m_no);
			System.out.println(school);
		  if (school != null) {
		  		resultMap.put("status", "success");
		  		resultMap.put("school", school);
		  } else {
		  	  resultMap.put("status", "failure");
		  }
		} catch (Exception e) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		return resultMap;
	}
	
	@RequestMapping(value="schManager", method=RequestMethod.GET) 
	public String get_schMangager() throws Exception {
		return "redirect:../../error.html";
	}
}
