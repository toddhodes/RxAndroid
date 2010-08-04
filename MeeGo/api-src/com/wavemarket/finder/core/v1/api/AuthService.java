package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthenticationException;
import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.api.result.AuthResult;
import com.wavemarket.finder.core.v1.api.result.DeliveryResult;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TCredential;
import com.wavemarket.finder.core.v1.dto.TCredentialRequestDeliveryType;
import com.wavemarket.finder.core.v1.dto.TCredentialRequestDestination;
import com.wavemarket.finder.core.v1.dto.TCredentialRequestPurpose;
import com.wavemarket.finder.core.v1.dto.TCredentialRequestType;
import com.wavemarket.finder.core.v1.dto.TDescriptor;
import com.wavemarket.finder.core.v1.dto.TLoginInfo;
import com.wavemarket.finder.core.v1.dto.TPasswordDescription;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 11:50:11 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface AuthService {

   /**
    * Method to authenticate a credential.
    * 
    * @param credential - An object that includes enough information to authenticate
    *                     a user is who they claim to be. 
    * @return An authtoken that can be used to make subsequent authenticated
    *         api calls and loginInfo indicating some useful information about
    *         the authenticated user.
    * @throws AuthenticationException.AccountBlocked if the user has successively 
    *          provided bad credentials too many times within a specified time period.
    * @throws AuthenticationException.AccountSuspended if the authOwner the credential
    *         indicates is suspended.
    * @throws AuthenticationException.PasswordExpired if the password for a temp
    *         password credential/auth combo is expired.
    * @throws AuthenticationException.BadCredentials if the information provided
    *         does not identify at least one auth.
    * @throws AuthenticationException.NoSuchAccount if the information provided
    *         does not eventually point to a proper authOwner.
    * @throws AuthenticationException.PendingAccount
    * @throws AuthenticationException.ServiceNotAvailable
    * @throws AuthorizationException.NotPermitted
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */
   public AuthResult auth(TCredential credential) 
         throws AuthenticationException.AccountBlocked,
                AuthenticationException.AccountSuspended,
                AuthenticationException.PasswordExpired,
                AuthenticationException.BadCredentials,
                AuthenticationException.NoSuchAccount,
                AuthenticationException.PendingAccount,
                AuthenticationException.ServiceNotAvailable,
                AuthorizationException.NotPermitted,
                PersistException,
                ServiceException,
                GatewayException;

   public void endAuthSession(TAuthToken token)
         throws AuthorizationException.InvalidToken,
                AuthorizationException.NotPermitted,
                PersistException,
                ServiceException;

   /**
    * A superuser (admin tool user) may call this method to request
    * a login token for a particular user account.
    * @param superuserAuthToken a current auth token for the superuser
    * @param phone the account number phone of the account to log into
    * @return an auth result.
    * @throws AuthorizationException.InvalidToken -
    * @throws AuthorizationException.NotPermitted -
    * @throws AuthenticationException.PendingAccount -
    * @throws OperationException.NotFound if an account with that phone number could not be found
    * @throws PersistException -
    * @throws ServiceException -
    * @throws GatewayException 
    */
   public AuthResult superuserRequestPhoneAuth(TAuthToken superuserAuthToken, String phone)
        throws AuthorizationException.InvalidToken,
               AuthorizationException.NotPermitted,
               AuthenticationException.PendingAccount,
               OperationException.NotFound,
               PersistException,
               ServiceException, GatewayException;

   /**
    * change password for  logins
    * @param authToken token representing a current auth session
    * @param oldPassword password to change
    * @param newPassword password to change to
    * @throws AuthenticationException.BadCredentials
    *   if the specified oldPassword is incorrect
    * @throws AuthenticationException.AccountBlocked
    *   if the account has been blocked
    * @throws AuthenticationException.CannotChangeOwnPassword
    *   if the user is not allowed to change his or her own password
    * @throws AuthenticationException.NoSuchAccount
    *   if no account can be found for the phone number
    * @throws AuthenticationException.RejectedPassword.InsecurePassword
    *   if the new password is insufficiently secure
    * @throws AuthenticationException.RejectedPassword.IllegalCharactersInPassword
    *   if the password contains characters that are illegal for this deployment
    * @throws AuthenticationException.RejectedPassword.MissingRequiredCharacterType
    *   if the password is missing a character of a required type.
    *   eg "must contain at least one number"
    * @throws AuthenticationException.RejectedPassword.TooShort
    *   if the new password is too short
    * @throws AuthenticationException.RejectedPassword.TooLong
    *   if the new password is too long
    * @throws AuthorizationException.InvalidToken
    *   if the auth token is invalid or has expired
    * @throws AuthorizationException.NotPermitted
    *   if the operation is not permitted for that token
    * @throws AuthorizationException.AccountSuspended
    *   if this account has been suspended
    * @throws PersistException
    *   in the case of a database or other persistence error
    * @throws GatewayException
    *   in the case of an error accessing a a service via a gateway
    * @throws ServiceException
    *   in the case of another error in the core service
    * @throws AccountBlocked 
    */
   public void changePassword(TAuthToken authToken, String oldPassword, String newPassword)
            throws AuthenticationException.BadCredentials,
                   AuthenticationException.AccountBlocked,
                   AuthenticationException.CannotChangeOwnPassword,
                   AuthenticationException.NoSuchAccount,
                   AuthenticationException.RejectedPassword.InsecurePassword,
                   AuthenticationException.RejectedPassword.IllegalCharactersInPassword,
                   AuthenticationException.RejectedPassword.MissingRequiredCharacterType,
                   AuthenticationException.RejectedPassword.TooShort,
                   AuthenticationException.RejectedPassword.TooLong,
                   AuthorizationException.InvalidToken,
                   AuthorizationException.NotPermitted,
                   AuthorizationException.AccountSuspended,
                   PersistException,
                   GatewayException,
                   ServiceException;

   /**
    * Method to change the password a user.
    * 
    * The provided descriptor must match the information pointed to by the authToken.
    * 
    * @param tToken - An authtoken.
    * @param descriptor - Identifying information provided by the user.
    * @param newPassword - The new password which the user would like to use.
    * @throws AuthenticationException.CannotChangeOwnPassword if the user cannot
    *         edit their own account.
    * @throws AuthenticationException.RejectedPassword.InsecurePassword
    * @throws AuthenticationException.RejectedPassword.IllegalCharactersInPassword
    * @throws AuthenticationException.RejectedPassword.MissingRequiredCharacterType
    * @throws AuthenticationException.RejectedPassword.TooShort
    * @throws AuthenticationException.RejectedPassword.TooLong
    * @throws AuthorizationException.InvalidToken if the provided token does not
    *         point to a user.
    * @throws AuthorizationException.AccountSuspended if the account is suspended.
    * @throws AuthorizationException.NotPermitted 
    * @throws PersistException if we have trouble communicating with the db.
    * @throws GatewayException if we have trouble with a remote server.
    * @throws ServiceException if we have trouble with a core service.
    */
   public void resetPassword(TAuthToken tToken, TDescriptor descriptor, String newPassword)
      throws AuthenticationException.CannotChangeOwnPassword,
             AuthenticationException.RejectedPassword.InsecurePassword,
             AuthenticationException.RejectedPassword.IllegalCharactersInPassword,
             AuthenticationException.RejectedPassword.MissingRequiredCharacterType,
             AuthenticationException.RejectedPassword.TooShort,
             AuthenticationException.RejectedPassword.TooLong,
             AuthorizationException.InvalidToken,
             AuthorizationException.AccountSuspended,
             AuthorizationException.NotPermitted,
             PersistException,
             GatewayException,
             ServiceException;
   
   /**
    * Get the password description used by the core for phone/password logins  
    * @return the description
    * @throws ServiceException in case of a serious error
    */
   public TPasswordDescription getPasswordDescription() throws ServiceException;

   /**
    * Method to pre-validate a potential password before submission.
    * @param potentialPassword the password to validate
    * @throws AuthenticationException.RejectedPassword.InsecurePassword
    *   if the new password is insufficiently secure
    * @throws AuthenticationException.RejectedPassword.IllegalCharactersInPassword
    *   if the password contains characters that are illegal for this deployment
    * @throws AuthenticationException.RejectedPassword.MissingRequiredCharacterType
    *   if the password is missing a character of a required type.
    *   e.g. "must contain at least one number"
    * @throws AuthenticationException.RejectedPassword.TooLong
    *   if the new password is too long
    * @throws AuthenticationException.RejectedPassword.TooShort
    *   if the new password is too short
    * @throws ServiceException
    *   in the case of another error in the core service
    */
   public void validatePassword(String potentialPassword)
         throws AuthenticationException.RejectedPassword.InsecurePassword,
                AuthenticationException.RejectedPassword.IllegalCharactersInPassword,
                AuthenticationException.RejectedPassword.TooShort,
                AuthenticationException.RejectedPassword.TooLong,
                AuthenticationException.RejectedPassword.MissingRequiredCharacterType,
                ServiceException;

   /**
    * Method to fetch an updated copy of login info for the current login. Called when
    * we do something that we suspect may have changed this information, like change
    * timezone or change subscription level.
    * @param authToken -
    * @return newly created login info
    * @throws AuthorizationException.AccountSuspended if the account is suspended.
    * @throws AuthorizationException.InvalidToken if the supplied auth token is invalid
    * @throws AuthorizationException.NotPermitted if the data cannot be obtained for
    *  permissions reasons.
    * @throws PersistException in the case of a database error.
    * @throws GatewayException in the case of an error with a remove server.
    * @throws ServiceException in the case of another error in the core service
    */
   public TLoginInfo getUpdatedLoginInfo(TAuthToken authToken)
      throws AuthorizationException.AccountSuspended,
             AuthorizationException.InvalidToken,
             AuthorizationException.NotPermitted,
             PersistException,
             GatewayException,
             ServiceException;
   
   /**
    * Method to allow a user to request a credential for some usage of Finder.
    * 
    * The method does not return the credential itself, but will undertake a 
    * Finder specified action that will result in some a credential being
    * delivered to a user. It returns a DeliveryResult that indicates what Finder
    * did to satisfy the request, or it throws an error.
    * 
    * @param descriptor - Identifying information provided by the user requesting
    *                     a credential
    * @param locale - The locale the user expects any notifications to be presented in.
    * @param purpose - The purpose for the credential request.
    * @param destination - The eventual destination at which the credential will
    *                      be used. e.g. WEB, WAP.
    * @param deliveryType - The method of delivery to be used, e.g. EMAIL, SMS.
    * @param type - The type of credential requested, e.g. PASSWORD, TOKEN.
    * @return An object representing the action undertaken including such favorites
    *         as EMAIL_SENT and SMS_SENT.
    * @throws AuthenticationException.NoSuchAccount if the user made a request
    *         that requires creating an authOwner, but the user doesn't have a carrier account
    * @throws AuthorizationException.AccountSuspended if the user made a request
    *         that requires an active authOwner, but their authOwner is suspended.
    * @throws AuthorizationException.NotPermitted if the user is no permitted
    *         to make the credential request they just made.
    * @throws AuthorizationException.UnprovisionedAccount if the credential 
    *         request requires an admin, but the admin is unprovisioned.
    * @throws OperationException.NotFound if the request requires an existing 
    *         authOwner, but none exists.
    * @throws OperationException.DuplicateAccount if the request requires creating
    *         a new authOwner, but one already exists.
    * @throws GatewayException if we have trouble communicating with a remote server.
    * @throws PersistException if we have trouble with a database.
    * @throws ServiceException if we have trouble with a core service.
    * @throws PasswordExpired 
    */
   public DeliveryResult requestCredential(
         TDescriptor descriptor,
         String locale,
         TCredentialRequestPurpose purpose,
         TCredentialRequestDestination destination,
         TCredentialRequestDeliveryType deliveryType,
         TCredentialRequestType type)
      throws AuthenticationException.NoSuchAccount,
             AuthenticationException.PasswordExpired,
             AuthorizationException.AccountSuspended,
             AuthorizationException.NotPermitted,
             AuthorizationException.UnprovisionedAccount,
             GatewayException, 
             PersistException,
             ServiceException,
             OperationException.NotFound,
             OperationException.DuplicateAccount;
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
