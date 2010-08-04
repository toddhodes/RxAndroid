package com.wavemarket.finder.core.v1.api;

import java.util.Map;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;

public interface SurveyService {
  
  /**
   * Save the survey response
   * @param authToken authToken of the survey taker
   * @param surveyType string identifier for the survey taken
   * @param version version of the survey taken
   * @param answers responses given to the survey in the form of a map of
   *        question to answer pairings
   */
  public void storeSurveyResponse(TAuthToken authToken, 
                                  String surveyType,
                                  int version, 
                                  Map<String, String> answers)
    throws AuthorizationException,
           PersistException,
           GatewayException,
           ServiceException;
  
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 2
**   tab-width: 2
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=2 tabstop=2 expandtab cindent shiftwidth=2
*/
