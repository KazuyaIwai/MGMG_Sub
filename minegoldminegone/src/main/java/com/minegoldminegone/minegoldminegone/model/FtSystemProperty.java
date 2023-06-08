package com.minegoldminegone.minegoldminegone.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** 
 * システムプロパティ
  `propertiy_name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `contents` LONGTEXT NOT NULL,
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FtSystemProperty {
    
    @Id
    private String propertiyName;

    private String description;

    private String contents;

}
