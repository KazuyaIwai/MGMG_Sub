package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.minegoldminegone.minegoldminegone.model.FtVideoSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

@Service
public interface FtVideoSummaryRepository extends JpaRepository<FtVideoSummary, String> {
  
  @Transactional
  @Modifying
  @Query(
    value = "UPDATE ft_video_summary SET views = views + 1 WHERE video_id = :videoId ;",
    nativeQuery = true)
  public void updateViewsIncrement(@Param("videoId") String videoId);
}
