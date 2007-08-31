package lsn.servlet;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.servlet.*;
import javax.servlet.http.*;
import lsn.util.*;
import lsn.facebook.ProcessFacebook;
import lsn.persist.*;

public class Provision extends HttpServlet {
	private static final long serialVersionUID = 2;
	public static final String CONFIG_FILE = "facebook.properties";

	public void init() {
		try {
			InputStream fis = getServletContext().getResourceAsStream(
								 "/WEB-INF/classes/" + CONFIG_FILE);
			if (fis == null) System.out.println("was null: " 
								 + getServletContext().getRealPath(""));
			else System.out.println("facebook props ok");

			Properties props = new Properties();
			props.load(fis);
			Facebook.init(props);
		} catch(Exception e) { System.out.println(e.getMessage()); }
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		System.out.println(req.getQueryString());

		int userId = Integer.parseInt(req.getParameter("fb_sig_user"));
		String session = req.getParameter("fb_sig_session_key");
		/*
		Account acct = new Account(1234, "5102207755");
		try {
			acct.persist();
		} catch(PersistException pe) { System.out.println(pe.getMessage()); }
		*/

		Facebook fb = new Facebook(userId, session);
		fb.setFBML("this is just a test for you", userId);

		PrintWriter pw = res.getWriter();
		pw.println("ok there: " + userId);
		pw.println("session: " + session);
	}
}
