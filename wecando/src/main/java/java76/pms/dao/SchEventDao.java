package java76.pms.dao;

import java.util.List;

import java76.pms.domain.SchEvent;

public interface SchEventDao {
	List<SchEvent> schEventList(String event_code);
}







