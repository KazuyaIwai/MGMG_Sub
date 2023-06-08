package com.minegoldminegone.minegoldminegone.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * 検索履歴
  `id` INT NOT NULL AUTO_INCREMENT,
  `search_text` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT NULL,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtSearchHistory {
    
  @Id
  private Integer id;
  private String searchText;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
