package org.tweetmycity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.veriplace.client.Location;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.Status;


public class Tweet {

   private static final Log logger = LogFactory.getLog(Tweet.class);


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


