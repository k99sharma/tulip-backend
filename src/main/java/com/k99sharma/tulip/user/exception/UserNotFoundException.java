package com.k99sharma.tulip.user.exception;

/**
 * Thrown to indicate that user is not found.
 */
public class UserNotFoundException extends RuntimeException{
    /**
     * Constructs a new validation exception with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public UserNotFoundException(String message){
        super(message);
    }
}
