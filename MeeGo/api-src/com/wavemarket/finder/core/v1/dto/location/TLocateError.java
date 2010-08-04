package com.wavemarket.finder.core.v1.dto.location;

import java.util.Date;

// if type is POLLING_SERVER_ERROR, codes should be that same as
// com.wavemarket.pserv.model.PollingServerError 
// because of enums and version dependancies this can't just be a
// PollingServerError. 
//
// otherwise, error codes are finder-defined.

public class TLocateError extends TLocateResult implements java.io.Serializable {

   private TLocationErrorCode locationErrorCode;
   private int majorCode;
   private int minorCode;

   public TLocateError() {
      // auto-generated
   }
   
   public TLocateError(Date observedTime, TLocationErrorCode locationErrorCode,
                       int majorPollingServerCode, int minorPollingServerCode) {
      super(observedTime);
      this.locationErrorCode = locationErrorCode;
      this.majorCode = majorPollingServerCode;
      this.minorCode = minorPollingServerCode;
   }

   public TLocationErrorCode getLocationErrorCode() {
      return locationErrorCode;
   }

   public int getMajorCode() {
      return majorCode;
   }

   public int getMinorCode() {
      return minorCode;
   }

   public void setLocationErrorCode(TLocationErrorCode locationErrorCode) {
      this.locationErrorCode = locationErrorCode;
   }

   public void setMajorCode(int majorCode) {
      this.majorCode = majorCode;
   }

   public void setMinorCode(int minorCode) {
      this.minorCode = minorCode;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/


