package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtVideoComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Service
public interface FtVideoCommentRepository extends JpaRepository<FtVideoComment, String> {
  String queryFtComment =
    "SELECT "
    + "  ftvc.v_id, "
    + "  ftvc.comment_id, "
    + "  ftvc.user_id AS author_user_id, "
    + "  ftu.name AS author_user_name, "
    + "  ftvc.comment, "
    + "  COALESCE(fvcs.evaluate, 0) AS myEvaluate, "
    + "  DATEDIFF(CURRENT_DATE(), ftvc.created_at) AS dayByUploaded, "
    + "  COALESCE(ftcs.goodCount, 0) AS goodCount, "
    + "  0 AS bad "
    + "FROM "
    + "  ft_video_comment ftvc "
    + "      LEFT JOIN "
    + "  ft_user ftu ON ftvc.user_id = ftu.user_id "
    + "      AND ftvc.v_id = :ftvcvid "
    + "      LEFT JOIN "
    + "  (SELECT  "
    + "      comment_id, COUNT(evaluate) AS goodCount "
    + "  FROM "
    + "      ft_video_comment_summary "
    + "  WHERE "
    + "      evaluate = :evaluate AND v_id = :vid "
    + "  GROUP BY comment_id) ftcs ON ftcs.comment_id = ftvc.comment_id "
    + "      LEFT JOIN "
    + "  ft_video_comment_summary fvcs ON fvcs.v_id = ftvc.v_id "
    + "      AND fvcs.comment_id = ftvc.comment_id "
    + "      AND fvcs.user_id = ftvc.user_id "
    + "      AND fvcs.v_id = :fvcsvid "
    + "WHERE ftvc.v_id = :targetVid "
    + "ORDER BY ftvc.comment_id ASC "
    + "LIMIT :setlimit OFFSET :setoffset "
    + ";";
  @Query(value = queryFtComment, nativeQuery = true)
  public List<Object[]> fetchFtCommentDto(
      @Param("ftvcvid") String ftvcvid, 
      @Param("vid") String vid, 
      @Param("fvcsvid") String fvcsvid, 
      @Param("evaluate") String evaluate,
      @Param("targetVid") String targetVid,
      @Param("setlimit") Integer setlimit,
      @Param("setoffset") Integer setoffset
      );

      String queryFtCommentSum = "SELECT COUNT(comment_id) FROM ft_video_comment WHERE v_id = :vid ;";
      @Query(value = queryFtCommentSum, nativeQuery = true)
      public Integer fetchFtCommentSum(@Param("vid") String vid);
}
