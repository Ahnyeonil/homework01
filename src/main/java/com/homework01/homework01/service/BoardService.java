package com.homework01.homework01.service;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import com.homework01.homework01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public List<BoardDto> findBoards(){
        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board b : boards) {

            BoardDto boardDto = new BoardDto(b);

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    @Transactional
    public BoardDto findBoard(Long boardId){
        Optional<Board> board = boardRepository.findById(boardId);

        BoardDto boardForm = new BoardDto();

        boardForm.setId(board.get().getId());
        boardForm.setTitle(board.get().getTitle());
        boardForm.setContent(board.get().getContent());
        boardForm.setWriter(board.get().getWriter());
        boardForm.setPassword(board.get().getPassword());
        boardForm.setCreatedAt(board.get().getCreatedAt());
        boardForm.setModifiedAt(board.get().getModifiedAt());

        return boardForm;
    }

    @Transactional
    public void insertBoard(BoardDto boardDto){
        Board board = new Board(boardDto);
        boardRepository.save(board);
    }

    @Transactional
    public void updateBoard(BoardDto boardDto) {
        Board board = new Board(boardDto);
        boardRepository.setBoardInfoById(boardDto.getTitle(), boardDto.getContent(), boardDto.getWriter(), boardDto.getPassword(), boardDto.getId(), boardDto.getModifiedAt());

    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
