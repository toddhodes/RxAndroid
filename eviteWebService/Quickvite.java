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

            ArrayOfQVInviteDecorator qvArr = 
              port.retrieveUpcomingInvites(creds, userId, new GregorianCalendar());

	} catch (Throwable t) {
	    t.printStackTrace();
	}
	
    }

}
