package com.minegoldminegone.minegoldminegone.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 動画ホーム用のサムネイルDTO
 */
@Getter
@Setter
@NoArgsConstructor
public class FtThumbnailVideoDto {
  Integer videoId;
  String vId;
  String title; // 動画タイトル
  String channelId; // 登録チャンネルID
  String channelName; // 登録チャンネル名
  BigInteger views; // 視聴回数
  Integer dayByUploaded; // アップロード時からの日数

  public FtThumbnailVideoDto(
    Integer videoId,
    String vId,
    String title,
    String channelId,
    String channelName,
    BigInteger views,
    Integer dayByUploaded
  ){
    this.videoId = videoId;
    this.vId = vId;
    this.title = title;
    this.channelId = channelId;
    this.channelName = channelName;
    this.views = views;
    this.dayByUploaded = dayByUploaded;
  }
}
