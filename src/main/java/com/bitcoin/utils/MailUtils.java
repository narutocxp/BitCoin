package com.bitcoin.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * MailUtils
 * 
 * @author Lin
 * 
 */
public class MailUtils {

	private String smtpHost;
	private String username;
	private String password;

	/**
	 * 发送邮件
	 * 
	 * @param toMail
	 * @param subject
	 * @param text
	 */
	public boolean sendMailUtis(String toMail, String subject, String text) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", smtpHost);
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(username,
								password);
					}
				});
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			InternetAddress address = new InternetAddress(username);
			mimeMessage.setFrom(address);
			mimeMessage.addRecipient(Message.RecipientType.TO,
					new InternetAddress(toMail));
			mimeMessage.setSubject(subject);
			BodyPart mdp = new MimeBodyPart();
			mdp.setContent(text, "text/html;charset=gb2312");
			Multipart mm = new MimeMultipart();
			mm.addBodyPart(mdp);
			mimeMessage.setContent(mm);
			mimeMessage.saveChanges();
			// mimeMessage.setText(text);
			Transport.send(mimeMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
