package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.SchEvent;

public interface SchEventDao {
	List<SchEvent> schEventList();
	
	int createTime(HashMap<String, Object> paramMap);
}







