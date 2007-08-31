package lsn.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class MailClient {
	static HashMap<Integer, String> gateways;

	static {
		gateways = new HashMap<Integer, String>();
		
		gateways.put(new Integer(1), "MDN@messaging.sprintpcs.com");
		gateways.put(new Integer(2), "MDN@vtext.com");
		gateways.put(new Integer(3), "MDN@txt.att.net");
		gateways.put(new Integer(4), "MDN@tmomail.net");
		gateways.put(new Integer(5), "MDN@message.alltel.com");
	}

	String generateAddress(String mdn, int carrier) {
		return gateways.get(new Integer(carrier)).replaceFirst("MDN", mdn);
	}

	public void sendSMS(String mdn, int carrier, String from, String message) {
		String to_email = generateAddress(mdn, carrier);
		System.out.println(to_email);

		postMail(to_email, "", message, from);
	}

	public void postMail(String recip, String subj, String mess, String from) {
		try {
			Properties props = new Properties();
			props.put("mail.host", "mail20.wavemarket.com");

			Session conn = Session.getInstance(props, null);
			javax.mail.Message msg = new MimeMessage(conn);
	
			Address addr_to = new InternetAddress(recip);
			Address addr_from = new InternetAddress(from);

			msg.setContent(mess, "text/plain");
			msg.setFrom(addr_from);
			msg.setRecipient(javax.mail.Message.RecipientType.TO, addr_to);
			msg.setSubject(subj);
	
			Transport.send(msg);
		} catch(MessagingException me) { System.out.println(me.getMessage()); }
	}
}
