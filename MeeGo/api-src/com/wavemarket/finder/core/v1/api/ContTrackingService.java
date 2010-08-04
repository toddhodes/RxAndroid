package com.wavemarket.finder.core.v1.api;

import java.util.Date;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TContTrackingSession;

/**
 * @author rwest
 *
 */
public interface ContTrackingService {

    public void startContinuousTracking( TAuthToken token,
                                         TContTrackingSession session )
        throws OperationException.AlreadyAtMaximum,
               AuthorizationException,
               PersistException,
               GatewayException,
               ServiceException;
	
    /**
     * Initiate a continuous tracking session for the indicated asset.
     * 
     * @param token
     * @param assetId - the id of the asset for which the we'd like to track.
     * @param start - the start time for the tracking session.
     * @throws OperationException.AlreadyAtMaximum if the asset already has an
     *         ongoing continuous tracking session.
     * @throws AuthorizationException if the admin is not authorized to start
     *         a continuous tracking session for the asset.
     * @throws PersistException
     * @throws GatewayException
     * @throws ServiceException
     */
    public void startTrackingAsset(TAuthToken token, long assetId, Date start)
          throws OperationException.AlreadyAtMaximum,
                 AuthorizationException, 
                 PersistException, 
                 GatewayException,
                 ServiceException;
    
    public void stopContinuousTracking( TAuthToken token,
                                        long assetId )
        throws AuthorizationException,
               PersistException,
               GatewayException,
               ServiceException;
    
    public TContTrackingSession queryContinuousTrackingSession( TAuthToken token,
                                                                long assetId )
        throws AuthorizationException,
               PersistException,
               GatewayException,
               ServiceException;
}
