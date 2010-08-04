package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 7, 2008
 * Created-Time: 3:58:40 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAuthToken implements java.io.Serializable {

   private byte[] sessionId;

   public TAuthToken() {
      // auto-generated
   }
   
   public TAuthToken(byte[] sessionId) {
      this.sessionId = sessionId;
   }

   public byte[] getSessionId() {
      return sessionId;
   }

   public void setSessionId(byte[] sessionId) {
      this.sessionId = sessionId;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

