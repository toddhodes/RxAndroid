package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.GeoException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.result.GeocodeResult;
import com.wavemarket.finder.core.v1.dto.TAddress;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TBox;
import com.wavemarket.finder.core.v1.dto.TDrivingDirections;
import com.wavemarket.finder.core.v1.dto.TLongLat;
import com.wavemarket.finder.core.v1.dto.TPointOfInterest;

import java.util.List;
import java.util.Locale;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 1:01:49 PM
 * Copyright 2007 WaveMarket, Inc 
 */

public interface GeoService {

   public TDrivingDirections getDrivingDirections(TAuthToken token, TLongLat from, TLongLat to)
           throws AuthorizationException,
                  GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

   public TAddress reverseGeocode(TAuthToken token, TLongLat coord)
           throws AuthorizationException,
                  GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

   public List<GeocodeResult> geocode(TAuthToken token, TAddress address)
           throws AuthorizationException,
                  GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

   public List<String> getPointOfInterestCategories()
           throws GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

   public List<TPointOfInterest> getPointsOfInterest(TAuthToken token, TBox box, String category, Locale locale)
           throws AuthorizationException,
                  GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

   public List<TPointOfInterest> getAllPointsOfInterest(TAuthToken token, TBox box, Locale locale)
           throws AuthorizationException,
                  GatewayException,
                  GeoException,
                  PersistException,
                  ServiceException;

  public TLongLat getCoordForZipcode(String zipcode)
          throws GatewayException, OperationException.NotFound, PersistException, ServiceException;
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/