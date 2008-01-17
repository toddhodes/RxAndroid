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

                    QVDate end = inv.getEventEndTime();
                    QVDate start = inv.getEventStartTime();
                    System.out.println("title is: " + inv.getEventTitle());
                    System.out.println("hostId is: " + inv.getEventHostUserId());
                    System.out.println("starts: " + formatQVDate(start));
                    //System.out.println("ends: " + formatQVDate(end));
                    
                    QVInvite qv = inv.getInvite();
                    System.out.println("eventId: " + qv.getEventId());
                    System.out.println("inviteId: " + qv.getInviteId());
                    System.out.println("name: " + qv.getName());
                    System.out.println("email: " + qv.getEmail());
                    System.out.println("comments: " + qv.getComments());
                    System.out.println("response: " + qv.getResponse().getValue());
                 
                    System.out.println("");   
                }

            } else {
                System.out.println("No invites returned.");
            }

	} catch (Throwable t) {
	    t.printStackTrace();
	}
	
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
