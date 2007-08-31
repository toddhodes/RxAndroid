package lsn.facebook;

import lsn.util.*;
import lsn.persist.*;
import java.util.*;
import java.util.regex.*;

public class ProcessFacebook {
	public static final String FromRegex = "^(\\d+)@";
	public static final String SubjRegex = "(\\d+)";

	String getMdn(Message m) {
		Pattern pattern = Pattern.compile(FromRegex);
		Matcher matcher = pattern.matcher(m.getField("From"));
		if (matcher.find()) return matcher.group(1);

		pattern = Pattern.compile(SubjRegex);
		matcher = pattern.matcher(m.getField("Subject"));
		if (matcher.find()) return matcher.group(1);

		return null;
	}

	void sendText(Facebook fb, Account acct) {
		String text = fb.generateText(acct);

		MailClient mc = new MailClient();
		mc.sendSMS(acct.getMdn(), acct.getCarrier(), 
							 "lsn@mail20.wavemarket.com", text);
	}

	String processBody(Facebook fb, Account acct, String in) {
		Pattern pattern = Pattern.compile("^\\?(\\S*)\\s+(.*)$");
		Matcher matcher = pattern.matcher(in);
		if (matcher.find()) {
			sendText(fb, acct);
			return matcher.group(2);
		} 

		return in;
	}

	public void processMessage(Message m) {
		System.out.println("received SMS from: " + m.getField("From"));

		String mdn = getMdn(m);
		if (mdn == null) {
			System.out.println("could not find MDN");
			return;
		}

		Account account = Account.queryByMdn(mdn);
		if (account == null) {
			System.out.println("cound not find account");
			return;
		}

		Facebook fb = new Facebook();
		String body = processBody(fb, account, m.getField("Body"));

		account.setLocation(body);
		account.setLocationUpdated(new Date());
		try {
			account.update();
		} catch(Exception e) { System.out.println(e.getMessage()); }


		String f = fb.generateSingleFbml(account);
		fb.setFBML(f, account.getFacebookId());
	}
}
