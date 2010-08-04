package com.wavemarket.finder.core.v1.dto.admintool;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 1:42:28 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public enum TLocateNotification implements java.io.Serializable {
   EVERY_LOCATE, // (sms) notification sent to asset on every location attempt
   PERIODICALLY, // notification sent to asset randomly
   ON_LOCATABLE, // notification will be sent to asset when it FIRST becomes locatable by an admin
   ON_LOCATABLE_NOTIFIED // notification was sent to the asset (it became locatable
                         // sometime in the past); this might eventually need to be moved
                         // into a separate table col, but for now we can do it this way
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

