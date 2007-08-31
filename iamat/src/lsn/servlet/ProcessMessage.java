package lsn.servlet;

import java.io.*;
import java.util.regex.*;
import javax.servlet.*;
import javax.servlet.http.*;
import lsn.util.Message;
import lsn.facebook.ProcessFacebook;

public class ProcessMessage extends HttpServlet {
	private static final long serialVersionUID = 1;
	static final String FieldRegex = "^(\\w+):\\s*(.*)$";

	void processMessage(Message m) {
		if (! m.validate()) return;

		(new ProcessFacebook()).processMessage(m);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		BufferedReader reader = req.getReader();

		String line = null;
		Pattern pattern = Pattern.compile(FieldRegex);
		Message m = new Message();
		while ((line = reader.readLine()) != null) {
			if (line.equals("")) break;

			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {
				m.addField(matcher.group(1), matcher.group(2));
			}
		}

		StringBuffer body = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			body.append(line);
		}

		m.addField("Body", body.toString());

		processMessage(m);
	}
}
