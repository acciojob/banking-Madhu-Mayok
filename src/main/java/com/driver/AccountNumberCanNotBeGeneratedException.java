package com.driver;

public class AccountNumberCanNotBeGeneratedException extends RuntimeException{
    public AccountNumberCanNotBeGeneratedException(String message)
    {
        super(message);
    }
}
