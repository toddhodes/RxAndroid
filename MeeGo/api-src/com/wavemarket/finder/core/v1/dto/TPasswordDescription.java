package com.wavemarket.finder.core.v1.dto;

import java.util.Set;

/**
 * @author oliver
 */

/*
 * Created-Date: Jul 25, 2008
 * Created-Time: 6:38:56 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TPasswordDescription implements java.io.Serializable {

   private int minLength;
   private int maxLength;
   private TPasswordType type;
   private Set<TRequiredCharacterType> requiredTypes;

   public TPasswordDescription() {
      // auto-generated
   }
   
   public TPasswordDescription(int minLength, int maxLength,
                               TPasswordType type,
                               Set<TRequiredCharacterType> requiredTypes) {
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.type = type;
      this.requiredTypes = requiredTypes;
   }

   public int getMinLength() {
      return minLength;
   }
   public void setMinLength(int minLength) {
      this.minLength = minLength;
   }

   public int getMaxLength() {
      return maxLength;
   }

   public void setMaxLength(int maxLength) {
      this.maxLength = maxLength;
   }

   public TPasswordType getType() {
      return type;
   }

   public void setType(TPasswordType type) {
      this.type = type;
   }

   public Set<TRequiredCharacterType> getRequiredTypes() {
      return requiredTypes;
   }

   public void setRequiredTypes(Set<TRequiredCharacterType> requiredTypes) {
      this.requiredTypes = requiredTypes;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

