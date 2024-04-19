package com.tobeto.miniproject.core.utils.exceptionhandling.types;

public class BusinessException extends RuntimeException
{
    public BusinessException(String message) {
        super(message);
    }
}
