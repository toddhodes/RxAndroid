package com.wavemarket.finder.core.v1.api.result;

import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TLoginInfo;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 5:48:38 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class AuthResult implements java.io.Serializable {

   private TAuthToken token;
   private TLoginInfo loginInfo;

   public AuthResult() {
      // auto-generated
   }
   
   public AuthResult(TAuthToken token, TLoginInfo loginInfo) {
      this.token = token;
      this.loginInfo = loginInfo;
   }

   public TAuthToken getToken() {
      return token;
   }

   public void setToken(TAuthToken token) {
      this.token = token;
   }

   public TLoginInfo getLoginInfo() {
      return loginInfo;
   }

   public void setLoginInfo(TLoginInfo loginInfo) {
      this.loginInfo = loginInfo;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

