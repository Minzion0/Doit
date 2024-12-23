package com.zino.doit.domain.entity.board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Table
@Getter
@ToString(callSuper = true)
@Entity(name = "Board")
public class BoardEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String content;

  private Long viewCount;

  public BoardEntity() {}
  private BoardEntity(String title, String content) {
    this.title = title;
    this.content = content;
    this.viewCount = 0L;
  }
  /*펙토리 메소드*/
  public static BoardEntity of(String title,String content){
    return new BoardEntity(title,content);
  }

}
