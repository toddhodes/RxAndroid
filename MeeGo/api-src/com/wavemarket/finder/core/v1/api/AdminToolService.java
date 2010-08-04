package com.wavemarket.finder.core.v1.api;

import java.util.List;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAccountData;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.admintool.TChild;
import com.wavemarket.finder.core.v1.dto.admintool.TFamily;
import com.wavemarket.finder.core.v1.dto.admintool.TFamilyDetail;
import com.wavemarket.finder.core.v1.dto.admintool.TLocatableDevice;
import com.wavemarket.finder.core.v1.dto.admintool.TParent;
import com.wavemarket.finder.core.v1.dto.signup.TDemoAccountRequest;

/**
 * @author oliver
 */

/*
 * Created-Date: May 12, 2008
 * Created-Time: 1:02:33 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface AdminToolService {

   public void addFamily(TAuthToken token, TFamily family, String billingHint)
      throws AuthorizationException.InvalidToken,
             AuthorizationException.NotPermitted,
             GatewayException,
             OperationException,
             PersistException,
             ServiceException;

   public TLocatableDevice getChildDetails(TAuthToken token, String mdn)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  OperationException.NoDataFound,
                  PersistException,
                  ServiceException;

   public List<Long> findFamiliesByUsername(TAuthToken token, String username)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  PersistException,
                  ServiceException;

   public List<Long> findFamiliesByPhone(TAuthToken token, String mdn)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  PersistException,
                  ServiceException;

   public List<Long> findFamiliesByEmail(TAuthToken token, String email)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  PersistException,
                  ServiceException;
   
   public List<TAccountData> findDemoFamilies(TAuthToken token)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  GatewayException,
                  PersistException, ServiceException;
   
   public TFamilyDetail getFamilyDetails(TAuthToken token, long adminId)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  GatewayException,
                  OperationException.NoDataFound,
                  PersistException,
                  ServiceException;

   public void deleteFamily(TAuthToken token, long adminId)
         throws AuthorizationException.InvalidToken,
                AuthorizationException.NotPermitted,
                OperationException.NotFound,
                PersistException, ServiceException, GatewayException;

   /**
    * Add a child to the specified account
    * @param token current admintool auth token
    * @param adminId id of the account to which the child should be added.
    * @param child details of the child to add
    * @throws AuthorizationException.InvalidToken if the admintool login token
    *  is not valid or has expired
    * @throws AuthorizationException.NotPermitted if the current admintool
    *  user is not allowed to make that request.
    * @throws OperationException.ChildAlreadyExists if the mdn specified has
    *  already been added to this account.
    * @throws OperationException.NotFound if account information for the
    *  specified mdn could not be found.
    * @throws OperationException.DuplicateName if the child's name is a duplicate of another child's.
    * @throws GatewayException if we cannot communicate with an external
    *  service, probably the carrier's account system
    * @throws PersistException if there is a database issue
    * @throws ServiceException in the case of any other error
    */
   public void addChildToFamily(TAuthToken token, long adminId, TChild child)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  OperationException.ChildAlreadyExists,
                  OperationException.NotFound,
                  OperationException.DuplicateName,
                  GatewayException,
                  PersistException, ServiceException;

   public void deleteChildFromFamily(TAuthToken token, long adminId, String phoneNumber)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  OperationException.NotFound,
                  GatewayException,
                  PersistException, ServiceException;

   public void updateParent(TAuthToken token, TParent updatedParent)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  OperationException.NotFound,
                  OperationException.InvalidParameter,
                  OperationException.Duplicate,
                  GatewayException,
                  PersistException, ServiceException;
   
   public void suspendAdmin(TAuthToken token, long adminId)
         throws AuthorizationException.InvalidToken,
                AuthorizationException.NotPermitted,
                GatewayException,
                OperationException.NoDataFound,
                PersistException,
                ServiceException;
   
   public void unsuspendAdmin(TAuthToken token, long adminId)
         throws AuthorizationException.InvalidToken,
                AuthorizationException.NotPermitted,
                GatewayException,
                OperationException.NoDataFound,
                PersistException,
                ServiceException;
   
   public TDemoAccountRequest getDemoAccountRequestByPhoneNumber(TAuthToken token, String phoneNumber)
           throws AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  OperationException.NotFound,
                  OperationException.InvalidParameter,
                  GatewayException,
                  PersistException, ServiceException;
   
   public void changeAdminToolPassword(TAuthToken token, String newPassword) 
         throws AuthorizationException.InvalidToken, 
                PersistException,
                ServiceException;
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/