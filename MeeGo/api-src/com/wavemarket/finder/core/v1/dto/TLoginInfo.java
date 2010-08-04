package com.wavemarket.finder.core.v1.dto;

import java.util.Set;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:40:38 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TLoginInfo implements java.io.Serializable {

   private Set<TPermission> allowed;
   private String timezone;
   private String locale;

   public TLoginInfo() {
      // auto-generated
   }
   
   public TLoginInfo(Set<TPermission> allowed, String timezone, String locale) {
      this.allowed = allowed;
      this.timezone = timezone;
      this.locale = locale;
   }

   public Set<TPermission> getAllowed() {
      return allowed;
   }

   public void setAllowed(Set<TPermission> allowed) {
      this.allowed = allowed;
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
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

