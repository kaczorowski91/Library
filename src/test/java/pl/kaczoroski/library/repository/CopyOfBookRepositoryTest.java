package pl.kaczoroski.library.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.model.BookStatus;
import pl.kaczoroski.library.model.CopyOfBook;

import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CopyOfBookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CopyOfBookRepository copyOfBookRepository;

    @Test
    public void saveBookInCopyOfBookRepository() {
        //Given
        Book book1 = new Book("Harry Potter", "J.K. Rowling", LocalDate.of(2001, 1, 1));
        Book book2 = new Book("Clean Code", "Robert C. Martin", LocalDate.of(2014, 1, 1));
        Book book3 = new Book("Thinking in java", "Bruce Eckel", LocalDate.of(2017, 1, 1));
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        CopyOfBook copyOfBook1 = new CopyOfBook(book1, BookStatus.AVAILABLE);
        CopyOfBook copyOfBook2 = new CopyOfBook(book1, BookStatus.LOST);
        CopyOfBook copyOfBook3 = new CopyOfBook(book1, BookStatus.DESTROYED);
        CopyOfBook copyOfBook4 = new CopyOfBook(book2, BookStatus.LOST);
        CopyOfBook copyOfBook5 = new CopyOfBook(book2, BookStatus.AVAILABLE);
        CopyOfBook copyOfBook6 = new CopyOfBook(book3, BookStatus.BORROWED);
        CopyOfBook copyOfBook7 = new CopyOfBook(book3, BookStatus.BORROWED);
        CopyOfBook copyOfBook8 = new CopyOfBook(book3, BookStatus.AVAILABLE);
        copyOfBookRepository.save(copyOfBook1);
        copyOfBookRepository.save(copyOfBook2);
        copyOfBookRepository.save(copyOfBook3);
        copyOfBookRepository.save(copyOfBook4);
        copyOfBookRepository.save(copyOfBook5);
        copyOfBookRepository.save(copyOfBook6);
        copyOfBookRepository.save(copyOfBook7);
        copyOfBookRepository.save(copyOfBook8);

        //When
        int count = copyOfBookRepository.findAll().size();
        //Then
        Assert.assertEquals(count, 8);
        //Clean Up
        copyOfBookRepository.deleteById(copyOfBook1.getId());
        copyOfBookRepository.deleteById(copyOfBook2.getId());
        copyOfBookRepository.deleteById(copyOfBook3.getId());
        bookRepository.deleteById(book1.getId());
    }


}