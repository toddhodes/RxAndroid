package com.wavemarket.finder.core.v1.dto;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 11:02:24 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TImageInfo implements java.io.Serializable {

   private int id;
   private int width;
   private int height;

   public TImageInfo() {
      // auto-generated
   }
   
   public TImageInfo(int id, int width, int height) {
      this.id = id;
      this.width = width;
      this.height = height;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

