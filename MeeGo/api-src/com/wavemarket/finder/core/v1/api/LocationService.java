package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.job.TLocateJob;
import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 5:06:02 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface LocationService {

   public TLocateJob requestLocation(TAuthToken authToken, long assetId)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                ServiceException;

   public TLocateJob checkLocationRequestStatus(TAuthToken authToken, byte[] jobId)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                ServiceException;

   
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/