package com.wavemarket.finder.core.v1.dto.signup;

import com.wavemarket.finder.core.v1.dto.TAddress;

import java.util.Date;

/**
 * @author oliver
 */

/*
 * Created-Date: Jun 17, 2008
 * Created-Time: 4:20:48 PM
 * Copyright 2007 WaveMarket, Inc 
 */
public class TDemoAccountRequest implements java.io.Serializable {

   private String applicantName;
   private String applicantEmail;
   private String applicantPhone;
   private String supervisorName;
   private String supervisorEmail;
   private String supervisorPhone;
   private String storeName;
   private String storeId;
   private TAddress storeAddress;
   private Date dateRequested;
   private Date expiryDate;
   private TDemoAccountState state;
   private long tiedDevice_id;
   private Date dateTiedToDevice;

   public TDemoAccountRequest() {
      // auto-generated
   }
   
   public TDemoAccountRequest(String applicantName, String applicantEmail,
                              String applicantPhone, String supervisorName,
                              String supervisorEmail, String supervisorPhone,
                              String storeName, String storeId,
                              TAddress storeAddress,
                              Date dateRequested, Date expiryDate,
                              TDemoAccountState state, long tiedDevice_id,
                              Date dateTiedToDevice) {
      this.applicantName = applicantName;
      this.applicantEmail = applicantEmail;
      this.applicantPhone = applicantPhone;
      this.supervisorName = supervisorName;
      this.supervisorEmail = supervisorEmail;
      this.supervisorPhone = supervisorPhone;
      this.storeName = storeName;
      this.storeId = storeId;
      this.storeAddress = storeAddress;
      this.dateRequested = dateRequested;
      this.expiryDate = expiryDate;
      this.state = state;
      this.tiedDevice_id = tiedDevice_id;
      this.dateTiedToDevice = dateTiedToDevice;
      
   }

   public String getApplicantName() {
      return applicantName;
   }

   public void setApplicantName(String applicantName) {
      this.applicantName = applicantName;
   }

   public String getApplicantEmail() {
      return applicantEmail;
   }

   public void setApplicantEmail(String applicantEmail) {
      this.applicantEmail = applicantEmail;
   }

   public String getApplicantPhone() {
      return applicantPhone;
   }

   public void setApplicantPhone(String applicantPhone) {
      this.applicantPhone = applicantPhone;
   }

   public String getSupervisorName() {
      return supervisorName;
   }

   public void setSupervisorName(String supervisorName) {
      this.supervisorName = supervisorName;
   }

   public String getSupervisorEmail() {
      return supervisorEmail;
   }

   public void setSupervisorEmail(String supervisorEmail) {
      this.supervisorEmail = supervisorEmail;
   }

   public String getSupervisorPhone() {
      return supervisorPhone;
   }

   public void setSupervisorPhone(String supervisorPhone) {
      this.supervisorPhone = supervisorPhone;
   }

   public String getStoreName() {
      return storeName;
   }

   public void setStoreName(String storeName) {
      this.storeName = storeName;
   }

   public String getStoreId() {
      return storeId;
   }

   public void setStoreId(String storeId) {
      this.storeId = storeId;
   }

   public TAddress getStoreAddress() {
      return storeAddress;
   }

   public void setStoreAddress(TAddress storeAddress) {
      this.storeAddress = storeAddress;
   }

   public Date getDateRequested() {
      return dateRequested;
   }

   public void setDateRequested(Date dateRequested) {
      this.dateRequested = dateRequested;
   }

   public Date getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(Date expiryDate) {
      this.expiryDate = expiryDate;
   }
   
   public TDemoAccountState getState() {
      return state;
   }

   public void setState(TDemoAccountState state) {
      this.state = state;
   }

   public long getTiedDevice_id() {
      return tiedDevice_id;
   }

   public void setTiedDevice_id(long tiedDevice_id) {
      this.tiedDevice_id = tiedDevice_id;
   }

   public Date getDateTiedToDevice() {
      return dateTiedToDevice;
   }

   public void setDateTiedToDevice(Date dateTiedToDevice) {
      this.dateTiedToDevice = dateTiedToDevice;
   }
}

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 3
**   indent-tabs-mode: nil
** End:
*/

