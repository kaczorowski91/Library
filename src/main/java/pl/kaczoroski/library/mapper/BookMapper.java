package pl.kaczoroski.library.mapper;

import org.springframework.stereotype.Component;
import pl.kaczoroski.library.domain.BookDto;
import pl.kaczoroski.library.model.Book;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook (final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getDateOfPublish());
    }

    public BookDto mapToBookDto (final Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getDateOfPublish());
        }

     public List<BookDto> mapToBookDtoList(final List<Book> bookList){
        return bookList.stream()
                .map(book -> new BookDto(book.getId(),book.getTitle(),book.getAuthor(),book.getDateOfPublish()))
                        .collect(Collectors.toList());



    }





}
