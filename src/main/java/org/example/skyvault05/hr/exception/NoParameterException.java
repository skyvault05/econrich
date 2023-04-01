package org.example.skyvault05.hr.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoParameterException extends RuntimeException{
    public NoParameterException(String message) {
        super(message);
    }
}
