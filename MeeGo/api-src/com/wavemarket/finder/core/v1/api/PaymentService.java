package com.wavemarket.finder.core.v1.api;

import com.wavemarket.finder.core.v1.api.exception.AuthorizationException;
import com.wavemarket.finder.core.v1.api.exception.GatewayException;
import com.wavemarket.finder.core.v1.api.exception.PersistException;
import com.wavemarket.finder.core.v1.api.exception.ServiceException;
import com.wavemarket.finder.core.v1.dto.TAuthToken;
import com.wavemarket.finder.core.v1.dto.payment.TCreditCard;

public interface PaymentService {

	public void addCreditCard(TAuthToken token, TCreditCard creditCard) throws AuthorizationException,
			PersistException, GatewayException, ServiceException;

	public TCreditCard getPrimaryCreditCard(TAuthToken token) throws AuthorizationException, PersistException,
			GatewayException, ServiceException;
}

/*
 * Local Variables: mode: java c-basic-offset: 3 tab-width: 3 indent-tabs-mode:
 * nil End:
 * 
 * ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
 */
