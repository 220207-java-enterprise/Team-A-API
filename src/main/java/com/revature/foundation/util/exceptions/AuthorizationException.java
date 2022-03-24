package com.revature.foundation.util.exceptions;

public class AuthorizationException extends RuntimeException {
    public AuthorizationException() {
        super("The requester does not have access to this endpoint.");
    }
}
