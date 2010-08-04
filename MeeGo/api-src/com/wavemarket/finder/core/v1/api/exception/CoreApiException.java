package com.wavemarket.finder.core.v1.api.exception;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 5:56:36 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class CoreApiException extends Exception implements java.io.Serializable {

   public CoreApiException() {
      super();
   }

   public CoreApiException(String message) {
      super(message);
   }

   public CoreApiException(String message, Throwable cause) {
      // discard cause
      super(message);
   }

   public CoreApiException(Throwable cause) {
      // discard cause
      super();
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

