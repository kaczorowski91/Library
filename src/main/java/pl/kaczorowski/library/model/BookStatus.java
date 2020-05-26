package pl.kaczorowski.library.model;

import pl.kaczorowski.library.exception.EntityNotFoundException;
import pl.kaczorowski.library.exception.ExceptionType;

import java.util.stream.Stream;

public enum BookStatus {
    AVAILABLE, BORROWED, LOST, DESTROYED;

    public static BookStatus getBookStatus(String bookStatus) {
        return Stream.of(BookStatus.valueOf(bookStatus))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_STATUS));
    }

}
