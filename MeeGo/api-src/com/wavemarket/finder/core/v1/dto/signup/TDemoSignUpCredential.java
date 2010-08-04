package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 25, 2008
 * Created-Time: 11:01:46 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDemoSignUpCredential implements TSignUpCredential,java.io.Serializable {
   private String name;
   private String phoneNumber;
   private String password;

   public TDemoSignUpCredential() {
      // auto-generated
   }
   
   public TDemoSignUpCredential(String name, String phoneNumber, String password) {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setDescriptor(TDescriptor descriptor) {
      this.phoneNumber = descriptor.getData();
   }
   
   public TDescriptor getDescriptor() {
      return new TDescriptor(getPhoneNumber(), Type.PHONENUMBER);
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

