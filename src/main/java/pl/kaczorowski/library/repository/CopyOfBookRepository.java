package pl.kaczorowski.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kaczorowski.library.model.Book;
import pl.kaczorowski.library.model.BookStatus;
import pl.kaczorowski.library.model.CopyOfBook;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyOfBookRepository extends CrudRepository<CopyOfBook, Long> {

    @Override
    CopyOfBook save(CopyOfBook copyOfBook);

    @Override
    void deleteById(Long copyOfBookId);

    @Override
    Optional<CopyOfBook> findById(Long id);

    @Override
    List<CopyOfBook>findAll();

    Optional<List<CopyOfBook>> findByBook(Book book);

    Optional<List<CopyOfBook>> findByBookAndBookStatus(Book book, BookStatus bookStatus);

}
