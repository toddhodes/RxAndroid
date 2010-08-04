package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 4:35:43 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TOnDemandLocateEvent extends TLocationEvent implements java.io.Serializable {

   private Date requestedTime;

   public TOnDemandLocateEvent() {
      // auto-generated
   }
   
   public TOnDemandLocateEvent(long assetId, String assetName, TLocateResult result,
                               Date dateRecorded,  Date requestedTime) {
      super(assetId, assetName, result, dateRecorded);
      this.requestedTime = requestedTime;
   }

   public Date getRequestedTime() {
      return requestedTime;
   }

   public void setRequestedTime(Date requestedTime) {
      this.requestedTime = requestedTime;
   }

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

