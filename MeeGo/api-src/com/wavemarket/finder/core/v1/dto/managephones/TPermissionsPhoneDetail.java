package com.wavemarket.finder.core.v1.dto.managephones;


public class TPermissionsPhoneDetail implements java.io.Serializable {
  
  private String mdn; // phone number
  private boolean compatible; // compatibleness

    public TPermissionsPhoneDetail() {
	// auto-generated
    }
    
  public TPermissionsPhoneDetail(
      String mdn,
      boolean compatible, 
      boolean registered) {
    this.mdn = mdn;
    this.compatible = compatible;
  }

  public boolean isCompatible() {
    return compatible;
  }

  public void setCompatible(boolean compatible) {
    this.compatible = compatible;
  }

  public String getMdn() {
    return mdn;
  }

  public void setMdn(String mdn) {
    this.mdn = mdn;
  }

}