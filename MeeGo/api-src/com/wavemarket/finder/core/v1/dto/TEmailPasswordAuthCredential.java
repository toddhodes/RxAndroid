package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;

public class TEmailPasswordAuthCredential implements TCredential,java.io.Serializable {
   private String email;
   private String password;

   public TEmailPasswordAuthCredential() {
      // auto-generated
   }
   
   public TEmailPasswordAuthCredential(String email, String password) {
      this.email = email;
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setDescriptor(TDescriptor descriptor) {
      this.email = descriptor.getData();
   }
   
   public TDescriptor getDescriptor() {
      return new TDescriptor(getEmail(), Type.EMAIL);
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

