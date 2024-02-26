package com.vehicle_department.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VINAlreadyExistsException extends RuntimeException {
    private String message;
    private String fieldName;
    private String fieldValue;

    public VINAlreadyExistsException(String fieldName, String fieldValue) {
        super(String.format("%s already exists for %s, VIN must be unique.", fieldName, fieldValue));
        log.info("====>>>> VINAlreadyExistsException() execution.");
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
