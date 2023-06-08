package com.minegoldminegone.minegoldminegone.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * 登録動画
`video_id` INT NOT NULL AUTO_INCREMENT,
`v_id` VARCHAR(32) NOT NULL,
`title` LONGTEXT NULL, -- 動画タイトル
`thumbnail_image` LONGTEXT NULL, -- サムネイル画像
`video_link` LONGTEXT NOT NULL, -- 動画リンク
`channel_id` VARCHAR(255) NOT NULL, -- 動画チャンネルID
`created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
`updated_at` DATETIME NULL,
 */
@Entity
@Table(name = "ft_video")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtVideos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long videoId;
    private String vId;

    private String title;
    private String thumbnailImage;
    private String thumbnailHover;
    private String videoLink;
    private String channelId;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
