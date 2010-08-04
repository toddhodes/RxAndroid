package com.wavemarket.finder.core.v1.dto.signup;

import java.io.Serializable;

import com.wavemarket.finder.core.v1.dto.admintool.TLocateNotification;

public class TAssetInfo implements Serializable {
   
   private String displayName;
   private String mdn;
   private TLocateNotification notification;

    public TAssetInfo() {
	// auto-generated
    }
    
   public TAssetInfo(String displayName, String mdn, TLocateNotification notification){
      this.displayName = displayName;
      this.mdn = mdn;
      this.notification = notification;
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
   public TLocateNotification getNotification() {
      return notification;
   }
   public void setNotification(TLocateNotification notification) {
      this.notification = notification;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result
            + ((displayName == null) ? 0 : displayName.hashCode());
      result = prime * result + ((mdn == null) ? 0 : mdn.hashCode());
      result = prime * result
            + ((notification == null) ? 0 : notification.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      TAssetInfo other = (TAssetInfo) obj;
      if (displayName == null) {
         if (other.displayName != null)
            return false;
      } else if (!displayName.equals(other.displayName))
         return false;
      if (mdn == null) {
         if (other.mdn != null)
            return false;
      } else if (!mdn.equals(other.mdn))
         return false;
      if (notification == null) {
         if (other.notification != null)
            return false;
      } else if (!notification.equals(other.notification))
         return false;
      return true;
   }
   
}
