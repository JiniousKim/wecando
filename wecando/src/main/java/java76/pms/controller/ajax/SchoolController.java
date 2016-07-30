package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.service.SchoolService;

@Controller("ajax.SchoolController")
@RequestMapping("/school/ajax/*")
public class SchoolController { 
	@Autowired SchoolService schoolService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="setSchool", method=RequestMethod.POST)
	public Object setSchool(
			String sch_name, String sch_location, String sch_tel, int m_no) {
		HashMap<String, Object> schoolMap = new HashMap<>();
		try{
			schoolMap.put("sch_name", sch_name);
			schoolMap.put("sch_location", sch_location);
			schoolMap.put("sch_tel", sch_tel);
			schoolMap.put("m_no", m_no);
			if (schoolService.sch_register(schoolMap) > 0) {}
		} catch (Exception e) {
			return new AjaxResult("status", "failure");
		}
		return new AjaxResult("status", "success");
	}
	
	@RequestMapping(value="setSchool", method=RequestMethod.GET)
	public String get_setSchool() {
		return "redirect:../../error.html";
	}
}
