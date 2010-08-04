package com.wavemarket.finder.core.v1.dto.admintool;

/**
 * @author oliver
 */

/*
 * Created-Date: Jul 24, 2008
 * Created-Time: 12:14:27 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDeviceParentInfo implements java.io.Serializable {

   private long adminId;
   private String displayName;
   private String mdn;
   private boolean suspended;
   private boolean canLocateDevice;
   private boolean onSameAccount;

   public TDeviceParentInfo() {
      // auto-generated
   }
   
   public TDeviceParentInfo(long adminId, String displayName,
                            String mdn, boolean suspended,
                            boolean canLocateDevice, boolean onSameAccount) {
      this.adminId = adminId;
      this.displayName = displayName;
      this.mdn = mdn;
      this.suspended = suspended;
      this.canLocateDevice = canLocateDevice;
      this.onSameAccount = onSameAccount;
   }

   public long getAdminId() {
      return adminId;
   }

   public void setAdminId(long adminId) {
      this.adminId = adminId;
   }

   public String getDisplayName() {
      return displayName;
   }

   public void setDisplayName(String displayName) {
      this.displayName = displayName;
   }

   public String getMdn() {
      return mdn;
   }

   public void setMdn(String mdn) {
      this.mdn = mdn;
   }

   public boolean isSuspended() {
      return suspended;
   }

   public void setSuspended(boolean suspended) {
      this.suspended = suspended;
   }

   public boolean isCanLocateDevice() {
      return canLocateDevice;
   }

   public void setCanLocateDevice(boolean canLocateDevice) {
      this.canLocateDevice = canLocateDevice;
   }

   public boolean isOnSameAccount() {
      return onSameAccount;
   }

   public void setOnSameAccount(boolean onSameAccount) {
      this.onSameAccount = onSameAccount;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

