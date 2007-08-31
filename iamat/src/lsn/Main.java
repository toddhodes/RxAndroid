package lsn;

import lsn.util.*;
import lsn.persist.*;

public class Main {
  public static void main(String[] args) throws Exception {
	 // Facebook fb = new Facebook();
	 // fb.setFBML("this is a test", 681580446);
	 // Account acct = new Account(0, "test", 0);
	 // acct.persist();
	 MailClient mc = new MailClient();
	 // mc.postMail("sahotes@gmail.com", "subjec", "body", "scott@wavemarket.com");
	 mc.sendSMS("5102207755", 3, "sahotes@gmail.com", "ok for now");
  }
}
