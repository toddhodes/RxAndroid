package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.Date;
import java.util.List;

import com.wavemarket.finder.core.v1.dto.location.TAccuracy;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 1:38:28 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TChild implements java.io.Serializable {
   private String phoneNumber;
   private String name;
   private TLocateNotification locateNotification;
   private Date dateAdded;
   private Date dateLastSuccessfulLocate;
   private TAccuracy lastSuccessfulLocateAccuracy;
   private Date dateLastFailedLocate;
   private String lastFailedLocateErrorCode;
   protected List<TBillingEvent> billingEvents;

   public TChild() {
      // empty constructor
   }
   
   public TChild(String name, String phoneNumber,
         TLocateNotification locateNotification, Date dateAdded,
         Date dateLastSuccessfulLocate, TAccuracy lastSuccessfulLocateAccuracy,
         Date dateLastFailedLocate, String lastFailedLocateErrorCode,
         List<TBillingEvent> billingEvents) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.locateNotification = locateNotification;
      this.dateAdded = dateAdded;
      this.dateLastSuccessfulLocate = dateLastSuccessfulLocate;
      this.lastSuccessfulLocateAccuracy = lastSuccessfulLocateAccuracy;
      this.dateLastFailedLocate = dateLastFailedLocate;
      this.lastFailedLocateErrorCode = lastFailedLocateErrorCode;
      this.billingEvents = billingEvents;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public TLocateNotification getLocateNotification() {
      return locateNotification;
   }

   public void setLocateNotification(TLocateNotification locateNotification) {
      this.locateNotification = locateNotification;
   }

   public Date getDateAdded() {
      return dateAdded;
   }

   public void setDateAdded(Date dateAdded) {
      this.dateAdded = dateAdded;
   }

   public Date getDateLastSuccessfulLocate() {
      return dateLastSuccessfulLocate;
   }

   public void setDateLastSuccessfulLocate(Date dateLastSuccessfulLocate) {
      this.dateLastSuccessfulLocate = dateLastSuccessfulLocate;
   }

   public TAccuracy getLastSuccessfulLocateAccuracy() {
      return lastSuccessfulLocateAccuracy;
   }

   public void setLastSuccessfulLocateAccuracy(
         TAccuracy lastSuccessfulLocateAccuracy) {
      this.lastSuccessfulLocateAccuracy = lastSuccessfulLocateAccuracy;
   }

   public Date getDateLastFailedLocate() {
      return dateLastFailedLocate;
   }

   public void setDateLastFailedLocate(Date dateLastFailedLocate) {
      this.dateLastFailedLocate = dateLastFailedLocate;
   }

   public String getLastFailedLocateErrorCode() {
      return lastFailedLocateErrorCode;
   }

   public void setLastFailedLocateErrorCode(String lastFailedLocateErrorCode) {
      this.lastFailedLocateErrorCode = lastFailedLocateErrorCode;
   }

   public List<TBillingEvent> getBillingEvents() {
      return billingEvents;
   }

   public void setBillingEvents(List<TBillingEvent> billingEvents) {
      this.billingEvents = billingEvents;
   }

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

