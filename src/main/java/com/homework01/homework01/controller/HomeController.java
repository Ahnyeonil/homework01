package com.homework01.homework01.controller;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import com.homework01.homework01.service.BoardService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class HomeController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model){
        List<BoardDto> boardList = boardService.findBoards();
        model.addAttribute("boards", boardList);
        return "board/boards";
    }
}
