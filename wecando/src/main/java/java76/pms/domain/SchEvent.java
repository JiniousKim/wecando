package java76.pms.domain;

import java.io.Serializable;

public class SchEvent  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected String				event_date;
	protected String 			T6_8;
	protected String 			T8_10;
	protected String 			T10_12;
	protected String 			T12_14;
	protected String 			T14_16;
	protected String 			T16_18;
	protected String 			T18_20;
	protected String 			T20_22;
  protected String   		event_code;
  protected String				court_code;
  protected int					sch_no;
  protected String				sch_location;
  protected String				sch_name;

  
  public String getSch_location() {
		return sch_location;
	}


	public void setSch_location(String sch_location) {
		this.sch_location = sch_location;
	}

	
	public String getEvent_code() {
		return event_code;
	}


	public void setEvent_code(String event_code) {
		this.event_code = event_code;
	}


	public String getCourt_code() {
		return court_code;
	}


	public void setCourt_code(String court_code) {
		this.court_code = court_code;
	}

	public int getSch_no() {
		return sch_no;
	}


	public void setSch_no(int sch_no) {
		this.sch_no = sch_no;
	}


	public String getSch_name() {
		return sch_name;
	}


	public void setSch_name(String sch_name) {
		this.sch_name = sch_name;
	}


	@Override
	public String toString() {
		return "SchEvent [schevent_date=" + event_date + ", T6_8=" + T6_8 + ", T8_10=" + T8_10 + ", T10_12=" + T10_12
		    + ", T12_14=" + T12_14 + ", T14_16=" + T14_16 + ", T16_18=" + T16_18 + ", T18_20=" + T18_20 + ", T20_22="
		    + T20_22 + ", event_code=" + event_code + ", court_code=" + court_code + ", sch_location=" + sch_location
		    + ", sch_name=" + sch_name + "]";
	}


	public String getEvent_date() {
		return event_date;
	}


	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}


	public String getT6_8() {
		return T6_8;
	}


	public void setT6_8(String t6_8) {
		T6_8 = t6_8;
	}


	public String getT8_10() {
		return T8_10;
	}


	public void setT8_10(String t8_10) {
		T8_10 = t8_10;
	}


	public String getT10_12() {
		return T10_12;
	}


	public void setT10_12(String t10_12) {
		T10_12 = t10_12;
	}


	public String getT12_14() {
		return T12_14;
	}


	public void setT12_14(String t12_14) {
		T12_14 = t12_14;
	}


	public String getT14_16() {
		return T14_16;
	}


	public void setT14_16(String t14_16) {
		T14_16 = t14_16;
	}


	public String getT16_18() {
		return T16_18;
	}


	public void setT16_18(String t16_18) {
		T16_18 = t16_18;
	}


	public String getT18_20() {
		return T18_20;
	}


	public void setT18_20(String t18_20) {
		T18_20 = t18_20;
	}


	public String getT20_22() {
		return T20_22;
	}


	public void setT20_22(String t20_22) {
		T20_22 = t20_22;
	}

	public SchEvent() {}
}
