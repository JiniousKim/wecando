package java76.pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Event;
import java76.pms.domain.SchEvent;
import java76.pms.service.EventService;
import java76.pms.service.SchEventService;
import java76.pms.service.SchoolService;

@Controller("ajax.InfoController")
@RequestMapping("/info/ajax/*")
public class InfoController { 
	@Autowired EventService eventService;
	@Autowired ServletContext servletContext;
	@Autowired SchEventService schEventService;
	@Autowired SchoolService	schoolService;
	
	@RequestMapping(value="eventList", method=RequestMethod.POST)
	public Object getEventList() throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<Event> eventList = eventService.getEventList();
			resultMap.put("eventList", eventList);
		} catch (Exception e) {
			return new AjaxResult("failure", null);
		}
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="eventList", method=RequestMethod.GET)
	public String get_EventList() {
		return "redirect:../../error.html";
	}
	
	@RequestMapping(value="search_gu", method=RequestMethod.POST)
	public Object schoolList(
		@RequestParam(defaultValue="")String event_code,
													String[] gu_list,
													String event_date,
		@RequestParam(defaultValue="1") int pageNum,
		@RequestParam(defaultValue="5") int pageSize) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", (pageNum - 1) * pageSize);
		paramMap.put("endIndex", (pageNum - 1) * pageSize + pageSize);
		paramMap.put("select_event_date", event_date);
		paramMap.put("event_code", event_code);
		List<SchEvent> schEventList = new ArrayList<>();
		
		for(String str : gu_list) {
			try {
				paramMap.put("gu_name", str);
				schEventList.addAll(schEventService.schEventList(paramMap));
			} catch (Exception e) {
				e.printStackTrace();
				resultMap.put("status", "failure");
				return resultMap;
			}
			resultMap.put("schEventList", schEventList);
		}
		System.out.println(schEventList);
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="AllschoolList", method=RequestMethod.POST)
	public Object AllschoolList() throws Exception {
		List<String> resultList	= schoolService.AllschoolList();
		return resultList;
	}
	
	@RequestMapping(value="search_sch", method=RequestMethod.POST)
	public Object search_sch(String sch_name,
													 String event_code,
													 String event_date) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("event_code", event_code);
		paramMap.put("event_date", event_date);
		try {
			int sch_num = schoolService.get_sch_num(sch_name);
			paramMap.put("sch_num", sch_num);
			List<SchEvent> schEventList = schEventService.searchSchEvent(paramMap);
			resultMap.put("schEventList", schEventList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		return resultMap;
	}
	
}
