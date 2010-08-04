package com.wavemarket.finder.core.v1.dto.location;

/**
 * @author oliver
 */

/*
 * Created-Date: May 23, 2008
 * Created-Time: 12:12:25 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public enum TLocationErrorCode implements java.io.Serializable {

   // The polling server attempted to locate the device and returned its own error code.
   POLLING_SERVER_ERROR,

   // The polling server is unavailable right now.
   SERVICE_UNAVAILABLE,

   // There was an error in decoding the response from the polling server.
   PROTOCOL_ERROR,

   // There were so many pending requests the request was never made.
   SERVICE_OVERLOADED,

   // the request timed out
   TIMEOUT,

   // catch-all for all other errors
   OTHER_ERROR;

   // might want to add ACCURACY_TOO_LOW at some stage; right now the Core doesn't check that.

   // also, if we start using Veriplace to tell us when we can locate someone, we'll need a
   // code in here to represent that.  
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/
