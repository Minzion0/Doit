package com.zino.doit.domain.model.board.vo;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.ToString;

public class BoardVO {

  @Getter
  @ToString
  public static class BoardList{
    private Long boardId;
    private String title;
    private Long viewCount;
    private LocalDateTime createdAt;

    public BoardList(){}
    private BoardList(Long boardId, String title, Long viewCount, LocalDateTime createdAt) {
      this.boardId = boardId;
      this.title = title;
      this.viewCount = viewCount;
      this.createdAt = createdAt;
    }
    public static BoardList of(Long boardId, String title, Long viewCount, LocalDateTime createdAt) {
      return new BoardList(boardId, title, viewCount, createdAt);
    }
  }
}
