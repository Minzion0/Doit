package com.zino.doit.domain.model.board.vo;

import com.zino.doit.domain.entity.board.BoardEntity;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
public class BoardVO {
  private Long boardId;
  private Long boardUserId;
  private String writer;
  private String title;
  private String content;
  private Long viewCount;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public BoardVO(){}
  private BoardVO(Long boardId, Long boardUserId,String writer, String title, String content, Long viewCount, LocalDateTime createdAt,LocalDateTime updatedAt) {
    this.boardId = boardId;
    this.boardUserId = boardUserId;
    this.writer = writer;
    this.title = title;
    this.content = content;
    this.viewCount = viewCount;
    this.createdAt = createdAt;
    this.updatedAt=updatedAt;
  }

  public static BoardVO of(BoardEntity entity){
    return new BoardVO(entity.getId(),entity.getId(),entity.getWriter().getNickname(),entity.getTitle(),entity.getContent(),
        entity.getViewCount(),entity.getCreatedAt(),entity.getUpdatedAt() );
  }

  @Getter
  @ToString
  public static class BoardList{
    private Long boardId;
    private Long boardUserId;
    private String writer;
    private String title;
    private Long viewCount;
    private LocalDateTime createdAt;

    public BoardList(){}
    private BoardList(Long boardId,Long boardUserId,String writer ,String title, Long viewCount, LocalDateTime createdAt) {
      this.boardId = boardId;
      this.boardUserId = boardUserId;
      this.writer=writer;
      this.title = title;
      this.viewCount = viewCount;
      this.createdAt = createdAt;
    }
    public static BoardList of(Long boardId,Long boardUserId,String writer ,String title, Long viewCount, LocalDateTime createdAt) {
      return new BoardList(boardId,boardUserId,writer,title, viewCount, createdAt);
    }
  }
}
