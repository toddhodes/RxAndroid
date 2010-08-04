package com.wavemarket.finder.core.v1.api;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAccountData;
import com.wavemarket.finder.core.v1.dto.TAccountTypeData;
import com.wavemarket.finder.core.v1.dto.TAsset;
import com.wavemarket.finder.core.v1.dto.TAssetState;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TBillingPaymentEvent;
import com.wavemarket.finder.core.v1.dto.TDowngradingState;
import com.wavemarket.finder.core.v1.dto.TMessageDeliveryType;
import com.wavemarket.finder.core.v1.dto.TPaymentAccountType;
import com.wavemarket.finder.core.v1.dto.TPlanDetails;
import com.wavemarket.finder.core.v1.dto.admintool.TLocateNotification;
import com.wavemarket.finder.core.v1.dto.admintool.TPhoneAccountData;


/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 12:08:36 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface AccountService {

   public TAccountData getAccountData(TAuthToken token)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                ServiceException;
   
   public void changeAccountLocale(TAuthToken token, Locale newLocale) 
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void changeAccountDisplayName(TAuthToken token, String name)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void changeAccountEmail(TAuthToken token, String email)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException, 
             OperationException.DuplicateEmail, 
             OperationException.InvalidParameter;

   public void changeAccountContactPhone(TAuthToken token, String contactPhone)
   throws AuthorizationException,
          PersistException,
          GatewayException,
          ServiceException;
   
   public void changeAccountTimezone(TAuthToken token, String timezone)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void changeAccountZipCode(TAuthToken token, String zipCode)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void changeAccountMessageDeliveryForAccountChange(TAuthToken token, TMessageDeliveryType messageDeliveryType)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void changeAccountMessageDeliveryForLocate(TAuthToken token, TMessageDeliveryType messageDeliveryType)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;
   
   public void changeDowngradingState(TAuthToken token, TDowngradingState newStatus)
         throws AuthorizationException,
                PersistException,
                ServiceException,
                GatewayException;
   
   public void changePaymentAccountType(TAuthToken token, TPaymentAccountType paymentAccountType)
   throws AuthorizationException,
          PersistException,
          GatewayException,
          ServiceException;
   
   /**
    * 
    * @param token a current auth token
    * @return accountType object
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws ServiceException -
    */
   public TAccountTypeData getAccountTypeData(TAuthToken token)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;
   
   /** 
    * @param token a current auth token
    * @param displayName name of the new asset
    * @param locateNotification locate notification setting for the new asset, 
    *        or null to use default
    * @param contactPhone phone of the new asset
    * @param ownerEmail email of person who pays child's bill, or null if the
    *        email is not known. Use it to inform that person that somebody else
    *        is trying to add this child
    * @return new asset
    * @throws AuthorizationException if the auth token is invalid or the admin
    *    is not permitted to complete this operation
    * @throws GatewayException if a service used by the Finder Core is
    *    unavailable or returns an error
    * @throws OperationException.AlreadyAtMaximum if the user already has
    *    the maximum allowed assets
    * @throws OperationException.DuplicatePhoneNumber if an asset with this phone number already exists
    * @throws OperationException.DuplicateName if an asset with this name already exists 
    * @throws OperationException.InvalidParameter if the user provided invalid inputs
    * @throws OperationException.NoDataFound if the user provided an invalid phone number
    * @throws PersistException if the Core encounters a database problem
    * @throws ServiceException for all other problems
    */
   public TAsset addAsset(TAuthToken token, String displayName,
                          String contactPhone, TLocateNotification locateNotification, String ownerEmail)
            throws AuthorizationException, GatewayException,
                   OperationException.AlreadyAtMaximum,
                   OperationException.InvalidParameter,
                   OperationException.NoDataFound,
                   OperationException.DuplicatePhoneNumber,
                   OperationException.DuplicateName,
                   PersistException, ServiceException;

   public void deleteAsset(TAuthToken token, long assetId)
         throws AuthorizationException,
                GatewayException, 
                PersistException,
                ServiceException;

   /**
    * Pare an account's assets down to only those in the list of assets to keep.
    * 
    * @param token
    * @param assetsToKeep
    * @throws AuthorizationException
    * @throws GatewayException
    * @throws PersistException
    * @throws ServiceException
    */
   public void pareAssets(TAuthToken token, List<TAsset> assetsToKeep)
      throws AuthorizationException, 
             GatewayException,
             PersistException, 
             ServiceException;
   
   /**
    * Fetch an asset
    * @param token -
    * @param assetId -
    * @return the fetched asset, or null if no asset was found
    * @throws AuthorizationException.NotPermitted if the asset doesn't belong to the supplied admin
    * @throws AuthorizationException for other authentication issues.
    * @throws GatewayException -
    * @throws PersistException -
    * @throws ServiceException -
    */
   public TAsset getAsset(TAuthToken token, long assetId)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   /**
    * Fetch an asset
    * @param token -
    * @param mdn the mdn of the asset to search for
    * @return the fetched asset, or null if no asset was found
    * @throws AuthorizationException.NotPermitted if the asset doesn't belong to the supplied admin
    * @throws AuthorizationException for other authentication issues.
    * @throws GatewayException -
    * @throws PersistException -
    * @throws ServiceException -
    */
   public TAsset getAsset(TAuthToken token, String mdn)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   public List<TAsset> getAssets(TAuthToken token)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;
   
   public List<TAssetState> getAssetStates(TAuthToken tToken) throws AuthorizationException, GatewayException,
	PersistException, ServiceException;
   
   public void updateAsset(TAuthToken token, TAsset asset)
           throws AuthorizationException,
                  GatewayException,
                  OperationException.DuplicateName,
                  PersistException, ServiceException;
   
   
   public void suspendAsset(TAuthToken token, TAsset asset)
   throws AuthorizationException,
          GatewayException,
          OperationException.DuplicateName,
          PersistException, ServiceException;
   
   public void reactivateAsset(TAuthToken token, TAsset asset)
   throws AuthorizationException,
          GatewayException,
          OperationException.DuplicateName,
          PersistException, ServiceException;

   /**
    * renames a set of the assets associated with an admin
    * @param token -
    * @param newNames map phoneNumber -> newName
    * @throws AuthorizationException -
    * @throws GatewayException -
    * @throws OperationException.DuplicateName -
    * @throws PersistException -
    * @throws ServiceException -
    */
   public void renameAssets(TAuthToken token, Map<String, String> newNames)
            throws AuthorizationException,
                   GatewayException,
                   OperationException.DuplicateName,
                   PersistException, ServiceException;

   /**
    * @param token a current auth token
    * @return a map of assetIds to valid TLocateNotifications for that asset
    * @throws AuthorizationException if the auth token is invalid or the admin
    *    is not permitted to complete this operation
    * @throws GatewayException if a service used by the Finder Core is
    *    unavailable or returns an error
    * @throws PersistException if the Core encounters a database problem
    * @throws ServiceException for all other problems
    */
   public Map<Long, List<TLocateNotification>> getValidAssetLocateNotifications(TAuthToken token)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   public void sendSMS(TAuthToken token, long assetId, String messageText)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   /**
    * @param token a current auth token
    * @return a list of phone numbers for phones that are "compatible" with
    *    this account - usually phones in this subscriber's family plan.
    * @throws AuthorizationException if the auth token is invalid or the admin
    *    is not permitted to complete this operation
    * @throws GatewayException if a service used by the Finder Core is
    *    unavailable or returns an error
    * @throws PersistException if the Core encounters a database problem
    * @throws ServiceException for all other problems
    *
    */
   public List<TPhoneAccountData> getAccountCompatiblePhones(TAuthToken token)
           throws AuthorizationException,
                  GatewayException,
                  PersistException,
                  ServiceException;
   
   /**
    * 
    * @param authToken a current auth token
    * @return getAccountCompatiblePhones without phones that have already been added as assets
    * @throws AuthorizationException if the auth token is invalid or the admin
    *    is not permitted to complete this operation
    * @throws GatewayException if a service used by the Finder Core is
    *    unavailable or returns an error
    * @throws PersistException if the Core encounters a database problem
    * @throws ServiceException for all other problems
    */
   public List<TPhoneAccountData> getNonAddedPhones(TAuthToken authToken)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   /**
    * Cancel the trial account for the account associated with a token.
    * May make the token invalid for future requests.
    * @param token a current auth token
    * @throws AuthorizationException if the auth token is invalid or not 
    *    associated with a trial account
    * @throws GatewayException if a service used by the Finder Core is
    *    unavailable or returns an error
    * @throws OperationException.NotFound if the account could not be found
    * @throws PersistException if the Core encounters a database problem
    * @throws ServiceException for all other problems
    */
   public void cancelTrialAccount(TAuthToken token)
      throws  AuthorizationException,
              GatewayException,
              OperationException.NotFound,
              PersistException,
              ServiceException;
   
   public Date getTrialEndDate(TAuthToken token) 
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;
   
   
   /**
    * Returns a list of billing payments for the Actor associated with given AuthToken
    * 
    * @param tToken
    * @param startDate
    * @param endDate
    * @param maxRecords
    * @return a list of billing events
    * @throws AuthorizationException
    * @throws PersistException
    * @throws GatewayException
    * @throws ServiceException
    */
   public List<TBillingPaymentEvent> getBillingPaymentEventHistory(TAuthToken tToken,
			Date startDate, Date endDate, int maxRecords)
			throws AuthorizationException, PersistException, GatewayException,
			ServiceException;

   public TPlanDetails getPlanDetails(TAuthToken tToken)
			throws AuthorizationException, PersistException, GatewayException,
			ServiceException;
   
   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
*/
