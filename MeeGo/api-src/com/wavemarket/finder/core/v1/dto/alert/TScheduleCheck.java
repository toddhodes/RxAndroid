package com.wavemarket.finder.core.v1.dto.alert;

import com.wavemarket.finder.core.v1.dto.TWeekday;
import com.wavemarket.finder.core.v1.dto.TAlertDirection;

import java.util.Set;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 11:02:47 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TScheduleCheck extends TAlert implements java.io.Serializable {

   private long assetId;
   private long landmarkId;
   private Set<TWeekday> daysToFire;
   private int timeToFire; // in seconds since the start of the day.
   private TAlertDirection direction;

   public TScheduleCheck() {
      // auto-generated
   }
   
   public TScheduleCheck(long id, 
                         long assetId, long landmarkId,
                         Set<TWeekday> daysToFire, int timeToFire,
                         boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                         boolean notifyThirdPartyViaEmail, String thirtyPartyEmail,
                         String timezone, TAlertDirection direction) {
      super(id, notifyParentViaEmail, notifyParentViaSMS,
            notifyThirdPartyViaEmail, thirtyPartyEmail, timezone);
      this.assetId = assetId;
      this.landmarkId = landmarkId;
      this.daysToFire = daysToFire;
      this.timeToFire = timeToFire;
      this.direction = direction;
   }

   public long getAssetId() {
      return assetId;
   }

   public void setAssetId(long assetId) {
      this.assetId = assetId;
   }

   public long getLandmarkId() {
      return landmarkId;
   }

   public void setLandmarkId(long landmarkId) {
      this.landmarkId = landmarkId;
   }

   public Set<TWeekday> getDaysToFire() {
      return daysToFire;
   }

   public void setDaysToFire(Set<TWeekday> daysToFire) {
      this.daysToFire = daysToFire;
   }

   public int getTimeToFire() {
      return timeToFire;
   }

   public void setTimeToFire(int timeToFire) {
      this.timeToFire = timeToFire;
   }

   public TAlertDirection getDirection() {
      return direction;
   }

   public void setDirection(TAlertDirection direction) {
      this.direction = direction;
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
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
*/
