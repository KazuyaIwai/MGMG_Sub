package com.minegoldminegone.minegoldminegone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 投稿動画コメント
  vid: string,
  commentId: number, 
  userId: string; // 投稿ユーザーID
  userName: string; // 投稿ユーザー名
  comment: string; // コメント
  myEvaluate: string; // 自ユーザーがコメントを評価してるかどうか（2:高評価、1:低評価、0:評価なし）
  dayByUploaded: string; // 最終更新日
  good: number; // 高評価数
  bad: number; // 低評価数
 */
@Getter
@Setter
@NoArgsConstructor
public class FtCommentDto {
  private String vid;
  private String commentId;
  private String userId; // 投稿ユーザーID
  private String userName; // 投稿ユーザー名
  private String comment; // コメント
  private String myEvaluate; // 自ユーザーがコメントを評価してるかどうか（2:高評価、1:低評価、0:評価なし）
  private String dayByUploaded; // 最終更新日
  private Integer good; // 高評価数
  private Integer bad; // 低評価数

  public FtCommentDto(
    String vid,
    String commentId,
    String userId,
    String userName,
    String comment,
    String myEvaluate,
    String dayByUploaded,
    Integer good,
    Integer bad
  ) {
    this.vid = vid;
    this.commentId = commentId;
    this.userId = userId;
    this.userName = userName;
    this.comment = comment;
    this.myEvaluate = myEvaluate;
    this.dayByUploaded = dayByUploaded;
    this.good = good;
    this.bad = bad;
  }
}
