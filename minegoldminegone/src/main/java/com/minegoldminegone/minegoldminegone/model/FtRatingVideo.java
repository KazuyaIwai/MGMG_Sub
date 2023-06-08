package com.minegoldminegone.minegoldminegone.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * いいね悪いね評価
  `video_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `evaluate` TINYINT(1) NULL, -- いいね：1 悪いね：0 評価なし：null
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtRatingVideo {
    
  @EmbeddedId
  private Pk pk;

  private Integer evaluate;

  @Embeddable
  @Setter
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public class Pk implements Serializable {
    
    private String videoId;
    private String userId;
  }
}
