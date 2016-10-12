package java76.pms.dao;

import java.util.HashMap;
import java.util.List;

import java76.pms.domain.SchEvent;

public interface SchEventDao {
	List<SchEvent> schEventList(HashMap<String, Object> paramMap);
	int schEventCnt();
	int createTime(HashMap<String, Object> paramMap);
	SchEvent searchSchEvent(HashMap<String, Object> paramMap);
}







