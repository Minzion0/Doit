package com.zino.doit.domain.entity.board;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
  @CreatedBy
  @Column(nullable = false,updatable = false)
  private LocalDateTime createdAt;
  @LastModifiedBy
  @Column(nullable = false)
  private LocalDateTime updatedAt;
}
