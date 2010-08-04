package com.wavemarket.finder.core.v1.dto.admintool;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 1:03:38 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDevice implements java.io.Serializable {
   private long id;
   private String mdn;
   private TAccountState accountState;
   private TNetwork network;

   public TDevice() {
      // auto-generated
   }
   
   public TDevice(long id, String mdn,
                 TAccountState accountState,
                 TNetwork network) {
      this.id = id;
      this.mdn = mdn;
      this.accountState = accountState;
      this.network = network;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getMdn() {
      return mdn;
   }

   public void setMdn(String mdn) {
      this.mdn = mdn;
   }

   public TAccountState getAccountState() {
      return accountState;
   }

   public void setAccountState(TAccountState accountState) {
      this.accountState = accountState;
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

