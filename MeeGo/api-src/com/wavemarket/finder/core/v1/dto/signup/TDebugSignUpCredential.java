package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 25, 2008
 * Created-Time: 10:58:13 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDebugSignUpCredential implements TSignUpCredential,java.io.Serializable {

   private String accountNumber;

   public TDebugSignUpCredential() {
      // auto-generated
   }
   
   public TDebugSignUpCredential(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   public void setDescriptor(TDescriptor descriptor) {
      this.accountNumber = descriptor.getData();
   }
   
   public TDescriptor getDescriptor() {
      return new TDescriptor(getAccountNumber(), Type.ACCOUNTNUMBER);
   }

   public String getPassword() {
      return null;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

