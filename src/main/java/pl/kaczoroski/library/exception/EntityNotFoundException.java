package pl.kaczoroski.library.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(ExceptionType type, String value) {
        super(String.format(type.getMessage(), value));
    }

    public EntityNotFoundException(ExceptionType type) {
        super(type.getMessage());
    }

    public EntityNotFoundException(ExceptionType type, String value, String value2) {
        super(String.format(type.getMessage(), value, value2));
    }

}
