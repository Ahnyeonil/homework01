package com.homework01.homework01.controller;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import com.homework01.homework01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String selectBoards(Model model){
        List<Board> boardList = boardService.findBoards();
        model.addAttribute("boards", boardList);
        return "board/boards";
    }

    @GetMapping("/board/new")
    public String newBoard(){
        return "board/createBoardForm";
    }

    @PostMapping("/board/new")
    public String insertBoard(BoardDto boardDto){
        boardService.insertBoard(boardDto);
        return "redirect:/";
    }

    @GetMapping("/board/info-board")
    public String infoBoard(Model model, @RequestParam("id") Long boardId){
        Optional<Board> board = boardService.findBoard(boardId);
        BoardDto boardDto = new BoardDto();

        boardDto.setId(board.get().getId());
        boardDto.setTitle(board.get().getTitle());
        boardDto.setContent(board.get().getContent());
        boardDto.setWriter(board.get().getWriter());
        boardDto.setPassword(board.get().getPassword());

        model.addAttribute("board", boardDto);
        return "board/infoBoard";
    }

}
