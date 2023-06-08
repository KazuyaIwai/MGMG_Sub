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
 * ユーザー登録チャンネル
  `user_id` VARCHAR(45) NOT NULL,
  `channel_id` VARCHAR(255) NOT NULL,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtUserSubscribedChannel {
    
  @EmbeddedId
  private Pk pk;

  @Embeddable
  @Setter
  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public class Pk implements Serializable {
    private String userId;
    private String channelId;
  }
}
