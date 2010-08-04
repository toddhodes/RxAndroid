package com.wavemarket.finder.core.v1.dto.job;

/*
** Local Variables:
**   mode: java
**   c-basic-offset: 2
**   indent-tabs-mode: nil
** End:
*/

public class TAsyncJob implements java.io.Serializable {
  private byte[] jobId;
  private boolean completed;
  private boolean success;

  /**
   * @deprecated for Hessian DON'T USE
   */
  public TAsyncJob() {
    // auto-generated
  }

  protected TAsyncJob(byte[] jobId, boolean completed, boolean success) {
    this.jobId = jobId;
    this.completed = completed;
    this.success = success;
  }

  public byte[] getJobId() {
    return jobId;
  }

  public boolean isCompleted() {
    return completed;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setJobId(byte[] jobId) {
     this.jobId = jobId;
  }

  public void setCompleted(boolean completed) {
     this.completed = completed;
  }

  public void setSuccess(boolean success) {
     this.success = success;
  }
}