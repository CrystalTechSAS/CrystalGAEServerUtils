package jcrystal.apis.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by G on 10/13/2016.
 */
public class SimpleMailSenderAPI {
	
	public static InternetAddress GLOBAL_MAIL_SENDER;
	private final InternetAddress mailSender;
	
	public SimpleMailSenderAPI(InternetAddress mailSender) {
		this.mailSender = mailSender == null ? GLOBAL_MAIL_SENDER : mailSender; 
	}
	public SimpleMailSenderAPI() {
		this(null);
	}
	
	public void sendSimpleMail(String to, String name, String subject, String body) throws Exception{
		// [START simple_example]
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(mailSender);
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to, name));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			Transport.send(msg);
		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		} catch (UnsupportedEncodingException e) {
			// ...
		}
		// [END simple_example]
	}
}
