package pl.kaczoroski.library.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kaczoroski.library.domain.CheckListDto;
import pl.kaczoroski.library.service.CheckListService;

import java.util.List;

@RestController
@RequestMapping("/api/checklist")
public class CheckListController {

    @Autowired
    private CheckListService checkListService;


    @GetMapping("/{id}")
    public CheckListDto getCheckList(@PathVariable Long id) {
        return checkListService.getCheckListById(id);
    }

    @GetMapping("/all")
    public List<CheckListDto> getCheckList() {
        return checkListService.getCheckList();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        checkListService.deleteById(id);
    }

}
