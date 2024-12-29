package com.zino.doit.domain.repository.board;

import com.zino.doit.domain.entity.board.BoardEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
  Optional<BoardEntity> findByIdAndWriter(Long id, String writer);

  @Modifying
  void deleteByIdAndWriter(Long id, String writer);
}
