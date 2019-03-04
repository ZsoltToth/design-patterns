package hu.uni.miskolc.iit.design.patterns;

public class TypeMismatchException extends Exception {

    public TypeMismatchException() {
    }

    public TypeMismatchException(String message) {
        super(message);
    }

    public TypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeMismatchException(Throwable cause) {
        super(cause);
    }

    public TypeMismatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
