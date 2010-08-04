package com.wavemarket.finder.core.v1.dto.payment;

import java.io.Serializable;

import com.wavemarket.finder.core.v1.dto.TAddress;

public class TCreditCard implements Serializable {

   private TAddress address;
   private String ccn;
   private String cvv2;
   private int expMonth;
   private int expYear;
   private String firstName;
   private String lastName;
   private String ccType;


   public TCreditCard() {
      this.address = null;
      this.ccn = null;
      this.cvv2 = null;
      this.expMonth = 0;
      this.expYear = 0;
      this.firstName = null;
      this.lastName = null;
   }

   public TCreditCard(TAddress address,
                      String ccType,
                      String ccn,
                      String cvv2,
                      int expMonth,
                      int expYear,
                      String firstName,
                      String lastName) {
      this.address = address;
      this.ccn = ccn;
      this.cvv2 = cvv2;
      this.expMonth = expMonth;
      this.expYear = expYear;
      this.firstName = firstName;
      this.lastName = lastName;
      this.ccType = ccType;
   }


   public TAddress getAddress() {
      return this.address;
   }

   public void setAddress(TAddress address) {
      this.address = address;
   }

   public String getCcn() {
      return this.ccn;
   }

   public void setCcn(String ccn) {
      this.ccn = ccn;
   }

   public String getCvv2() {
      return this.cvv2;
   }

   public void setCvv2(String cvv2) {
      this.cvv2 = cvv2;
   }

   public int getExpMonth() {
      return this.expMonth;
   }

   public void setExpMonth(int expMonth) {
      this.expMonth = expMonth;
   }

   public int getExpYear() {
      return this.expYear;
   }

   public void setExpYear(int expYear) {
      this.expYear = expYear;
   }

   public String getFirstName() {
      return this.firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return this.lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setCcType(String ccType) {
      this.ccType = ccType;
   }

   public String getCcType() {
      return ccType;
   }

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

