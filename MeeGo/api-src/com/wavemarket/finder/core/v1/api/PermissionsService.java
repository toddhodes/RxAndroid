package com.wavemarket.finder.core.v1.api;

import java.util.List;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TPermissionRequest;
import com.wavemarket.finder.core.v1.dto.managephones.TPermissionsPhoneDetail;


public interface PermissionsService {

   public List<TPermissionsPhoneDetail> getPhoneList(TAuthToken token)
           throws AuthorizationException,
                  GatewayException,
                  PersistException,
                  ServiceException;

   public List<TPermissionRequest> getPermissionRequests(TAuthToken token)
   throws AuthorizationException,
                  GatewayException,
                  PersistException,
                  ServiceException;
   
   public TPermissionRequest getPermissionRequest(TAuthToken token, long permissionRequestId)
   throws AuthorizationException,
                  GatewayException,
                  PersistException,
                  ServiceException;
   
   public void fulfillPermissionRequest(TAuthToken token, long permissionRequestId)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;
   
   public void rejectPermissionRequest(TAuthToken token, long permissionRequestId)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;
   
   public void revokePermissionRequest(TAuthToken token, long permissionRequestId)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;
   

   public String getAccountEmail(TAuthToken token)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;
   
   public void saveAccountEmail(TAuthToken token, String email)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;
   
   public void removeAccountEmail(TAuthToken token)
   throws AuthorizationException,
         GatewayException,
         PersistException,
         ServiceException;

}

