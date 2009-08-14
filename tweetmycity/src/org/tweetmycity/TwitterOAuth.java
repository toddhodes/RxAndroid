
package org.tweetmycity;

import com.veriplace.client.Location;
import com.veriplace.client.User;
import com.veriplace.client.Client;
import com.veriplace.client.store.TokenStore;
import com.veriplace.client.store.MemoryTokenStore;
import com.veriplace.oauth.consumer.Token;
import com.veriplace.oauth.OAuthException;
import com.veriplace.oauth.message.Revision;

import java.net.URL;
import java.net.HttpURLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import java.text.SimpleDateFormat;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Status;


/**
 */
public class TwitterOAuth
   extends ClientServlet {

   private static final Log logger = LogFactory.getLog(TwitterOAuth.class);

   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      boolean doFinish = "true".equalsIgnoreCase(request.getParameter("finish"));
      if (doFinish) {
         doFinish(request, response);
         return;
      }

      StringBuilder buf = new StringBuilder();

      response.setContentType("text/html");
      buf.append("<html>");
      buf.append(" <head>");
      buf.append("       <title>TweetMyCity</title>");
      buf.append("       <meta http-equiv='content-type' content='text/html'/>");
      buf.append("       <link rel='stylesheet' href='/tweetmycity/css/tmc.css'/>");
      buf.append(" </head>");
      
      buf.append(" <body>");
      buf.append("   <div class='background_image'>");
      buf.append("     <div class='text_properties'>");
      buf.append("      <h2>Twitter testing</h2>");
      buf.append("      <p>" + (new SimpleDateFormat()).format(System.currentTimeMillis()) + "</p>");
      buf.append("      <p>Give permission at the following URL:</p>");
      String authUrl = Tweet.startOAuth();
      buf.append("      <p><a href='" + authUrl + "'>" + authUrl + "</a></p>");
      buf.append("     </div>");
      buf.append("   </div>  ");
      buf.append(" </body>");
      buf.append("</html>");

      response.getOutputStream().write(buf.toString().getBytes());
   }

   public void doFinish(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException,
             IOException {

      StringBuilder buf = new StringBuilder();

      response.setContentType("text/html");
      buf.append("<html>");
      buf.append(" <head>");
      buf.append("       <title>TweetMyCity</title>");
      buf.append("       <meta http-equiv='content-type' content='text/html'/>");
      buf.append("       <link rel='stylesheet' href='/tweetmycity/css/tmc.css'/>");
      buf.append(" </head>");
      
      buf.append(" <body>");
      buf.append("   <div class='background_image'>");
      buf.append("     <div class='text_properties'>");
      buf.append("      <h2>Twitter testing</h2>");
      buf.append("      <p>" + (new SimpleDateFormat()).format(System.currentTimeMillis()) + "</p>");
      buf.append("      <p>Tweeting</p>");
      Tweet.finishOAuth();
      Tweet.updateStatusViaOAuth((new SimpleDateFormat()).format(System.currentTimeMillis()));
      buf.append("     </div>");
      buf.append("   </div>  ");
      buf.append(" </body>");
      buf.append("</html>");



      response.getOutputStream().write(buf.toString().getBytes());

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

