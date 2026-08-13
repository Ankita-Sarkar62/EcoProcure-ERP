package com.ecoprocure.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String mesg){
        super(mesg);
    }
    
}
