package java76.pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Court;
import java76.pms.service.CourtService;

@Controller("ajax.CourtController")
@RequestMapping("/court/ajax/*")
public class CourtController { 
	@Autowired CourtService courtService;
	
	@RequestMapping(value="addCourt", method=RequestMethod.POST)
	public Object addCourt(int sch_no, String event_code,
			                   int court_cnt, int court_max,
			                   int court_price) {
		
		event_code = event_code.replace(" ", "");
		String court_code = sch_no + event_code; 
		String cc = court_code;
		Court court = new Court();
		
		court.setCourt_cnt(court_cnt);
		court.setCourt_max(court_max);
		court.setSch_no(sch_no);
		court.setCourt_price(court_price);
		court.setEvent_code(event_code);
		
		for (int i = 1; i <= court_cnt; i++) {
			if (i < 10) {
				court_code = cc + "0" + i;
			} else {
				court_code = cc + i;
			}
			court.setCourt_code(court_code);
			try {
				if (courtService.insert_court(court) > 0) {}
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
		List<Court> courts = courtService.courtList(sch_no);
		List<Court> courtList = new ArrayList<>();
		for (Court co : courts) {
			Court court = new Court();
			court.setCourt_cnt(co.getCourt_cnt());
			court.setCourt_max(co.getCourt_max());
			court.setCourt_price(co.getCourt_price());
			court.setEvent_code(co.getEvent_code());
			court.setEvent_name(co.getEvent_name());
			courtList.add(court);
		}
		
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("courtList", courtList);
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="removeCourt", method=RequestMethod.POST)
	public Object removeCourt (String event_code, 
														int sch_no) throws Exception {
		event_code = (event_code.replace("fa fa-trash ibutton excluir ", ""))
				.toUpperCase().replace(" ", "");
		String code = sch_no + event_code;
		try {
			if (courtService.removeAllCourt(code) > 0) {}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
	
	@RequestMapping(value="setCourt", method=RequestMethod.POST)
	public Object setCourt (String event_code,
			                    int sch_no) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		event_code = (event_code.replace("fa fa-pencil ibutton alterar ", ""))
				.toUpperCase().replace(" ", "");
		String code = sch_no + event_code;
		Court court = new Court();
		try {
			court = courtService.setCourt(code);
		} catch (Exception e) {
			resultMap.put("status", "failure");
		}
		resultMap.put("court", court);
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="updateCourt", method=RequestMethod.POST)
	public Object updateCourt(String event_code,
			 								      int sch_no,
			 								      int court_cnt,
			 								      int current_cnt,
			 								      int court_max,
			 								      int court_price) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		event_code = event_code.replace(" " , "");
		String court_code = sch_no + event_code;
		String cc = court_code;
		Court court = new Court();
		court.setCourt_cnt(court_cnt);
		court.setCourt_max(court_max);
		court.setCourt_price(court_price);
		court.setEvent_code(event_code);
		court.setSch_no(sch_no);
		try {
			if (courtService.updateCourt(court) > 0) {};
			if (current_cnt == court_cnt) {} 
			else if (current_cnt < court_cnt) {
				for(int i = current_cnt + 1; i < court_cnt; i++) {
					if (i < 10) {
						court_code = cc + "0" + i;
					} else {
						court_code = cc + i;
					}
					court.setCourt_code(court_code);
					courtService.insert_court(court);
				}
			} else {
				for(int i = court_cnt + 1; i < current_cnt; i++) {
					if (i < 10) {
						court_code = cc + "0" + i;
					} else {
						court_code = cc + i;
					}
					courtService.removeCourt(court_code);
				}
			}
		} catch (Exception e) {
			resultMap.put("status", "failure");
			return resultMap;
		}
		
		return resultMap;
	}
	
}
