package java76.pms.domain;

import java.io.Serializable;
import java.util.Date;

public class Reserve  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       res_no;
	protected int			  res_person;
	protected String    res_pro;
	protected Date    		res_date;
	protected Member			member;
	protected Event			event;
	protected Court			court;
	protected SchEvent		schevent;
	
	public Reserve() {}

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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	public SchEvent getSchevent() {
		return schevent;
	}

	public void setSchevent(SchEvent schevent) {
		this.schevent = schevent;
	}

	@Override
	public String toString() {
		return "Reserve [res_no=" + res_no + ", res_person=" + res_person + ", res_pro=" + res_pro + ", res_date="
		    + res_date + ", member=" + member + ", event=" + event + ", court=" + court + ", schevent=" + schevent + "]";
	}
}
