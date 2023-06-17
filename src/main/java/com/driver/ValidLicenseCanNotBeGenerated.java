package com.driver;

public class ValidLicenseCanNotBeGenerated extends RuntimeException{
    public ValidLicenseCanNotBeGenerated(String message)
    {
        super(message);
    }
}
