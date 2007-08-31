<%@page import="lsn.util.Facebook" %>
<%@page import="lsn.persist.Account" %>
<%@page import="java.util.Collection" %>
<%
	String message = null;

	int 		userId = -1;
	String 	fbSession = null;
	String 	name = null;
	Account 	account = null;
	String	fbml = null;

	int isAdded = Integer.parseInt((String) request.getParameter("fb_sig_added"));
	if (isAdded != 1) {
		String url = "http://www.facebook.com/add.php?api_key="
				  + request.getParameter("fb_sig_api_key");
%>
<script type="text/javascript">
top.location.href = "<%= url %>";
</script>
<%
	} else {
		userId = Integer.parseInt((String) request.getParameter("fb_sig_user"));
		fbSession = (String) request.getParameter("fb_sig_session_key");
	
		Facebook fb = new Facebook(userId, fbSession);

		// just update the "infinite session" on every page load
		fb.updateInfiniteSession(fbSession);

		name = fb.getFirstName(userId);

		account = Account.queryByFacebookId(userId);

		if (request.getParameter("phone") != null) {
			if (account == null) {
				account = new Account(userId, request.getParameter("phone"),
									 Integer.parseInt(request.getParameter("carrier")));
				account.persist();

				message = "Account created!";
			} 
		}

		if (account != null) {
			Collection<Integer> friends = fb.getFriends();
			account.setFriendsColl(friends);
			account.update();

			fbml = fb.generateFbml(account);

			String singleFbml = fb.generateSingleFbml(account);
			fb.setFBML(singleFbml, account.getFacebookId());
		}
	}
%>

<html>
<head>
<link rel="stylesheet" href="base.css" type="text/css" />
</head>
<body>
<div style="margin: 10px">
<% 
	if (message != null) 
		out.print("<font color=red>" + message + "</font><p>\n");

	if (account == null) {
%>
Hi <%= name %>, welcome to <b>FriendFinder</b>!<br/><br/>
To proceed, please enter your mobile number:<br/><br/>
<form>
<input type="hidden" name="fb_sig_user" value="<%= userId %>">
<input type="hidden" name="fb_sig_session_key" value="<%= fbSession %>">
<input type="hidden" name="fb_sig_added" value="1">
<table>
<tr><td><b>carrier:</b></td><td>
<select name="carrier" style="font-size: 12px">
<option disabled="1" selected="1" value="0">Choose:</option>
<option value="1">Sprint PCS</option>
<option value="2">Verizon Wireless</option>
<option value="3">AT&T Wireless</option>
<option value="4">T-Mobile</option>
<option value="5">Alltel</option>
</select>
</td></tr>
<tr><td><b>mobile:</b></td><td><input style="font-size: 12px" name="phone"></td></tr>
<tr><td></td><td><input type="submit" name="submit" value="Submit"></td></tr>
</table>
</form>
<%
	} else {
%>
Hi <%= name %>, your mobile is registered as <%= account.getMdn() %>.<br/><br/>
<b>latest updates:</b><br/><br/>
<%= fbml %>
<b>instructions:</b><br/><br/>
Just send your location in an SMS to <a href="mailto:lsn@mail20.wavemarket.com">lsn@mail20.wavemarket.com</a>, or...<br/><br/>
send email to this address, and enter your mobile number in the subject line.
Make sure to send the email as plain text.  NOTE: you cannot send this email
from within the WaveMarket corporate network (ask Tom if you want this fixed!)
<br/><br/>
If you add a question mark to the start of your message, you will 
receive a text message back with the latest location of your friends.
<br/><br/>
For example, send "? at work" to update your location and find out where your friends are.
<%
	}
%>
</div>
</body>
</html>
