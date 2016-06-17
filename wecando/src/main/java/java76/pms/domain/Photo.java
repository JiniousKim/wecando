package java76.pms.domain;

import java.io.Serializable;

public class Photo  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int				photo_no;
	protected String			photo_name;
	protected Member			member;
	protected	Board			board;
	
	public Photo() {}

	public int getPhoto_no() {
		return photo_no;
	}

	public void setPhoto_no(int photo_no) {
		this.photo_no = photo_no;
	}

	public String getPhoto_name() {
		return photo_name;
	}

	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Photo [photo_no=" + photo_no + ", photo_name=" + photo_name + ", member=" + member + ", board=" + board
		    + "]";
	}
}
