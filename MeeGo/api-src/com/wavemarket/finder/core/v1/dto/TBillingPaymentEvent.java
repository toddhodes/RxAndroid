package com.wavemarket.finder.core.v1.dto;

import java.math.BigDecimal;
import java.util.Date;

public class TBillingPaymentEvent implements java.io.Serializable {

	private Date paymentDate;
	private BigDecimal amount;
	private PaymentType paymentType;

	/* Appropriate for PaymentType.BILL */
	private BillReason billReason;
	private String billReasonTarget;

	/* Appropriate for PaymentType.CHARGE */
	private ChargeReason chargeReason;
	private Date chargeBeginDate;
	private Date chargeEndDate;
	private String last4CardNumber;
	private CreditCardType cardType;

	private String message;
	
	public enum PaymentType {
		CHARGE, BILL, FREE_TRIAL
	}

	public enum ChargeReason {
		MRC_MOTHLY, MRC_PRORATE, PAYG_MONTHLY, REACTIVATE_DEVICE
	}

	public enum BillReason {
		LOCATE, CONTINUOUS_LOCATE, REACTIVATE_DEVICE
	}

	public enum CreditCardType {
		VISA, MC, DISC, AMEX
	}

    public TBillingPaymentEvent() {
	// auto-generated
    }
    
	public TBillingPaymentEvent(Date paymentDate, BigDecimal amount, PaymentType paymentType, BillReason billReason,
			String billReasonTarget, ChargeReason chargeReason, Date chargeBeginDate, Date chargeEndDate,
			String last4CardNumber, CreditCardType cardType, String message) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentType = paymentType;
		this.billReason = billReason;
		this.billReasonTarget = billReasonTarget;
		this.chargeReason = chargeReason;
		this.chargeBeginDate = chargeBeginDate;
		this.chargeEndDate = chargeEndDate;
		this.last4CardNumber = last4CardNumber;
		this.cardType = cardType;
		this.message = message;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public BillReason getBillReason() {
		return billReason;
	}

	public String getBillReasonTarget() {
		return billReasonTarget;
	}

	public ChargeReason getChargeReason() {
		return chargeReason;
	}

	public String getLast4CardNumber() {
		return last4CardNumber;
	}

	public CreditCardType getCardType() {
		return cardType;
	}

	public Date getChargeBeginDate() {
		return chargeBeginDate;
	}

	public Date getChargeEndDate() {
		return chargeEndDate;
	}

   public String getMessage() {
      return message;
   }

}
