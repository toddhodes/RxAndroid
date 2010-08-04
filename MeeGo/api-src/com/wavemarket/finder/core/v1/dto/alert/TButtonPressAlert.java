package com.wavemarket.finder.core.v1.dto.alert;

import com.wavemarket.finder.core.v1.dto.TAlertDirection;

/**
 * @author eli
 */

/*
 * Created-Date: Oct 20, 2008
 * Copyright 2008 WaveMarket, Inc 
 */
public class TButtonPressAlert extends TAlert implements java.io.Serializable {

   private long assetId;

   public TButtonPressAlert() {
      // auto-generated
   }
   
   public TButtonPressAlert(long id, long assetId,
                             boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                             boolean notifyThirdPartyViaEmail, String thirdPartyEmail,
                             String timezone) {
      super(id, notifyParentViaEmail, notifyParentViaSMS,
            notifyThirdPartyViaEmail, thirdPartyEmail, timezone);
      this.assetId = assetId;
   }

   public long getAssetId() {
      return assetId;
   }

   public void setAssetId(long assetId) {
      this.assetId = assetId;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/
