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
import java76.pms.domain.Court;
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
	
	//@Scheduled(cron="0 0 0 * * 0/6")
	@Scheduled(cron="0 50 04 * * ?")
	public void init(){
		System.out.println("run => " + schEventService);
		HashMap<String, Object> paramMap = new HashMap<>();
		if (schEventService != null) {
			List<Court> resultList = courtService.courtcodeList();
			String date = new TimeTable().getTime();
			date = "2016-11-06";
			
			try {
				for(Court court : resultList) {
					paramMap.put("event_date", date);
					paramMap.put("court_code", court.getCourt_code());
					paramMap.put("evnet_code", court.getEvent_code());
					paramMap.put("sch_no", court.getSch_no());
					schEventService.createTime(paramMap);
					continue;
				}
			} catch (Exception e) {
				
			}
		}
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public Object schEventList (
			@RequestParam(defaultValue="1") int pageNum,
      @RequestParam(defaultValue="5") int pageSize,
      String keyword, String event_code) throws Exception {
		List<SchEvent> resultList = new ArrayList<SchEvent>();
		HashMap<String, Object> paramMap = new HashMap<>();
		HashMap<String, Object> resultMap = new HashMap<>();
		paramMap.put("keyword", keyword);
		paramMap.put("event_code", event_code);
		int startIndex = (pageNum - 1) * pageSize;
		int endIndex = (pageNum - 1) * pageSize + pageSize;
		
		try {
			resultList = schEventService.schEventList(paramMap);
			List<SchEvent> result = new ArrayList<>();
			int total = resultList.size();
			if ((total - endIndex) > 0) {
				for (int i = startIndex; i < endIndex; i++) {
					result.add(resultList.get(i));
				}
			} else {
				for (int i = startIndex; i < total; i++) {
					result.add(resultList.get(i));
				}
			}
			resultMap.put("resultList", result);
		} catch (Exception e) {
			return new AjaxResult("failure", null);
		}
		resultMap.put("status", "success");
		return resultMap;
	}
	
	
}
