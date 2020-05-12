package pl.kaczoroski.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "Copies_Of_Book")
    private CopyOfBook copiesOfBook;

    @OneToOne
    @JoinColumn(name = "User")
    private User user;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    public CheckList(CopyOfBook copiesOfBook, User user, LocalDate borrowDate, LocalDate returnDate) {
        this.copiesOfBook = copiesOfBook;
        this.user = user;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public CheckList(CopyOfBook copiesOfBook, User user) {
        this.copiesOfBook = copiesOfBook;
        this.user = user;
    }

    public CheckList(CopyOfBook copiesOfBook, User user, LocalDate borrowDate) {
        this.copiesOfBook = copiesOfBook;
        this.user = user;
        this.borrowDate = borrowDate;
    }

}
