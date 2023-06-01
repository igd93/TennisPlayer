package io.datajek.spring.dbmanytomany;

public class CustomNotFoundException extends RuntimeException{

    public CustomNotFoundException() {
        super();
    }

    public CustomNotFoundException(String message, Throwable cause, boolean enableSupression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSupression, writableStackTrace);
    }

    public CustomNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(Throwable cause) {
        super(cause);
    }
}
