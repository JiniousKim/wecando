package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Event;

public interface EventDao {
  List<String> getEventList();
  Event getEvent(String event_code);
}







