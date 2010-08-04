package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 1:02:55 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TLongLat implements java.io.Serializable {

   private long longitude;
   private long latitude;

   public TLongLat() {
      // auto-generated
   }
   
   public TLongLat(long longitude, long latitude) {
      this.longitude = longitude;
      this.latitude = latitude;
   }

   public long getLongitude() {
      return longitude;
   }

   public void setLongitude(long longitude) {
      this.longitude = longitude;
   }

   public long getLatitude() {
      return latitude;
   }

   public void setLatitude(long latitude) {
      this.latitude = latitude;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/