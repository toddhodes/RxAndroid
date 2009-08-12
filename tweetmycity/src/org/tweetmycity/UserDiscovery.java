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
      buf.append(" <head>");
      buf.append("    <title>TweetMyCity</title>");
      buf.append("    <meta http-equiv='content-type' content='text/html'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/normalize.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/typography.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/graphics.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/footer.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/branding.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/layout.css'/>");
      buf.append("    <link rel='stylesheet' href='/tweetmycity/css/forms.css'/>");
      
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
      buf.append("        <p>Tweet My City is a simple utility that follows your phone&#39;s location and posts to Twitter when you arrive in a new city.</p>");
      buf.append("         <form method='post'>");
      buf.append("            <button class='button getStarted' type='submit' value='Get Started' tabindex='100' />");
      buf.append("         </form>");
      buf.append("     </div>");
      buf.append("     <!-- /content -->");
      buf.append("     <div id='footer'>");
      buf.append("        <a href='privacy.html'>privacy policy</a>");
      buf.append("     </div>");
      buf.append("     <!-- /footer -->");
      buf.append("   </div>  ");
      buf.append("   <!-- /container -->");
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
         buf.append(" <head>");
         buf.append("       <title>TweetMyCity</title>");
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

         if (user != null) {
            buf.append("  <h2 id='header-getStarted'>Get Started</h2>");
            buf.append("  <p>You are about to link your Veriplace account "
                       + "(for locating your phone) "
                       //"(" + user.getId() + ") "
                       + "with your Twitter account.");
            buf.append("  To do so, you need to give permission for location requests on Veriplace.");
            buf.append("  Be sure to choose 'on an ongoing basis' when asked.</p>");
            /*
            buf.append("  <p><a href='location?user=" + user.getId() + "'>Get Location</a></p>");
             */
             buf.append("  <form id='signIn' action='location' method='post'>");
             buf.append("  <fieldset>");
             buf.append("     <label for='twitterId'>Twitter Username:</label>");
             buf.append("     <input id='twitterId' class='twitterId' name='twitterId' type='text' tabindex='100' />");
             buf.append("  </fieldset>");
             
             buf.append("  <fieldset>");
             buf.append("     <label for='twitterPass'>Twitter Password:</label>");
             buf.append("     <input id='twitterPass' class='twitterPass' name='twitterPass' type='password' tabindex='100' />");
             buf.append("  </fieldset>");
             
             buf.append("  <fieldset class='optional'>");
             buf.append("     <label for='deviceDesc'>Device Nickname (optional):</label>");
             buf.append("     <input id='deviceDesc' class='deviceDesc' name='deviceDesc' type='text' tabindex='100' /><span class='deviceDesc-example'>e.g. My Phone</span>");
             buf.append("     <input type='hidden' name='user' value='" + user.getId() + "'/>");
             buf.append("  </fieldset>");
             
             buf.append("  <button class='button continue' type='submit' value='Continue' tabindex='120' />");
             buf.append("  </form>");

         } else {
            buf.append("  <h2>Cannot link your accounts</h2>");
            buf.append("  <p>We could not discover your Veripalce user ID. Please try again.</p>");
         }

         buf.append("     </div>");
         buf.append("     <!-- /content -->  ");
         buf.append("     <div id='footer'>  ");
         buf.append("        <a href='privacy.html'>privacy policy</a>  ");
         buf.append("     </div>  ");
         buf.append("     <!-- /footer -->  ");
         
         
         buf.append("  </div>  ");
         buf.append("  <!-- container -->  ");
         buf.append("</body>");
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

