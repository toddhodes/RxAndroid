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

import com.veriplace.client.User;
import com.veriplace.oauth.consumer.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

/**
 * Sample servlet that makes a UserDiscovery request using the Veriplace Client library.
 */
public class UserDiscovery 
   extends ClientServlet {

   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      if (client.isCallback(request)) {
         doCallback(request,response);
      } else {
         doForm(request,response);
      }
   }

   /**
    * Show a simple html page and form.
    */
   protected void doForm(HttpServletRequest request,
                         HttpServletResponse response)
      throws ServletException,
             IOException {

      StringBuilder buf = new StringBuilder();
      buf.append("<html>");
      buf.append(" <body>");
      buf.append(" <img src=\"images/tweet_my_city_signup_bg.png\"/>");
      buf.append("  <h2>Get started:</h2>");
      buf.append("  <form method='post'>");
      buf.append("   <input type='submit' value='Click to link your accounts'/>");
      buf.append("  </form>");
      buf.append(" </body>");
      buf.append("</html>");

      response.setContentType("text/html");
      response.getOutputStream().write(buf.toString().getBytes());
   }

   protected void doCallback(HttpServletRequest request,
                             HttpServletResponse response)
      throws ServletException,
             IOException {

      // retrieve the Access Token, if any
      Token accessToken = client.getAccessToken(request);
      if (accessToken != null) {
         // get user
         User user = client.getUserDiscoveryAPI().getUser(accessToken);

      //append the twitter info
      String twitterId = request.getParameter("twitterId");
      String twitterPass = request.getParameter("twitterPass");

         // show user
         StringBuilder buf = new StringBuilder();
         buf.append("<html>");
         buf.append(" <body>");
         buf.append("  <img src=\"images/tweet_my_city_signup_bg.png\"/>");
         buf.append("  <h2>Veriplace User Discovered</h2>");
         if (user != null) {
            buf.append("  <p>You are about to link your veriplace user account ("
                       + user.getId() + ") "
                       + "to your twitter account.</p>");
            buf.append("  <p>To do so, you need to give permission for location requests on Veriplace.</p>");
            buf.append("  <p>Be sure to choose 'on an ongoing basis' when asked.</p>");
            /*
            buf.append("  <p><a href='location?user=" + user.getId() + "'>Get Location</a></p>");
             */
             buf.append("  <form action='location' method='post'>");
             buf.append("   Twitter Username:");
             buf.append("   <input type='text' name='twitterId'/>");
             buf.append("   <br/>");
             buf.append("   Twitter Password:");
             buf.append("   <input type='text' name='twitterPass'/>");
             buf.append("   <br/>");
             buf.append("   Device Nickname (optional):");
             buf.append("   <input type='text' name='deviceDesc'/>");
             buf.append("   <br/>");
             buf.append("   <input type='hidden' name='user' value='" + user.getId() + "'/>");
             buf.append("   <input type='submit' value='Give location permission'/>");
             buf.append("  </form>");

         }
         buf.append(" </body>");
         buf.append("</html>");

         
         response.setContentType("text/html");
         response.getOutputStream().write(buf.toString().getBytes());
      } else {
         // either access was not granted by the user 
         // or the page has been reloaded and the original request token 
         // is no longer valid
         doForm(request,response);
      }
   }

   /**
    * On a post, perform user discovery 
    */
   @Override
   protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      // construct callback url
      String callback = 
         client.prepareCallback(request) + 
         request.getRequestURI();
      // construct the redirect URL for user authorization
      String redirectUrl = client.getUserDiscoveryAPI().getRedirectURL(callback,null);

      /*
      //append the twitter info
      redirectUrl += "&twitterId=" + request.getParameter("twitterId");
      redirectUrl += "&twitterPass=" + request.getParameter("twitterPass");
      */

      // redirect the User Agent
      response.sendRedirect(redirectUrl);
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

