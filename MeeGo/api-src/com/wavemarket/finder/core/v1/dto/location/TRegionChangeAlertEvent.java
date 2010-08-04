package com.wavemarket.finder.core.v1.dto.location;

import com.wavemarket.finder.core.v1.dto.TAlertDirection;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Jul 22, 2008
 * Created-Time: 11:28:38 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TRegionChangeAlertEvent extends TLocationEvent implements java.io.Serializable {

   private long landmarkId;
   private String landmarkName;
   private long regionChangeAlertId;
   private int radius;
   private TAlertDirection direction;

   public TRegionChangeAlertEvent() {
      // auto-generated
   }
   
   public TRegionChangeAlertEvent(long assetId, String assetName,
                                  TLocateResult result, Date dateRecorded,
                                  long landmarkId, String landmarkName,
                                  long regionChangeAlertId, int radius,
                                  TAlertDirection direction) {
      super(assetId, assetName, result, dateRecorded);
      this.landmarkId = landmarkId;
      this.landmarkName = landmarkName;
      this.regionChangeAlertId = regionChangeAlertId;
      this.radius = radius;
      this.direction = direction;
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

   public long getRegionChangeAlertId() {
      return regionChangeAlertId;
   }

   public void setRegionChangeAlertId(long regionChangeAlertId) {
      this.regionChangeAlertId = regionChangeAlertId;
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
