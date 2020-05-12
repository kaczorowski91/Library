package pl.kaczoroski.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kaczoroski.library.domain.BookDto;
import pl.kaczoroski.library.exception.EntityNotFoundException;
import pl.kaczoroski.library.exception.ExceptionType;
import pl.kaczoroski.library.mapper.BookMapper;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        return bookMapper.mapToBookDtoList(bookRepository.findAll());
    }

    public List<BookDto> getAllBooks(String author) {
        List<Book> books = bookRepository.findByAuthor(author)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_AUTHOR, author));
        return bookMapper.mapToBookDtoList(books);
    }

    public BookDto getBook(final Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_ID, id.toString()));
        return bookMapper.mapToBookDto(book);
    }


    public BookDto saveBook(BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        boolean isBookExist = bookRepository
                .existsBookByTitleAndAuthorAndDateOfPublish(book.getTitle(), book.getAuthor(), book.getDateOfPublish());

        if (!isBookExist) {
            bookRepository.save(book);
        }
        return bookMapper.mapToBookDto(book);
    }

    public void deleteByBookId(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_ID, id.toString());
        }
    }
}

