package com.zino.doit.domain.service.board;

import com.zino.doit.domain.model.board.dto.BoardDTO;
import com.zino.doit.domain.model.board.dto.BoardDTO.PostBoard;

public interface BoardService {

  public void postBoard(PostBoard request)throws IllegalAccessException;
}
