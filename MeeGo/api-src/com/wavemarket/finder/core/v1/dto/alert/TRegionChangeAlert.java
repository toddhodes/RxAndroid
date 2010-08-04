package com.wavemarket.finder.core.v1.dto.alert;

import java.util.Set;

import com.wavemarket.finder.core.v1.dto.TAlertDirection;
import com.wavemarket.finder.core.v1.dto.TWeekday;

/**
 * @author oliver
 */

/*
 * Created-Date: Jul 15, 2008
 * Created-Time: 2:24:57 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TRegionChangeAlert extends TAlert implements java.io.Serializable {

   private long assetId;
   private long landmarkId;
   private int radius;
   private TAlertDirection direction;
   private Set<TWeekday> daysToFire;
   private int startSec;
   private int endSec;

   public TRegionChangeAlert() {
      // auto-generated
   }
   
   public TRegionChangeAlert(long id, long assetId, long landmarkId,
                             int radius, TAlertDirection direction,
                             Set<TWeekday> daysToFire, int startSec, int endSec,
                             boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                             boolean notifyThirdPartyViaEmail, String thirtyPartyEmail,
                             String timezone) {
      super(id, notifyParentViaEmail, notifyParentViaSMS,
            notifyThirdPartyViaEmail, thirtyPartyEmail, timezone);
      this.assetId = assetId;
      this.landmarkId = landmarkId;
      this.radius = radius;
      this.direction = direction;
      this.setDaysToFire(daysToFire);
      this.setStartSec(startSec);
      this.setEndSec(endSec);
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

   public int getRadius() {
      return radius;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   public TAlertDirection getDirection() {
      return direction;
   }

   public void setDirection(TAlertDirection direction) {
	   this.direction = direction;
   }

   public void setDaysToFire(Set<TWeekday> daysToFire) {
	   this.daysToFire = daysToFire;
   }

   public Set<TWeekday> getDaysToFire() {
	   return daysToFire;
   }

   public void setStartSec(int startSec) {
	   this.startSec = startSec;
   }

   public int getStartSec() {
	   return startSec;
   }

   public void setEndSec(int endSec) {
	   this.endSec = endSec;
   }

   public int getEndSec() {
	   return endSec;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

