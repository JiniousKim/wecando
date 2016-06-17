package java76.pms.domain;

import java.io.Serializable;

public class School  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       sch_no;
	protected String    sch_name;
	protected String		  sch_location;
  protected String 		sch_tel;
  protected Member			member;
  
	public School() {}

	public int getSch_no() {
		return sch_no;
	}

	@Override
	public String toString() {
		return "School [sch_no=" + sch_no + ", sch_name=" + sch_name + ", sch_location=" + sch_location + ", sch_tel="
		    + sch_tel + ", member=" + member + "]";
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

	public String getSch_location() {
		return sch_location;
	}

	public void setSch_location(String sch_location) {
		this.sch_location = sch_location;
	}

	public String getSch_tel() {
		return sch_tel;
	}

	public void setSch_tel(String sch_tel) {
		this.sch_tel = sch_tel;
	}
	
	
}
