package com.ecoprocure.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String mesg;

    public ErrorResponse(){

    }
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String mesg){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.mesg = mesg;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public String getMesg() {
        return mesg;
    }
    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
    

}
