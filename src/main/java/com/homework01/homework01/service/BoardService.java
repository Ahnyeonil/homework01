package com.homework01.homework01.service;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import com.homework01.homework01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public List<Board> findBoards(){
        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        return boards;
    }

    @Transactional
    public Optional<Board> findBoard(Long boardId){
        Optional<Board> board = boardRepository.findById(boardId);
        return board;
    }

    @Transactional
    public void insertBoard(BoardDto boardDto){
        Board board = new Board(boardDto);
        boardRepository.save(board);
    }
}
