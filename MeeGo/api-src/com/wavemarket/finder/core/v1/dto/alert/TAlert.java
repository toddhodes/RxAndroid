package com.wavemarket.finder.core.v1.dto.alert;

import java.io.Serializable;

/**
 * @author oliver
 */

/*
 * Created-Date: Jul 15, 2008
 * Created-Time: 2:33:55 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAlert implements Serializable {

   private long id;
   private boolean notifyParentViaEmail;
   private boolean notifyParentViaSMS;
   private boolean notifyThirdPartyViaEmail;
   private String thirdPartyEmail;
   private String timezone;

   public TAlert() {
      // auto-generated
   }
   
   public TAlert(long id, boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                 boolean notifyThirdPartyViaEmail, String thirdPartyEmail,
                 String timezone) {
      this.id = id;
      this.notifyParentViaEmail = notifyParentViaEmail;
      this.notifyParentViaSMS = notifyParentViaSMS;
      this.notifyThirdPartyViaEmail = notifyThirdPartyViaEmail;
      this.thirdPartyEmail = thirdPartyEmail;
      this.timezone = timezone;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public boolean isNotifyParentViaEmail() {
      return notifyParentViaEmail;
   }

   public void setNotifyParentViaEmail(boolean notifyParentViaEmail) {
      this.notifyParentViaEmail = notifyParentViaEmail;
   }

   public boolean isNotifyParentViaSMS() {
      return notifyParentViaSMS;
   }

   public void setNotifyParentViaSMS(boolean notifyParentViaSMS) {
      this.notifyParentViaSMS = notifyParentViaSMS;
   }

   public boolean isNotifyThirdPartyViaEmail() {
      return notifyThirdPartyViaEmail;
   }

   public void setNotifyThirdPartyViaEmail(boolean notifyThirdPartyViaEmail) {
      this.notifyThirdPartyViaEmail = notifyThirdPartyViaEmail;
   }

   public String getThirdPartyEmail() {
      return thirdPartyEmail;
   }

   public void setThirdPartyEmail(String thirdPartyEmail) {
      this.thirdPartyEmail = thirdPartyEmail;
   }

   public String getTimezone() {
      return timezone;
   }

   public void setTimezone(String timezone) {
      this.timezone = timezone;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

