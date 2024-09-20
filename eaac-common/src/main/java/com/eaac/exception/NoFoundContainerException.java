package com.eaac.exception;

/**
 * The type No found container exception.
 */
public class NoFoundContainerException extends EcBaseException {
    private String type;

    /**
     * Instantiates a new No found container exception.
     *
     * @param type the type
     */
    public NoFoundContainerException(String type) {
        this.type = type;
    }

    /**
     * Instantiates a new No found container exception.
     *
     * @param message the message
     * @param type    the type
     */
    public NoFoundContainerException(String message, String type) {
        super(message);
        this.type = type;
    }

    /**
     * Instantiates a new No found container exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param type    the type
     */
    public NoFoundContainerException(String message, Throwable cause, String type) {
        super(message, cause);
        this.type = type;
    }

    /**
     * Instantiates a new No found container exception.
     *
     * @param cause the cause
     * @param type  the type
     */
    public NoFoundContainerException(Throwable cause, String type) {
        super(cause);
        this.type = type;
    }

    /**
     * Instantiates a new No found container exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     * @param type               the type
     */
    public NoFoundContainerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
    }

    @Override
    public String toString() {
        return "NoFoundContainerException{" +
                "type='" + type + '\'' +
                '}';
    }
}
