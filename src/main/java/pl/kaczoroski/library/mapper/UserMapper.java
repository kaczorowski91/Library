package pl.kaczoroski.library.mapper;

import org.springframework.stereotype.Component;
import pl.kaczoroski.library.domain.UserDto;
import pl.kaczoroski.library.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfRegister());
    }

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                LocalDate.now());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(user -> new UserDto(user.getId(), user.getFirstName(), user.getLastName(), user.getDateOfRegister()))
                .collect(Collectors.toList());
    }

}
