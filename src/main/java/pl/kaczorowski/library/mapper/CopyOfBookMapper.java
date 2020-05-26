package pl.kaczorowski.library.mapper;

import org.springframework.stereotype.Component;
import pl.kaczorowski.library.domain.CopyOfBookDto;
import pl.kaczorowski.library.model.CopyOfBook;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CopyOfBookMapper {

    public CopyOfBook mapToCopyOfBook(final CopyOfBookDto copyOfBookDto) {
        return new CopyOfBook(
                copyOfBookDto.getId(),
                copyOfBookDto.getBook(),
                copyOfBookDto.getBookStatus());
    }

    public CopyOfBookDto mapToCopyOfBookDto(final CopyOfBook copyOfBook) {
        return new CopyOfBookDto(
                copyOfBook.getId(),
                copyOfBook.getBook(),
                copyOfBook.getBookStatus());
    }

    public List<CopyOfBookDto> mapToCopyOfBookDtoList(final List<CopyOfBook> copyOfBookList) {
        return copyOfBookList.stream()
                .map(copyOfBook -> new CopyOfBookDto(copyOfBook.getId(), copyOfBook.getBook(), copyOfBook.getBookStatus()))
                .collect(Collectors.toList());
    }


}
