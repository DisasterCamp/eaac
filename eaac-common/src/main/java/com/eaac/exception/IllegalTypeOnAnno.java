package com.eaac.exception;

/**
 * The type Illegal type on anno.
 */
public class IllegalTypeOnAnno extends EcBaseException{
    /**
     * Instantiates a new Illegal type on anno.
     */
    public IllegalTypeOnAnno() {
    }

    /**
     * Instantiates a new Illegal type on anno.
     *
     * @param message the message
     */
    public IllegalTypeOnAnno(String message) {
        super(message);
    }

    /**
     * Instantiates a new Illegal type on anno.
     *
     * @param message the message
     * @param cause   the cause
     */
    public IllegalTypeOnAnno(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Illegal type on anno.
     *
     * @param cause the cause
     */
    public IllegalTypeOnAnno(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new Illegal type on anno.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public IllegalTypeOnAnno(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
