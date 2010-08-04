package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 4:06:15 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public abstract class TLocationEvent implements java.io.Serializable {

   protected TLocateResult result;
   protected long assetId;
   protected String assetName;
   protected Date dateRecorded;

   public TLocationEvent() {
      // auto-generated
   }

   public TLocationEvent(long assetId, String assetName, TLocateResult result, Date dateRecorded) {
      this.assetId = assetId;
      this.assetName = assetName;
      this.result = result;
      this.dateRecorded = dateRecorded;
   }

   public long getAssetId() {
      return assetId;
   }

   public void setAssetId(long assetId) {
      this.assetId = assetId;
   }

   public String getAssetName() {
      return assetName;
   }

   public void setAssetName(String assetName) {
      this.assetName = assetName;
   }

   public TLocateResult getResult() {
      return result;
   }

   public void setResult(TLocateResult result) {
      this.result = result;
   }

   public Date getDateRecorded() {
      return dateRecorded;
   }

   public void setDateRecorded(Date dateRecorded) {
      this.dateRecorded = dateRecorded;
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
