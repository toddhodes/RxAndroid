/**
 * 
 */
package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

/**
 * @author rwest
 *
 */
public class TContTrackingLocationEvent extends TLocationEvent implements java.io.Serializable {
   
   private long timeBetweenLocatesSec;
   private Date stopTime;
   
   public TContTrackingLocationEvent() {
      // auto-generated
   }

   /**
    * @param assetId
    * @param assetName
    * @param result
    * @param dateRecorded
   */
   public TContTrackingLocationEvent(long assetId, String assetName,
         TLocateResult result, Date dateRecorded, 
         long timeBetweenLocatesSec, Date stopTime) {
      super(assetId, assetName, result, dateRecorded);
      this.timeBetweenLocatesSec = timeBetweenLocatesSec;
      this.stopTime = stopTime;
   }

   public long getTimeBetweenLocatesSec() {
      return timeBetweenLocatesSec;
   }

   public void setTimeBetweenLocatesSec( long timeBetweenLocatesSec ) {
      this.timeBetweenLocatesSec = timeBetweenLocatesSec;
   }

   public Date getStopTime() {
      return stopTime;
   }

   public void setStopTime( Date stopTime ) {
      this.stopTime = stopTime;
   }

}
