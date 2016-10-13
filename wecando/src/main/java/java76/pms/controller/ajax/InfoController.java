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
	
	@RequestMapping(value="schoolList", method=RequestMethod.POST)
	public Object schoolList(String event_code) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		
		return resultMap;
	}
	
	@RequestMapping(value="AllschoolList", method=RequestMethod.POST)
	public Object AllschoolList() throws Exception {
		List<String> resultList	= schoolService.AllschoolList();
		System.out.println(resultList);
		return resultList;
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public Object schEventList (
			@RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="서울시") String keyword) throws Exception {
		List<SchEvent> resultList = new ArrayList<SchEvent>();
		HashMap<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("pageNum", pageNo);
		paramMap.put("pageSize", pageSize);
		paramMap.put("keyword", keyword);
		
		try {
			resultList = schEventService.schEventList(paramMap);	
		} catch (Exception e) {
			return new AjaxResult("failure", null);
		}
		
		return resultList;
	}
	
	@RequestMapping(value="search_sch", method=RequestMethod.POST)
	public Object search_sch(String sch_name,
													 String event_code,
													 String event_date,
													 int sch_num) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		HashMap<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("event_code", event_code);
		paramMap.put("event_date", event_date);
		try {
			sch_num = schoolService.get_sch_num(sch_name);
			paramMap.put("sch_num", sch_num);
			SchEvent schEvent = schEventService.searchSchEvent(paramMap);
			resultMap.put("schEvent", schEvent);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		return resultMap;
	}
	
}
