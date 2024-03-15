package com.smtpmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

	public static void main(String[] args) {

		String to = "webamo8060@fryshare.com";
		String from = "habibur0199mhr@gmail.com";

		String host = "smtp.gmail.com";

		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		System.setProperty("mail.smtp.starttls.enable", "true");
		System.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//		System.setProperty("mail.smtp.ssl.ciphersuites", "TLS_AES_128_GCM_SHA256");
		
		Properties properties = System.getProperties();

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.ssl.enable", true);
		properties.put("mail.smtp.auth", true);
		

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, "zrqgcxpeokacrqvf");
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("Send from Habibur Rahman app");

			message.setText("Hello Friends how are you?");

			System.out.println("Sending Email...");
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
