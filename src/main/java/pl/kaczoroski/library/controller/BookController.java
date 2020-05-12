package pl.kaczoroski.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kaczoroski.library.domain.BookDto;
import pl.kaczoroski.library.service.BookService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<BookDto> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author/{author}")
    public List<BookDto> getBook(@PathVariable String author) {
        return bookService.getAllBooks(author);
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        bookService.deleteByBookId(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.saveBook(bookDto);
    }

}





