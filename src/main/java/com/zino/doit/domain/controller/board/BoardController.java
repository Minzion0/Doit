package com.zino.doit.domain.controller.board;

import com.zino.doit.domain.model.board.dto.BoardDTO.PostBoard;
import com.zino.doit.domain.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
  private final BoardService boardService;

  @PostMapping("/doit")
  public ResponseEntity<?> postBoard(@RequestBody PostBoard request){
    try{
      boardService.postBoard(request);
    }catch (IllegalAccessException e){
      log.error(e.getMessage());
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
