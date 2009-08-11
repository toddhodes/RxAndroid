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
package org.tweetmycity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** store user data to the filesystem
 */
public class UserStore {

   private static final Log logger = LogFactory.getLog(UserStore.class);

   /**
    * Default directory (/tmp)
    */
   public static final String DEFAULT_DIRECTORY = "/tmp/tmcusers";

   /**
    * Default file base (users)
    */
   public static final String DEFAULT_FILE_BASE = "tmcuser";

   /**
    * Directory to store users.
    */
   protected final String directory;

   /**
    * File base to store users.
    */
   protected final String fileBase;

   /**
    * Create a new file token store using default values.
    */
   public UserStore() {
      this(DEFAULT_FILE_BASE);
   }

   /**
    * Create a new file token store using custom fileBase.
    * @param fileBase the file base for storing tokens
    */
   public UserStore(String fileBase) {
      this(fileBase,DEFAULT_DIRECTORY);
   }

   /**
    * Create a new file token store using custom fileBase and directory.
    * @param fileBase the file base for storing tokens
    * @param directory the directory for storing tokens
    */
   public UserStore(String fileBase, 
                    String directory) {
      this.fileBase = fileBase;
      this.directory = directory;
   }
   
   /**
    * Get a user by userId.
    */
   public synchronized TmcUser get(long userId) {

      try {
         File file = getFile(userId + ".tid");
         FileInputStream fis = new FileInputStream(file);
         logger.debug("Reading info from file: " + file.getPath());
         
         StringBuilder tId = new StringBuilder();
         int c;
         while ((c = fis.read()) != -1) {
            if (c == '\n') {
               break;
            }
            tId.append((char)c);
         }
         

         file = getFile(userId + ".tpass");
         fis = new FileInputStream(file);
         logger.debug("Reading info from file: " + file.getPath());

         StringBuilder tPass = new StringBuilder();
         while ((c = fis.read()) != -1) {
            if (c == '\n') {
               break;
            }
            tPass.append((char)c);
         }

         file = getFile(userId + ".dev");
         fis = new FileInputStream(file);
         logger.debug("Reading info from file: " + file.getPath());

         StringBuilder dev = new StringBuilder();
         while ((c = fis.read()) != -1) {
            if (c == '\n') {
               break;
            }
            dev.append((char)c);
         }


         logger.debug("twitterId was: " + tId.toString());
         logger.debug("twitterPass was: " + tPass.toString());
         logger.debug("deviceDesc: " + dev.toString());

         return new TmcUser(userId,
                            tId.toString(),
                            tPass.toString(),
                            dev.toString());
      } catch (FileNotFoundException e) {
         logger.debug(e);

         return null;
      } catch (IOException e) {
         logger.warn(e);

         return null;
      }
   }

   /**
    * Add a user to this store.
    */
   public synchronized void add(TmcUser tmcUser) {

      try {
         File file = getFile(tmcUser.getUserId() + ".tid");
         FileOutputStream fos = new FileOutputStream(file);
         logger.debug("Writing tid to file: " + file.getPath());
         fos.write(tmcUser.getTwitterId().getBytes());
         fos.close();

         file = getFile(tmcUser.getUserId() + ".tpass");
         fos = new FileOutputStream(file);
         logger.debug("Writing tpass to file: " + file.getPath());
         fos.write(tmcUser.getTwitterPass().getBytes());
         fos.close();

         file = getFile(tmcUser.getUserId() + ".dev");
         fos = new FileOutputStream(file);
         logger.debug("Writing tpass to file: " + file.getPath());
         fos.write(tmcUser.getDeviceDescription().getBytes());
         fos.close();

      } catch (IOException e) {
         logger.warn(e);
      }
   }

   /**
    * Remove a user from this store.
    */
   public synchronized void remove(TmcUser tmcUser) {

      File file = getFile(tmcUser.getUserId() + ".tid");
      if (file.exists()) {
         file.delete();
      }

      file = getFile(tmcUser.getUserId() + ".tpass");
      if (file.exists()) {
         file.delete();
      }

      file = getFile(tmcUser.getUserId() + ".dev");
      if (file.exists()) {
         file.delete();
      }
   }

   /**
    * Get the File for this tmc.
    */
   protected File getFile(String tmc) {
      File dir = new File(directory);
      dir.mkdirs();

      return new File(directory + 
                      File.separatorChar +
                      fileBase +
                      "." +
                      tmc);
   }
}

/*
** Local Variables:
**   c-basic-offset: 3
**   tab-width: 3
**   indent-tabs-mode: nil
** End:
**
** ex: set softtabstop=3 tabstop=3 expandtab cindent shiftwidth=3
*/


