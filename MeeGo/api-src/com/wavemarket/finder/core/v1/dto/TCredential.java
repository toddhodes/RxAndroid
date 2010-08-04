package com.wavemarket.finder.core.v1.dto;

import javax.xml.bind.annotation.XmlSeeAlso;

import com.wavemarket.finder.core.v1.dto.signup.TAuthTokenSignUpCredential;
import com.wavemarket.finder.core.v1.dto.signup.TCarrierSuppliedSignUpCredential;
import com.wavemarket.finder.core.v1.dto.signup.TDebugSignUpCredential;
import com.wavemarket.finder.core.v1.dto.signup.TDemoSignUpCredential;
import com.wavemarket.finder.core.v1.dto.signup.TTempPasswordSignUpCredential;

@XmlSeeAlso({TCarrierSuppliedSignUpCredential.class, TAuthTokenSignUpCredential.class, TDemoSignUpCredential.class, TDebugSignUpCredential.class, TTempPasswordSignUpCredential.class, TEmailPasswordAuthCredential.class, TNamePasswordAuthCredential.class, TPhoneNumberPasswordAuthCredential.class, TIdentityTokenCredential.class, TSuperuserAuthCredential.class})
public interface TCredential {
   
   /**
    * A piece of information identifying the credential.
    * e.g.: phone number, token, username, account number
    * @return a means of identifying the credential.
    */
   public TDescriptor getDescriptor();
   
   /**
    * Returns the provided password as a string.
    * @return null if the credential doesn't have a password
    */
   public String getPassword();
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

