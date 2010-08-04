package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.admintool.TNetwork;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 3:26:44 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDevice implements java.io.Serializable {

   private String mdn;
   private TNetwork network;

   public TDevice() {
      // auto-generated
   }
   
   public TDevice(String mdn, TNetwork network) {
      this.mdn = mdn;
      this.network = network;
   }

   public String getMdn() {
      return mdn;
   }

   public void setMdn(String mdn) {
      this.mdn = mdn;
   }

   public TNetwork getNetwork() {
      return network;
   }

   public void setNetwork(TNetwork network) {
      this.network = network;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

