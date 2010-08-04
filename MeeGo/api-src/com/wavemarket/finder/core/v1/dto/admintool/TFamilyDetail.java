package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.List;
import java.util.Map;

import com.wavemarket.finder.core.v1.dto.alert.TRegionChangeAlert;
import com.wavemarket.finder.core.v1.dto.alert.TScheduleCheck;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 5, 2008
 * Created-Time: 3:49:33 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TFamilyDetail implements java.io.Serializable {

   private TParentDetail parent;
   private List<TChild> children;
   private List<TScheduleCheck> scheduleChecks;
   private List<TRegionChangeAlert> regionChangeAlerts;
   private Map<String, String> familyDescription;

   public TFamilyDetail() {
      // auto-generated
   }
   
   public TFamilyDetail(TParentDetail parent, List<TChild> children,
         List<TRegionChangeAlert> regionChangeAlerts,
         List<TScheduleCheck> scheduleChecks,
         Map<String, String> familyDescription) {
      this.parent = parent;
      this.children = children;
      this.regionChangeAlerts = regionChangeAlerts;
      this.scheduleChecks = scheduleChecks;
      this.familyDescription = familyDescription;
   }
   
   public List<TScheduleCheck> getScheduleChecks() {
      return scheduleChecks;
   }

   public List<TRegionChangeAlert> getRegionChangeAlerts() {
      return regionChangeAlerts;
   }

   public TParentDetail getParent() {
      return parent;
   }

   public List<TChild> getChildren() {
      return children;
   }

   public Map<String, String> getFamilyDescription() {
      return familyDescription;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

