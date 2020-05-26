package pl.kaczorowski.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kaczorowski.library.model.CopyOfBook;
import pl.kaczorowski.library.model.User;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CheckListDto {
    private Long id;
    private CopyOfBook copiesOfBook;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
