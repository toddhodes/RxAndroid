package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.Date;

public class TBillingEvent implements java.io.Serializable {
   String description;
   String result;
   Date dateSubmitted;

    public TBillingEvent() {
	// auto-generated
    }
    
   public TBillingEvent(String description, String result, Date dateSubmitted) {
      this.dateSubmitted = dateSubmitted;
      this.description = description;
      this.result = result;
   }

   public String getDescription() {
      return description;
   }

   public String getResult() {
      return result;
   }

   public Date getDateSubmitted() {
      return dateSubmitted;
   }
}
