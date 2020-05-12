package pl.kaczoroski.library.mapper;

import org.springframework.stereotype.Component;
import pl.kaczoroski.library.domain.CheckListDto;
import pl.kaczoroski.library.model.CheckList;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CheckListMapper {

    public CheckList mapToCheckList (final CheckListDto checkListDto){
        return new CheckList(
                checkListDto.getId(),
                checkListDto.getCopiesOfBook(),
                checkListDto.getUser(),
                checkListDto.getBorrowDate(),
                checkListDto.getReturnDate());
    }

    public CheckListDto mapToCheckListDto (CheckList checkList){
        return new CheckListDto(
                checkList.getId(),
                checkList.getCopiesOfBook(),
                checkList.getUser(),
                checkList.getBorrowDate(),
                checkList.getReturnDate());
    }

    public List <CheckListDto> mapToCheckListDtoList(final List<CheckList> checkListList){
        return checkListList.stream()
                .map(checkList -> new CheckListDto(checkList.getId(),checkList.getCopiesOfBook(),checkList.getUser(),checkList.getBorrowDate(),checkList.getReturnDate()))
                .collect(Collectors.toList());
    }
}
