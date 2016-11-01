package java76.pms.controller.ajax;

import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.service.ReserveService;
import java76.pms.service.SchEventService;

@Controller("ajax.ReserveController")
@RequestMapping("/reserve/ajax/*")
public class ReserveController { 
	@Autowired ReserveService reserveService;
	@Autowired SchEventService schEventService;
	@Autowired ServletContext servletContext;
	
	@RequestMapping(value="reserveInfo", method=RequestMethod.POST)
	public String getEventList() throws Exception {
		return "/reserve/reserveInfo";
	}
	
	@RequestMapping(value="reserve", method=RequestMethod.POST)
	public Object doReserve(int m_no,
			                    String event_date,
			                    String court_code,
			                    String event_code,
			                    int user_cnt,
			                    int sch_num,
			                    String event_time
			                    ) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("m_no", m_no);
		paramMap.put("court_code", court_code);
		paramMap.put("event_date", event_date);
		paramMap.put("event_code", event_code);
		paramMap.put("sch_num", sch_num);
		paramMap.put("res_person", user_cnt);
		paramMap.put("res_pro", "예약완료");
		paramMap.put("event_time", event_time);
		System.out.println(event_time);
		try {
		  if (reserveService.doReserve(paramMap) > 0) {
			  	switch(event_time) {
				  	case "T6_8" :
				  		{schEventService.reserveT6_8(paramMap); break;}
				  	case "T8_10" :
				  		{schEventService.reserveT8_10(paramMap); break;}
				  	case "T10_12" :
				  		{schEventService.reserveT10_12(paramMap); break;}
				  	case "T12_14" : 
				  	  {schEventService.reserveT12_14(paramMap); break;}
				  	case "T14_16" :
				  		{schEventService.reserveT14_16(paramMap); break;}
				  	case "T16_18" :
				  	  {schEventService.reserveT16_18(paramMap); break;}
				  	case "T18_20" :
				  	  {schEventService.reserveT18_20(paramMap); break;}
				  	case "T20_22" :
				  	  {schEventService.reserveT20_22(paramMap); break;}
			  	}
		  }
		} catch(Exception e) {
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
}
