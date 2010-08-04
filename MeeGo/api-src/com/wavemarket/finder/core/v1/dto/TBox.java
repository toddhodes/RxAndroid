package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 4:15:12 PM
 * Copyright 2007 WaveMarket, Inc
 */

public class TBox implements java.io.Serializable {
   private TLongLat southeast;
   private TLongLat northwest;

   public TBox() {
      // auto-generated
   }
   
   public TBox(TLongLat southeast, TLongLat northwest) {
      this.southeast = southeast;
      this.northwest = northwest;
   }

   public TLongLat getSoutheast() {
      return southeast;
   }

   public void setSoutheast(TLongLat southeast) {
      this.southeast = southeast;
   }

   public TLongLat getNorthwest() {
      return northwest;
   }

   public void setNorthwest(TLongLat northwest) {
      this.northwest = northwest;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

