package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Event;

public interface EventDao {
  List<Event> getEventList();
  Event getEvent(String event_code);
}







