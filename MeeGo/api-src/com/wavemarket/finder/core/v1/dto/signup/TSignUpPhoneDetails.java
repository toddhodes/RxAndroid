package com.wavemarket.finder.core.v1.dto.signup;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 17, 2008
 * Created-Time: 3:34:50 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TSignUpPhoneDetails implements java.io.Serializable {

   private String mdn;
   private TServiceAvailable available;
   private boolean alreadyBilled;

   private boolean highQualityLocatable;
   private boolean lowQualityLocatable;

   public TSignUpPhoneDetails() {
      // auto-generated
   }
   
   public TSignUpPhoneDetails(String mdn, TServiceAvailable available, boolean alreadyBilled,
                             boolean highQualityLocatable, boolean lowQualityLocatable) {
      this.mdn = mdn;
      this.available = available;
      this.alreadyBilled = alreadyBilled;
      this.highQualityLocatable = highQualityLocatable;
      this.lowQualityLocatable = lowQualityLocatable;
   }
   
   public String getMdn() {
      return mdn;
   }

   public void setMdn(String mdn) {
      this.mdn = mdn;
   }

   public TServiceAvailable getAvailable() {
      return available;
   }

   public void setAvailable(TServiceAvailable available) {
      this.available = available;
   }

   public boolean isAlreadyBilled() {
      return alreadyBilled;
   }

   public void setAlreadyBilled(boolean alreadyBilled) {
      this.alreadyBilled = alreadyBilled;
   }

   public boolean isHighQualityLocatable() {
      return this.highQualityLocatable;
   }

   public void setHighQualityLocatable(boolean highQualityLocatable) {
      this.highQualityLocatable = highQualityLocatable;
   }

   public boolean isLowQualityLocatable() {
      return this.lowQualityLocatable;
   }

   public void setLowQualityLocatable(boolean lowQualityLocatable) {
      this.lowQualityLocatable = lowQualityLocatable;
   }
   
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append(this.getClass().getCanonicalName());
      sb.append("{mdn=").append(mdn);
      sb.append(", available=").append(available);
      sb.append(", alreadyBilled=").append(alreadyBilled);
      sb.append(", highQualityLocatable=").append(highQualityLocatable);
      sb.append(", lowQualityLocatable=").append(lowQualityLocatable);
      sb.append('}');
      
      return sb.toString();
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

