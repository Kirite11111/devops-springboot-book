package org.grostarin.springboot.demorest.exceptions;

public class BookBannedIdMismatchException extends RuntimeException {

    public BookBannedIdMismatchException() {
        super();
    }

    public BookBannedIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookBannedIdMismatchException(final String message) {
        super(message);
    }

    public BookBannedIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
