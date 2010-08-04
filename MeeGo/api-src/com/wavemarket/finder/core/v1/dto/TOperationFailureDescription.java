package com.wavemarket.finder.core.v1.dto;

// this class  represents some kind of error, and has room for an error code.
// this allows us to show user specific errors we have experienced 
public class TOperationFailureDescription implements java.io.Serializable {
   
   TOperationType operationType;
   TOperationResult operationResult;
   String reportedCode;
      
   public TOperationFailureDescription() {
      super();
   }

   /**
    * @param operationResult
    * @param operationType
    * @param reportedCode
    */
   public TOperationFailureDescription(TOperationResult operationResult,
         TOperationType operationType, String reportedCode) {
      this.operationResult = operationResult;
      this.operationType = operationType;
      this.reportedCode = reportedCode;
   }

   public TOperationType getOperationType() {
      return operationType;
   }

   public TOperationResult getOperationResult() {
      return operationResult;
   }

   public String getReportedCode() {
      return reportedCode;
   }
      
   public void setOperationType(TOperationType operationType) {
      this.operationType = operationType;
   }

   public void setOperationResult(TOperationResult operationResult) {
      this.operationResult = operationResult;
   }

   public void setReportedCode(String reportedCode) {
      this.reportedCode = reportedCode;
   }

   public enum TOperationType {
      QUERY_CARRIER,
      UPDATE_CARRIER,
      QUERY_FINDER,
      UPDATE_FINDER;
   }
   
   public enum TOperationResult {
      // success
      SUCCESS,

      // service unavailable
      SERVICE_UNAVAILABLE,

      // account error
      THIRD_PARTY_RETURNED_ERROR,
      NOT_ALLOWED_FOR_ACCOUNT,

      // application error
      APPLICATION_DOES_NOT_SUPPORT,
      SKIPPED_REPEATED_REQUEST,
      
      UNKNOWN;
   }
}

