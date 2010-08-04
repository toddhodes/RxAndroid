package com.wavemarket.finder.core.v1.dto;

import java.util.Locale;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:43:41 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAccountData implements java.io.Serializable {

   private long id;
   private String name;
   private String contactPhone;
   private String email;
   private TMessageDeliveryType accountMessageDeliveryType;
   private TMessageDeliveryType locateMessageDeliveryType;
   private Locale locale;
   private String timezone;
   private String zipcode;
   private int lowAccuracyThreshold;
   private boolean suspended;   
   
   public TAccountData() {
      // auto-generated
   }
   
   public TAccountData(long id, String name,
                       String contactPhone, String email,
                       TMessageDeliveryType accountMessageDeliveryType,
                       TMessageDeliveryType locateMessageDeliveryType,
                       Locale locale, String timezone,
                       String zipcode, int lowAccuracyThreshold,
                       boolean suspended) {
      this.id = id;
      this.name = name;
      this.contactPhone = contactPhone;
      this.email = email;
      this.accountMessageDeliveryType = accountMessageDeliveryType;
      this.locateMessageDeliveryType = locateMessageDeliveryType;
      this.locale = locale;
      this.timezone = timezone;
      this.zipcode = zipcode;
      this.lowAccuracyThreshold = lowAccuracyThreshold;
      this.suspended = suspended;
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

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public TMessageDeliveryType getAccountMessageType() {
      return accountMessageDeliveryType;
   }

   public void setAccountMessageType(TMessageDeliveryType accountMessageDeliveryType) {
      this.accountMessageDeliveryType = accountMessageDeliveryType;
   }

   public TMessageDeliveryType getLocateMessageType() {
      return locateMessageDeliveryType;
   }

   public void setLocateMessageType(TMessageDeliveryType locateMessageDeliveryType) {
      this.locateMessageDeliveryType = locateMessageDeliveryType;
   }

   public Locale getLocale() {
      return locale;
   }

   public void setLocale(Locale locale) {
      this.locale = locale;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public int getLowAccuracyThreshold() {
      return lowAccuracyThreshold;
   }

   public void setLowAccuracyThreshold(int lowAccuracyThreshold) {
      this.lowAccuracyThreshold = lowAccuracyThreshold;
   }

   public boolean isSuspended() {
      return suspended;
   }

   public void setSuspended(boolean suspended) {
      this.suspended = suspended;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

