package com.wavemarket.finder.core.v1.dto.admintool;

import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 1:03:46 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TFamily implements java.io.Serializable {

   private TParent parent;
   private List<TChild> children;

   public TFamily() {
      // auto-generated
   }
   
   public TFamily(TParent parent, List<TChild> children) {
      this.parent = parent;
      this.children = children;
   }

   public List<TChild> getChildren() {
     return children;
   }

   public TParent getParent() {
     return parent;
   }

   public void setParent(TParent parent) {
      this.parent = parent;
   }

   public void setChildren(List<TChild> children) {
      this.children = children;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

