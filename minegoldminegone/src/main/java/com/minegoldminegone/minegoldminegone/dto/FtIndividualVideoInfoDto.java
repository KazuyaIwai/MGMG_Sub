package com.minegoldminegone.minegoldminegone.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 動画ホーム用のサムネイルDTO
  videoId: string;
  vid: string;
  title: string; // 動画タイトル
  channelId: string; // 登録チャンネルId
  channelName: string; // 登録チャンネル名
  description: string; // 詳細文章
  good: number; // いいねの数
  views: number; // 視聴回数
  dayByUploaded: string; // 最終更新日
 */
@Getter
@Setter
@NoArgsConstructor
public class FtIndividualVideoInfoDto {
  Integer videoId;
  String vId;
  String title; // 動画タイトル
  String channelId; // 登録チャンネルID
  String channelName; // 登録チャンネル名
  Integer subscribedCount; // 登録チャンネル数
  String description; // 詳細文章
  Integer good; // いいねの数
  BigInteger views; // 視聴回数
  Integer dayByUploaded; // アップロード時からの日数

  public FtIndividualVideoInfoDto(
    Integer videoId,
    String vId,
    String title,
    String channelId,
    String channelName,
    Integer subscribedCount,
    String description,
    Integer good,
    BigInteger views,
    Integer dayByUploaded
  ){
    this.videoId = videoId;
    this.vId = vId;
    this.title = title;
    this.channelId = channelId;
    this.channelName = channelName;
    this.subscribedCount = subscribedCount;
    this.description = description;
    this.good = good;
    this.views = views;
    this.dayByUploaded = dayByUploaded;
  }
}
