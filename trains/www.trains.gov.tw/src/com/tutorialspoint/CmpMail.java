
package com.tutorialspoint;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class CmpMail {
	private String errorMsg = null;

	public String getErrorMsg() {
		return errorMsg;
	}

	public boolean sendText(String mailserver, int port, String frommail, String mailpwd, String tomail, String ccmail,
			String bccmail, String subject, String body) {
		try {
			boolean sessionDebug = false;

			// Get system properties
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", mailserver); // 指定SMTP server
			prop.put("mail.transport.protocol", "smtp"); // 設定傳送協定
			prop.put("mail.smtp.auth", "true"); // 設定是否須smtp驗證
			prop.put("mail.smtp.port", port);

			// 產生新的Session
			javax.mail.Session mailsess = Session.getDefaultInstance(prop, null);
			mailsess.setDebug(sessionDebug); // 是否在控制台顯示debug訊息

			MimeMessage msg = new MimeMessage(mailsess);

			// 設定郵件
			msg.setFrom(new InternetAddress(frommail)); // 設定傳送郵件的發信人

			// 設定傳送郵件的收件者
			InternetAddress[] address = null;
			if (getAddress(tomail) != null) {
				address = getAddress(tomail);
			}
			msg.setRecipients(Message.RecipientType.TO, address);

			// 設定傳送郵件的副本收件者
			if (ccmail != null && !ccmail.equals("null") && !ccmail.equals("")) {
				InternetAddress[] ccaddress = getAddress(ccmail);
				msg.setRecipients(Message.RecipientType.CC, ccaddress);
			}

			// 設定傳送郵件的密件副本收件者
			if (bccmail != null && !bccmail.equals("null") && !bccmail.equals("")) {
				InternetAddress[] bccaddress = getAddress(bccmail);
				msg.setRecipients(Message.RecipientType.BCC, bccaddress);
			}

			msg.setSubject(subject, "UTF-8"); // 設定主題
			msg.setText(body, "UTF-8"); // 設定內文
			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());

			Transport transport = mailsess.getTransport("smtp"); // 只支持IMAP、
																	// SMTP和
																	// POP3
			transport.connect(mailserver, port, frommail, mailpwd); // 以smtp的方式登入mail
																	// server
			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();
			return true;

		} catch (SendFailedException e) {
			errorMsg = "郵件傳送失敗(SendFailedException):" + e.toString();
		} catch (MessagingException e) {
			errorMsg = "郵件傳送失敗(MessagingException):" + e.toString();
		} catch (Exception e) {
			errorMsg = "郵件傳送失敗(Exception):" + e.toString();
		}
		return false;
	}

	public boolean sendHtml(String mailserver, int port, String frommail, String mailpwd, String tomail, String ccmail,
			String bccmail, String subject, String body) {
		boolean sessionDebug = true;

		try {

			// Get system properties
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", mailserver); // 指定SMTP server
			prop.put("mail.transport.protocol", "smtp"); // 設定傳送協定
			prop.put("mail.smtp.auth", "true"); // 設定是否須smtp驗證
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.port", port);

			// 產生新的Session
			javax.mail.Session mailsess = Session.getDefaultInstance(prop, null);

			mailsess.setDebug(sessionDebug); // 是否在控制台顯示debug訊息

			MimeMessage msg = new MimeMessage(mailsess);
			// 設定郵件
			msg.setFrom(new InternetAddress(frommail)); // 設定傳送郵件的發信人

			// 設定傳送郵件的收件者
			InternetAddress[] address = null;
			if (getAddress(tomail) != null) {
				address = getAddress(tomail);
			}
			msg.setRecipients(Message.RecipientType.TO, address);

			// 設定傳送郵件的副本收件者
			if (ccmail != null && !ccmail.equals("null") && !ccmail.equals("")) {
				InternetAddress[] ccaddress = getAddress(ccmail);
				msg.setRecipients(Message.RecipientType.CC, ccaddress);
			}

			// 設定傳送郵件的密件副本收件者
			if (bccmail != null && !bccmail.equals("null") && !bccmail.equals("")) {
				InternetAddress[] bccaddress = getAddress(bccmail);
				msg.setRecipients(Message.RecipientType.BCC, bccaddress);
			}

			msg.setSubject(subject, "UTF-8"); // 設定主題
			// 內容
			BodyPart mdp = new MimeBodyPart();
			mdp.setContent(body, "text/html;charset=UTF-8"); // HTML
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mdp);
			msg.setContent(mp);

			msg.setHeader("X-Mailer", "LOTONtechEmail");
			msg.setSentDate(new Date());

			Transport transport = mailsess.getTransport("smtp"); // 只支持IMAP、
																	// SMTP和
																	// POP3
			transport.connect(mailserver, port, frommail, mailpwd); // 以smtp的方式登入mail
																	// server
			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

		} catch (SendFailedException e) {
			sessionDebug = false;
			errorMsg = "郵件傳送失敗(SendFailedException):" + e.toString();
		} catch (MessagingException e) {
			sessionDebug = false;
			errorMsg = "郵件傳送失敗(MessagingException):" + e.toString();
		} catch (Exception e) {
			sessionDebug = false;
			errorMsg = "郵件傳送失敗(Exception):" + e.toString();
		}
		return sessionDebug;
	}

	private InternetAddress[] getAddress(String mails) throws AddressException {
		if (mails == null || mails.equals("")) {
			return null;
		}

		String[] mailAddrList = mails.split(",");
		InternetAddress[] mailAddrs = new InternetAddress[mailAddrList.length];
		for (int i = 0; i < mailAddrList.length; i++) {
			mailAddrs[i] = new InternetAddress(mailAddrList[i]);
		}
		return mailAddrs;
	}
}
