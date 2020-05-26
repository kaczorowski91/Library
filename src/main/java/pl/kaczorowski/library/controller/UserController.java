package pl.kaczorowski.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.kaczorowski.library.domain.UserDto;
import pl.kaczorowski.library.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDto> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/{firstName}/{lastName}")
    public UserDto getUser(@PathVariable String firstName, @PathVariable  String lastName) {
        return userService.getUser(firstName, lastName);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto create(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

}
