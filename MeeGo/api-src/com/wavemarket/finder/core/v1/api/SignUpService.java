package com.wavemarket.finder.core.v1.api;

import java.util.List;

import com.wavemarket.finder.core.v1.api.exception.AuthenticationException;
import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAccountInfo;
import com.wavemarket.finder.core.v1.dto.TAddress;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.signup.TAssetInfo;
import com.wavemarket.finder.core.v1.dto.signup.TDemoAccountRequest;
import com.wavemarket.finder.core.v1.dto.signup.TSignUpPhoneDetails;
import com.wavemarket.finder.core.v1.dto.signup.TSignUpPhoneInfo;
import com.wavemarket.finder.core.v1.dto.signup.TSignUpResult;
import com.wavemarket.finder.core.v1.dto.signup.TSignupType;
import com.wavemarket.finder.core.v1.dto.signup.TClientType;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 17, 2008
 * Created-Time: 3:20:52 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface SignUpService {

   public TSignUpPhoneInfo getSignupPhoneInfo(TAuthToken signupAuthToken)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;
   /**
    * Request some details about a phone we want to signup for service with. We
    * have already authenticated ourselves.
    * 
    * @param signupAuthToken - An auth token to pick out which signup phone 
    *                          we're talking about
    * @return Signup phone details about the phone we're requesting to sign up with.
    * @throws AuthorizationException if the provided token is invalid
    * @throws OperationException.NotFound if the provided token does not specify a device
    * @throws GatewayException
    * @throws PersistException
    * @throws ServiceException
    */
   public TSignUpPhoneDetails getSignUpPhoneDetails(TAuthToken signupAuthToken)
         throws AuthorizationException,            
                GatewayException,
                PersistException,
                ServiceException,
                OperationException.NotFound;
   
   public TSignUpPhoneDetails getSignupPhoneDetails(String phoneNumber)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException,
                OperationException.NotFound;
   
   public TSignUpPhoneInfo getSignupChildPhoneList(TAuthToken signupAuthToken)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   /**
    * Creates a new account, without the REGISTRATION_INCOMPLETE flag but with the
    * CHILD_CREATION_INCOMPLETE flag, and modifies the supplied auth token into a
    * login token for that account.
    *
    * @param signupAuthToken auth token for this signup attempt
    * @param accountMdn mdn to create account under
    * @param displayName displayname to use
    * @param email email address of record on account
    * @param zipcode used to work out timezone
    * @param locale language you want to use, null for default
    * @param password new password
    * @param trialRequested true if you would like a trial account
    * @param assets assets to add
    * @param needToAddAllChildren if true, then signup will fail if all supplied
    *        children could not be added. If false, signup will fail if none of
    *        the supplied children could be added.
    * @param clientType the type of client which is being used to sign up.
    * @return updated login info for the newly created account
    * @throws AuthenticationException.ServiceNotAvailable if the requested service is
    *         not available for the mdn you specified
    * @throws AuthorizationException.InvalidToken if the supplied token is invalid
    * @throws AuthorizationException.NotPermitted if the token supplied is not allowed
    *         to create an account
    * @throws GatewayException if we can't communicate with an external service,
    *         eg carrier account service
    * @throws OperationException.NotFound if the specified mdn is not
    *         found on the account
    * @throws OperationException.Duplicate if the account that the caller requested to
    * create already exists.
    * @throws OperationException.InvalidParameter if one of the supplied
    * parameters has a bad value. Expected values are:<ul>
    * <li>contactPhone</li>
    * <li>email</li>
    * <li>mdn</li>
    * <li>password</li>
    * <li>zipcode</li>
    * </ul>
    * @throws PersistException in the case of a db error
    * @throws ServiceException in the case of a serious error
    * @throws OperationException.NoAssetsAdded if the operation fails because
    *         no assets were added
    */
   public TSignUpResult signUp(TAuthToken signupAuthToken, String accountMdn,
                      String displayName, String email,
                      String zipcode, String locale,
                      String password, boolean trialRequested,
                      List<TAssetInfo> assets, boolean needToAddAllChildren,
                      TClientType clientType)
         throws AuthenticationException.ServiceNotAvailable,
                AuthorizationException.InvalidToken,
                AuthorizationException.NotPermitted,
                GatewayException,
                OperationException.Duplicate,
                OperationException.InvalidParameter,
                OperationException.NoAssetsAdded,
                OperationException.NotFound,
                PersistException, ServiceException;
   
   public TSignupType getSignupType(TAuthToken signupAuthToken) 
   throws AuthorizationException.InvalidToken,
          AuthorizationException.NotPermitted,
          GatewayException,
          PersistException,
          ServiceException;

   public void requestDemoAccount(String applicantName,
                                  String applicantEmail, String applicantPhone,
                                  String supervisorName, String supervisorEmail,
                                  String supervisorPhone,
                                  String storeName, String storeId,
                                  TAddress storeAddress, String localeId)
            throws GatewayException,
                   OperationException.InvalidParameter,
                   OperationException.NotFound,
                   OperationException.RequestExists,
                   OperationException.RequestAlreadyApproved,
                   PersistException, ServiceException;   
   
   public List<TDemoAccountRequest> getOutstandingDemoRequests(TAuthToken superuserAuth)
           throws AuthorizationException.InvalidToken, GatewayException, PersistException, ServiceException;

   public List<TDemoAccountRequest> getApprovedDemoRequests(TAuthToken superuserAuth)
           throws AuthorizationException.InvalidToken, GatewayException, PersistException, ServiceException;
   
   public List<TDemoAccountRequest> getRejectedDemoRequests(TAuthToken superuserAuth)
   throws AuthorizationException.InvalidToken, GatewayException, PersistException, ServiceException;
   
   public void approveDemoAccountRequest(TAuthToken superuserAuth, String applicantMdn)
           throws AuthenticationException.NoSuchAccount, 
                  AuthorizationException.AccountSuspended,
                  AuthorizationException.InvalidToken,
                  AuthorizationException.NotPermitted,
                  AuthorizationException.UnprovisionedAccount,
                  AuthorizationException.TemporaryPassword,
                  GatewayException, 
                  PersistException,
                  ServiceException,
                  OperationException.NotFound,
                  OperationException.DuplicateAccount;

   public void rejectDemoAccountRequest(TAuthToken superuserAuth, String applicantMdn)
           throws AuthorizationException.InvalidToken, GatewayException, OperationException.NotFound, PersistException, ServiceException;

   public String getEmailForToken(TAuthToken token)
         throws AuthorizationException.NotPermitted,
                AuthorizationException.InvalidToken, 
                PersistException,
                GatewayException;
   
   /**
    * Associate the accountInfo with the UnregisteredUser identified by the descriptor
    */
   public void savePresignupInfo(
         TDescriptor descriptor,
         List<TAccountInfo> accountInfo) 
      throws AuthorizationException.NotPermitted,
             PersistException, 
             GatewayException;
   
   /**
    * Return the accountInfo associated with the UnregisteredUser identified by
    * the TAuthtoken. It is an error to call this method with an TAuthtoken not
    * associated with an UnregisteredUser
    */
   public List<TAccountInfo> getPresignupInfo(
         TAuthToken token) 
      throws AuthorizationException.NotPermitted,
             PersistException, 
             GatewayException;
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3 :
*/
