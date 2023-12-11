package com.devsuperior.DSCommerce.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String text) {
        super(text);
    }
}
