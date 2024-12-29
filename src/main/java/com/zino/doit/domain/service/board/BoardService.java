package com.zino.doit.domain.service.board;

import com.zino.doit.domain.model.board.dto.BoardDTO;
import com.zino.doit.domain.model.board.dto.BoardDTO.DeleteBoard;
import com.zino.doit.domain.model.board.dto.BoardDTO.PostBoard;
import com.zino.doit.domain.model.board.vo.BoardVO;
import java.util.List;

public interface BoardService {

  public void postBoard(PostBoard request)throws IllegalAccessException;
  public List<BoardVO.BoardList> boardList();
  public BoardVO boardDetail(Long boardId);
  public void boardModify(Long boardId, PostBoard request) throws Exception;
  void deleteBoard(Long boardId, DeleteBoard request);
}
