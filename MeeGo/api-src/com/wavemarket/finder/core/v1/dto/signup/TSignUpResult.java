package com.wavemarket.finder.core.v1.dto.signup;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.wavemarket.finder.core.v1.dto.TLoginInfo;
import com.wavemarket.finder.core.v1.dto.TOperationFailureDescription;

public class TSignUpResult implements Serializable {
   private Map<TAssetInfo, TOperationFailureDescription> failedAssets;
   private TLoginInfo loginInfo;

   public TSignUpResult() {
      // auto-generated
   }
    
  public TSignUpResult(Map<TAssetInfo, TOperationFailureDescription> failedAssets, TLoginInfo loginInfo) {
     this.failedAssets = failedAssets;
     this.loginInfo = loginInfo;
   }

   public TLoginInfo getLoginInfo() {
      return this.loginInfo;
   }

   public void setLoginInfo(TLoginInfo loginInfo) {
      this.loginInfo = loginInfo;
   }

   public Map<TAssetInfo, TOperationFailureDescription> getFailedAssets() {
      if(failedAssets == null) {
         failedAssets = new HashMap<TAssetInfo, TOperationFailureDescription>(0);
      }
      return failedAssets;
   }

   public void setFailedAssets(
         Map<TAssetInfo, TOperationFailureDescription> failedAssets) {
      this.failedAssets = failedAssets;
   }      
}