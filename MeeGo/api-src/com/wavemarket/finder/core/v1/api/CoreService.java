package com.wavemarket.finder.core.v1.api;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 8, 2008
 * Created-Time: 11:48:11 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface CoreService {

   public AccountService getAccountService();
   public AdminToolService getAdminToolService();
   public AlertService getAlertService();
   public AuthService getAuthService();
   public GeoService getGeoService();
   public HistoryService getHistoryService();
   public ImageService getImageService();
   public LandmarkService getLandmarkService();
   public LocationService getLocationService();
   public PermissionsService getPermissionsService();
   public MetaService getMetaService();
   public SignUpService getSignUpService();
   public SurveyService getSurveyService();
   public StatsService getStatsService();
   public PaymentService getPaymentService();
   public ContTrackingService getContTrackingService();
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/
