package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 11:02:11 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TGeocodeResult extends TAddress implements java.io.Serializable {

   public TGeocodeResult() {
      // auto-generated
   }
   
   public TGeocodeResult(String streetaddr, String city, String state, String zipcode, String country) {
      super(streetaddr, city, state, zipcode, country);
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

