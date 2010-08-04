package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TImageInfo;
import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;

import java.util.List;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 9, 2008
 * Created-Time: 10:57:27 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface ImageService {

   public List<TImageInfo> getStockImageInfo()
         throws AuthorizationException,
                GatewayException,
                PersistException,
                ServiceException;

   /**
    *
    * @param imageId the id of the stock image to fetch
    * @param width the width of the image to return, or -1 to return the image as is.
    * @param height the height of the image to return, or -1 to return the image as is.
    * @return the image data
    * @throws OperationException.NoDataFound if the specified stock image could not be found.
    * @throws PersistException -
    * @throws GatewayException -
    * @throws ServiceException -
    */
   public byte[] getStockImageData(int imageId, int width, int height)
         throws OperationException.NoDataFound,
                PersistException,
                GatewayException,
                ServiceException;

   /**
    *
    * @param token -
    * @param assetId -
    * @param imageId -
    * @throws AuthorizationException -
    * @throws GatewayException -
    * @throws OperationException.NotFound if the specified asset could not be found
    * @throws OperationException.NoDataFound if the specified stock image could not be found.
    * @throws PersistException -
    * @throws ServiceException -
    */
   public void chooseStockImage(TAuthToken token, long assetId, int imageId)
         throws AuthorizationException,
                GatewayException,
                OperationException.NotFound,
                OperationException.NoDataFound,
                PersistException,
                ServiceException;

   public void uploadCustomImageToTemp(TAuthToken token, long assetId, byte[] data)
         throws AuthorizationException,
                GatewayException,
                OperationException.NotFound,
                OperationException.UnsupportedImageFormat,
                PersistException,
                ServiceException;

   /**
    *
    * @param token -
    * @param assetId -
    * @param width the width of the image to return, or -1 to return the image as is.
    * @param height the height of the image to return, or -1 to return the image as is.
    * @return the image data
    * @throws AuthorizationException -
    * @throws GatewayException -
    * @throws OperationException.NotFound if the specified asset could not be found
    * @throws OperationException.NoDataFound if the image data for that asset
    *    could not be found or is invalid
    * @throws PersistException -
    * @throws ServiceException -
    */
   public byte[] getAssetImageData(TAuthToken token, long assetId, int width, int height)
         throws AuthorizationException,
                GatewayException,
                OperationException.NotFound,
                OperationException.NoDataFound,
                PersistException, ServiceException;

   /**
    *
    * @param token -
    * @param assetId -
    * @param width the width of the image to return, or -1 to return the image as is.
    * @param height the height of the image to return, or -1 to return the image as is.
    * @return image data, or null if the asset has no temp image.
    * @throws AuthorizationException -
    * @throws GatewayException -
    * @throws OperationException.NotFound if the specified asset could not be found
    * @throws PersistException -
    * @throws ServiceException-
    */
   public byte[] getAssetTempImageData(TAuthToken token, long assetId, int width, int height)
         throws AuthorizationException,
                GatewayException,
                OperationException.NotFound,
                PersistException, ServiceException;

   public void promoteTempImageData(TAuthToken token, long assetId)
           throws AuthorizationException,
                  GatewayException,
                  OperationException.NotFound,
                  OperationException.NoDataFound,
                  PersistException, ServiceException;

}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/
