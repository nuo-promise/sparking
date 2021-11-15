package cn.sparking.bootstrap.exception;

/**
 * SerializerException.
 */
public class SerializerException extends RuntimeException {
    private static final long serialVersionUID = 8068509879445395353L;

    /**
     * Instantiates a new Serializer exception.
     * @param throwable the throwable
     */
    public SerializerException(final Throwable throwable) {
       super(throwable);
    }

    /**
     * Instantiates a new Serializer exception.
     * @param message the message
     */
    public SerializerException(final String message) {
       super(message);
    }

    /**
     * Instantiates a new Serializer exception.
     * @param message the message
     * @param throwable the throwable
     */
    public SerializerException(final String message, final Throwable throwable) {
       super(message, throwable);
    }
}

