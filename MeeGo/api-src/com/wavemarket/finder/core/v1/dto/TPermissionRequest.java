package com.wavemarket.finder.core.v1.dto;

import java.util.Map;

/**
 * @author aspolito
 */

/*
 * Created-Date: July 13, 2008
 * Created-Time: 3:46:12 PM
 * Copyright 2008 WaveMarket, Inc
 */

public class TPermissionRequest implements java.io.Serializable {
  private Long id;
  private String capabilityType; 
  private String permissionType;
  private String requestingPhoneNumber;
  private String requestedPhoneNumber;
  private String status;
  private Map<String, String> params;  

  public TPermissionRequest() {
    // auto-generated
  }
  
  public TPermissionRequest(Long id, 
                            String capabilityType,
                            String permissionType,
                            String requestingPhoneNumber,
                            String requestedPhoneNumber,
                            String status,
                            Map<String, String> params) {
    this.id = id;
    this.capabilityType = capabilityType;
    this.permissionType = permissionType;
    this.requestingPhoneNumber = requestingPhoneNumber;
    this.requestedPhoneNumber = requestedPhoneNumber;
    this.status = status;
    this.params = params;
  }

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getCapabilityType() {
    return capabilityType;
  }
  
  public void setCapabilityType(String capabilityType) {
    this.capabilityType = capabilityType;
  }
  
  public String getPermissionType() {
    return permissionType;
  }
  
  public void setPermissionType(String permissionType) {
    this.permissionType = permissionType;
  }
  
  public String getRequestedPhoneNumber() {
    return requestedPhoneNumber;
  }

  public void setRequestedPhoneNumber(String requestedPhoneNumber) {
    this.requestedPhoneNumber = requestedPhoneNumber;
  }

  public String getRequestingPhoneNumber() {
    return requestingPhoneNumber;
  }

  public void setRequestingPhoneNumber(String requestingPhoneNumber) {
    this.requestingPhoneNumber = requestingPhoneNumber;
  }

  public Map<String, String> getParams() {
    return params;
  }
  
  public void setParams(Map<String, String> params) {
    this.params = params;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 2
**   indent-tabs-mode: nil
** End:
*/

