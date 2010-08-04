package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:57:22 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TLandmark implements java.io.Serializable {

   private long id;
   private String name;
   private TAddress address;
   private TLongLat location;

   public TLandmark() {
      // auto-generated
   }
   
   public TLandmark(long id, String name, TAddress address, TLongLat location) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.location = location;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public TAddress getAddress() {
      return address;
   }

   public void setAddress(TAddress address) {
      this.address = address;
   }

   public TLongLat getLocation() {
      return location;
   }

   public void setLocation(TLongLat location) {
      this.location = location;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

