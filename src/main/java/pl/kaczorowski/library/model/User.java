package pl.kaczorowski.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfRegister;
    @OneToOne
    private CheckList checkList;

    public User(String firstName, String lastName, LocalDate dateOfRegister) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfRegister = dateOfRegister;
    }
}

