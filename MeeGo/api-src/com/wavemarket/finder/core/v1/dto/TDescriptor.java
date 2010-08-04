package com.wavemarket.finder.core.v1.dto;

/**
 * Provide identification data and type information. 
 */
public class TDescriptor implements java.io.Serializable {

   public enum Type {
      EMAIL,
      PHONENUMBER,
      USERNAME,
      TOKEN,
      ACCOUNTNUMBER,
      BILLING_IDENTITY;
   }
   
   private String data;
   private Type type;

   public TDescriptor() {
      // auto-generated
   }
   
   public TDescriptor(String data, Type type) {
      this.data = data;
      this.type = type;
   }
   
   public String getData() {
      return data;
   }
   
   public Type getType() {
      return type;
   }

   public void setData(String data) {
      this.data = data;
   }

   public void setType(Type type) {
      this.type = type;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

