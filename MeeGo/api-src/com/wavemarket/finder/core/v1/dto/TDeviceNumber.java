package com.wavemarket.finder.core.v1.dto;

import java.io.Serializable;

public final class TDeviceNumber implements Serializable {
  private String type;
  private String number;
  
  public TDeviceNumber(String type, String number) {
    this.type = type;
    this.number = number;      
  }

  public String getType() {
    return type;
  }

  public String getNumber() {
    return number;
  }

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 2
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=2 tabstop=2 expandtab cindent :
*/
