package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.location.TAccuracy;

/**
 * @author oliver
 */

/*
 * Created-Date: May 13, 2008
 * Created-Time: 3:16:20 PM
 * Copyright 2007 WaveMarket, Inc 
 */

public class TTimePlace implements java.io.Serializable {
   private TLongLat longLat;
   private long time; // seconds since the epoch
   private TAccuracy accuracy; //accuracy of time place
   private boolean isKnown;

   public TTimePlace() {
      // auto-generated
   }
   
   public TTimePlace(TLongLat longLat, long time, TAccuracy accuracy, boolean known) {
      this.longLat = longLat;
      this.time = time;
      this.accuracy = accuracy;
      isKnown = known;
   }

   public TLongLat getLongLat() {
      return longLat;
   }

   public void setLongLat(TLongLat longLat) {
      this.longLat = longLat;
   }

   public long getTime() {
      return time;
   }

   public void setTime(long time) {
      this.time = time;
   }

   public TAccuracy getAccuracy() {
      return accuracy;
   }

   public void setAccuracy(TAccuracy accuracy) {
      this.accuracy = accuracy;
   }

   public boolean isKnown() {
      return isKnown;
   }

   public void setKnown(boolean known) {
      isKnown = known;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

