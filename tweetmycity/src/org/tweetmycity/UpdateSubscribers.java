
package org.tweetmycity;

import com.veriplace.client.Location;
import com.veriplace.client.User;
import com.veriplace.oauth.consumer.Token;

//query.bash
import com.veriplace.client.Client;
//import com.veriplace.client.Location;
//import com.veriplace.client.User;
import com.veriplace.client.store.TokenStore;
import com.veriplace.client.store.MemoryTokenStore;
import com.veriplace.oauth.OAuthException;
//import com.veriplace.oauth.consumer.Token;
import com.veriplace.oauth.message.Revision;

import java.net.URL;
import java.net.HttpURLConnection;
//

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Status;


/**
 * tweet all our subscribers' cities.
 */
public class UpdateSubscribers
   extends ClientServlet {

   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      boolean doText = "true".equalsIgnoreCase(request.getParameter("text"));

      StringBuilder buf = new StringBuilder();

      if (doText) {
         buf.append("Updating subscribers:\n");
      } else {
         buf.append("<html>");
         buf.append(" <head>");
         buf.append("       <title>tweetmycity</title>");
         buf.append("       <meta http-equiv='content-type' content='text/html'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/tmc.css'/>");
         buf.append(" </head>");

         buf.append(" <body>");
         buf.append("   <div class='background_image'>");
         buf.append("     <div class='text_properties'>");
         buf.append("      <h2>Update Subscribers</h2>");
         buf.append("      <p>Updating the following:</p>");
      }

      for (TmcUser tmcUser : (new UserStore()).getUsers()) {
         Location location = getLocation(tmcUser);
         if (location != null) {
            tweet(tmcUser, location);
            if (doText) 
               buf.append("tweet: " + tmcUser 
                          + " is in " + location.getCity() + ", " + location.getState()
                          + "\n");
            else
               buf.append("<p>tweet: " + tmcUser 
                          + " is in " + location.getCity() + ", " + location.getState()
                          + "</p>");
         } else {
            if (doText) 
               buf.append("no location for: " + tmcUser + "\n");
            else
               buf.append("<p>no location for: " + tmcUser + "</p>");
         }
      }

      if (doText) {
         buf.append("\n");
         response.setContentType("text/plain");
      } else {
         buf.append("     </div>");
         buf.append("   </div>  ");
         buf.append(" </body>");
         buf.append("</html>");
         response.setContentType("text/html");
      }

      response.getOutputStream().write(buf.toString().getBytes());
   }

   protected Location getLocation(TmcUser tmcUser) {

      // This callback is required by the OAuth standard, but is unused
      String callback = "http://veriplace.com";

      // We require the special "Application Token" to issue User Discovery *queries*
      // For your application, you can find this value in the Developer Portal
      Token applicationToken = new Token("DHgu0Ky1zUS8llHxMXt0",
                                         "nJs2pAxco6wmsOASgmOV");


      // We'll need to use our own token store below.
      TokenStore tokenStore = new MemoryTokenStore();

      Client client = null;
      try {
         // Create the Veriplace client
         client = new Client("RfhjzYkyYxOL6lrWgrOe",
                             "pHVlIQP1ofd3kpDbe9BV",
                             Revision.Core1_0RevA,
                             applicationToken,
                             "http://veriplace.com",
                             tokenStore);
      } catch (java.security.NoSuchAlgorithmException nsae) {
         System.err.println(nsae);
         return null;
      } catch (java.net.MalformedURLException mue) {
         System.err.println(mue);
         return null;
      }

      User user = new User(tmcUser.getUserId());

      int code = -1;
      HttpURLConnection connection = null;
      try {
         // Veriplace's implementation of OAuth User Authorization supports an "immediate" flag
         // If true, Veriplace will grant an Access Token is permission is already granted
         // and will bypass all UI, performing the callback immediately
         boolean immediate = true;
         URL authorizationUrl = 
            new URL(client.getGetLocationAPI().getRedirectURL(callback,user,immediate));

         // GET this URL, but do not follow redirects
         connection = (HttpURLConnection)authorizationUrl.openConnection();
         connection.setInstanceFollowRedirects(false);
         code = connection.getResponseCode();
         System.out.println("response code: " + code);
      } catch (IOException ioe) {
         System.err.println(ioe);
         return null;
      }

      if (code == 302) {
         // The User Authorization URL sent a redirect, extract the callback URL
         String location_header = connection.getHeaderField("Location");
         System.out.println("location:" + location_header);

         // The callback URL contains the oauth_token and oauth_verifier values (as of Rev A)
         String oauth_token = location_header.split("oauth_token=")[1].split("&")[0];
         String oauth_verifier = location_header.split("oauth_verifier=")[1].split("&")[0];
         System.out.println("callback oauth_token: " + oauth_token);
         System.out.println("callback oauth_verifier: " + oauth_verifier);


         // Retrieve the request token from storage
         Token requestToken = tokenStore.get(oauth_token);
         System.out.println("requestToken: " + requestToken.getToken());

         try {
            // Attempt to get an access token
            Token accessToken = client.getConsumer().getAccessToken(requestToken,oauth_verifier);
            System.out.println("accessToken: " + accessToken.getToken());

            // We got an access token, now make a location request
            // If our application was provisioned for it, we can try cached location by setting the mode
            String mode = null;//"cached";
            Location location = client.getGetLocationAPI().getLocation(accessToken,user,mode);

            if (location == null) {
               // If we didn't get back a location object, it means we encountered a rare
               // race condition where the access token was revoked between when we retrieved it
               // and when the location request was issued
               System.out.println("Could not obtain location");
               return null;
            }

            // We got location, but was it successful?
            if (location.getLongitude() != null &&
                location.getLatitude() != null) {
               // Yes!
               System.out.println(location.getLatitude() + " " + location.getLongitude());
               System.out.println("user is in " 
                                  + location.getCity() + ", " + location.getState());
               return location;
            } else {
               // Sadly, no...
               System.out.println(location.getMessage());
               return null;
            }
         } catch (OAuthException e) {
            // An exception here means an Access Token wasn't available
            // Try granting permission directly for your application in the Privacy Manager
            // There should now be a permission request visible in the sidebar
            System.err.println(e);
            return null;
         } catch (IOException ioe) {
            // from Token accessToken = client.getConsumer().getAccessToken(requestToken,oauth_verifier);
            System.err.println(ioe);
            return null;
         } finally {
            tokenStore.remove(requestToken);
         }
      } else {
         System.out.println("Unexpected http response code: " + code);
         return null;
      }
   }

   protected void tweet(TmcUser tmc, Location location) {
      Twitter twitter = new Twitter(tmc.getTwitterId(),
                                    tmc.getTwitterPass());
      String stat = "tweetmycity.org: "//"@tweet_my_city: "
         + "my " + tmc.getDeviceDescription()
         + " is now in "
         + location.getCity() + ", " + location.getState();
      try {
         Status status = twitter.updateStatus(stat);
         System.out.println("Successfully updated the status to [" 
                            + status.getText() + "].");
      } catch (twitter4j.TwitterException te) {
         System.out.println("Got exception:" + te.getMessage() );
      }
   }


}

/*
** Local Variables:
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
*/

