package com.wavemarket.finder.core.v1.dto.job;

import com.wavemarket.finder.core.v1.dto.location.TLocateResult;


public class TLocateJob extends TAsyncJob implements java.io.Serializable {
   private TLocateResult result;
   private long assetId;

   /**
    * @deprecated for Hessian DON'T USE
    */
   public TLocateJob() {
      super();
   }

   public TLocateJob(byte[] jobId, long assetId, boolean completed, boolean success,
                      TLocateResult result) {
      super(jobId, completed, success);
      this.result = result;
      this.assetId = assetId;
   }

   public TLocateResult getResult() {
      return result;
   }

   public long getAssetId() {
      return assetId;
   }

   public void setResult(TLocateResult result) {
      this.result = result;
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
