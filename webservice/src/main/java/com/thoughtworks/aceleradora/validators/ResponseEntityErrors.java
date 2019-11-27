package com.thoughtworks.aceleradora.validators;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ResponseEntityErrors {
    private List<ObjectError> errors;

    public ResponseEntityErrors(List<ObjectError> errors) {
        this.errors = errors;
    }

    public ResponseEntity build(){
        return ResponseEntity.badRequest().body(this.errors);
    }
}
