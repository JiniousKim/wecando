package java76.pms.util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java76.pms.domain.Member;

public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public int doPost(Member member) 
			throws ServletException, IOException{
		String host = "smtp.gmail.com";
		String to = member.getM_email();
		String from = "daejinious@gmail.com";
		System.out.println("mailServlet" + member.getM_no());
		String subject = "Wecando 메일 가입 인증 절차";
		String content = "Wecando 메일 가입 인증 절차입니다.<br>"
				+ "아래 버튼을 클릭하여 계속 진행해 주시기 바랍니다.<br>"
				+ "<form action='http://localhost:8080/wecando/loginpage/choose_auth.html' method='post'>"
				+ "<input type='hidden' name='m_no' value='"
				+ member.getM_no() + "'>"
				+ "<input type='hidden' name='email_code' value='"
				+ member.getEmail_code() + "'>"
				+ "<input type='hidden' name='email_ava' value='"
				+ member.getEmail_ava() + "'>"
				+ "<button type='submit'>등록하러가기</button></form>";
		try{
			Properties props = new Properties();
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "465");
			props.put("mail.stmp.user", from);
			props.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from,"aunmzmasaakpmywi");
			}
			});
	
			Message msg = new MimeMessage(mailSession);
			
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(
					from, "UTF-8","B")));
			InternetAddress[] address1 = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address1);
			msg.setSubject(subject);
			msg.setSentDate(new java.util.Date());
			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
			
		}catch(MessagingException e) {
			return -1;
		}catch(Exception e){
			return -1;
		}
		return 0;
	}
}
