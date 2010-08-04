package com.wavemarket.finder.core.v1.dto.signup;

import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 17, 2008
 * Created-Time: 3:34:25 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TSignUpPhoneInfo implements java.io.Serializable {

   List<TSignUpPhoneDetails> phones;

   public TSignUpPhoneInfo() {
      // auto-generated
   }
   
   public TSignUpPhoneInfo(List<TSignUpPhoneDetails> phones) {
      this.phones = phones;
   }

   public List<TSignUpPhoneDetails> getPhones() {
      return phones;
   }

   public void setPhones(List<TSignUpPhoneDetails> phones) {
      this.phones = phones;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

