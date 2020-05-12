package pl.kaczoroski.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kaczoroski.library.domain.BookDto;
import pl.kaczoroski.library.domain.BookStatusDto;
import pl.kaczoroski.library.domain.CopyOfBookDto;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.model.BookStatus;
import pl.kaczoroski.library.service.CopyOfBookService;

import java.util.List;

@RestController
@RequestMapping("/api/copyOfBook")
public class CopyOfBookController {

    @Autowired
    private CopyOfBookService copyOfBookService;

    @GetMapping("/{id}")
    public CopyOfBookDto getCopyOfBook(@PathVariable Long id) {
        return copyOfBookService.getCopyOfBook(id);
    }

    @GetMapping("/all")
    public List<CopyOfBookDto> getAllCopiesOfBook() {
        return copyOfBookService.getAllCopyOfBook();
    }

    @GetMapping("/book")
    public List<CopyOfBookDto> getAll(@RequestParam(required = true) Book book) {
        return copyOfBookService.getAllCopyOfBook(book);
    }

    @GetMapping("/available")
    public List<CopyOfBookDto> getAll(@RequestParam(required = true) Book book,
                                      @RequestParam(required = true) BookStatus bookStatus) {
        return copyOfBookService.getAllCopyOfBook(book, bookStatus);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CopyOfBookDto createCopy(@RequestBody BookDto bookDto) {
        return copyOfBookService.saveCopyOfBook(bookDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CopyOfBookDto updateStatus(@RequestBody BookStatusDto bookStatusDto) {
        return copyOfBookService.updateStatus(bookStatusDto);
    }

    @DeleteMapping("/{id")
    public void deleteCopyOfBook(@PathVariable Long id) {
        copyOfBookService.deleteByCopyOfBookId(id);
    }
}
