package com.wavemarket.finder.core.v1.dto.location;

/**
 * @author oliver
 */

/*
 * Created-Date: May 1, 2008
 * Created-Time: 6:14:36 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TAccuracy implements java.io.Serializable {

   private int majorRadius;
   private int minorRadius;
   private double confidence;
   private double angle;

   public TAccuracy() {
      // auto-generated
   }
   
   public TAccuracy(int majorRadius, int minorRadius, double confidence, double angle) {
      this.majorRadius = majorRadius;
      this.minorRadius = minorRadius;
      this.confidence = confidence;
      this.angle = angle;
   }

   public int getMajorRadius() {
      return majorRadius;
   }

   public void setMajorRadius(int majorRadius) {
      this.majorRadius = majorRadius;
   }

   public int getMinorRadius() {
      return minorRadius;
   }

   public void setMinorRadius(int minorRadius) {
      this.minorRadius = minorRadius;
   }

   public double getConfidence() {
      return confidence;
   }

   public void setConfidence(double confidence) {
      this.confidence = confidence;
   }

   public double getAngle() {
      return angle;
   }

   public void setAngle(double angle) {
      this.angle = angle;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

