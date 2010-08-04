package com.wavemarket.finder.core.v1.dto;

/**
 * This is an enumeration fo operations to which a user might possibly be granted
 * access.
 *
 * @see TLoginInfo
 *
 * @author oliver
 */

/*
 * Created-Date: Apr 10, 2008
 * Created-Time: 3:11:34 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public enum TPermission implements java.io.Serializable {

   // permissions for normal admins
   SHOW_ACCOUNT_DETAILS,
   CHANGE_NOTIFICATION,
   CHANGE_EMAIL,
   CHANGE_PASSWORD,
   SEND_SMS_TO_ASSET,
   ADD_REMOVE_ASSET,
   EDIT_ASSET,
   REMOVE_ASSET,
   CHANGE_ASSET_ICON,
   SHOW_SCHEDULE_CHECKS,
   ADD_REMOVE_SCHEDULE_CHECK,
   EDIT_SCHEDULE_CHECK,
   SHOW_REGION_CHANGE_ALERTS,
   ADD_REMOVE_REGION_CHANGE_ALERT,
   EDIT_REGION_CHANGE_ALERT,
   REQUEST_CONTINUOUS_TRACKING,
   REGION_CHANGE_AVAILABLE_BUT_INACTIVE,
   SCHEDULE_CHECK_AVAILABLE_BUT_INACTIVE,
   UNSUSPEND_SELF,

   // flags for normal admins
   TEMP_PASSWORD,
   REGISTRATION_INCOMPLETE,
   CHILD_CREATION_INCOMPLETE,
   TRIAL_ACCOUNT,

   // flag to indicate suspended account
   SUSPENDED,   
   
   // superuser permissions, usually distinct from regular permissions.
   // all superuser logins have SUPERUSER_VIEW
   SUPERUSER_VIEW,
   SUPERUSER_MODIFY,   

   // sign up flag, also distict from other permission sets
   REGISTRATION,
   
   // registration from temp password method
   TEMP_PASSWORD_SIGNUP,

   // preregistration for a demo account
   DEMO_SIGNUP,
   
   //Downgrading
   FORCED_DOWNGRADED,
   NEEDS_DOWNGRADING;
   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3 ft=java
*/
