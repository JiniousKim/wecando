package java76.pms.controller.ajax;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.Reserve;
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
	
	@RequestMapping(value="doReserve", method=RequestMethod.POST)
	public Object doReserve(int m_no,
			                    String event_date,
			                    String court_code,
			                    String event_code,
			                    int user_cnt,
			                    int sch_num,
			                    String event_time
			                    ) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> updateMap = new HashMap<>();
		paramMap.put("m_no", m_no);
		paramMap.put("court_code", court_code);
		paramMap.put("event_date", event_date);
		paramMap.put("event_code", event_code);
		paramMap.put("sch_num", sch_num);
		paramMap.put("res_person", user_cnt);
		paramMap.put("res_pro", "예약완료");
		paramMap.put("event_time", event_time);
		try {
		  if (reserveService.doReserve(paramMap) > 0) {
		  	  updateMap.put("event_date", event_date);
		  	  updateMap.put("court_code", court_code);
		  	  updateMap.put("time", "1");
			  	switch(event_time) {
				  	case "T6_8" :
				  		{schEventService.reserveT6_8(updateMap); break;}
				  	case "T8_10" :
				  		{schEventService.reserveT8_10(updateMap); break;}
				  	case "T10_12" :
				  		{schEventService.reserveT10_12(updateMap); break;}
				  	case "T12_14" : 
				  	  {schEventService.reserveT12_14(updateMap); break;}
				  	case "T14_16" :
				  		{schEventService.reserveT14_16(updateMap); break;}
				  	case "T16_18" :
				  	  {schEventService.reserveT16_18(updateMap); break;}
				  	case "T18_20" :
				  	  {schEventService.reserveT18_20(updateMap); break;}
				  	case "T20_22" :
				  	  {schEventService.reserveT20_22(updateMap); break;}
			  	}
		  }
		} catch(Exception e) {
			e.printStackTrace();
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
	
	@RequestMapping(value="reserveInfoList", method=RequestMethod.POST)
	public Object reserveInfo(int m_no) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<Reserve> reserveList = reserveService.reserveInfoList(m_no);
			System.out.println(reserveList);
			resultMap.put("reserveList", reserveList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "failure");
			return resultMap;
		}
		
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="ClientReserveList", method=RequestMethod.POST)
	public Object ClientReserveList(int m_no) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<Reserve> reserveList = reserveService.ClientReserveList(m_no);
			resultMap.put("reserveList", reserveList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		return resultMap;
	}
	
	@RequestMapping(value="cancleReserve", method=RequestMethod.POST)
	public Object cancleReserve(int res_no,
														  int m_no,
														  String event_date,
														  String court_code,
														  String event_time) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> updateMap = new HashMap<>();
		paramMap.put("res_no", res_no);
		paramMap.put("m_no", m_no);
		try {
			Reserve reserve = reserveService.getReserve(res_no);
			if (reserveService.cancleReserve(paramMap) > 0) {
				updateMap.put("event_date", reserve.getEvent_date());
		  	  updateMap.put("court_code", reserve.getCourt_code());
		  	  updateMap.put("time", "0");
			  	switch(reserve.getEvent_time()) {
				  	case "T6_8" :
				  		{schEventService.cancleT6_8(updateMap); break;}
				  	case "T8_10" :
				  		{schEventService.cancleT8_10(updateMap); break;}
				  	case "T10_12" :
				  		{schEventService.cancleT10_12(updateMap); break;}
				  	case "T12_14" : 
				  	  {schEventService.cancleT12_14(updateMap); break;}
				  	case "T14_16" :
				  		{schEventService.cancleT14_16(updateMap); break;}
				  	case "T16_18" :
				  	  {schEventService.cancleT16_18(updateMap); break;}
				  	case "T18_20" :
				  	  {schEventService.cancleT18_20(updateMap); break;}
				  	case "T20_22" :
				  	  {schEventService.cancleT20_22(updateMap); break;}
			  	}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResult("failure", null);
		}
		
		return new AjaxResult("success", null);
	}
	
	@RequestMapping(value="reserveLastList", method=RequestMethod.POST)
	public Object reserveLastList(int m_no) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<>();
		try {
			List<Reserve> reserveList = reserveService.reserveLastList(m_no);
			resultMap.put("reserveList", reserveList);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("status", "failure");
			return resultMap;
		}
		resultMap.put("status", "success");
		return resultMap;
	}
}
