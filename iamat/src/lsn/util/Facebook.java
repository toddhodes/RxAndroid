package lsn.util;

import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import com.facebook.api.*;
import org.w3c.dom.*;
import lsn.persist.*;

public class Facebook {
	static String apiKey 			= null;
	static String secret 			= null;
	static String infiniteSession = null;

	FacebookRestClient fbClient 	= null;
	String session 					= null;

	public Facebook() {
		fbClient = new FacebookRestClient(apiKey, secret, infiniteSession);
		fbClient.setDebug(true);
	}

	public static void init(Properties props) {
		apiKey = props.getProperty("api_key");
		secret = props.getProperty("secret");
		infiniteSession = props.getProperty("session");
	}

	public Facebook(int userId, String session) {
		if (apiKey == null) (new lsn.servlet.Provision()).init();

		this.session = session;

		fbClient = new FacebookRestClient(apiKey, secret, session);
		fbClient.setDebug(true);
		fbClient.setUserId(userId);
	}

	public void updateInfiniteSession(String is) {
		infiniteSession = is;
	}

	public void setFBML(String fbml, int userId) {
		try {
			fbClient.profile_setFBML(fbml, new Integer(userId));
		} catch(Exception e) { System.out.println("set: " + e.getMessage()); }
	}

	public String getSingleAttribute(int userId, ProfileField pf) {
		HashSet<Integer> users = new HashSet<Integer>();
		users.add(new Integer(userId));

		EnumSet<ProfileField> fields = EnumSet.of(pf);

		Document doc = null;
		try {
			doc = fbClient.users_getInfo(users, fields);
			return doc
					  .getDocumentElement()
					  .getFirstChild()
					  .getFirstChild()
					  .getNextSibling()
					  .getFirstChild()
					  .getNodeValue();
		} catch(Exception e) { System.out.println("name: " + e); }

		return null;
	}

	public String getName(int userId) {
		return getSingleAttribute(userId, ProfileField.NAME);
	}

	public String getFirstName(int userId) {
		return getSingleAttribute(userId, ProfileField.FIRST_NAME);
	}

	public Collection<Integer> getFriends() {
		Collection<Integer> ret = new HashSet<Integer>();
		Document doc = null;
		try {
			doc = fbClient.friends_get();
			Node node = doc.getDocumentElement().getFirstChild();
			while (true) {
				if (node == null) break;

				int id = Integer.parseInt(node.getFirstChild().getNodeValue());
				System.out.println(id);
				ret.add(new Integer(id));

				node = node.getNextSibling();
			}
		} catch(Exception e) { System.out.println("friends: " + e); }

		return ret;
	}

	String formatTimestamp(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("(hh:mm aa)");
		return sdf.format(d);
	}

	public String generateSingleFbml(Account acct) {
		StringBuffer out = new StringBuffer();

		if (acct.getLocation() != null && ! acct.getLocation().equals("")) {
			out.append("Current location: " + acct.getLocation() + " "
								 + formatTimestamp(acct.getLocationUpdated()) 
								 + "<br /><br />");
		}

		return out.toString();
	}

	public String generateText(Account acct) {
		StringBuffer out = new StringBuffer();

		Iterator<Integer> it = acct.getFriendsColl().iterator();

		if (! it.hasNext())
			return new String("no updates");

		while (it.hasNext()) {
			int friendId = it.next().intValue();
			Account fAcct = Account.queryByFacebookId(friendId);
			if (fAcct == null) continue;

			if (fAcct.getLocation() == null || fAcct.getLocation().equals(""))
				continue;

			String name = getFirstName(friendId);
			out.append(name + ": " + fAcct.getLocation() + " "
								 + formatTimestamp(fAcct.getLocationUpdated())
								 + "\n");
		}

		return out.toString();
	}

	public String generateFbml(Account acct) {
		StringBuffer out = new StringBuffer();

		if (acct.getLocation() != null && ! acct.getLocation().equals("")) {
			String name = getName(acct.getFacebookId());
			out.append(name + ": " + acct.getLocation() + " "
								 + formatTimestamp(acct.getLocationUpdated()) 
								 + "<br /><br />");
		}

		Iterator<Integer> it = getFriends().iterator();
		while (it.hasNext()) {
			int friendId = it.next().intValue();
			Account fAcct = Account.queryByFacebookId(friendId);
			if (fAcct == null) continue;

			if (fAcct.getLocation() == null || fAcct.getLocation().equals(""))
				continue;

			String name = getName(friendId);
			out.append(name + ": " + fAcct.getLocation() + " "
								 + formatTimestamp(fAcct.getLocationUpdated())
								 + "<br /><br />");
		}

		return out.toString();
	}
}
