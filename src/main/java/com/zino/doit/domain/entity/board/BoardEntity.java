package com.zino.doit.domain.entity.board;

import com.zino.doit.domain.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table
@Getter
@ToString(callSuper = true)
@Entity(name = "Board")
public class BoardEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "board_id")
  private Long id;

  @JoinColumn(name = "user_id",nullable = false,updatable = false)
  @ManyToOne
  private UserEntity writer;
  @Setter
  @Column(nullable = false)
  private String title;

  @Setter
  @Column(nullable = false)
  private String content;

  @Setter
  private Long viewCount;

  public BoardEntity() {}
  private BoardEntity(UserEntity writer,String title, String content) {
    this.writer=writer;
    this.title = title;
    this.content = content;
    this.viewCount = 0L;
  }
  /*펙토리 메소드*/
  public static BoardEntity of(UserEntity writer,String title,String content){
    return new BoardEntity(writer,title,content);
  }


}
