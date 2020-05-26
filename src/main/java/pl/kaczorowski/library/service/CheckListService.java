package pl.kaczorowski.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kaczorowski.library.domain.CheckListDto;
import pl.kaczorowski.library.domain.CopyOfBookDto;
import pl.kaczorowski.library.domain.UserDto;
import pl.kaczorowski.library.exception.EntityNotFoundException;
import pl.kaczorowski.library.exception.ExceptionType;
import pl.kaczorowski.library.mapper.CheckListMapper;
import pl.kaczorowski.library.mapper.CopyOfBookMapper;
import pl.kaczorowski.library.mapper.UserMapper;
import pl.kaczorowski.library.model.BookStatus;
import pl.kaczorowski.library.model.CheckList;
import pl.kaczorowski.library.repository.CheckListRepository;
import pl.kaczorowski.library.repository.CopyOfBookRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class CheckListService {

    @Autowired
    private CheckListRepository checkListRepository;
    @Autowired
    private CheckListMapper checkListMapper;
    @Autowired
    private CopyOfBookMapper copyOfBookMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CopyOfBookRepository copyOfBookRepository;


    public CheckListDto getCheckListById(Long id) {
        CheckList checkList = checkListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionType.RENTAL_NOT_FOUND,id.toString()));
        return checkListMapper.mapToCheckListDto(checkList);
    }

    public List<CheckListDto> getCheckList() {
        List<CheckList> checkLists = checkListRepository.findAll();
        return checkListMapper.mapToCheckListDtoList(checkLists);
    }

    public CheckList save(CopyOfBookDto copyOfBookDto, UserDto userDto) {

        copyOfBookDto.setBookStatus(BookStatus.BORROWED);
        copyOfBookRepository.save(copyOfBookMapper.mapToCopyOfBook(copyOfBookDto));

        CheckList checkList = new CheckList(copyOfBookMapper.mapToCopyOfBook(copyOfBookDto),userMapper.mapToUser(userDto),LocalDate.now());

        return checkListRepository.save(checkList);
    }

    public void deleteById(Long id) {
        checkListRepository.deleteById(id);
    }
}
