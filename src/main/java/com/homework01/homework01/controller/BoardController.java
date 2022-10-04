package com.homework01.homework01.controller;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import com.homework01.homework01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Controller
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public String selectBoards(Model model) {
        List<Board> boardList = boardService.findBoards();
        model.addAttribute("boards", boardList);
        return "board/boards";
    }

    @GetMapping("/board/new")
    public String newBoard() {
        return "board/createBoardForm";
    }

    @PostMapping("/board/new")
    public String insertBoard(BoardDto boardDto) {
        boardService.insertBoard(boardDto);
        return "redirect:/";
    }

    @GetMapping({"/board/{id}/info-board"})
    public String infoBoard(Model model, @PathVariable("id") Long boardId) {
        BoardDto boardDto = boardService.findBoard(boardId);
        model.addAttribute("board", boardDto);
        return "board/infoBoard";
    }

    @PostMapping("/board/update")
    public String updateBoard(Model model, BoardDto boardDto, @RequestParam("pwcheck") String pw) {

        if(checkPw(boardDto.getId(), pw)){
            boardDto.setModifiedAt(LocalDateTime.now());
            boardService.updateBoard(boardDto);
            model.addAttribute("id", boardDto.getId());
        }

        return "redirect:/board/"  + boardDto.getId() + "/info-board";
    }

    @PostMapping("/board/delete")
    public String deleteBoard(@RequestParam("bid") Long boardId, @RequestParam("pwcheck2") String pw) {
        if(checkPw(boardId, pw)){
            boardService.deleteBoard(boardId);
        }
        return "redirect:/";
    }

    public boolean checkPw(Long id, String pw) {
        BoardDto boardDto = boardService.findBoard(id);
        if(boardDto.getPassword().equals(pw)){
            return true;
        }
        return false;
    }

    // 비밀번호 판별 API 구현시 실행 X
    // 수정 및 삭제 버튼 눌렀을 경우 수정/삭제 API 도중 비밀번호 판별
    /*@PostMapping("/board/check-password")
    public boolean checkPassword(@RequestParam("boardId") Long id,@RequestParam("pwd") String pw){
        BoardDto boardDto = boardService.findBoard(id);
        if(boardDto.getPassword().equals(pw)){
            return true;
        }
        return false;
    }*/
}
