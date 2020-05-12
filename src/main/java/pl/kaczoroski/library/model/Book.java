package pl.kaczoroski.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private LocalDate dateOfPublish;

    public Book(String title, String author, LocalDate dateOfPublish) {
        this.title = title;
        this.author = author;
        this.dateOfPublish = dateOfPublish;
    }
}

