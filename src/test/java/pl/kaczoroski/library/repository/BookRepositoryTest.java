package pl.kaczoroski.library.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kaczoroski.library.exception.EntityNotFoundException;
import pl.kaczoroski.library.exception.ExceptionType;
import pl.kaczoroski.library.model.Book;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindByBookId() throws EntityNotFoundException {
        //Given
        Book book = new Book("Harry Potter", "J.K. Rowling", LocalDate.now());
        bookRepository.save(book);
        //When
        Book newBook = bookRepository.findById(book.getId()).orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_ID, book.getId().toString()));
        //Then
        Assert.assertEquals(book.getId(), newBook.getId());
        Assert.assertEquals(book.getAuthor(), newBook.getAuthor());
        Assert.assertEquals(book.getTitle(), newBook.getTitle());
        Assert.assertEquals(book.getDateOfPublish(), newBook.getDateOfPublish());
        //Clean up
        bookRepository.deleteById(book.getId());
    }

    @Test
    public void testFindByBookAuthor() throws EntityNotFoundException {
        //Given
        Book book1 = new Book("Harry Potter", "J.K. Rowling", LocalDate.now());
        Book book2 = new Book("Harry Potter, The Deathly Hallows", "J.K. Rowling", LocalDate.now());
        Book book3 = new Book("Clean code ", "Robert C. Martin", LocalDate.now());
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        //When
        List<Book> bookList = bookRepository.findByAuthor(book1.getAuthor())
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.BOOK_NOT_FOUND_ID, book1.getAuthor()));
        int count = bookList.size();
        //Then
        Assert.assertEquals(2, count);
        //Clean up
        bookRepository.deleteById(book1.getId());
        bookRepository.deleteById(book2.getId());
        bookRepository.deleteById(book3.getId());
    }


    @Test
    public void testDeleteBookById() {
        //Given
        Book book1 = new Book("Harry Potter, The Philosopher's Stone", "J.K. Rowling", LocalDate.now());
        bookRepository.save(book1);
        //When
        bookRepository.deleteById(book1.getId());
        int count = bookRepository.findAll().size();
        //Then
        Assert.assertEquals(0, count);
    }

}
