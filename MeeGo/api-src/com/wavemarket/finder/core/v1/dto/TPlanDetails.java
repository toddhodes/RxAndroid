package com.wavemarket.finder.core.v1.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TPlanDetails implements java.io.Serializable {
	private TPaymentAccountType paymentAccountType;
	private Date nextBillingDate;
	private BigDecimal currentBalance;
	private boolean switchingToPAYG;
	private boolean inTrial;
	private Date paygStartDate;
	private Date mrcEndDate;

        public TPlanDetails() {
          // auto-generated
        }	
	
	public TPaymentAccountType getPaymentAccountType() {
		return paymentAccountType;
	}

	public void setPaymentAccountType(TPaymentAccountType paymentAccountType) {
		this.paymentAccountType = paymentAccountType;
	}

	public Date getNextBillingDate() {
		return nextBillingDate;
	}

	public void setNextBillingDate(Date nextBillingDate) {
		this.nextBillingDate = nextBillingDate;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getPaygStartDate() {
		return paygStartDate;
	}

	public void setPaygStartDate(Date paygStartDate) {
		this.paygStartDate = paygStartDate;
	}

	public Date getMrcEndDate() {
		return mrcEndDate;
	}

	public void setMrcEndDate(Date mrcEndDate) {
		this.mrcEndDate = mrcEndDate;
	}

	public boolean getSwitchingToPAYG() {
		return switchingToPAYG;
	}

	public void setSwitchingToPAYG(boolean switchingToPAYG) {
		this.switchingToPAYG = switchingToPAYG;
	}

   public void setInTrial(boolean inTrial) {
      this.inTrial = inTrial;
   }

   public boolean isInTrial() {
      return inTrial;
   }
	

}
