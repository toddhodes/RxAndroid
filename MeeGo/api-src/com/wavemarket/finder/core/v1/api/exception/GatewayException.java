package com.wavemarket.finder.core.v1.api.exception;

import com.wavemarket.finder.core.v1.dto.TOperationFailureDescription;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:28:30 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class GatewayException extends CoreApiException implements java.io.Serializable {

   protected TOperationFailureDescription failureDescription = new TOperationFailureDescription();
   
   public GatewayException() {
      super();
   }

   public GatewayException(String message) {
      super(message);
   }

   public GatewayException(String message, Throwable cause) {
      super(message, cause);
   }

   public GatewayException(Throwable cause) {
      super(cause);
   }

   public GatewayException(TOperationFailureDescription failureDescription) {
      this.failureDescription = failureDescription;
   }
   
   public GatewayException(TOperationFailureDescription failureDescription, Throwable cause) {
      super(cause);
      this.failureDescription = failureDescription;
   }
   
   public GatewayException(TOperationFailureDescription failureDescription, String message) {
      super(message);
      this.failureDescription = failureDescription;
   }
   
   public GatewayException(TOperationFailureDescription failureDescription, 
         String message, Throwable cause) {
      super(message, cause);
      this.failureDescription = failureDescription;
   }

   public TOperationFailureDescription getFailureDescription() {
      return failureDescription;
   }

   public void setFailureDescription(
         TOperationFailureDescription failureDescription) {
      this.failureDescription = failureDescription;
   }

   public static class AccountServiceUnavailable extends GatewayException implements java.io.Serializable {
      public AccountServiceUnavailable() {
         super();
      }

      public AccountServiceUnavailable(String message) {
         super(message);
      }

      public AccountServiceUnavailable(String message, Throwable cause) {
         super(message, cause);
      }

      public AccountServiceUnavailable(Throwable cause) {
         super(cause);
      }
   }

   public static class SMSCUnavailable extends GatewayException implements java.io.Serializable {
      public SMSCUnavailable() {
         super();
      }

      public SMSCUnavailable(String message) {
         super(message);
      }

      public SMSCUnavailable(String message, Throwable cause) {
         super(message, cause);
      }

      public SMSCUnavailable(Throwable cause) {
         super(cause);
      }
   }

   public static class LocationServiceUnavailable extends GatewayException implements java.io.Serializable {
      public LocationServiceUnavailable() {
         super();
      }

      public LocationServiceUnavailable(String message) {
         super(message);
      }

      public LocationServiceUnavailable(String message, Throwable cause) {
         super(message, cause);
      }

      public LocationServiceUnavailable(Throwable cause) {
         super(cause);
      }
   }
   
   public static class PaymentServiceUnavailable extends GatewayException implements java.io.Serializable {
      public PaymentServiceUnavailable() {
         super();
      }

      public PaymentServiceUnavailable(String message) {
         super(message);
      }

      public PaymentServiceUnavailable(String message, Throwable cause) {
         super(message, cause);
      }

      public PaymentServiceUnavailable(Throwable cause) {
         super(cause);
      }
   }
   
   public static class PaymentDeclined extends GatewayException implements java.io.Serializable {
      public PaymentDeclined() {
         super();
      }

      public PaymentDeclined(String message) {
         super(message);
      }

      public PaymentDeclined(String message, Throwable cause) {
         super(message, cause);
      }

      public PaymentDeclined(Throwable cause) {
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

