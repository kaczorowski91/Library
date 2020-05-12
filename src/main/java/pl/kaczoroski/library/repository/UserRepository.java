package pl.kaczoroski.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kaczoroski.library.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    List<User> findAll();

    @Override
    User save(User user);

    @Override
    Optional<User> findById(Long userId);

    @Override
    void deleteById(Long userId);

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}
