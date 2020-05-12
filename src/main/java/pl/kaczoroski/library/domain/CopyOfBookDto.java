package pl.kaczoroski.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kaczoroski.library.model.Book;
import pl.kaczoroski.library.model.BookStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CopyOfBookDto {

    private Long id;
    private Book book;
    private BookStatus bookStatus;


}
