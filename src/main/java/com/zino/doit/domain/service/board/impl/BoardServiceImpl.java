package com.zino.doit.domain.service.board.impl;

import com.zino.doit.domain.entity.board.BoardEntity;
import com.zino.doit.domain.entity.board.UserEntity;
import com.zino.doit.domain.model.board.dto.BoardDTO.DeleteBoard;
import com.zino.doit.domain.model.board.dto.BoardDTO.PostBoard;
import com.zino.doit.domain.model.board.vo.BoardVO;
import com.zino.doit.domain.model.board.vo.BoardVO.BoardList;
import com.zino.doit.domain.repository.board.BoardRepository;
import com.zino.doit.domain.repository.board.UserRepository;
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
  private final UserRepository userRepository;

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void postBoard(PostBoard request) throws IllegalAccessException {
    UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(
            ()->new IllegalAccessException()
    );

    BoardEntity boardEntity =
        BoardEntity.of(user,request.getTitle() ,request.getContent());

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
            entity.getWriter().getId(),
            entity.getWriter().getNickname(),
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
  /*
  doit의 경우 db 부하를 최대한 줄이기위해 게시물 내용 변경이 있는지 확인하고 변경이 있으면 updated를 하기로 한다.
  */
  @Override
  @Transactional(rollbackOn = Exception.class)
  public void boardModify(Long boardId, PostBoard request)throws Exception {
    UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalAccessException());

    BoardEntity boardEntity = boardRepository.findByIdAndWriter_Id(boardId, user.getId())
        .orElseThrow(NotFoundException::new);

    if (!boardEntity.getTitle().equals(request.getTitle())){
      boardEntity.setTitle(request.getTitle());
    }
    if(!boardEntity.getContent().equals(request.getContent())){
      boardEntity.setContent(request.getContent());
    }

  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public void deleteBoard(Long boardId, DeleteBoard request) {
    UserEntity user = userRepository.findById(request.getUserId()).orElseThrow(() -> new IllegalArgumentException());
    boardRepository.deleteByIdAndWriter_Id(boardId, user.getId());

  }


}
