package com.wavemarket.finder.core.v1.api;

import java.util.List;

import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TInfoPage;
import com.wavemarket.finder.core.v1.dto.meta.TApiStatus;
import com.wavemarket.finder.core.v1.dto.signup.TClientType;

/**
 * @author oliver
 */

/*
 * Created-Date: May 1, 2008
 * Created-Time: 3:23:20 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface MetaService {

   public boolean doesForgotPasswordRequireCredential()
      throws ServiceException;

   public List<String> getAdminTypes()
      throws PersistException, ServiceException;

   public int getMaxNumberOfChildrenPerAccount()
      throws OperationException.InvalidState,
             ServiceException;
             
   public TApiStatus getApiStatus()
         throws ServiceException;

   public String getClientDownloadUrl(TClientType clientType)
         throws OperationException.NotFound, ServiceException;
   
   public String getInformationUrl(TInfoPage infoPage)
      throws OperationException.NotFound, ServiceException;
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3 ft=java :
*/