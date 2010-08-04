package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 4:46:49 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TScheduleCheckEvent extends TLocationEvent implements java.io.Serializable {

   private long landmarkId;
   private String landmarkName;
   private long scheduleCheckId;
   private boolean nearLandmark;

   public TScheduleCheckEvent() {
      // auto-generated
   }
   
   public TScheduleCheckEvent(long assetId, String assetName,
                              TLocateResult result, Date dateRecorded,
                              long landmarkId, String landmarkName,
                              long scheduleCheckId, boolean nearLandmark) {
      super(assetId, assetName, result, dateRecorded);
      this.landmarkId = landmarkId;
      this.landmarkName = landmarkName;
      this.scheduleCheckId = scheduleCheckId;
      this.nearLandmark = nearLandmark;
   }

   public long getLandmarkId() {
      return landmarkId;
   }

   public void setLandmarkId(long landmarkId) {
      this.landmarkId = landmarkId;
   }

   public String getLandmarkName() {
      return landmarkName;
   }

   public void setLandmarkName(String landmarkName) {
      this.landmarkName = landmarkName;
   }

   public long getScheduleCheckId() {
      return scheduleCheckId;
   }

   public void setScheduleCheckId(long scheduleCheckId) {
      this.scheduleCheckId = scheduleCheckId;
   }

   public boolean isNearLandmark() {
      return nearLandmark;
   }

   public void setNearLandmark(boolean nearLandmark) {
      this.nearLandmark = nearLandmark;
   }
   
   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3 ft=java
*/
