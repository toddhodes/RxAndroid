package com.wavemarket.finder.core.v1.api.result;


public class DeliveryResult implements java.io.Serializable {

   public enum ActionTaken {
      EMAIL_SENT,
      SMS_SENT,
      EMAIL_AND_SMS_SENT
   }

   private ActionTaken actionTaken;
   
   private boolean authReset;
   private boolean resend;
   
   public DeliveryResult() {
      // auto-generated
   }

   public DeliveryResult(ActionTaken actionTaken, boolean authReset, boolean resend) {
      this.actionTaken = actionTaken;
      this.authReset = authReset;
      this.resend = resend;
   }

   public DeliveryResult(ActionTaken actionTaken) {
      this(actionTaken, false, false);
   }

   public ActionTaken getActionTaken() {
      return actionTaken;
   }

   public void setActionTaken(ActionTaken actionTaken) {
      this.actionTaken = actionTaken;
   }

   public boolean isAuthReset() {
      return this.authReset;
   }

   public void setAuthReset(boolean authReset) {
      this.authReset = authReset;
   }

   public boolean isResend() {
      return this.resend;
   }

   public void setResend(boolean resend) {
      this.resend = resend;
   }
   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

