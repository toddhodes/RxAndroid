package com.wavemarket.finder.core.v1.api.exception;

import java.util.Collection;

import com.wavemarket.finder.core.v1.dto.TOperationFailureDescription;

/**
 * This class is used for expected failures due to bad inputs or an
 * incompatibility between inputs and state.
 *
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 3:39:23 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class OperationException extends CoreApiException implements java.io.Serializable {

   protected OperationException() {
      super();
   }

   protected OperationException(String message) {
      super(message);
   }

   protected OperationException(Throwable cause) {
      super(cause);
   }

   public static class ParentAlreadyExists extends OperationException implements java.io.Serializable {}
   public static class ChildAlreadyExists extends OperationException implements java.io.Serializable {}
   public static class Duplicate extends OperationException implements java.io.Serializable {}
   public static class DuplicateAccount extends Duplicate implements java.io.Serializable {}
   public static class DuplicateName extends Duplicate implements java.io.Serializable {}
   public static class DuplicateEmail extends Duplicate implements java.io.Serializable {}
   public static class DuplicatePhoneNumber extends Duplicate implements java.io.Serializable {}
   public static class InvalidPassword extends OperationException implements java.io.Serializable {}
   public static class NotFound extends OperationException implements java.io.Serializable {
      public NotFound() { }
      public NotFound(String message) {
         super(message);
      }
      public NotFound(Throwable cause) {
         super(cause);
      }
   }

   /**
    * There is already a pending request that is identical to the one that the caller is
    * attempting to make
    */
   public static class RequestExists extends OperationException implements java.io.Serializable {}

   /**
    * That request has already been approved
    */
   public static class RequestAlreadyApproved extends OperationException implements java.io.Serializable {}

   /**
    * A multi-part operation that included the addition of assets failed as none of the requests to
    *  add assets were successful.
    */
   public static class NoAssetsAdded extends OperationException implements java.io.Serializable {
      Collection<TOperationFailureDescription> errorDescriptions;

      public NoAssetsAdded() {
         super();
      }

      public NoAssetsAdded(String message) {
         super(message);
      }

      public NoAssetsAdded(Throwable cause) {
         super(cause);
      }

      public NoAssetsAdded(Collection<TOperationFailureDescription> errorDescriptions) {
         this.errorDescriptions = errorDescriptions;
      }

      public Collection<TOperationFailureDescription> getErrorDescriptions() {
         return errorDescriptions;
      }
   }

   /**
    * A piece of data required for the operation to proceed was not found.
    */
   public static class NoDataFound extends OperationException implements java.io.Serializable {
      public NoDataFound(String message) {
         super(message);
      }
   }

   public static class InvalidClass extends OperationException implements java.io.Serializable {
      public InvalidClass(String paramName) {
         super (paramName);
      }
   }
   
   /**
    * the named parameter had a value that was not allowed or invalid
    */
   public static class InvalidParameter extends OperationException implements java.io.Serializable {
      public InvalidParameter(String paramName) {
         super(paramName);
      }
   }

   /**
    * the named parameter had a value that was valid but not supported
    */
   public static class UnsupportedParameterValue extends OperationException implements java.io.Serializable {
      public UnsupportedParameterValue(String paramName) {
         super(paramName);
      }
   }

   /**
    * the current system state is invalid
    */

   public static class InvalidState extends OperationException implements java.io.Serializable {
      public InvalidState(String message) {
         super(message);
      }
      
      public InvalidState(Throwable cause) {
         super(cause);
      }
   }

   public static class AlreadyAtMaximum extends OperationException implements java.io.Serializable {
      public AlreadyAtMaximum(String message) {
         super(message);
      }
   }

   public static class UnsupportedImageFormat extends OperationException implements java.io.Serializable {
      public UnsupportedImageFormat(String message) {
         super(message);
      }
      
      public UnsupportedImageFormat(Throwable cause) {
         super(cause);
      }
   }

}


/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
*/
