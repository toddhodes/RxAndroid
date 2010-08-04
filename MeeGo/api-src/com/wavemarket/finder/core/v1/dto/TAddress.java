package com.wavemarket.finder.core.v1.dto;

import java.io.Serializable;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 1:22:32 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAddress implements Serializable {

   private String streetaddr;
   private String city;
   private String state;
   private String zipcode;
   private String country;

   public TAddress() {
      // auto-generated
   }
   
   public TAddress(String streetaddr, String city, String state, String zipcode, String country) {
      this.streetaddr = streetaddr;
      this.city = city;
      this.state = state;
      this.zipcode = zipcode;
      this.country = country;
   }

   public String getStreetaddr() {
      return streetaddr;
   }

   public void setStreetaddr(String streetaddr) {
      this.streetaddr = streetaddr;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

