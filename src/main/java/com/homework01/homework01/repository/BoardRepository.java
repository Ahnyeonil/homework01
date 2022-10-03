package com.homework01.homework01.repository;

import com.homework01.homework01.dto.BoardDto;
import com.homework01.homework01.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository<Entity명, Id 타입>
}
