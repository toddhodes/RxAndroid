package org.tweetmycity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.veriplace.client.Location;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Status;
import twitter4j.http.RequestToken;
import twitter4j.http.AccessToken;


public class Tweet {

   private static final Log logger = LogFactory.getLog(Tweet.class);
 

   private static final String consumer_key = "4lUrVENZYCIcfx5U3L45Ig";
   private static final String consumer_secret = "q1O8Rytr6HZy8cZKEMs9oxRawplHRjC56yCFqaFhI";


   public static String startOAuth() {
      Twitter twitter = new Twitter();
      twitter.setSource("TweetMyCity.org");
      twitter.setOAuthConsumer(consumer_key, consumer_secret);

      //RequestToken requestToken = null;
      try {
         requestToken = twitter.getOAuthRequestToken();
         logger.debug("requestToken = " + requestToken);
      }  catch (TwitterException te) {
         logger.error(te);
      }

      String authUrl = requestToken.getAuthorizationURL();
      logger.info("returning auth url:" + authUrl);

      return authUrl;
   }
   static RequestToken requestToken = null;


   public static void finishOAuth() {
      Twitter twitter = new Twitter();
      twitter.setSource("TweetMyCity.org");
      twitter.setOAuthConsumer(consumer_key, consumer_secret);

      logger.debug("requestToken = " + requestToken);
      AccessToken accessToken = null;
      int retry = 0;
      while (accessToken == null && retry < 100) {
         try{
            accessToken = requestToken.getAccessToken();
         } catch (TwitterException te) {
            if(401 == te.getStatusCode()){
               logger.error("Unable to get the access token.");
            } else {
               logger.error(te);
            }
         }
         logger.debug("retrying");
         retry++;
      }

      try {
         logger.info("accessToken = " + accessToken);
         twitter.setOAuthAccessToken(accessToken);
         logger.info("creds = " + twitter.verifyCredentials());
         logger.info("creds = " + twitter.verifyCredentials().getId());
         //persist to the accessToken for future reference.
         storeAccessToken(twitter.verifyCredentials().getId(), accessToken);

         Status status = twitter.updateStatus("update using oauth credentials");
         logger.info("Successfully updated the status to [" + status.getText() + "].");
      }  catch (TwitterException te) {
         te.printStackTrace();
         logger.error(te);
      }
   }




   public static void updateStatusViaOAuth(String statusMsg) {
      Twitter twitter = new Twitter();
      twitter.setSource("TweetMyCity.org");
      twitter.setOAuthConsumer(consumer_key, consumer_secret);
      AccessToken accessToken = loadAccessToken(-1);
      twitter.setOAuthAccessToken(accessToken);
      try {
         Status status = twitter.updateStatus(statusMsg);
         logger.info("Successfully updated the status to [" + status.getText() + "].");
      }  catch (TwitterException te) {
         logger.error(te);
      }
   }


      // XXX store to persistent store
   private static void storeAccessToken(int userId, AccessToken at){
      tokenStore = at.getToken();
      tokenSecretStore = at.getTokenSecret();
   }
   static String tokenStore;
   static String tokenSecretStore;

      // XXX load from persistent store
   private static AccessToken loadAccessToken(int userId){
      String token = tokenStore;
      String tokenSecret = tokenSecretStore;
      return new AccessToken(token, tokenSecret);
   }



   public static String tryTweet(TmcUser tmc, Location location) {
      if (!GetLocation.empty(location)) {
         String cityState = location.getCity() + ", " + location.getState();
         if (!cityState.equals(tmc.getLastCityState())) {

            // not same as last time
            logger.info("tweeting the location, it's not the same as last time: " + cityState);

            // tweet the city
            String stat = tweet(tmc, location);
            
            // ... and update and save new location
            tmc.updateLastCity(cityState);
            (new UserStore()).update(tmc);

            return stat;
         } else {
            logger.info("not tweeting the location, it's the same as last time: " + cityState);
         }
      } else {
         logger.info("No location available.  Did not update the status");
      }
      return null;
   }


   public static String tweet(TmcUser tmc, Location location) {
      Twitter twitter = new Twitter(tmc.getTwitterId(),
                                    tmc.getTwitterPass());
      twitter.setSource("TweetMyCity.org");
      String stat = "TweetMyCity.org: "//"@tweet_my_city: "
         + tmc.getDeviceDescription()
         + " is now in "
         + location.getCity() + ", " + location.getState();
      try {
         Status status = twitter.updateStatus(stat);
         logger.info("Successfully updated the status to ["
                     + status.getText() + "].");
      } catch (twitter4j.TwitterException te) {
         logger.info("Got exception:" + te.getMessage() );
      }
     return stat;
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


