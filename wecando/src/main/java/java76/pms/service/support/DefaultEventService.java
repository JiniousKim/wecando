package java76.pms.service.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java76.pms.dao.EventDao;
import java76.pms.domain.Event;
import java76.pms.service.EventService;

@Service
public class DefaultEventService implements EventService {
  @Autowired EventDao eventDao;

  public List<Event> getEventList() {
    return eventDao.getEventList();
  }
  
  public Event getEvent(String event_code) {
  		return eventDao.getEvent(event_code);
  }
  
  public String getEventName(String event_code) {
  	  return eventDao.getEventName(event_code);
  }
}







