package com.zino.doit.domain.model.board.dto;

import lombok.Data;

public class BoardDTO {

  @Data
  public static class PostBoard{
    private String title;
    private Long userId;
    private String content;
  }
  @Data
  public static class DeleteBoard{
    private Long userId;
  }

}
