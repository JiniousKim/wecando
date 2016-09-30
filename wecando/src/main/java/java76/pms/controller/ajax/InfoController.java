package java76.pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Event;
import java76.pms.service.EventService;
import java76.pms.service.SchEventService;

@Controller("ajax.InfoController")
@RequestMapping("/info/ajax/*")
public class InfoController { 
	@Autowired EventService eventService;
	@Autowired ServletContext servletContext;
	@Autowired SchEventService schEventService;
	
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
	
	
}
