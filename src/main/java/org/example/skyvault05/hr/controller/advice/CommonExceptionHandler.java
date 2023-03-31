package org.example.skyvault05.hr.controller.advice;

import org.example.skyvault05.hr.exception.NoParameterException;
import org.example.skyvault05.hr.exception.NoResultException;
import org.example.skyvault05.hr.exception.dto.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.example.skyvault05.hr.controller")
public class CommonExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResult> exceptionHandle(NoParameterException e){
        ExceptionResult exceptionResult = new ExceptionResult("400", "잘못된 파라미터.");
        return new ResponseEntity<>(
                exceptionResult,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResult> exceptionHandle(NoResultException e){
        ExceptionResult exceptionResult = new ExceptionResult("200", "결과가 없습니다.");
        return new ResponseEntity<>(
                exceptionResult,
                HttpStatus.OK
        );
    }
}
