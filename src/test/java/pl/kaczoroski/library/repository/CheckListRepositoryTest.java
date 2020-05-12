package pl.kaczoroski.library.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kaczoroski.library.model.*;

import java.time.LocalDate;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckListRepositoryTest {

    @Autowired
    private CheckListRepository checkListRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CopyOfBookRepository copyOfBookRepository;

    @Test
    public void testCheckListRepository() {
        //Given
        User user = new User("Mateusz", "Kaczorowski", LocalDate.now());
        userRepository.save(user);
        Book book = new Book("Harry Potter", "J.K. Rowling", LocalDate.of(2000, 11, 23));
        bookRepository.save(book);
        CopyOfBook copyOfBook = new CopyOfBook(book, BookStatus.AVAILABLE);
        copyOfBookRepository.save(copyOfBook);
        CheckList checkList = new CheckList(copyOfBook, user);
        checkListRepository.save(checkList);
        //When
        int count = checkListRepository.findAll().size();
        //Then
        Assert.assertEquals(1, count);
        System.out.println(checkListRepository.findAll());
        //
        checkListRepository.delete(checkList);
        copyOfBookRepository.delete(copyOfBook);
        userRepository.delete(user);
        bookRepository.delete(book);

    }


    @Test
    public void testCheckListRepositoryDeleteById() {
        //Given
        User user = new User("Mateusz", "Kaczorowski", LocalDate.now());
        userRepository.save(user);
        Book book = new Book("Harry Potter", "J.K. Rowling", LocalDate.of(2000, 11, 23));
        bookRepository.save(book);
        CopyOfBook copyOfBook1 = new CopyOfBook(book, BookStatus.AVAILABLE);
        CopyOfBook copyOfBook2 = new CopyOfBook(book, BookStatus.AVAILABLE);
        copyOfBookRepository.save(copyOfBook1);
        copyOfBookRepository.save(copyOfBook2);
        CheckList checkList1 = new CheckList(copyOfBook1, user);
        CheckList checkList2 = new CheckList(copyOfBook2, user);
        checkListRepository.save(checkList1);
        checkListRepository.save(checkList2);
        //When
        checkListRepository.deleteById(checkList1.getId());
        int count = checkListRepository.findAll().size();
        //Then
        Assert.assertEquals(1, count);
        //
        checkListRepository.delete(checkList1);
        checkListRepository.delete(checkList2);
        copyOfBookRepository.delete(copyOfBook1);
        copyOfBookRepository.delete(copyOfBook2);
        userRepository.delete(user);
        bookRepository.delete(book);

    }


}