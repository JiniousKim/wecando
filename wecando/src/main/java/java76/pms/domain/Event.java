package java76.pms.domain;

import java.io.Serializable;

public class Event  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String    event_code;
	protected String		  event_name;
	protected int       event_price;
	protected int				event_max;
	
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

	public int getEvent_price() {
		return event_price;
	}

	public void setEvent_price(int event_price) {
		this.event_price = event_price;
	}

	public int getEvent_max() {
		return event_max;
	}

	public void setEvent_max(int event_max) {
		this.event_max = event_max;
	}

	@Override
	public String toString() {
		return "Event [event_code=" + event_code + ", event_name=" + event_name + ", event_price=" + event_price
		    + ", event_max=" + event_max + "]";
	}

	
}
