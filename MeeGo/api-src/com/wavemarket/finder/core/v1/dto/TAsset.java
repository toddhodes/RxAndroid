package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.admintool.TLocateNotification;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:43:49 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAsset implements java.io.Serializable {

   private long id;
   private String name;
   private String contactPhone;
   private boolean permittedToLocate;
   private boolean beingTracked;
   private TLocateNotification locateNotification;

   public TAsset() {      
   }
   
   public TAsset(long id, String name, String contactPhone,
                 boolean permittedToLocate, boolean beingTracked,
                 TLocateNotification locateNotification) {
      this.id = id;
      this.name = name;
      this.contactPhone = contactPhone;
      this.permittedToLocate = permittedToLocate;
      this.locateNotification = locateNotification;
      this.beingTracked = beingTracked;
   }
   
   public TAsset(TAsset asset) {      
      this.id = asset.getId();
      this.name = asset.getName();
      this.contactPhone = asset.getContactPhone();
      this.permittedToLocate = asset.isPermittedToLocate();
      this.beingTracked = asset.isBeingTracked();
      this.locateNotification = asset.getLocateNotification();      
   }
   
   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getContactPhone() {
      return contactPhone;
   }

   public void setContactPhone(String contactPhone) {
      this.contactPhone = contactPhone;
   }

   public boolean isPermittedToLocate() {
      return permittedToLocate;
   }

   public void setPermittedToLocate(boolean permittedToLocate) {
      this.permittedToLocate = permittedToLocate;
   }
   
   public boolean isBeingTracked() {
      return beingTracked;
   }
   
   public void setBeingTracked( boolean beingTracked ) {
      this.beingTracked = beingTracked;
   }

   public TLocateNotification getLocateNotification() {
      return locateNotification;
   }

   public void setLocateNotification(TLocateNotification locateNotification) {
      this.locateNotification = locateNotification;
   }

   @Override
   public String toString() {
      return "TAsset [beingTracked=" + this.beingTracked + ", contactPhone="
            + this.contactPhone + ", id=" + this.id + ", locateNotification="
            + this.locateNotification + ", name=" + this.name
            + ", permittedToLocate=" + this.permittedToLocate + "]";
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

