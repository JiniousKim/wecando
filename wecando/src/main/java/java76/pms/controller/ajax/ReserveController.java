package java76.pms.controller.ajax;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.service.ReserveService;

@Controller("ajax.ReserveController")
@RequestMapping("/reserve/ajax/*")
public class ReserveController { 
	@Autowired ReserveService reserveService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="reserveInfo", method=RequestMethod.POST)
	public String getEventList() throws Exception {
		return "/reserve/reserveInfo";
	}
	
	@RequestMapping(value="eventList", method=RequestMethod.GET)
	public String get_EventList() {
		return "redirect:../../error.html";
	}
}
