import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotificationManager implements NotificationManager{
	
	/**
	 * The email of the sender (the program is the sender)
	 */
	public static final String SENDER_EMAIL = "oodptest@gmail.com";
	/**
	 * The password used for the sender's email (the program is the sender)
	 */
	public static final String SENDER_PW = "OODPtest";
	@Override
	public void sendNotification(String recipient, String courseCode) {
		// TODO Auto-generated method stub
		
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(SENDER_EMAIL, SENDER_PW);
					}
				});

			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(SENDER_EMAIL));
				Student s = DataListManager.getStudent(recipient);
				String recipientEmail=s.getEmailID();
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(recipientEmail));
				message.setSubject("Waitlist notification");
				message.setText("You have been registered to " + courseCode);

				Transport.send(message);


			} catch (MessagingException e) {
				System.out.println("You are not connected to the internet!");
			}
	}

}
