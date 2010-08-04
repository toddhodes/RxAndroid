package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 4:37:07 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TLocateResult implements java.io.Serializable {

   private Date observedTime;

   public TLocateResult() {
      // auto-generated
   }
   
   public TLocateResult(Date observedTime) {
      this.observedTime = observedTime;
   }

   public Date getObservedTime() {
      return observedTime;
   }

   public void setObservedTime(Date observedTime) {
      this.observedTime = observedTime;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

