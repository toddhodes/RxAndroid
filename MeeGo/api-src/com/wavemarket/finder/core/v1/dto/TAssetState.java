package com.wavemarket.finder.core.v1.dto;

import com.wavemarket.finder.core.v1.dto.admintool.TLocateNotification;

public class TAssetState extends TAsset implements java.io.Serializable {


    public TAssetState() {
	// auto-generated
    }
    
	public TAssetState(long id, String name, String contactPhone,
                      boolean permittedToLocate, boolean beingTracked,
                      TLocateNotification locateNotification,
                      ProvisioningState provisioningState) {      
	   super(id, name, contactPhone, permittedToLocate, beingTracked,
            locateNotification);
	   this.provisioningState = provisioningState;
   }

	public TAssetState(TAsset asset, ProvisioningState provisioningState) {
	   super(asset);
	   this.provisioningState = provisioningState;
	}
	
   public enum ProvisioningState {
		ACTIVE,
		SUSPENDED,
		PENDING_SUSPENSION,
		PENDING_ACTIVATION
	}
	
	private ProvisioningState provisioningState;	

	public ProvisioningState getProvisioningState() {
		return provisioningState;
	}

	public void setProvisioningState(ProvisioningState provisioningState) {
		this.provisioningState = provisioningState;
	}
}
