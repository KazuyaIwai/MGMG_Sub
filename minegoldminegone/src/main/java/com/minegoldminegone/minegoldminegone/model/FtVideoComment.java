package com.minegoldminegone.minegoldminegone.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * 動画コメント保存
  `v_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `comment` VARCHAR(1023) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT NULL,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtVideoComment {
    
  @Id
  private String vId;
  private String userId;
  private String comment;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
