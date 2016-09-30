package java76.pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.SchEventDao;
import java76.pms.domain.SchEvent;
import java76.pms.service.SchEventService;

@Service
public class DefaultSchEventService implements SchEventService {
	@Autowired SchEventDao schEventDao;
	
	public List<SchEvent> schEventList(String event_code) {
		return schEventDao.schEventList(event_code);
	}
}







