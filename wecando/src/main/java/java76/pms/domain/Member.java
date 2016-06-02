package java76.pms.domain;

import java.io.Serializable;

public class Member  implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int       m_no;
	protected int			  m_grade;
	protected String    m_email;
	protected String    m_name;
	protected String		  m_tel;
  protected String 		m_password;
	protected int				m_ava;
	protected String			m_nick;
	protected	String			email_code;
	protected	String			email_ava;

	public Member() {}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public int getM_grade() {
		return m_grade;
	}

	public void setM_grade(int m_grade) {
		this.m_grade = m_grade;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public int getM_ava() {
		return m_ava;
	}

	public void setM_ava(int m_ava) {
		this.m_ava = m_ava;
	}

	public String getEmail_code() {
		return email_code;
	}

	public void setEmail_code(String email_code) {
		this.email_code = email_code;
	}

	public String getEmail_ava() {
		return email_ava;
	}

	public void setEmail_ava(String email_ava) {
		this.email_ava = email_ava;
	}

	public String getM_nick() {
		return m_nick;
	}

	public void setM_nick(String m_nick) {
		this.m_nick = m_nick;
	}

	@Override
	public String toString() {
		return "Member [m_no=" + m_no + ", m_grade=" + m_grade + ", m_email=" + m_email + ", m_name=" + m_name + ", m_tel="
		    + m_tel + ", m_password=" + m_password + ", m_ava=" + m_ava + ", m_nick=" + m_nick + ", email_code="
		    + email_code + ", email_ava=" + email_ava + "]";
	}

	
}
