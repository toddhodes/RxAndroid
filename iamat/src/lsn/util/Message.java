package lsn.util;

import java.util.*;

public class Message {
	Map<String, String> fields = null;

	public Message() {
		fields = new HashMap<String, String>();
	}

	public void addField(String a, String b) {
		fields.put(a, b);
	}

	public String getField(String a) {
		return fields.get(a);
	}

	public boolean validate() {
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		Iterator<String> it = fields.keySet().iterator();
		while (it.hasNext()) {
			String k = it.next();
			sb.append(k + " - " + fields.get(k) + "\n");
		}

		return sb.toString();
	}
}
