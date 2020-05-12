package pl.kaczoroski.library.exception;

public enum ExceptionType {
    BOOK_NOT_FOUND_ID("ERROR: Book with this ID not found in database."),
    BOOK_NOT_FOUND_AUTHOR("ERROR: Book with this Author not found in database."),
    BOOK_NOT_FOUND_TITTLE("ERROR: Book with this Tittle not found in database."),
    BOOK_NOT_FOUND_STATUS("ERROR: Book with this Status not found in database."),
    BOOK_NOT_FOUND("ERROR: This book not exist in library, please first add book"),
    RENTAL_NOT_FOUND("ERROR: We haven't rental with this ID"),
    COPY_OF_BOOK_NOT_FOUND_ID("ERROR: Copy of book with this id not exist in library"),
    COPY_OF_BOOK_NOT_FOUND_BOOK("ERROR: This copy of book not found in library "),
    COPY_OF_BOOK_NOT_FOUND_BOOK_AND_STATUS("ERROR: This copy of book with this status not found in library "),
    USER_NOT_FOUND_ID("ERROR: User with this ID not found in database."),
    USER_NOT_FOUND_NAME("ERROR: User with this name not found in database.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
