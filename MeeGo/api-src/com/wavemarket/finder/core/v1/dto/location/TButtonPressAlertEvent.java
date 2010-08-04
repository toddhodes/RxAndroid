package com.wavemarket.finder.core.v1.dto.location;

import com.wavemarket.finder.core.v1.dto.TAlertDirection;

import java.util.Date;

/**
 * @author eli
 */

/*
 * Created-Date: Oct 20, 2008
 * Copyright 2008 WaveMarket, Inc 
 */
public class TButtonPressAlertEvent extends TLocationEvent implements java.io.Serializable {

   private long buttonPressAlertId;

   public TButtonPressAlertEvent() {
      // auto-generated
   }
   
   public TButtonPressAlertEvent(long assetId, String assetName, long alertId,
                                  TLocateResult result, Date dateRecorded) {
      super(assetId, assetName, result, dateRecorded);
      buttonPressAlertId = alertId;
   }

   public long getButtonPressAlertId() {
      return buttonPressAlertId;
   }

   public void setButtonPressAlertId(long buttonPressAlertId) {
      this.buttonPressAlertId = buttonPressAlertId;
   }
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
