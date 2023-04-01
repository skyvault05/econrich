package org.example.skyvault05.hr.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoResultException extends RuntimeException{
    public NoResultException(String message) {
        super(message);
    }
}
