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

@Controller("ajax.EventController")
@RequestMapping("/event/ajax/*")
public class EventController { 
	@Autowired EventService eventService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="eventList", method=RequestMethod.POST)
	public Object getEventList() throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<String> eventList = eventService.getEventList();
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
	
	
	@RequestMapping(value="getEvent", method=RequestMethod.POST)
	public Object getEvent(String event_code) {
		HashMap<String, Object> resultMap = new HashMap<>();
		try{
			Event event = eventService.getEvent(event_code);
			resultMap.put("event", event);
		} catch (Exception e) {
			return new AjaxResult("failure", null);
		}
		
		resultMap.put("status", "success");
		return resultMap;
	}
	@RequestMapping(value="getEvent", method=RequestMethod.GET)
	public String get_getEvent() {
		return "redirect:../../error.html";
	}
}
