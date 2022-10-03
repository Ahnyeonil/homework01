package com.homework01.homework01.dto;

import com.homework01.homework01.entity.Board;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardDto {

    Long id;
    String title;
    String writer;
    String content;
    String password;

}
