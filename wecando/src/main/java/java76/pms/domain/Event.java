package java76.pms.domain;

import java.io.Serializable;

public class Event  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String    event_code;
	protected String		  event_name;
	
	public Event() {}

	public String getEvent_code() {
		return event_code;
	}

	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	@Override
	public String toString() {
		return "Event [event_code=" + event_code + ", event_name=" + event_name + "]";
	}

	
}
