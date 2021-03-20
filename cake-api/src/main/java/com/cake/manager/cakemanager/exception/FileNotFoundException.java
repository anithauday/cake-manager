package com.cake.manager.cakemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus ( HttpStatus.NOT_FOUND )
public class FileNotFoundException extends RuntimeException
{
    public FileNotFoundException( String message , Throwable cause )
    {
        super( message , cause );
    }
}
