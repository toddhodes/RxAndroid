package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.Date;
import java.util.List;

import com.wavemarket.finder.core.v1.dto.TMessageDeliveryType;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 2:47:54 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TParent extends TParentDetail implements java.io.Serializable {
   private String password;
   private String group;

   public TParent() {
      // auto-generated
   }
   
   public TParent(long id, String phoneNumber,
                  String displayName, String email,
                  String zipcode, String timezone,
                  String group, String locale,
                  String accountStatus, String provisionState, String password,
                  String actorStatus, String parentRoleStatus, String billingCode,
                  Date lastLogin, TMessageDeliveryType accountMessageDeliveryType, 
                  TMessageDeliveryType locateMessageDeliveryType,
                  List<TBillingEvent> billingEvents, boolean blocked,
                  String carrierStatus, String carrierAvailability) {
      super(id, phoneNumber, displayName, email, zipcode, timezone,
            locale, accountStatus, provisionState, actorStatus, parentRoleStatus,
            billingCode, lastLogin, accountMessageDeliveryType, 
            locateMessageDeliveryType,  billingEvents, blocked, 
            carrierStatus, carrierAvailability);
      this.group = group;
      this.password = password;
   }

   public TParent(TParentDetail parentDetail) {
      super(parentDetail);
      this.group = null;
      this.password = null;
   }
   
   public TParent(TParentDetail parentDetail, String group, String password) {
      this(parentDetail);
      this.group = group;
      this.password = password;
   }
   
   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getGroup() {
      return group;
   }

   public void setGroup(String group) {
      this.group = group;
   }

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

