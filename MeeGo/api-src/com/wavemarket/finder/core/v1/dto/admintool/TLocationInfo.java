package com.wavemarket.finder.core.v1.dto.admintool;


import java.util.Date;
import java.util.List;

import com.wavemarket.finder.core.v1.dto.location.TAccuracy;

import com.wavemarket.finder.core.v1.dto.TLandmark;

public class TLocationInfo implements java.io.Serializable {
   private Date timestamp;
   private TAccuracy accuracy;
   private TLandmark landmark;


   public TLocationInfo() {
      // auto-generated
   }
   
   public TLocationInfo(Date timestamp,
                        TAccuracy accuracy,
                        TLandmark landmark) {
      this.timestamp = timestamp;
      this.accuracy = accuracy;
      this.landmark = landmark;
   }


   public Date getTimestamp() {
      return this.timestamp;
   }

   public void setTimestamp(Date timestamp) {
      this.timestamp = timestamp;
   }

   public TAccuracy getAccuracy() {
      return this.accuracy;
   }

   public void setAccuracy(TAccuracy accuracy) {
      this.accuracy = accuracy;
   }

   public TLandmark getLandmark() {
      return this.landmark;
   }

   public void setLandmark(TLandmark landmark) {
      this.landmark = landmark;
   }
   
}
/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

