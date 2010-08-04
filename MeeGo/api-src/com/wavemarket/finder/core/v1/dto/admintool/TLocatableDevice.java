package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: May 13, 2008
 * Created-Time: 10:43:00 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TLocatableDevice extends TDevice implements java.io.Serializable {

   private List<TDeviceParentInfo> parents;

   public TLocatableDevice() {
      // auto-generated
   }
   
   public TLocatableDevice(long id, String mdn,
                 TAccountState accountState,
                 TNetwork network, List<TDeviceParentInfo> parents) {
      super(id, mdn, accountState, network);
      this.parents = parents;
   }

   public List<TDeviceParentInfo> getParents() {
      return parents;
   }

   public void setParents(List<TDeviceParentInfo> parents) {
      this.parents = parents;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

