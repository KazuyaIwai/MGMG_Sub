package com.minegoldminegone.minegoldminegone.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.dto.FtCommentDto;
import com.minegoldminegone.minegoldminegone.dto.FtIndividualVideoInfoDto;
import com.minegoldminegone.minegoldminegone.dto.FtThumbnailVideoDto;
import com.minegoldminegone.minegoldminegone.dto.FtRecommendVideoDto;
import com.minegoldminegone.minegoldminegone.dto.FtSuggestSearchDto;
import com.minegoldminegone.minegoldminegone.model.FtSystemProperty;
import com.minegoldminegone.minegoldminegone.repository.FtSearchHistoryRepository;
import com.minegoldminegone.minegoldminegone.repository.FtSystemPropertyRepository;
import com.minegoldminegone.minegoldminegone.repository.FtVideoCommentRepository;
import com.minegoldminegone.minegoldminegone.repository.FtVideoRepository;
import com.minegoldminegone.minegoldminegone.type.FtRatingType;

@Service
public class FtVideosService {
  
	@Autowired
	private FtVideoRepository ftVideoRepository;
	@Autowired
	private FtSystemPropertyRepository ftSystemPropertyRepository;
  @Autowired
	private FtVideoCommentRepository ftVideoCommentRepository;
  @Autowired
	private FtSearchHistoryRepository ftSearchHistoryRepository;

  /**
   *  ホーム画面用サムネイル情報取得処理
   */
  public List<FtThumbnailVideoDto> fetchFtThumbnailVideoDto(int limit, int offset) {
    List<Object[]> thumnails = ftVideoRepository.fetchFtThumbnailVideoDto(limit, offset);
    List<FtThumbnailVideoDto> list = new ArrayList<>();
    for(Object[] row : thumnails) {
      list.add(new FtThumbnailVideoDto(
        Integer.valueOf(row[0].toString()), // videoId
        row[1] == null ? "" : row[1].toString(), // vId
        row[2] == null ? "" : row[2].toString(), // title
        row[3] == null ? "" : row[3].toString(), // channelId
        row[4] == null ? "" : row[4].toString(), // channelName
        new BigInteger(row[5] == null ? "0" : row[5].toString()),
        Integer.valueOf(row[6] == null ? "0" : row[6].toString())
      ));
    }
    return list;
  }

  /**
   *  動画再生画面用 再生動画情報取得処理
   */
  public FtIndividualVideoInfoDto fetchFtIndividualVideoInfoDto(String vid) {
    List<Object[]> videoInfo = ftVideoRepository.fetchFtIndividualVideoInfoDto(vid, FtRatingType.GOOD.getType());
    FtIndividualVideoInfoDto info = new FtIndividualVideoInfoDto();
    if (videoInfo.size() > 0) 
      for(Object[] row : videoInfo) {
        info = new FtIndividualVideoInfoDto(
          Integer.valueOf(row[0].toString()), // videoId
          row[1] == null ? "" : row[1].toString(), // vId
          row[2] == null ? "" : row[2].toString(), // title
          row[3] == null ? "" : row[3].toString(), // channelId
          row[4] == null ? "" : row[4].toString(), // channelName
          Integer.valueOf(row[5] == null ? "0" : row[5].toString()), // subscribedCount
          row[6] == null ? "" : row[6].toString(), // discription
          Integer.valueOf(row[7] == null ? "0" : row[7].toString()), // good
          new BigInteger(row[8] == null ? "0" : row[8].toString()), // views
          Integer.valueOf(row[9] == null ? "0" : row[9].toString()) // dayByUploaded
        );
        break;
      }
    return info;
  }

  /**
   *  動画再生画面用 動画コメント情報取得処理
   */
  public List<FtCommentDto> fetchFtCommentDto(String vid, Integer offset) {
    List<Object[]> comments = ftVideoCommentRepository.fetchFtCommentDto(vid, vid, vid, "2", vid, 10, offset);
    List<FtCommentDto> list = new ArrayList<>();
    for(Object[] row : comments) {
      list.add(new FtCommentDto(
        row[0] == null ? "" : row[0].toString(), // vid
        row[1] == null ? "" : row[1].toString(), // commentId
        row[2] == null ? "" : row[2].toString(), // userId
        row[3] == null ? "" : row[3].toString(), // userName
        row[4] == null ? "" : row[4].toString(), // comment
        row[5] == null ? "" : row[5].toString(), // myEvaluate
        row[6] == null ? "" : row[6].toString(), // dayByUploaded
        Integer.valueOf(row[7] == null ? "0" : row[7].toString()), // good
        Integer.valueOf(row[8] == null ? "0" : row[8].toString())  // bad
      ));
    }
    return list;
  }

  public Integer fetchFtCommentSummary(String vid) {
      return ftVideoCommentRepository.fetchFtCommentSum(vid);
  }

  public String getSystemValueByName(String name) {
    Optional<FtSystemProperty> prop = ftSystemPropertyRepository.findById(name);
    String contents = prop.get().getContents();
    return contents;
  }

  public List<FtRecommendVideoDto> fetchFtRecommendVideoDto(String vid, Integer offset) {
    List<Object[]> thumnails = ftVideoRepository.fetchFtRecommendVideoDto(vid, 10, offset);
    List<FtRecommendVideoDto> list = new ArrayList<>();
    for(Object[] row : thumnails) {
      list.add(new FtRecommendVideoDto(
        Integer.valueOf(row[0].toString()), // videoId
        row[1] == null ? "" : row[1].toString(), // vId
        row[2] == null ? "" : row[2].toString(), // recommendNo
        row[3] == null ? "" : row[3].toString(), // title
        row[4] == null ? "" : row[4].toString(), // channelId
        row[5] == null ? "" : row[5].toString(), // channelName
        Integer.valueOf(row[6] == null ? "0" : row[6].toString()),
        Integer.valueOf(row[7] == null ? "0" : row[7].toString())
      ));
    }
    return list;
  }

  public List<FtSuggestSearchDto> fetchFtSuggestSearchDto() {
    List<Object[]> thumnails = ftSearchHistoryRepository.fetchFtSuggestSearchDto(10, 0);
    List<FtSuggestSearchDto> list = new ArrayList<>();
    for(Object[] row : thumnails) {
      list.add(new FtSuggestSearchDto(
        row[0].toString(), // id
        row[1].toString() // text
      ));
    }
    return list;
  }
}
