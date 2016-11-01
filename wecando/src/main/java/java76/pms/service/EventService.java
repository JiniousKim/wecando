package java76.pms.service;

import java.util.List;

import java76.pms.domain.Event;

public interface EventService {
  List<Event> getEventList();
  Event getEvent(String event_code);
  String getEventName(String event_code);
}







