package com.wavemarket.finder.core.v1.dto.location;

import com.wavemarket.finder.core.v1.dto.TAddress;
import com.wavemarket.finder.core.v1.dto.TLongLat;

import java.util.Date;

public class TLocateData extends TLocateResult implements java.io.Serializable {

   private TLongLat longLat;
   private TAccuracy accuracy;
   private TAddress reverseGeocodedAddress;

   public TLocateData() {
      // auto-generated
   }
   
   public TLocateData(Date observedTime, TLongLat longLat,
                      TAccuracy accuracy, TAddress reverseGeocodedAddress) {
      super(observedTime);
      this.longLat = longLat;
      this.accuracy = accuracy;
      this.reverseGeocodedAddress = reverseGeocodedAddress;
   }

   public TLongLat getLongLat() {
      return longLat;
   }

   public TAccuracy getAccuracy() {
      return accuracy;
   }

   public TAddress getReverseGeocodedAddress() {
      return reverseGeocodedAddress;
   }

   public void setLongLat(TLongLat longLat) {
      this.longLat = longLat;
   }

   public void setAccuracy(TAccuracy accuracy) {
      this.accuracy = accuracy;
   }

   public void setReverseGeocodedAddress(TAddress reverseGeocodedAddress) {
      this.reverseGeocodedAddress = reverseGeocodedAddress;
   }   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

