package com.minegoldminegone.minegoldminegone.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * 登録チャンネル
  `channel_id` VARCHAR(255) NOT NULL,
  `channel_name` LONGTEXT NULL, -- 登録チャンネル名
  `channel_icon` LONGTEXT NULL, -- 登録チャンネルアイコン
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtSubscribedChannel {
    
    @Id
    private String channelId;

    private String channelName;

    private String channelIcon;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
