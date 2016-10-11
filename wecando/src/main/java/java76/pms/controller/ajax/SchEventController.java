package java76.pms.controller.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java76.pms.domain.AjaxResult;
import java76.pms.domain.SchEvent;
import java76.pms.service.CourtService;
import java76.pms.service.SchEventService;
import java76.pms.util.TimeTable;

@Controller("ajax.SchEventController")
@RequestMapping("/schevent/ajax/*")
public class SchEventController { 
	@Autowired SchEventService schEventService;
	@Autowired CourtService courtService;
	@Autowired ServletContext servletContext;
	
	@Scheduled(cron="0 0 0 * * 0/6")
	public void init(){
		System.out.println("run => " + schEventService);
		HashMap<String, Object> paramMap = new HashMap<>();
		if (schEventService != null) {
			List<String> resultList = courtService.courtcodeList();
			String date = new TimeTable().getTime();
			
			try {
				for(String court_code : resultList) {
					paramMap.put("event_date", date);
					paramMap.put("court_code", court_code);
					schEventService.createTime(paramMap);
				}
			} catch (Exception e) {
				
			}
		}
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public Object schEventList (
			@RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="10") int pageSize,
      @RequestParam(defaultValue="서울시") String keyword,
      @RequestParam(defaultValue="soccer")String event_code) throws Exception {
		List<SchEvent> resultList = new ArrayList<SchEvent>();
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> resultMap = new HashMap<>();
		paramMap.put("startIndex", (pageNo - 1) * pageSize);
		paramMap.put("pageNum", pageNo);
		paramMap.put("pageSize", pageSize);
		paramMap.put("keyword", keyword);
		paramMap.put("event_code", event_code);
		
		int list_cnt = schEventService.schEventCnt();
		
		try {
			resultList = schEventService.schEventList(paramMap);	
		} catch (Exception e) {
			return new AjaxResult("failure", null);
		}
		resultMap.put("cnt", list_cnt);
		resultMap.put("resultList", resultList);
		resultMap.put("status", "success");
		return resultMap;
	}
	
	
}
