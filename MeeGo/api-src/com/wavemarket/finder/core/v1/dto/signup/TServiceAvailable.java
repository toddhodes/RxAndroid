package com.wavemarket.finder.core.v1.dto.signup;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 17, 2008
 * Created-Time: 3:36:41 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public enum TServiceAvailable implements java.io.Serializable {
   SERVICE_ALLOWED(true),
   SERVICE_ALLOWED_NO_TRIAL(false),
   SERVICE_ALLOWED_DEMO(false),
   ALREADY_REGISTERED(false),
   UNAVAILABLE_FOR_ACCOUNT_TYPE(false),
   UNAVAILABLE_FOR_ACCOUNT_TYPE_CORPORATE_LIABLE(false),
   UNAVAILABLE_FOR_ACCOUNT_TYPE_PREPAID(false),
   DEVICE_INCOMPATIBLE(false);
   
   private boolean canGetTrial;
   
   private TServiceAvailable(boolean canGetTrial) {
      this.canGetTrial = canGetTrial;
   }

   public boolean isCanGetTrial() {
      return canGetTrial;
   }
}
