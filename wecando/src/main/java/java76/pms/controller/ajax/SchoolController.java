package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.School;
import java76.pms.service.SchoolService;
import java76.pms.util.SearchSchool;

@Controller("ajax.SchoolController")
@RequestMapping("/school/ajax/*")
public class SchoolController { 
	@Autowired SchoolService schoolService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="addSchool", method=RequestMethod.POST)
	public Object addSchool(String sch_name, int m_no) {
		HashMap<String, Object> schoolMap = new HashMap<>();
		HashMap<String, Object> resultMap	= new HashMap<>();
		School school = null;
		try{
			school = new SearchSchool().getSchool(sch_name);
			schoolMap.put("sch_name", school.getSch_name());
			schoolMap.put("sch_location", school.getSch_location());
			schoolMap.put("sch_tel", school.getSch_tel());
			schoolMap.put("m_no", m_no);
			if (schoolService.sch_register(schoolMap) > 0) {}
		} catch (Exception e) {
			resultMap.put("status", "failure");
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
}
