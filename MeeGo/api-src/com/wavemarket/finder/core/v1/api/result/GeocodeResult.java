package com.wavemarket.finder.core.v1.api.result;

import com.wavemarket.finder.core.v1.dto.TAddress;
import com.wavemarket.finder.core.v1.dto.TLongLat;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 2:41:18 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class GeocodeResult implements java.io.Serializable {

   private TAddress address;
   private TLongLat coord;

   public GeocodeResult() {
      // auto-generated
   }
   
   public GeocodeResult(TAddress address, TLongLat coord) {
      this.address = address;
      this.coord = coord;
   }

   public TAddress getAddress() {
      return address;
   }

   public void setAddress(TAddress address) {
      this.address = address;
   }

   public TLongLat getCoord() {
      return coord;
   }

   public void setCoord(TLongLat coord) {
      this.coord = coord;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

