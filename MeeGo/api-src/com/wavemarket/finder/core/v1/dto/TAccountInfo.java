package com.wavemarket.finder.core.v1.dto;

public class TAccountInfo implements java.io.Serializable {
 
   public enum Type {
      EMAIL,
      PHONENUMBER,
      LOCALE
   }
   
   private Type type;
   private String data;

    public TAccountInfo() {
	// auto-generated
    }
    
   public TAccountInfo(Type type, String data) {
      this.type = type;
      this.data = data;
   }

   public Type getType() {
      return type;
   }

   public String getData() {
      return data;
   }
   
}
