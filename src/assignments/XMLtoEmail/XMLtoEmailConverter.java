package assignments.XMLtoEmail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

interface InvoiceEmail {
	public void sendEmail(String recepientEmail, String filePath);
}

public class XMLtoEmailConverter implements InvoiceEmail {
	@Override
	public void sendEmail(String recepientEmail, String filePath) {
		final String host = "smtp.gmail.com";
		final int port = 587;
		final String senderEmail = "YOUR_EMAIL_ID";
		final String password = "YOUR_PASSWORD";
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		
		Session session = Session.getInstance(properties, 
			new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmail, password);
				}
		});
		
		try {
			Date date = new Date();
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recepientEmail));
			message.setSubject("Invoice");
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Please find attached your purchase invoice.");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Invoice");
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);
			
			Transport.send(message);
			
			System.out.println("Sent message successfully.");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}