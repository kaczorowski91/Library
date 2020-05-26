package pl.kaczorowski.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CopyOfBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    private BookStatus bookStatus;

    public CopyOfBook(Book book, BookStatus bookStatus) {
        this.book = book;
        this.bookStatus = bookStatus;

    }

}

