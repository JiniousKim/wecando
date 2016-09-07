package java76.pms.controller.ajax;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.service.CourtService;

@Controller("ajax.CourtController")
@RequestMapping("/court/ajax/*")
public class CourtController { 
	@Autowired CourtService courtService;
	
	@RequestMapping(value="addCourt", method=RequestMethod.POST)
	public Object addCourt(int sch_no, String event_code,
			                   int court_cnt, int court_max,
			                   int court_price) {
		
		HashMap<String, Object> paramMap = new HashMap<>();
		String court_code = sch_no + event_code; 
		
		paramMap.put("sch_no", sch_no);
		paramMap.put("court_cnt", court_cnt);
		paramMap.put("event_code", event_code);
		paramMap.put("court_max", court_max);
		paramMap.put("court_price", court_price);
		
		for (int i = 1; i <= court_cnt; i++) {
			if (i < 10) {
				court_code = court_code + "0" + i;
			} else {
				court_code = court_code + i;
			}
			paramMap.put("court_code", court_code);
			try {
				if (courtService.insert_court(paramMap) > 0) {}
			} catch (Exception e) {
				return new AjaxResult("failure", null);
			}
		}
		return new AjaxResult("success", null);
	}
	
	@RequestMapping(value="addCourt", method=RequestMethod.GET)
	public String get_addCourt() {
		return "redirect:../../error.html";
	}
	
	@RequestMapping(value="courtList", method=RequestMethod.POST)
	public Object courtList(int sch_no) {
		
		
		
		return new AjaxResult("success", null);
	}
}
