package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TDescriptor.Type;
import com.wavemarket.finder.core.v1.dto.signup.TSignUpCredential;

public class TAuthTokenSignUpCredential implements TSignUpCredential, java.io.Serializable {

   private String token;

    public TAuthTokenSignUpCredential() {
	// auto-generated
    }
    
   public TAuthTokenSignUpCredential(String token) {
      this.token = token;
   }

    public void setDescriptor(TDescriptor descriptor) {
       this.token = descriptor.getData();
    }
    
   public TDescriptor getDescriptor() {
      return new TDescriptor(token, Type.TOKEN);
   }
   
   public String getPassword() {
      return null;
   }
   
   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }
   
}
