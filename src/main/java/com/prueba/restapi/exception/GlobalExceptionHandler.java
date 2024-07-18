package com.prueba.restapi.exception;

import com.prueba.restapi.dto.ResponseDTO;
import com.prueba.restapi.dto.StatusDTO;
import com.prueba.restapi.util.Constantes;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            StatusDTO statusDTO = new StatusDTO();
            statusDTO.setStatusCode(String.valueOf(HttpStatus.BAD_REQUEST));
            statusDTO.setStatusDescription(violation.getMessage());
            errors.put("status", statusDTO);
        }
        return ResponseEntity.badRequest().body(errors);
    }

}
