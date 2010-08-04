package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;


public class TTempPasswordSignUpCredential implements TSignUpCredential,java.io.Serializable {

   private String phoneNumber;
   private String password;

   public TTempPasswordSignUpCredential() {
      // auto-generated
   }
   
   public TTempPasswordSignUpCredential(
         String phoneNumber,
         String password) {
      this.phoneNumber = phoneNumber;
      this.password = password;
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

