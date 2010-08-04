package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.Map;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 2:48:04 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TPhoneAccountData implements java.io.Serializable {

   protected String mdn;
   protected TNetwork network;
   protected String accountNumber;
   protected TBillingSystem billingSystem;
   protected TPhoneStatus status;
   protected TCompatible controlPlaneLocCompatible;
   protected TCompatible brewTagLocCompatible;
   protected TCompatible j2meTagLocCompatible;
   protected TCompatible brewParentCompatible;
   protected TCompatible j2meParentCompatible;
   protected Map<String, String> properties;

   protected boolean allowParentRole;
   protected boolean allowChildRole;

   protected boolean highQualityLocatable;
   protected boolean lowQualityLocatable;
   

   public TPhoneAccountData() {
      // auto-generated
   }
   
   public TPhoneAccountData(String mdn, TNetwork network,
                           String accountNumber, TBillingSystem billingSystem,
                           TPhoneStatus status, TCompatible controlPlaneLocCompatible,
                           TCompatible brewTagLocCompatible,
                           TCompatible brewParentCompatible,
                           TCompatible j2meTagLocCompatible,
                           TCompatible j2meParentCompatible,
                           boolean allowParentRole,
                           boolean allowChildRole,
                           boolean highQualityLocatable,
                           boolean lowQualityLocatable,
                           Map<String, String> properties) {
      this.mdn = mdn;
      this.network = network;
      this.billingSystem = billingSystem;
      this.accountNumber = accountNumber;
      this.status = status;
      this.controlPlaneLocCompatible = controlPlaneLocCompatible;
      this.brewTagLocCompatible = brewTagLocCompatible;
      this.j2meTagLocCompatible = j2meTagLocCompatible;
      this.brewParentCompatible = brewParentCompatible;
      this.j2meParentCompatible = j2meParentCompatible;

      this.allowParentRole = allowParentRole;
      this.allowChildRole = allowChildRole;
      this.highQualityLocatable = highQualityLocatable;
      this.lowQualityLocatable = lowQualityLocatable;
      
      this.properties = properties;
   }

   public String getMdn() {
      return mdn;
   }

   public void setMdn(String mdn) {
      this.mdn = mdn;
   }

   public TNetwork getNetwork() {
      return network;
   }

   public void setNetwork(TNetwork network) {
      this.network = network;
   }

   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public TPhoneStatus getStatus() {
      return status;
   }

   public void setStatus(TPhoneStatus status) {
      this.status = status;
   }

   public TCompatible getControlPlaneLocCompatible() {
      return controlPlaneLocCompatible;
   }

   public void setControlPlaneLocCompatible(TCompatible controlPlaneLocCompatible) {
      this.controlPlaneLocCompatible = controlPlaneLocCompatible;
   }

   public TCompatible getBrewTagLocCompatible() {
      return brewTagLocCompatible;
   }

   public void setBrewTagLocCompatible(TCompatible brewTagLocCompatible) {
      this.brewTagLocCompatible = brewTagLocCompatible;
   }

   public TCompatible getJ2meTagLocCompatible() {
      return j2meTagLocCompatible;
   }

   public void setJ2meTagLocCompatible(TCompatible j2meTagLocCompatible) {
      this.j2meTagLocCompatible = j2meTagLocCompatible;
   }

   public TCompatible getBrewParentCompatible() {
      return brewParentCompatible;
   }

   public void setBrewParentCompatible(TCompatible brewParentCompatible) {
      this.brewParentCompatible = brewParentCompatible;
   }

   public TCompatible getJ2meParentCompatible() {
      return j2meParentCompatible;
   }

   public void setJ2meParentCompatible(TCompatible j2meParentCompatible) {
      this.j2meParentCompatible = j2meParentCompatible;
   }

   public boolean isAllowParentRole() {
      return allowParentRole;
   }

   public void setAllowParentRole(boolean allowParentRole) {
      this.allowParentRole = allowParentRole;
   }

   public boolean isAllowChildRole() {
      return allowChildRole;
   }

   public void setAllowChildRole(boolean allowChildRole) {
      this.allowChildRole = allowChildRole;
   }

   public boolean isHighQualityLocatable() {
      return highQualityLocatable;
   }

   public void setHighQualityLocatable(boolean highQualityLocatable) {
      this.highQualityLocatable = highQualityLocatable;
   }

   public boolean isLowQualityLocatable() {
      return lowQualityLocatable;
   }

   public void setLowQualityLocatable(boolean lowQualityLocatable) {
      this.lowQualityLocatable = lowQualityLocatable;
   }

   public Map<String, String> getProperties() {
      return properties;
   }

   public void setProperties(Map<String, String> properties) {
      this.properties = properties;
   }

   public TBillingSystem getBillingSystem() {
      return billingSystem;
   }

   public void setBillingSystem(TBillingSystem billingSystem) {
      this.billingSystem = billingSystem;
   }


}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

