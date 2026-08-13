package com.ecoprocure.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
        //ErrorResponse contaions the error details...ResponeEntity sends the information along with status(400,404) etc
        public ResponseEntity<ErrorResponse> handleResoursenotFound(ResourceNotFoundException ex){
            ErrorResponse error=new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Resource Not Found", ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); 
    }

    @ExceptionHandler(BadRequestException.class)
        //ErrorResponse contaions the error details...ResponeEntity sends the information along with status(400,404) etc
        public ResponseEntity<ErrorResponse> handleBadRequest(BadRequestException  ex){
            ErrorResponse error=new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request", ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
    }           //value() because we need integer

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex){
        ErrorResponse error=new ErrorResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationError(MethodArgumentNotValidException ex ){
        String message= ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField()+ ": "+error.getDefaultMessage()).collect(Collectors.joining(", "));


        ErrorResponse errorR=new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation error", message);
        return new ResponseEntity<>(errorR,HttpStatus.BAD_REQUEST);
    }
}
