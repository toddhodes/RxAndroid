package com.wavemarket.finder.core.v1.api.exception;

import java.io.Serializable;

import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TOperationFailureDescription;
import com.wavemarket.finder.core.v1.dto.TRequiredCharacterType;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:31:47 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class AuthenticationException extends CoreApiException implements Serializable {

   protected AuthenticationException() {
   }

   protected AuthenticationException(String message) {
      super(message);
   }

   protected AuthenticationException(String message, Throwable cause) {
      super(message, cause);
   }

   protected AuthenticationException(Throwable cause) {
      super(cause);
   }

   public static class NoSuchAccount extends AuthenticationException implements Serializable {
      public NoSuchAccount() {
         super();
      }

      public NoSuchAccount(Throwable cause) {
         super(cause);
      }
   }

   public static class PendingAccount extends AuthenticationException implements Serializable {
      public PendingAccount() {
         super();
      }
   }

   /**
    * The account you're trying to log into is blocked due to too many failed
    * login attempts. Try again later.
    */
   public static class AccountBlocked extends AuthenticationException implements Serializable {
      public AccountBlocked() {
         super();
      }

      public AccountBlocked(String message, Throwable cause) {
         super(message, cause);
      }

      public AccountBlocked(String message) {
         super(message);
      }

      public AccountBlocked(Throwable cause) {
         super(cause);
      }
   }

   /**
    * Unrecognized username / phone number, or password that doesn't match that
    * username / phone number.
    */
   public static class BadCredentials extends AuthenticationException implements Serializable {

      boolean accountIsBlocked;

      public BadCredentials() {
      }
      
      public BadCredentials(Throwable cause, boolean accountIsBlocked) {
         super(cause);
         this.accountIsBlocked = accountIsBlocked;
      }
   }

   /**
    * Temporary passwords can expire (the definition of "temporary").
    */
   public static final class PasswordExpired extends AuthenticationException implements Serializable {
      private TDescriptor descriptor;
      
      public PasswordExpired() {
      }
      public PasswordExpired(TDescriptor descriptor) {
         super();
         this.descriptor = descriptor;
      }
      
      public void setDescriptor(TDescriptor descriptor) {
         this.descriptor = descriptor;
      }
      
      public TDescriptor getDescriptor() {
         return descriptor;
      }
   }
   
   /**
    * The account you're trying to log into has been suspended. This can happen
    * due to nonpayment or service cancellation, or at the request of someone
    * with authority over the account. 
    */
   public static class AccountSuspended extends AuthenticationException implements Serializable {
      public AccountSuspended() {
         super();
      }

      public AccountSuspended(Throwable cause) {
         super(cause);
      }      
   }

   /**
    * The service you are trying to sign up for is not available to you.
    */
   public static class ServiceNotAvailable extends AuthenticationException implements Serializable {
      
      protected TOperationFailureDescription failureDescription = new TOperationFailureDescription();
      
      public ServiceNotAvailable() {
         super();
      }

      public ServiceNotAvailable(Throwable cause) {
         super(cause);
      }
      
      public ServiceNotAvailable(TOperationFailureDescription failureDescription) {
         this.failureDescription = failureDescription;
      }
      
      public ServiceNotAvailable(TOperationFailureDescription failureDescription, Throwable cause) {
         super(cause);
         this.failureDescription = failureDescription;
      }

      public TOperationFailureDescription getFailureDescription() {
         return failureDescription;
      }

      public void setFailureDescription(
            TOperationFailureDescription failureDescription) {
         this.failureDescription = failureDescription;
      }

      public static class CorporateLiable extends ServiceNotAvailable {
         public CorporateLiable() {
            super();
         }

         public CorporateLiable(Throwable cause) {
            super(cause);
         }

         public CorporateLiable(
               TOperationFailureDescription failureDescription, Throwable cause) {
            super(failureDescription, cause);
         }

         public CorporateLiable(TOperationFailureDescription failureDescription) {
            super(failureDescription);
         }
      }
      
      public static class PrepaidAccount extends ServiceNotAvailable {
         public PrepaidAccount() {
            super();
         }

         public PrepaidAccount(Throwable cause) {
            super(cause);
         }

         public PrepaidAccount(TOperationFailureDescription failureDescription,
               Throwable cause) {
            super(failureDescription, cause);
         }

         public PrepaidAccount(TOperationFailureDescription failureDescription) {
            super(failureDescription);
         }
      }
      
      public static class InactiveDevice extends ServiceNotAvailable {
         public InactiveDevice() {
            super();
         }

         public InactiveDevice(Throwable cause) {
            super(cause);
         }

         public InactiveDevice(TOperationFailureDescription failureDescription,
               Throwable cause) {
            super(failureDescription, cause);
         }

         public InactiveDevice(TOperationFailureDescription failureDescription) {
            super(failureDescription);
         }
      }
   }

   /**
    * You are not allowed to change your own password
    */
   public static class CannotChangeOwnPassword extends AuthenticationException implements Serializable {
      public CannotChangeOwnPassword() {
         super();
      }
   }

   /**
    * Your new password isn't secure enough or contains characters that we
    * don't allow in a password
    */
   public static class RejectedPassword extends AuthenticationException implements Serializable {
      public RejectedPassword() {
         super();
      }

      public static class InsecurePassword extends RejectedPassword implements Serializable {
         public InsecurePassword() {
            super();
         }
      }

      public static class IllegalCharactersInPassword extends RejectedPassword implements Serializable {
         public IllegalCharactersInPassword() {
            super();
         }
      }

      private static abstract class WrongLength extends RejectedPassword implements Serializable {

         private int requiredLength;
         private int suppliedLength;

         public WrongLength(int requiredLength, int suppliedLength) {
            super();
            this.requiredLength = requiredLength;
            this.suppliedLength = suppliedLength;
         }

         public int getRequiredLength() {
            return requiredLength;
         }

         public int getSuppliedLength() {
            return suppliedLength;
         }
      }

      public static class TooLong extends WrongLength implements Serializable {
         public TooLong(int requiredLength, int suppliedLength) {
            super(requiredLength, suppliedLength);
         }
      }
      public static class TooShort extends WrongLength implements Serializable {
         public TooShort(int requiredLength, int suppliedLength) {
            super(requiredLength, suppliedLength);
         }
      }

      public static class MissingRequiredCharacterType extends RejectedPassword implements Serializable {
         private TRequiredCharacterType type;

         public MissingRequiredCharacterType(TRequiredCharacterType type) {
            this.type = type;
         }

         public TRequiredCharacterType getType() {
            return type;
         }
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