package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;

public class TPhoneNumberPasswordAuthCredential implements TCredential,java.io.Serializable {
   private String phoneNumber;
   private String password;
      
   public TPhoneNumberPasswordAuthCredential() {
      super();
   }

   public TPhoneNumberPasswordAuthCredential(String phoneNumber, String password) {
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

