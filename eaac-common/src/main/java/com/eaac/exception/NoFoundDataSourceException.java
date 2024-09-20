package com.eaac.exception;

/**
 * The type No found data source exception.
 */
public class NoFoundDataSourceException extends EcBaseException{
    private String type;

    /**
     * Instantiates a new No found data source exception.
     *
     * @param type the type
     */
    public NoFoundDataSourceException(String type) {
        this.type = type;
    }

    /**
     * Instantiates a new No found data source exception.
     *
     * @param message the message
     * @param type    the type
     */
    public NoFoundDataSourceException(String message, String type) {
        super(message);
        this.type = type;
    }

    /**
     * Instantiates a new No found data source exception.
     *
     * @param message the message
     * @param cause   the cause
     * @param type    the type
     */
    public NoFoundDataSourceException(String message, Throwable cause, String type) {
        super(message, cause);
        this.type = type;
    }

    /**
     * Instantiates a new No found data source exception.
     *
     * @param cause the cause
     * @param type  the type
     */
    public NoFoundDataSourceException(Throwable cause, String type) {
        super(cause);
        this.type = type;
    }

    /**
     * Instantiates a new No found data source exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     * @param type               the type
     */
    public NoFoundDataSourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String type) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
    }

    @Override
    public String toString() {
        return "NoFoundDataSourceException{" +
                "type='" + type + '\'' +
                '}';
    }
}
