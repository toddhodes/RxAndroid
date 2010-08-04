package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.OperationException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.TWeekday;
import com.wavemarket.finder.core.v1.dto.TAlertDirection;
import com.wavemarket.finder.core.v1.dto.alert.TButtonPressAlert;
import com.wavemarket.finder.core.v1.dto.alert.TRegionChangeAlert;
import com.wavemarket.finder.core.v1.dto.alert.TScheduleCheck;

import java.util.List;
import java.util.Set;

/**
 * @author oliver
 */

/*
 * Created-Date: Apr 9, 2008
 * Created-Time: 11:43:54 AM
 * Copyright 2007 WaveMarket, Inc 
 */
public interface AlertService {


   public TScheduleCheck addScheduleCheck(TAuthToken token,
                                          long assetId, long landmarkId,
                                          Set<TWeekday> daysToFire, int timeToFire,
                                          boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                                          boolean notifyThirdPartyViaEmail, String thirdPartyEmail,
                                          TAlertDirection direction)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                OperationException.AlreadyAtMaximum,
                ServiceException;

   public void deleteScheduleCheck(TAuthToken token, long scheduleCheckId)
         throws AuthorizationException,
                OperationException.NotFound,
                PersistException,
                GatewayException,
                ServiceException;

   public List<TScheduleCheck> getScheduleChecks(TAuthToken token)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TScheduleCheck> getScheduleChecks(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TScheduleCheck> getScheduleChecksForLandmark(TAuthToken token, long landmarkId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public TScheduleCheck getScheduleCheck(TAuthToken token, long scheduleCheckId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void updateScheduleCheck(TAuthToken token, TScheduleCheck scheduleCheck)
        throws AuthorizationException,
               OperationException.NotFound,
               OperationException.Duplicate,
               GatewayException,
               PersistException,
               ServiceException;

   /**
    *
    * @param token current auth token
    * @param assetId ID of asset that schedule check would be added to
    * @return true if the currently logged in admin can add a schedule check to
    *   the specified asset, false otherwise. Reasons for not being able to add
    *   a schedule check include:
    *   <ul>
    *     <li>the user is not allowed to locate the asset</li>
    *     <li>the user or asset already has its maximum number of schedule
    *         checks, or of alerts in general</li>
    *     <li>this user is unauthorized to add schedule checks</li>
    *     <li>this deployment doesn't support schedule checks</li>
    *   </ul>
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws GatewayException -
    * @throws ServiceException -
    */
   public boolean canAddScheduleCheck(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;


   /**
    * Creates a region chage alert.
    * @param token a sign-in token for an admin.
    * @param assetId the asset to which the new alert should be associated
    * @param landmarkId the landmark to which the new alert should be associated
    * @param radius the radius of the alert, in meters
    * @param direction the direction of the alert
    * @param notifyParentViaEmail -
    * @param notifyParentViaSMS -
    * @param notifyThirdPartyViaEmail -
    * @param thirdPartyEmail - third party to notify, null if none. Must not be null if
    * notifyThirdPartyViaEmail is set.
    * @return the newly created alerts
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws GatewayException -
    * @throws OperationException.AlreadyAtMaximum -
    * @throws OperationException.NotFound if the asset with the specified ID could not be found
    * @throws OperationException.NoDataFound <ul>
    * <li>with paramName "landmark" if the landmark specified could not be found</li>
    * </ul>
    * @throws OperationException.UnsupportedParameterValue <ul>
    * <li> with paramName "direction" if the specified direction is unsupported for this alert type.</li>
    * </ul>
    * @throws ServiceException -
    */
   @Deprecated
   public TRegionChangeAlert addRegionChangeAlert(TAuthToken token,
                                                  long assetId, long landmarkId,
                                                  int radius,
                                                  TAlertDirection direction,
                                                  boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                                                  boolean notifyThirdPartyViaEmail, String thirdPartyEmail)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                OperationException.AlreadyAtMaximum,
                OperationException.NotFound,
                OperationException.NoDataFound,
                OperationException.UnsupportedParameterValue,
                ServiceException;

   public TRegionChangeAlert addRegionChangeAlert(TAuthToken token,
		                                          long assetId, long landmarkId,
		                                          int radius,
		                                          TAlertDirection direction,
		                                          Set<TWeekday> daysToFire, int startSec, int endSec,
		                                          boolean notifyParentViaEmail, boolean notifyParentViaSMS,
		                                          boolean notifyThirdPartyViaEmail, String thirdPartyEmail)
   		throws AuthorizationException,
   		       PersistException,
   		       GatewayException,
   		       OperationException.AlreadyAtMaximum,
   		       OperationException.NotFound,
   		       OperationException.NoDataFound,
   		       OperationException.UnsupportedParameterValue,
   		       ServiceException;

   public void deleteRegionChangeAlert(TAuthToken token, long regionChangeAlertId)
         throws AuthorizationException,
                OperationException.NotFound,
                PersistException,
                GatewayException,
                ServiceException;

   public List<TRegionChangeAlert> getRegionChangeAlerts(TAuthToken token)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TRegionChangeAlert> getRegionChangeAlerts(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TRegionChangeAlert> getRegionChangeAlertsForLandmark(TAuthToken token, long landmarkId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public TRegionChangeAlert getRegionChangeAlert(TAuthToken token, long alertId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void updateRegionChangeAlert(TAuthToken token, TRegionChangeAlert alert)
        throws AuthorizationException,
               OperationException.NotFound,
               OperationException.Duplicate,
               GatewayException,
               PersistException, ServiceException;

   /**
    *
    * @param token current auth token
    * @param assetId ID of asset that schedule check would be added to
    * @return true if the currently logged in admin can add a schedule check to the specified asset,
    *   false otherwise. Reasons for not being able to add a schedule check include:
    *   <ul>
    *     <li>the user is not allowed to locate the asset</li>
    *     <li>the user or asset already has its maximum number of region change alerts, or of alerts in general</li>
    *     <li>this user is unauthorized to add region change alerts</li>
    *     <li>this deployment doesn't support region change alerts</li>
    *   </ul>
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws GatewayException -
    * @throws ServiceException -
    */
   public boolean canAddRegionChangeAlert(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;


   /**
    * Creates a button press alert.
    * @param token a sign-in token for an admin.
    * @param assetId the asset to which the new alert should be associated
    * @param notifyParentViaEmail -
    * @param notifyParentViaSMS -
    * @param notifyThirdPartyViaEmail -
    * @param thirdPartyEmail - third party to notify, null if none. Must not be null if
    * notifyThirdPartyViaEmail is set.
    * @return the newly created alerts
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws GatewayException -
    * @throws OperationException.AlreadyAtMaximum -
    * @throws OperationException.NotFound if the asset with the specified ID could not be found
    * @throws ServiceException -
    */
   public TButtonPressAlert addButtonPressAlert(TAuthToken token,
                                                  long assetId,
                                                  boolean notifyParentViaEmail, boolean notifyParentViaSMS,
                                                  boolean notifyThirdPartyViaEmail, String thirdPartyEmail)
         throws AuthorizationException,
                PersistException,
                GatewayException,
                OperationException.AlreadyAtMaximum,
                OperationException.NotFound,
                OperationException.NoDataFound,
                OperationException.UnsupportedParameterValue,
                ServiceException;

   public void deleteButtonPressAlert(TAuthToken token, long alertId)
         throws AuthorizationException,
                OperationException.NotFound,
                PersistException,
                GatewayException,
                ServiceException;

   public List<TButtonPressAlert> getButtonPressAlerts(TAuthToken token)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public List<TButtonPressAlert> getButtonPressAlerts(TAuthToken token, long assetId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public TButtonPressAlert getButtonPressAlert(TAuthToken token, long alertId)
      throws AuthorizationException,
             PersistException,
             GatewayException,
             ServiceException;

   public void updateButtonPressAlert(TAuthToken token, TButtonPressAlert alert)
        throws AuthorizationException,
               OperationException.NotFound,
               OperationException.Duplicate,
               GatewayException,
               PersistException, ServiceException;

   /**
    *
    * @param token current auth token
    * @param assetId ID of asset that button press alert would be added to
    * @return true if the currently logged in admin can add a button press alert to the specified asset,
    *   false otherwise. Reasons for not being able to add a button press alert include:
    *   <ul>
    *     <li>the user is not allowed to locate the asset</li>
    *     <li>the user or asset already has its maximum number of button press alerts, or of alerts in general</li>
    *     <li>this user is unauthorized to add button press alerts</li>
    *     <li>this deployment doesn't support button press alerts</li>
    *   </ul>
    * @throws AuthorizationException -
    * @throws PersistException -
    * @throws GatewayException -
    * @throws ServiceException -
    */
   public boolean canAddButtonPressAlert(TAuthToken token, long assetId)
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
