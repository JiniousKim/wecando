package java76.pms.domain;

import java.io.Serializable;

public class Reply  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int				reply_no;
	protected	String			reply_content;
	protected	Board			board;
	protected	Member			member;
	
	public Reply() {}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Reply [reply_no=" + reply_no + ", reply_content=" + reply_content + ", board=" + board + ", member="
		    + member + "]";
	}
}
