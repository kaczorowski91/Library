package pl.kaczoroski.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kaczoroski.library.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Book save (Book book);

    @Override
    Optional<Book> findById(Long bookId);

    Optional<List<Book>>findByAuthor(String author);

    @Override
    void deleteById (Long id);

    Optional<Book>findByTitleAndDateOfPublish(String title, LocalDate dateOfPublish);

    boolean existsBookByTitleAndAuthorAndDateOfPublish(String title, String author, LocalDate dateOfPublish);

    boolean existsById(Long id);
}
