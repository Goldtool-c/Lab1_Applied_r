public class MethodException extends Exception
{
    public MethodException() {
    }

    public MethodException(String message) {
        super(message);
    }

    public MethodException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodException(Throwable cause) {
        super(cause);
    }

    public MethodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
