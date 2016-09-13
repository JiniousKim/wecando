package java76.pms.domain;

import java.io.Serializable;

public class Court  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String    court_code;
	protected int       court_cnt;
	protected int       court_price;
	protected int       court_max;
	protected int       sch_no;
	protected String    event_code;
	protected String    event_name;
	
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

	public int getCourt_price() {
		return court_price;
	}

	public void setCourt_price(int court_price) {
		this.court_price = court_price;
	}

	public int getCourt_max() {
		return court_max;
	}

	public void setCourt_max(int court_max) {
		this.court_max = court_max;
	}

	public int getSch_no() {
		return sch_no;
	}

	public void setSch_no(int sch_no) {
		this.sch_no = sch_no;
	}

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
		return "Court [court_code=" + court_code + ", court_cnt=" + court_cnt + ", court_price=" + court_price
		    + ", court_max=" + court_max + ", sch_no=" + sch_no + ", event_code=" + event_code + ", event_name="
		    + event_name + "]";
	}

}
