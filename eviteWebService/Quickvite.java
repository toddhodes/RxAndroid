import java.util.*;
import com.evite.qv.model.*;
import com.evite.qv.webservice.*;

public class Quickvite {

    public static void main(String args[]) {
	
	String login = "none";
	String pass = "none";
	
	if (args.length > 1) {
            login = args[0];
            pass = args[1];
        }

	System.out.println("login is: " + login);
	System.out.println("pass is: " + pass);
	System.out.println("");			   

	try {
            QVWebServiceLocator loc = new QVWebServiceLocator();
            QVWebServicePortType port = loc.getQVWebServiceHttpPort();

            QVCredentials creds = new QVCredentials("wavemarket", "t64Hadre");
            String userId = port.login(creds, login, pass, "5105551212");
            System.out.println("userId is: " + userId);

            GregorianCalendar cal = new GregorianCalendar();
            Date trialTime = new Date();
            cal.setTime(trialTime);
            // let's look at some old ones
            cal.set(Calendar.YEAR, 2007);

            ArrayOfQVInviteDecorator qvArr = 
              port.retrieveUpcomingInvites(creds, userId, cal);

            QVInviteDecorator[] invites = qvArr.getQVInviteDecorator();
            if (invites != null && invites.length > 0) {
                System.out.println("");
                System.out.println("   " + invites.length + " invites returned.");
                System.out.println("");
                for (int i=0; i < invites.length; i++) {
                    QVInviteDecorator inv = invites[i];
                    System.out.println(formatQVInviteDecorator(inv));

                    QVInvite qv = inv.getInvite();
                    QVEventDecorator guests =
                        port.retrieveEventWithGuestlist(creds, qv.getEventId());

                    System.out.println(formatQVEventDecorator(guests));

                    System.out.println("---------------------------------------");
                }

            } else {
                System.out.println("No invites returned.");
            }

	} catch (Throwable t) {
	    t.printStackTrace();
	}
	
    }

    public static String formatQVEventDecorator(QVEventDecorator e) {
        String ret = "";

        QVEvent qv = e.getEvent();

        QVDate start = qv.getStartTime();
        QVDate end = qv.getEndTime();

        ret += "\ntitle: " + qv.getTitle();
        ret += "\nHostName: " +qv.getHostName();
        ret += "\nstarts: " + formatQVDate(start);
        ret += "\nends: " + formatQVDate(end);
        ret += "\nLocationName: " +qv.getLocationName();
        ret += "\naddress: " + qv.getStreet() + ", " + qv.getCity() + ", " + qv.getState() 
                          + ", " + qv.getPostalCode();
        ret += "\nHostMessage: " +qv.getHostMessage();
        ret += "\nHostUserId: " +qv.getHostUserId();
        ret += "\neventId: " + qv.getEventId();

        QVInvite[] guests = e.getGuestList().getQVInvite();
        if (guests != null) {
            ret += "\n"+ guests.length +" guests:\n";
            for (int i=0; i < guests.length; i++) {
                ret += formatQVInvite(guests[i]) + "\n";
            }
        } else {
            ret += "guestList is null\n";
        }
                     

        QVUserProfile host = e.getHostProfile();
        ret += "\n";

        ret += "\n";
        return ret;
    }


    public static String formatQVInviteDecorator(QVInviteDecorator inv) {
        String ret = "";

        QVDate end = inv.getEventEndTime();
        QVDate start = inv.getEventStartTime();
        ret += "\ntitle is: " + inv.getEventTitle();
        ret += "\nstarts: " + formatQVDate(start);
        //ret += "\nends: " + formatQVDate(end);
        ret += "\nhostId is: " + inv.getEventHostUserId();
                    
        QVInvite qv = inv.getInvite();
        ret += formatQVInvite(qv);
                 
        return ret;
    }

    public static String formatQVInvite(QVInvite qv) {
        String ret = "";
        ret += "\nname: " + qv.getName();
        ret += "\nemail: " + qv.getEmail();
        ret += "\ncomments: " + qv.getComments();
        ret += "\nresponse: " + qv.getResponse().getValue();
        ret += "\neventId: " + qv.getEventId();
        ret += "\ninviteId: " + qv.getInviteId();        
        return ret;
    }

    public static String formatQVDate(QVDate d) {
        String ret = "";

        ret += d.getMonth() + "/"  + d.getDay() + "/"  + d.getYear();
        ret += " " + d.getHours() + ":" + d.getMinutes();
        if (d.getMinutes() < 10)
            ret += "0";

        return ret;
    }

}
