package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;

public class TNamePasswordAuthCredential implements TCredential,java.io.Serializable {
   private String name;
   private String password;

   public TNamePasswordAuthCredential() {
      // auto-generated
   }
   
   public TNamePasswordAuthCredential(String name, String password) {
      this.name = name;
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setDescriptor(TDescriptor descriptor) {
      this.name = descriptor.getData();
   }
   
   public TDescriptor getDescriptor() {
      return new TDescriptor(getName(), Type.USERNAME);
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

