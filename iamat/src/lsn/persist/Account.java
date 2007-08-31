package lsn.persist;

import java.util.*;
import java.util.regex.*;

public class Account {
	long		id;
	int		facebookId;
	String	mdn;
	int		carrier;
	String	friends;
	String	location;
	Date		locationUpdated;

	public Account() { }

	public Account(int facebookId, String mdn, int carrier) {
		this.facebookId = facebookId;
		this.mdn = mdn;
		this.carrier = carrier;
	}

	public Collection<Integer> getFriendsColl() {
		Collection<Integer> ret = new HashSet<Integer>();

		String[] mdns = friends.split(",");
		for (int i = 0; i < mdns.length; i++) 
			ret.add(Integer.parseInt(mdns[i]));

		return ret;
	}

	public void setFriendsColl(Collection<Integer> f) {
		StringBuffer sb = new StringBuffer();
		Iterator<Integer> it = f.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			if (it.hasNext()) sb.append(",");
		}
		friends = sb.toString();
	}

	public void persist() 
	throws PersistException {
		(new Persist()).persist(this);
	}

	public void update() 
	throws PersistException {
		(new Persist()).update(this);
	}

	public static Account queryByFacebookId(int facebookId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("facebookId", new Integer(facebookId));
		
		return (Account) (new Persist()).doNamedQuery("accountByFacebookId", 
							 params, false, 0);			
	}

	public static Account queryByMdn(String mdn) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mdn", mdn);
		
		return (Account) (new Persist()).doNamedQuery("accountByMdn", 
							 params, false, 0);			
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public int getFacebookId() { return facebookId; }
	public void setFacebookId(int facebookId) { this.facebookId = facebookId; }

	public String getMdn() { return mdn; }
	public void setMdn(String mdn) { this.mdn = mdn; }

	public int getCarrier() { return carrier; }
	public void setCarrier(int c) { this.carrier = c; }

	public String getFriends() { return friends; }
	public void setFriends(String f) { this.friends = f; }

	public String getLocation() { return location; }
	public void setLocation(String location) { this.location = location; }

	public Date getLocationUpdated() { return locationUpdated; }
	public void setLocationUpdated(Date u) { locationUpdated = u; }
}

