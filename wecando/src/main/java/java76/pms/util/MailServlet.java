package java76.pms.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java76.pms.domain.Member;

public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SMTP_HOST = "localhost";
	
	public void doPost(Member member) 
			throws ServletException, IOException{
		String to = member.getM_email();
		String from = "localhost@wecando.com";
		String subject = "Wecando 메일 가입 인증 절차";
		String content = "Wecando 메일 가입 인증 절차입니다.\n"
				+ "아래 링크를 클릭하여 계속 진행해 주시기 바랍니다.\n"
				+ "http://localhost:8080/wecando/choose_auth?m_no="
				+ member.getM_no() + "&email_code"
				+ member.getEmail_code();
		Properties props = new Properties();
		props.put("mail.host", SMTP_HOST);
		try{
			Session session= Session.getDefaultInstance(props);
			Message ms = new MimeMessage(session);
			ms.setFrom(new InternetAddress(from)); 
			ms.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); 
			ms.setSubject(new String(subject.getBytes("8859_1"), "KSC5601")); 
			ms.setContent(content, "text/plain");
			Transport.send(ms);
		}catch(Exception e){
		}finally{
		}
	}
}
