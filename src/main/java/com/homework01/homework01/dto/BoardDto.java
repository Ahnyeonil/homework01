package com.homework01.homework01.dto;

import com.homework01.homework01.entity.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String writer;
    private String content;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.content = board.getContent();
        this.password = board.getPassword();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();
    }
}
