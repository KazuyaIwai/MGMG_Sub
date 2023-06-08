package com.minegoldminegone.minegoldminegone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * 動画視聴統計データ
  `video_id` INT NOT NULL ,
  `views` BIGINT(10) NULL -- 視聴回数
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtVideoSummary {
    
    @Id
    private String video_id;

    private Long views;

}
