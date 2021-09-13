package com.livecron.util.lib.exception;

public class SongFileNotFoundException extends RuntimeException{

    public SongFileNotFoundException() {
        super();
    }

    public SongFileNotFoundException(String message) {
        super(message);
    }

    public SongFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SongFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SongFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
