package com.wavemarket.finder.core.v1.api.exception;

/**
 * Exception relating to geographical services - geocoding, mapping,
 * navigation etc
 *
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 1:12:27 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class GeoException extends CoreApiException implements java.io.Serializable {

   public GeoException() {
      super();
   }

   public GeoException(String message) {
      super(message);
   }

   public GeoException(String message, Throwable cause) {
      super(message, cause);
   }

   public GeoException(Throwable cause) {
      super(cause);
   }

   public static class NoData extends GeoException implements java.io.Serializable {
      public NoData() {
         super();
      }

      public NoData(String message) {
         super(message);
      }

      public NoData(String message, Throwable cause) {
         super(message, cause);
      }

      public NoData(Throwable cause) {
         super(cause);
      }
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

