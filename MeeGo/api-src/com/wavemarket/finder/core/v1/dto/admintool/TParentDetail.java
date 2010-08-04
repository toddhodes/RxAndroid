package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.Date;
import java.util.List;

import com.wavemarket.finder.core.v1.dto.TMessageDeliveryType;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 5, 2008
 * Created-Time: 4:44:32 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TParentDetail implements java.io.Serializable {

   protected long id;
   protected String phoneNumber;
   protected String displayName;
   protected String email;
   protected String zipcode;
   protected String timezone;
   protected String locale;
   protected String accountStatus;
   protected String provisionState;
   protected String actorStatus;
   protected String parentRoleStatus;
   protected String billingCode;
   protected Date lastLogin;
   protected TMessageDeliveryType accountMessageDeliveryType;
   protected TMessageDeliveryType locateMessageDeliveryType;
   protected List<TBillingEvent> billingEvents;
   protected boolean blocked;
   protected String carrierStatus;
   protected String carrierAvailability;

   public TParentDetail() {
      // auto-generated
   }
   
   public TParentDetail(long id, String phoneNumber,
                        String displayName, String email,
                        String zipcode, String timezone,
                        String locale, String accountStatus,
                        String provisionState, String actorStatus,
                        String parentRoleStatus, String billingCode,
                        Date lastLogin, TMessageDeliveryType accountMessageDeliveryType, 
                        TMessageDeliveryType locateMessageDeliveryType,
                        List<TBillingEvent> billingEvents, boolean blocked, 
                        String carrierStatus, String carrierAvailability) {
      this.id = id;
      this.phoneNumber = phoneNumber;
      this.displayName = displayName;
      this.email = email;
      this.zipcode = zipcode;
      this.timezone = timezone;
      this.locale = locale;
      this.accountStatus = accountStatus;
      this.provisionState = provisionState;
      this.actorStatus = actorStatus;
      this.parentRoleStatus = parentRoleStatus;
      this.billingCode = billingCode;
      this.lastLogin = lastLogin;
      this.accountMessageDeliveryType = accountMessageDeliveryType;
      this.locateMessageDeliveryType = locateMessageDeliveryType;
      this.billingEvents = billingEvents;
      this.blocked = blocked;
      this.carrierStatus = carrierStatus;
      this.carrierAvailability = carrierAvailability;
   }

   //copy constructor
   public TParentDetail(TParentDetail parentDetail) {
      this(
            parentDetail.id,
            parentDetail.phoneNumber,
            parentDetail.displayName,
            parentDetail.email,
            parentDetail.zipcode,
            parentDetail.timezone,
            parentDetail.locale,
            parentDetail.accountStatus,
            parentDetail.provisionState,
            parentDetail.accountStatus,
            parentDetail.parentRoleStatus,
            parentDetail.billingCode,
            parentDetail.lastLogin,
            parentDetail.accountMessageDeliveryType,
            parentDetail.locateMessageDeliveryType,
            parentDetail.billingEvents,
            parentDetail.blocked, 
            parentDetail.carrierStatus,
            parentDetail.carrierAvailability
            );
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getDisplayName() {
      return displayName;
   }

   public void setDisplayName(String displayName) {
      this.displayName = displayName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }

   public String getLocale() {
      return locale;
   }

   public void setLocale(String locale) {
      this.locale = locale;
   }

   public String getAccountStatus() {
      return accountStatus;
   }

   public void setAccountStatus(String accountStatus) {
      this.accountStatus = accountStatus;
   }

   public String getProvisionState() {
      return provisionState;
   }

   public void setProvisionState(String provisionState) {
      this.provisionState = provisionState;
   }

   public String getActorStatus() {
      return actorStatus;
   }

   public void setActorStatus(String actorStatus) {
      this.actorStatus = actorStatus;
   }

   public String getParentRoleStatus() {
      return parentRoleStatus;
   }

   public void setParentRoleStatus(String parentRoleStatus) {
      this.parentRoleStatus = parentRoleStatus;
   }

   public String getBillingCode() {
      return billingCode;
   }

   public void setBillingCode(String billingCode) {
      this.billingCode = billingCode;
   }

   public Date getLastLogin() {
      return lastLogin;
   }

   public void setLastLogin(Date lastLogin) {
      this.lastLogin = lastLogin;
   }

   public TMessageDeliveryType getAccountMessageDeliveryType() {
      return accountMessageDeliveryType;
   }

   public void setAccountMessageDeliveryType(
         TMessageDeliveryType accountMessageDeliveryType) {
      this.accountMessageDeliveryType = accountMessageDeliveryType;
   }

   public TMessageDeliveryType getLocateMessageDeliveryType() {
      return locateMessageDeliveryType;
   }

   public void setLocateMessageDeliveryType(
         TMessageDeliveryType locateMessageDeliveryType) {
      this.locateMessageDeliveryType = locateMessageDeliveryType;
   }

   public List<TBillingEvent> getBillingEvents() {
      return billingEvents;
   }

   public void setBillingEvents(List<TBillingEvent> billingEvents) {
      this.billingEvents = billingEvents;
   }

   public boolean isBlocked() {
      return blocked;
   }

   public void setBlocked(boolean blocked) {
      this.blocked = blocked;
   }

   public String getCarrierStatus() {
      return carrierStatus;
   }

   public void setCarrierStatus(String carrierStatus) {
      this.carrierStatus = carrierStatus;
   }

   public String getCarrierAvailability() {
      return carrierAvailability;
   }

   public void setCarrierAvailability(String carrierAvailability) {
      this.carrierAvailability = carrierAvailability;
   }
   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

