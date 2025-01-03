package com.zino.doit.domain.repository.board;

import com.zino.doit.domain.entity.board.BoardEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
  Optional<BoardEntity> findByIdAndWriter_Id(Long id, Long userId);

  @Modifying
  void deleteByIdAndWriter_Id(Long id, Long userId);

}
