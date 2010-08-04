package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.dto.TAddress;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TBox;
import com.wavemarket.finder.core.v1.dto.TLandmark;
import com.wavemarket.finder.core.v1.dto.TLongLat;

import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 5:51:36 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface LandmarkService {


   public TLandmark addLandmark(TAuthToken token, TLongLat location,
                                TAddress address, String name)
           throws AuthorizationException,
                  GatewayException,
                  OperationException.Duplicate,
                  PersistException,
                  ServiceException;

   public List<TLandmark> getLandmarks(TAuthToken token)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TLandmark> getLandmarksForArea(TAuthToken token, TBox area)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TLandmark> getLandmarksInRadius(TAuthToken token, TLongLat center, double distanceInMeters)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void deleteLandmark(TAuthToken token, long landmarkId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;


   public TLandmark getLandmark(TAuthToken token, long landmarkId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException,
             OperationException.NotFound;
   
   public TLandmark getLandmark(TAuthToken token, String landmarkName)
   throws AuthorizationException,
          PersistException,
          GatewayException,
          ServiceException;

   public void updateLandmark(TAuthToken token, TLandmark landmark)
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException,
                OperationException.DuplicateName;

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
