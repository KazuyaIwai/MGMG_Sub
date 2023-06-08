package com.minegoldminegone.minegoldminegone.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FtRecommendVideoDto {
  Integer videoId;
  String vid;
  String recommendNo; // レコメンドNo
  String title; // タイトル
  String channelId; // 登録チャンネルID
  String channelName; // 登録チャンネル名
  Integer views; // 視聴回数
  Integer dayByUploaded; // 最終更新日
}
