package java76.pms.domain;

import java.io.Serializable;

public class Court  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String    court_code;
	protected int       court_cnt;
	protected Event			event;
	protected School 		school;
	
	public Court() {}

	public String getCourt_code() {
		return court_code;
	}

	public void setCourt_code(String court_code) {
		this.court_code = court_code;
	}

	public int getCourt_cnt() {
		return court_cnt;
	}

	public void setCourt_cnt(int court_cnt) {
		this.court_cnt = court_cnt;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Court [court_code=" + court_code + ", court_cnt=" + court_cnt + ", event=" + event + ", school=" + school
		    + "]";
	}

	
}
