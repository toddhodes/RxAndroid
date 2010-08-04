package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.location.TLocationEvent;

import java.util.Date;
import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 9, 2008
 * Created-Time: 2:46:55 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface HistoryService {

   public List<TLocationEvent> getLocationHistory(TAuthToken token, Date startDate,
                                                  Date EndDate, int maxRecords)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TLocationEvent> getLocationHistoryForAsset(TAuthToken token, long assetId,
                                                          Date startDate, Date EndDate,
                                                          int maxRecords)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TLocationEvent> getSuccessfulLocatesForAsset(TAuthToken token, long assetId,
                                                            Date startDate, Date EndDate,
                                                            int maxRecords)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void submitLocationEvent(TAuthToken token, TLocationEvent event)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             OperationException,
             ServiceException;

   /** returns the most recent locate
    *  returns null if there are no locates inside the history
    */
   public TLocationEvent getMostRecentLocate(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
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
