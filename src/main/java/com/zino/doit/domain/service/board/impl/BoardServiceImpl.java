package com.zino.doit.domain.service.board.impl;

import com.zino.doit.domain.entity.board.BoardEntity;
import com.zino.doit.domain.model.board.dto.BoardDTO.PostBoard;
import com.zino.doit.domain.model.board.vo.BoardVO;
import com.zino.doit.domain.model.board.vo.BoardVO.BoardList;
import com.zino.doit.domain.repository.board.BoardRepository;
import com.zino.doit.domain.service.board.BoardService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardRepository boardRepository;

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void postBoard(PostBoard request) throws IllegalAccessException {

    BoardEntity boardEntity =
        BoardEntity.of(request.getTitle(),request.getWriter() ,request.getContent());

    boardRepository.save(boardEntity);

    if (boardEntity.getId() == null) {
      throw new IllegalAccessException();
    }

  }

  @Override
  public List<BoardList> boardList() {
    List<BoardEntity> boardList =
        boardRepository.findAll();
    return boardList.stream().map(entity ->
        BoardVO.BoardList.of(
            entity.getId(),
            entity.getWriter(),
            entity.getTitle(),
            entity.getViewCount(),
            entity.getCreatedAt()
        )).toList();

  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public BoardVO boardDetail(Long boardId) {
    BoardEntity boardEntity = boardRepository.findById(boardId).orElseThrow(
        IllegalArgumentException::new
    );

    boardEntity.setViewCount(boardEntity.getViewCount()+1);

    return BoardVO.of(boardEntity);

  }


}
