package pl.kaczoroski.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.model.CheckList;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckListRepository extends CrudRepository<CheckList, Long> {


    @Override
    CheckList save (CheckList checkList);

    @Override
    Optional<CheckList> findById(Long id);

    @Override
    List<CheckList>findAll();

    List<CheckList> findByCopiesOfBook(Book book);

    @Override
    void deleteById (Long checkListId);


}
