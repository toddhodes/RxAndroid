/* Copyright 2008-2009 WaveMarket, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.veriplace.web.servlet.tags;

import com.veriplace.client.User;
import com.veriplace.web.VeriplaceState;

public class RequireUserTag extends AbstractRequireTag {

   @Override
   protected VeriplaceState getVeriplaceState() throws Exception {
      VeriplaceState state = super.getVeriplaceState();
      state.setRequiresUser(true);
      state.setUserInteractionAllowed(interactive);
      return state;
   }
   
   protected Object getResultObject() {
      return veriplaceState.getUser();
   }

   public static class ExtraInfo extends AbstractRequireTag.ExtraInfo {
      
      protected Class getObjectClass() {
         return User.class;
      }
   }
}
