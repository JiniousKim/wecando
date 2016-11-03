package java76.pms.domain;

import java.io.Serializable;
import java.util.Date;

public class Reserve  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       res_no;
	protected int			  res_person;
	protected String    res_pro;
	protected Date    		res_date;
	protected int				m_no;
	protected String			m_email;
	protected	String			m_nick;
	protected String			court_code;
	protected String    	event_date;
	protected int				sch_num;
	protected String    	sch_location;
	protected String			sch_name;
	protected String			sch_tel;
	protected String			event_time;
	protected String			event_code;
	protected String    event_name;
	protected int    		court_price;
	
	public Reserve() {}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_code() {
		return event_code;
	}

	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}

	public int getSch_num() {
		return sch_num;
	}

	public void setSch_num(int sch_num) {
		this.sch_num = sch_num;
	}

	public String getSch_location() {
		return sch_location;
	}

	public void setSch_location(String sch_location) {
		this.sch_location = sch_location;
	}

	public String getSch_name() {
		return sch_name;
	}

	public void setSch_name(String sch_name) {
		this.sch_name = sch_name;
	}

	public String getSch_tel() {
		return sch_tel;
	}

	public void setSch_tel(String sch_tel) {
		this.sch_tel = sch_tel;
	}

	public String getEvent_time() {
		return event_time;
	}

	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}

	@Override
	public String toString() {
		return "Reserve [res_no=" + res_no + ", res_person=" + res_person + ", res_pro=" + res_pro + ", res_date="
		    + res_date + ", m_no=" + m_no + ", m_email=" + m_email + ", m_nick=" + m_nick + ", court_code=" + court_code
		    + ", event_date=" + event_date + ", sch_num=" + sch_num + ", sch_location=" + sch_location + ", sch_name="
		    + sch_name + ", sch_tel=" + sch_tel + ", event_time=" + event_time + ", event_code=" + event_code
		    + ", event_name=" + event_name + ", court_price=" + court_price + "]";
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	public String getCourt_code() {
		return court_code;
	}

	public void setCourt_code(String court_code) {
		this.court_code = court_code;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public int getCourt_price() {
		return court_price;
	}

	public void setCourt_price(int court_price) {
		this.court_price = court_price;
	}

	public int getRes_no() {
		return res_no;
	}

	public void setRes_no(int res_no) {
		this.res_no = res_no;
	}

	public int getRes_person() {
		return res_person;
	}

	public void setRes_person(int res_person) {
		this.res_person = res_person;
	}

	public String getRes_pro() {
		return res_pro;
	}

	public void setRes_pro(String res_pro) {
		this.res_pro = res_pro;
	}

	public Date getRes_date() {
		return res_date;
	}

	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}

}
