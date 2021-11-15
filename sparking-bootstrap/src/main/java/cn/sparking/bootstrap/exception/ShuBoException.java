package cn.sparking.bootstrap.exception;

public class ShuBoException extends RuntimeException {
    private static final long serialVersionUID = 8068509879445395353L;

    /**
     * Instantiates a new Spk exception.
     * @param throwable the throwable
     */
    public ShuBoException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * Instantiates a new Spk exception.
     * @param message the message
     */
    public ShuBoException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Spk exception.
     * @param message the message
     * @param throwable the throwable
     */
    public ShuBoException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}
