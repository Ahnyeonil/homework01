package com.homework01.homework01.entity;

import com.homework01.homework01.domain.Timestamped;
import com.homework01.homework01.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter // getInstance
@Setter
@NoArgsConstructor  // 기본 생성자
@Entity // DB 테이블
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "writer", nullable = false)
    private String writer;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "password", nullable = false)
    private String password;

    public Board(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.writer = boardDto.getWriter();
        this.content = boardDto.getContent();
        this.password = boardDto.getPassword();
    }

}
