package org.grostarin.springboot.demorest.exceptions;

public class BookBannedNotFoundException extends RuntimeException {

    public BookBannedNotFoundException() {
        super();
    }

    public BookBannedNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookBannedNotFoundException(final String message) {
        super(message);
    }

    public BookBannedNotFoundException(final Throwable cause) {
        super(cause);
    }
}