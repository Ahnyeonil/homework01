package com.homework01.homework01.repository;

import com.homework01.homework01.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // JpaRepository<Entity명, Id 타입>

    @Modifying
    @Query("update Board b set b.title = ?1, b.content = ?2, b.writer = ?3, b.password = ?4, b.modifiedAt = ?6 where b.id = ?5")
    void setBoardInfoById(String title, String content, String writer, String password, Long id, LocalDateTime ldt);


}
