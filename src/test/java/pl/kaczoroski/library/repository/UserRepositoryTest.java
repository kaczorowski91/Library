package pl.kaczoroski.library.repository;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kaczoroski.library.model.User;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testUserSave() {
        //Given
        User user1 = new User("Mateusz", "Kaczorowski", LocalDate.now());
        //When
        userRepository.save(user1);
        int count = userRepository.findAll().size();
        //Then
        Assert.assertEquals(1, count);
        //Clean up
        userRepository.deleteById(user1.getId());
    }

    @Test
    public void testUserFindById() {
        //Given
        User user1 = new User("Mateusz", "Kaczorowski", LocalDate.now());
        User user2 = new User("Szymon", "Wydra", LocalDate.now());
        User user3 = new User("Klaudiusz", "Sepkovic", LocalDate.now());

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        Optional<User> cloneUser = userRepository.findById(user1.getId());
        //Then
        Assert.assertEquals("Mateusz", cloneUser.get().getFirstName());
        //Clean up
        userRepository.deleteById(user1.getId());
        userRepository.deleteById(user2.getId());
        userRepository.deleteById(user3.getId());
    }

    @Test
    public void testUserFindByFirstNameAndLastName() {
        //Given
        userRepository.deleteAll();
        User user1 = new User("Mateusz", "Kaczorowski", LocalDate.of(2020, 2, 2));
        User user2 = new User("Szymon", "Wydra", LocalDate.now());
        User user3 = new User("Klaudiusz", "Sepkovic", LocalDate.now());

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        Optional<User> cloneUser = userRepository.findByFirstNameAndLastName("Mateusz", "Kaczorowski");
        //Then
        Assert.assertEquals(LocalDate.of(2020, 2, 2), cloneUser.get().getDateOfRegister());
        //Clean up
        userRepository.deleteById(user1.getId());
        userRepository.deleteById(user2.getId());
        userRepository.deleteById(user3.getId());
    }


}