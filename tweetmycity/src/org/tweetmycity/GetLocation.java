/* Copyright 2008 WaveMarket, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tweetmycity;

import com.veriplace.client.Location;
import com.veriplace.client.User;
import com.veriplace.oauth.consumer.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Status;


/**
  servlet that makes a GetLocation request using the Veriplace Client library.
 */
public class GetLocation
   extends ClientServlet {

   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      User user = getUser(request);

      if (user == null) {
         doDiscoverUser(request,response);
      } else if (client.isCallback(request)) {
         doCallback(request,response,user);
      } else {
         doForm(request,response,user);
      }
   }

   /**
    * Pull the current user from request parameters
    */
   protected User getUser(HttpServletRequest request) {
      try {
         long userId = Long.parseLong(request.getParameter("user"));
         return new User(userId);
      } catch (NullPointerException e) {
      } catch (NumberFormatException e) {
      }
      return null;
   }

   /**
    * Delegate to {@link UserDiscovery} servlet, e.g. if we don't know the user.
    */
   protected void doDiscoverUser(HttpServletRequest request,
                                 HttpServletResponse response)
      throws ServletException,
             IOException {

      String callback = client.prepareCallback(request) + request.getRequestURI();
      String redirectUrl = client.getUserDiscoveryAPI().getRedirectURL(callback,null);
      response.sendRedirect(redirectUrl);
   }

   /**
    * Show a simple html page and form.
    */
   protected void doForm(HttpServletRequest request,
                         HttpServletResponse response,
                         User user)
      throws ServletException,
             IOException {

      StringBuilder buf = new StringBuilder();
      buf.append("<html>");
      buf.append(" <body>");
      buf.append("  <h2>Veriplace Client Example</h2>");
      buf.append("  <form method='post'>");
      buf.append("   <input type='hidden' name='user' value='" + user.getId() + "'/>");
      buf.append("   <input type='submit' value='Locate User'/>");
      buf.append("  </form>");
      buf.append(" </body>");
      buf.append("</html>");

      response.setContentType("text/html");
      response.getOutputStream().write(buf.toString().getBytes());
   }

   protected void doCallback(HttpServletRequest request,
                             HttpServletResponse response,
                             User user)
      throws ServletException,
             IOException {

      // retrieve the Access Token, if any
      Token accessToken = client.getAccessToken(request);
      if (accessToken != null) {
         // get user
         Location location = client.getGetLocationAPI().getLocation(accessToken, user);

         // tweet the city
         TmcUser tmc = (new UserStore()).get(user.getId());
         Twitter twitter = new Twitter(tmc.getTwitterId(),
                                        tmc.getTwitterPass());
         String stat = "my " + tmc.getDeviceDescription()
                        + " is now in "
                        + location.getCity() + ", " + location.getState();
         try {
            Status status = twitter.updateStatus(stat);
            System.out.println("Successfully updated the status to [" 
                               + status.getText() + "].");
         } catch (twitter4j.TwitterException te) {
            System.out.println("Got exception:" + te.getMessage() );
         }
         

         // show user
         StringBuilder buf = new StringBuilder();
         buf.append("<html>");

         buf.append(" <head>");
         buf.append("       <title>tweetmycity</title>");
         buf.append("       <meta http-equiv='content-type' content='text/html'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/tmc.css'/>");
         buf.append(" </head>");

         buf.append(" <body>");
         buf.append("   <div class='background_image'>");
         buf.append("     <div class='text_properties'>");

         buf.append("  <h2>Success!</h2>");
         //buf.append("  <p>You've successfully linked Veriplace to twitter.</p>");
         buf.append("  <p>Tweet My City will post on your behalf");
         buf.append("  when you arrive in a new city.  To turn this off");
         buf.append("  at any time, simply go to veriplace.com and disallow");
         buf.append("  location sharing.</p>");
         //buf.append("  <p>User: " + user.getId() + "</p>");
         if (location != null) {
            buf.append("  <p>Additionally, we have a location for you");
            buf.append("  and you've tweeted your current city as:</p>");
            buf.append("  <p><b>'" + stat + "'</b></p>");
         }

         buf.append("     </div>");
         buf.append("   </div>  ");
         buf.append(" </body>");
         buf.append("</html>");

         response.setContentType("text/html");
         response.getOutputStream().write(buf.toString().getBytes());
      } else {
         // either access was not granted by the user 
         // or the page has been reloaded and the original request token 
         // is no longer valid
         doForm(request,response,user);
      }
   }

   /**
    * On a post, locate user
    */
   @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
      throws ServletException,
             IOException {

      User user = getUser(request);

      if (user == null) {
         doDiscoverUser(request,response);
      } else {
          //save the twitter + vp info
          String twitterId = request.getParameter("twitterId");
          String twitterPass = request.getParameter("twitterPass");
          String deviceDesc = request.getParameter("deviceDesc");
          long vpUserId = user.getId();
          saveUser(vpUserId, twitterId, twitterPass, deviceDesc);

         // construct callback url
         String callback = 
            client.prepareCallback(request) + 
            request.getRequestURI() + 
            "?user=" + 
            user.getId();
         // construct the redirect URL for user authorization
         String redirectUrl = client.getGetLocationAPI().getRedirectURL(callback,user);
         // redirect the User Agent
         response.sendRedirect(redirectUrl);
      }
   }

   protected void saveUser(long vpId, String twitterId, String twitterPass, String dev) {
       TmcUser u = new TmcUser(vpId, twitterId, twitterPass, dev); 
       UserStore us = new UserStore(); 
      
       us.add(u);
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

