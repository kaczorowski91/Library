package pl.kaczoroski.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kaczoroski.library.domain.BookDto;
import pl.kaczoroski.library.domain.BookStatusDto;
import pl.kaczoroski.library.domain.CopyOfBookDto;
import pl.kaczoroski.library.exception.EntityNotFoundException;
import pl.kaczoroski.library.exception.ExceptionType;
import pl.kaczoroski.library.mapper.CopyOfBookMapper;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.model.BookStatus;
import pl.kaczoroski.library.model.CopyOfBook;
import pl.kaczoroski.library.repository.BookRepository;
import pl.kaczoroski.library.repository.CopyOfBookRepository;

import java.util.List;

@Service
public class CopyOfBookService {

    @Autowired
    CopyOfBookRepository copyOfBookRepository;
    @Autowired
    CopyOfBookMapper copyOfBookMapper;
    @Autowired
    private BookRepository bookRepository;

    public List<CopyOfBookDto> getAllCopyOfBook() {
        return copyOfBookMapper.mapToCopyOfBookDtoList(copyOfBookRepository.findAll());
    }

    public CopyOfBookDto getCopyOfBook(Long id) {
        CopyOfBook copyOfBook = copyOfBookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.COPY_OF_BOOK_NOT_FOUND_ID,id.toString()));
        return copyOfBookMapper.mapToCopyOfBookDto(copyOfBook);
    }

    public List<CopyOfBookDto> getAllCopyOfBook(Book book) {
        List<CopyOfBook> copies = copyOfBookRepository.findByBook(book)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.COPY_OF_BOOK_NOT_FOUND_BOOK,book.toString()));
        return copyOfBookMapper.mapToCopyOfBookDtoList(copies);
    }

    public List<CopyOfBookDto> getAllCopyOfBook(Book book, BookStatus bookStatus) {
        List<CopyOfBook> copies = copyOfBookRepository.findByBookAndBookStatus(book, bookStatus)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.COPY_OF_BOOK_NOT_FOUND_BOOK_AND_STATUS,book.toString(),bookStatus.toString()));
        return copyOfBookMapper.mapToCopyOfBookDtoList(copies);
    }

    public CopyOfBookDto saveCopyOfBook(BookDto bookDto) {
        Book newCopyBook = bookRepository.findByTitleAndDateOfPublish(bookDto.getTitle(), bookDto.getDateOfPublish())
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND,bookDto.toString()));
        return copyOfBookMapper.mapToCopyOfBookDto(copyOfBookRepository.save(new CopyOfBook(newCopyBook, BookStatus.AVAILABLE)));
    }

    public CopyOfBookDto updateStatus(BookStatusDto bookStatusDto) {
        Long id = bookStatusDto.getId();
        String bookStatus = bookStatusDto.getBookStatus();
        BookStatus newBookStatus = BookStatus.getBookStatus(bookStatus);

        CopyOfBook copyOfBook = copyOfBookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.COPY_OF_BOOK_NOT_FOUND_ID,id.toString()));

        copyOfBook.setBookStatus(newBookStatus);
        copyOfBookRepository.save(copyOfBook);
        return copyOfBookMapper.mapToCopyOfBookDto(copyOfBook);
    }

    public void deleteByCopyOfBookId(Long id) {
        if (!copyOfBookRepository.existsById(id)) {
            throw new EntityNotFoundException(ExceptionType.COPY_OF_BOOK_NOT_FOUND_ID,id.toString());
        } else {
            copyOfBookRepository.deleteById(id);
        }
    }

}
