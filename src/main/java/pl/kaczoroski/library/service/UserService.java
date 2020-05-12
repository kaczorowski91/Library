package pl.kaczoroski.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kaczoroski.library.domain.UserDto;
import pl.kaczoroski.library.mapper.UserMapper;
import pl.kaczoroski.library.model.User;
import pl.kaczoroski.library.repository.UserRepository;
import pl.kaczoroski.library.exception.EntityNotFoundException;
import pl.kaczoroski.library.exception.ExceptionType;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public List<UserDto> getAll(){ return userMapper.mapToUserDtoList(userRepository.findAll());}

    public UserDto getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.USER_NOT_FOUND_ID,id.toString()));
        return userMapper.mapToUserDto(user);
    }

    public UserDto getUser (String firstName, String lastName){
        User user =userRepository.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(()->new EntityNotFoundException(ExceptionType.USER_NOT_FOUND_NAME,firstName,lastName));
        return userMapper.mapToUserDto(user);
    }

    public UserDto save (UserDto userDto){
        return userMapper.mapToUserDto(userRepository.save(userMapper.mapToUser(userDto)));
    }


}
