package com.wavemarket.finder.core.v1.dto;

public class TAccountTypeData implements java.io.Serializable {
   private int maxNumberAssets;
   private boolean atMaxAssets;
   private boolean canGoAboveMax;
   private boolean canGetTrial;
   private TAccountType accountType;

    public TAccountTypeData() {
	// auto-generated
    }
    
   public TAccountTypeData(int maxNumberAssets,
                           boolean atMaxAssets,
                           boolean canGoAboveMax,
                           boolean canGetTrial,
                           TAccountType accountType){

      this.maxNumberAssets = maxNumberAssets;
      this.atMaxAssets = atMaxAssets;
      this.accountType = accountType;
      this.canGoAboveMax = canGoAboveMax;
      this.canGetTrial = canGetTrial;
   }
   
   public int getMaxNumberAssets() {
      return maxNumberAssets;
   }

   public boolean isAtMaxAssets() {
      return atMaxAssets;
   }

   public boolean isCanGoAboveMax() {
      return canGoAboveMax;
   }

   public TAccountType getAccountType() {
      return accountType;
   }
   
   public boolean isCanGetTrial() {
      return canGetTrial;
   }

   public static enum TAccountType{
      Alltel_GENERAL,
      ATT_999,
      ATT_1499,
      ATT_IPHONE_999,
      ATT_IPHONE_1499,
      Sprint_GENERAL,
      Verizon_GENERAL,
      COULD_NOT_DETERMINE;
   }
}
