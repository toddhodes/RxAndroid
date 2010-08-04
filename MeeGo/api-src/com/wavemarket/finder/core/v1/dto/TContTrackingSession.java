/**
 * 
 */
package com.wavemarket.finder.core.v1.dto;

import java.util.Date;
import java.util.Map;

import com.wavemarket.finder.core.v1.dto.location.TLocateResult;

/**
 * @author rwest
 *
 *asset id
array of locate responses (time + location or error)
time between locates
stop time/number of locates left (depending on how defined)

 */
public class TContTrackingSession implements java.io.Serializable {

   private long assetId;
   private Map<Date,TLocateResult> locationResults;
   private Date startTime;
   private Date stopTime;
   private boolean active;
   private String failureReason;
   private long timeBetweenLocatesSec;
   
   public TContTrackingSession() {
       // auto-generated
   }

   /**
    * 
   */
   public TContTrackingSession( long assetId, 
                                Map<Date,TLocateResult> locationResults, 
                                boolean active,
                                Date startTime, 
                                Date stopTime,
                                long timeBetweenLocatesSec,
                                String failureReason ) {
      this.assetId = assetId;
      this.locationResults = locationResults;
      this.active = active;
      this.startTime = startTime;
      this.stopTime = stopTime;
      this.timeBetweenLocatesSec = timeBetweenLocatesSec;
      this.failureReason = failureReason;
   }

   public long getAssetId() {
      return assetId;
   }

   public void setAssetId( long assetId ) {
      this.assetId = assetId;
   }

   public Map<Date, TLocateResult> getLocationResults() {
      return locationResults;
   }

   public void setLocationResults( Map<Date, TLocateResult> locationResults ) {
      this.locationResults = locationResults;
   }
   
   public Date getStartTime() {
      return startTime;
   }
   
   public void setStartTime( Date startTime ) {
      this.startTime = startTime;
   }

   public Date getStopTime() {
      return stopTime;
   }

   public void setStopTime( Date stopTime ) {
      this.stopTime = stopTime;
   }
   
   public long getTimeBetweenLocatesSec() {
      return this.timeBetweenLocatesSec;
   }
   
   public void setTimeBetweenLocatesSec( long timeSec ) {
      this.timeBetweenLocatesSec = timeSec;
   }
   
   public boolean isActive() {
      return active;
   }
   
   public void setActive( boolean active ) {
      this.active = active;
   }
   
   public String getFailureReason() {
      return failureReason;
   }
   
   public void setFailureReason( String failureReason ) {
      this.failureReason = failureReason;
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append("VContTrackingSession(assetId=");
      sb.append(getAssetId());
      sb.append(",active=");
      sb.append(isActive());
      sb.append(",startTime=");
      sb.append(getStartTime());
      sb.append(",stopTime=");
      sb.append(getStopTime());
      sb.append(",secBetweenLocates=");
      sb.append(getTimeBetweenLocatesSec());
      sb.append(",failureReason=");
      sb.append(getFailureReason());
      sb.append(")");

      return sb.toString();
   }

}
