package java76.pms.domain;

import java.io.Serializable;
import java.util.Date;

public class Board  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       board_no;
	protected String    board_content;
	protected String    board_password;
	protected Date				board_date;
	protected Member			member;
	protected School			school;
	
	public Board() {}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_password() {
		return board_password;
	}

	public void setBoard_password(String board_password) {
		this.board_password = board_password;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Board [board_no=" + board_no + ", board_content=" + board_content + ", board_password=" + board_password
		    + ", board_date=" + board_date + ", member=" + member + ", school=" + school + "]";
	}
}
