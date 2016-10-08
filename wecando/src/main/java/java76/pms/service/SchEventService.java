package java76.pms.service;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.SchEvent;

public interface SchEventService {
	List<SchEvent> schEventList();
	
	int createTime(HashMap<String, Object> paramMap);
}







