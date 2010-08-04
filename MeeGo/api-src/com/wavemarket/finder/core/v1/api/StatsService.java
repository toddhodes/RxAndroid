package com.wavemarket.finder.core.v1.api;

import java.util.Date;
import java.util.Map;
import java.util.List;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;

/**
 * @author aspolito
 */

/*
 * Created-Date: Feb 26, 2009
 * Copyright 2009 WaveMarket, Inc 
 */
public interface StatsService {
   
   /**
    * Logs the completion/failure of a signup step.
    * @param authToken
    * @param step
    * @param date
    * @param errorCode
    * @throws AuthorizationException
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */
   public void logSignupStep(TAuthToken authToken, String step, Date date, String errorCode) 
      throws AuthorizationException,
             PersistException,
             ServiceException,
             GatewayException;
   /**
    * Logs that we're initiating signup. A hold over from when we were generating
    * signup ids.
    * @param authToken
    * @param date
    * @param product
    * @param sessionId
    * @throws AuthorizationException
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */
   public void logSignupInitiate(TAuthToken authToken, Date date, String product, String sessionId)
      throws AuthorizationException,
             PersistException,
             ServiceException,
             GatewayException;
   
   /**
    * Logs errors discovered during signup form validation
    * @param authToken
    * @param step
    * @param date
    * @param errorCodes
    * @throws AuthorizationException
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */
   public void logSignupErrors(TAuthToken authToken, String step, Date date, List<String> errorCodes)
      throws AuthorizationException,
             PersistException,
             ServiceException,
             GatewayException;

   /**
    * Logs an attempt to make a phone locatable during signup
    * @param authToken
    * @param mdn
    * @param date
    * @param failed
    * @throws AuthorizationException
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */
   public void logSignupLocatablePhone(TAuthToken authToken, String mdn, Date date, boolean failed)
      throws AuthorizationException,
             PersistException,
             ServiceException,
             GatewayException;

   /**
    * Logs a crash report (e.g. from the iPhone client)
    * @param authToken
    * @param data values are either strings or byte arrays
    * @throws AuthorizationException
    * @throws PersistException
    * @throws ServiceException
    * @throws GatewayException
    */

   public void logCrash(TAuthToken authToken, Map<String,Object> data)
      throws AuthorizationException,
             PersistException,
             ServiceException,
             GatewayException;
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/