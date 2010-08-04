package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:43:31 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TPointOfInterest implements java.io.Serializable {
   private String name;
   private String phone;
   private String description;
   private TLongLat longLat;
   private TAddress address;
   private String category;

   public TPointOfInterest() {
      // auto-generated
   }
   
   public TPointOfInterest(String name, String phone,
                           String description, TLongLat longLat,
                           TAddress address, String category) {
      this.name = name;
      this.phone = phone;
      this.description = description;
      this.longLat = longLat;
      this.address = address;
      this.category = category;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public TLongLat getLongLat() {
      return longLat;
   }

   public void setLongLat(TLongLat longLat) {
      this.longLat = longLat;
   }

   public TAddress getAddress() {
      return address;
   }

   public void setAddress(TAddress address) {
      this.address = address;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

