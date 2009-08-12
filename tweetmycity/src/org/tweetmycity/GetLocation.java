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
       // ignore this -- never called!
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

         String stat = null;
         if (!empty(location)) {
            // tweet the city
            TmcUser tmc = (new UserStore()).get(user.getId());
            stat = Tweet.tweet(tmc, location);
         } else {
            System.out.println("No location available.  Did not update the status");
         }
         

         // show user
         StringBuilder buf = new StringBuilder();
         buf.append("<html>");

         buf.append(" <head>");
         buf.append("       <title>tweetmycity</title>");
         buf.append("       <meta http-equiv='content-type' content='text/html'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/normalize.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/typography.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/graphics.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/footer.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/branding.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/layout.css'/>");
         buf.append("       <link rel='stylesheet' href='/tweetmycity/css/forms.css'/>");
         
         buf.append("    <!--[if IE]>");
         buf.append("       <link rel='stylesheet' type='text/css' media='screen' href='css/fixes_IE.css' />");
         buf.append("    <![endif]-->");
         buf.append("    <!--[if IE 6]>");
         buf.append("       <link rel='stylesheet' type='text/css' media='screen' href='css/fixes_IE6.css' />");
         buf.append("    <![endif]-->");
         buf.append(" </head>");

         buf.append(" <body>");
         buf.append("   <div id='container'>");
         buf.append("     <div id='branding'>");
         buf.append("        <h1>Tweet My City</h1>");
         buf.append("     </div>");
         buf.append("     <!-- /branding -->");
         
         buf.append("     <div id='content'>");
         buf.append("        <p>Success! Tweet My City will post on your behalf when you arrive in a new city. To turn this off later, simply go to veriplace.com and turn off location sharing.</p>");
         //buf.append("      <p>You've successfully linked Veriplace to twitter.</p>");
         //buf.append("      <p>User: " + user.getId() + "</p>");
         if (!empty(location)) {
            buf.append("     <p>Additionally, we have a location for you and you've tweeted your current city as:</p>");
            buf.append("     <p><strong>" + stat + "</strong></p>");
         } else {
            buf.append("     <p>We were not able to located you right now, but we'll keep trying!</p>");
         }
         buf.append("        <a class='button ok' href='user' tabindex='100'>OK</a>");
         buf.append("     </div>");
         buf.append("     <!-- /content -->");
         
         buf.append("     <div id='footer'>");
         buf.append("        <a href='privacy.html'>privacy policy</a>");
         buf.append("     </div>");
         buf.append("     <!-- /footer -->");
         buf.append("   </div>  ");
         buf.append("   <!-- /container -->  ");
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
          if (deviceDesc == null || "".equals(deviceDesc)) {
             deviceDesc = "phone";
          }
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

   public static boolean empty(Location location) {
       return location == null 
              || empty(location.getCity()) 
              || empty(location.getState());

   }

   public static boolean empty(String s) {
       if (s == null) return true;
       if ("".equals(s.trim())) return true;
       return false;
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

