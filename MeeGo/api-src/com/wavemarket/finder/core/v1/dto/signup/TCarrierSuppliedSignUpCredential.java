package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TDescriptor;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 25, 2008
 * Created-Time: 11:00:20 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TCarrierSuppliedSignUpCredential implements TSignUpCredential,java.io.Serializable {

   private String source;
   private String data;

   public TCarrierSuppliedSignUpCredential() {
      // auto-generated
   }
   
   public TCarrierSuppliedSignUpCredential(String source, String data) {
      this.source = source;
      this.data = data;
   }

   public String getSource() {
      return source;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }

   public void setDescriptor(TDescriptor descriptor) {
      this.data = descriptor.getData();
   }
   
   public TDescriptor getDescriptor() {
      return new TDescriptor(data, TDescriptor.Type.BILLING_IDENTITY);
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

