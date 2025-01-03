package com.zino.doit.domain.entity;

import com.zino.doit.domain.entity.board.BaseEntity;
import com.zino.doit.domain.entity.board.BoardEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@Table
@Entity(name = "User")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @ManyToMany
    private List<BoardEntity> boards;

}
