package com.wavemarket.finder.core.v1.api.exception;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:30:06 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class ServiceException extends CoreApiException implements java.io.Serializable {

   public ServiceException() {
      super();
   }

   public ServiceException(String message) {
      super(message);
   }

   public ServiceException(String message, Throwable cause) {
      super(message, cause);
   }

   public ServiceException(Throwable cause) {
      super(cause);
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

