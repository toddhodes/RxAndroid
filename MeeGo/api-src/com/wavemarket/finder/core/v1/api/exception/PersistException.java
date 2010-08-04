package com.wavemarket.finder.core.v1.api.exception;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:27:26 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class PersistException extends CoreApiException implements java.io.Serializable {

   public PersistException() {
      super();
   }

   public PersistException(String message) {
      super(message);
   }

   public PersistException(String message, Throwable cause) {
      super(message, cause);
   }

   public PersistException(Throwable cause) {
      super(cause);
   }

   public static class SQLException extends PersistException implements java.io.Serializable {
      public SQLException() {
         super();
      }

      public SQLException(String message) {
         super(message);
      }

      public SQLException(String message, Throwable cause) {
         super(message, cause);
      }

      public SQLException(Throwable cause) {
         super(cause);
      }
   }

   public static class DatabaseUnavailable extends PersistException implements java.io.Serializable {
      public DatabaseUnavailable() {
         super();
      }

      public DatabaseUnavailable(String message) {
         super(message);
      }

      public DatabaseUnavailable(String message, Throwable cause) {
         super(message, cause);
      }

      public DatabaseUnavailable(Throwable cause) {
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

