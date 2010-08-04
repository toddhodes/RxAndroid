package com.wavemarket.finder.core.v1.api.exception;

import com.wavemarket.finder.core.v1.dto.TOperationFailureDescription;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:23:27 PM
 * Copyright 2007 WaveMarket, Inc
 */
public class AuthorizationException extends CoreApiException implements java.io.Serializable {

   public AuthorizationException() {
      super();
   }

   public AuthorizationException(String message) {
      super(message);
   }

   public AuthorizationException(String message, Throwable cause) {
      super(message, cause);
   }

   public AuthorizationException(Throwable cause) {
      super(cause);
   }

   public static class InvalidToken extends AuthorizationException implements java.io.Serializable {
      public InvalidToken() {
         super();
      }

      public InvalidToken(String message) {
         super(message);
      }

      public InvalidToken(String message, Throwable cause) {
         super(message, cause);
      }

      public InvalidToken(Throwable cause) {
         super(cause);
      }
   }

   public static class NotPermitted extends AuthorizationException implements java.io.Serializable {
      protected TOperationFailureDescription failureDescription = new TOperationFailureDescription();
      
      public NotPermitted() {
         super();
      }

      public NotPermitted(String message) {
         super(message);
      }

      public NotPermitted(String message, Throwable cause) {
         super(message, cause);
      }

      public NotPermitted(Throwable cause) {
         super(cause);
      }
      
      public NotPermitted(TOperationFailureDescription failureDescription) {
         this.failureDescription = failureDescription;
      }
      
      public NotPermitted(TOperationFailureDescription failureDescription, Throwable cause) {
         super(cause);
         this.failureDescription = failureDescription;
      }
      
      public NotPermitted(TOperationFailureDescription failureDescription, String message) {
         super(message);
         this.failureDescription = failureDescription;
      }
      
      public NotPermitted(TOperationFailureDescription failureDescription, 
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
   }

   /**
    * The account you're performing an operation on has been suspended
    */
   public static class AccountSuspended extends AuthorizationException implements java.io.Serializable {
      public AccountSuspended() {
         super();
      }
   }

   /**
    * The operation you're attempting isn't available because you have a demo account.
    */
   public static class DemoAccount extends AuthorizationException implements java.io.Serializable {
      public DemoAccount() {
         super();
      }
   }

   /**
    * The operation you're attempting isn't available because your account has not
    * been fully provisioned.
    */
   public static class UnprovisionedAccount extends AuthorizationException implements java.io.Serializable {
      public UnprovisionedAccount() {
         super();
      }
   }
   
   /**
    * The operation you're attempting is not reasonable for an account with a 
    * temporary password.
    */
   public static class TemporaryPassword extends AuthorizationException implements java.io.Serializable {
      public TemporaryPassword() {
         super();
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

