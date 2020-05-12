package pl.kaczoroski.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kaczoroski.library.model.CheckList;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfRegister;
    private CheckList checkList;

    public UserDto(Long id, String firstName, String lastName, LocalDate dateOfRegister) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfRegister = dateOfRegister;
    }
}
