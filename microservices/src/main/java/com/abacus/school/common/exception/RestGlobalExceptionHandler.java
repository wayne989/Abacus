package com.abacus.school.common.exception;

import com.abacus.school.logging.TransactionLogger;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

/**
 * RestGlobalExceptionHandler
 * this class intended for restful service exception handling, which returns proper http status
 * and respond back the error message in json format
 */
@ControllerAdvice
@RestController
public class RestGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    Logger errorLogger = TransactionLogger.getErrorLogger();

    /**
     * this is to handle the particular NumberFormatException when it is thrown from
     * controller
     * @param ex
     * @param req
     * @return
     */
    @ExceptionHandler(NumberFormatException.class)
    public final ResponseEntity<HashMap> handleInvalidJSONFormatException(NumberFormatException ex, WebRequest req){
        HashMap<String, String> errorMap = new HashMap<String,String>();
        errorMap.put("Invalid numeric format", ex.getMessage());
        errorLogger.error("error=" + "Invalid JSON String: " + ex.getMessage());
        return new ResponseEntity<HashMap>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
