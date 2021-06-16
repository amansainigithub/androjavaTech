package com.androjava.helper;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.androjava.entity.ContactForm;

public class SendEmail {
	
public static boolean sendEmail(ContactForm data, String to) {
	
		//Variable for G-mail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		properties.put("authentication", "plain");
		properties.put("domain", "gmail.com");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("pixcarry@gmail.com", "nzljmqnxbgvpgwfe");
			}});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
			
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress("pixcarry@gmail.com"));
		
		//adding subject to message
		m.setSubject(data.getName()+" "+data.getLastName());
		
		String content="<h2>QUERY : AndrojavaTech4u</h2>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "<table style=\"width:100%;border: 1px solid black;\">\r\n"
				+ "  <tr style=\"border: 1px solid black;\">\r\n"
				+ "    <th style=\"border: 1px solid black;\">Firstname</th>\r\n"
				+ "    <th style=\"border: 1px solid black;\">Lastname</th> \r\n"
				+ "    <th style=\"border: 1px solid black;\">Course</th>\r\n"
				+ "     <th style=\"border: 1px solid black;\">Email</th>\r\n"
				+ "     <th style=\"border: 1px solid black;\">mobile</th>\r\n"
				+ "  </tr>\r\n"
				+ "  <tr>\r\n"
				+ "    <td style=\"border: 1px solid black;\">"+data.getName()+"</td>\r\n"
				+ "    <td style=\"border: 1px solid black;\">"+data.getLastName()+"</td>\r\n"
				+ "    <td style=\"border: 1px solid black;\">"+data.getCourse()+"</td>\r\n"
				+ "    <td style=\"border: 1px solid black;\">"+data.getEmail()+"</td>\r\n"
				+ "    <td style=\"border: 1px solid black;\">"+data.getMobile() +"</td>\r\n"
				+ "  </tr>\r\n"
				+ " \r\n"
				+ "</table>"
				;
		
		//adding text to message
		 m.setContent(content, "text/html");
		 m.setSentDate(new Date());
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		return true;
		
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
	}

}
