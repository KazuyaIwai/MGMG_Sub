package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtVideos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Service
public interface FtVideoRepository extends JpaRepository<FtVideos, Long> {
    
    String queryFtThumbnailVideoDto = 
        "SELECT "
        + "    ftv.video_id, "
        + "    ftv.v_id, "
        + "    ftv.title, "
        + "    ftsc.channel_id, "
        + "    ftsc.channel_name, "
        + "    COALESCE(ftvs.views, 0), "
        + "    DATEDIFF(CURRENT_DATE(), ftv.created_at)"
        + "FROM "
        + "    ft_video AS ftv "
        + "LEFT JOIN "
        + "    ft_subscribed_channel AS ftsc ON ftv.channel_id = ftsc.channel_id "
        + "LEFT JOIN "
        + "    ft_video_summary AS ftvs ON ftv.video_id = ftvs.video_id "
        + "ORDER BY ftv.video_id "
        + "LIMIT :setlimit OFFSET :setoffset "
        + "; ";
    @Query(value = queryFtThumbnailVideoDto, nativeQuery = true)
    public List<Object[]> fetchFtThumbnailVideoDto(@Param("setlimit") int limit, @Param("setoffset") int offset);

    String queryIndividualVideoInfo =
          "SELECT  "
        + "    ftv.video_id, "
        + "    ftv.v_id, "
        + "    ftv.title, "
        + "    ftsc.channel_id, "
        + "    ftsc.channel_name, "
        + "    COALESCE(subsc.subscribedCount, 0),"
        + "    ftv.description, "
        + "    eval.good, "
        + "    COALESCE(ftvs.views, 0) AS views, "
        + "    DATEDIFF(CURRENT_DATE(), ftv.created_at) "
        + "FROM "
        + "    ft_video ftv "
        + "        LEFT JOIN "
        + "    ft_subscribed_channel AS ftsc ON ftv.channel_id = ftsc.channel_id "
        + "        LEFT JOIN "
        + "    ft_video_summary AS ftvs ON ftv.video_id = ftvs.video_id "
        + "        LEFT JOIN "
        + "    (SELECT  "
        + "        v_id, COUNT(evaluate) good "
        + "    FROM "
        + "        ft_rating_video "
        + "    WHERE "
        + "        evaluate = :evaluate AND v_id = :vid "
        + "    GROUP BY v_id) eval ON ftv.v_id = eval.v_id "
        + "    LEFT JOIN "
        + "    (SELECT  "
        + "        channel_id, COUNT(user_id) AS subscribedCount "
        + "    FROM "
        + "        ft_user_subscribed_channel "
        + "    GROUP BY channel_id) subsc ON subsc.channel_id = ftsc.channel_id "
        + "WHERE "
        + "    ftv.v_id = :vid "
        + ";";
    @Query(value = queryIndividualVideoInfo, nativeQuery = true)
    public List<Object[]> fetchFtIndividualVideoInfoDto(@Param("vid") String vid, @Param("evaluate") String evaluate);
    
    @Query(value = "select ftv from FtVideos ftv where ftv.vId = :vid")
    public FtVideos fetchByVId(@Param("vid") String vid);

    String queryFtRecommendVideoDto = 
        "SELECT "
        + "    ftv.video_id, "
        + "    ftv.v_id, "
        + "    1, "
        + "    ftv.title, "
        + "    ftsc.channel_id, "
        + "    ftsc.channel_name, "
        + "    COALESCE(ftvs.views, 0), "
        + "    DATEDIFF(CURRENT_DATE(), ftv.created_at)"
        + "FROM "
        + "    ft_video AS ftv "
        + "LEFT JOIN "
        + "    ft_subscribed_channel AS ftsc ON ftv.channel_id = ftsc.channel_id "
        + "LEFT JOIN "
        + "    ft_video_summary AS ftvs ON ftv.video_id = ftvs.video_id "
        + "WHERE NOT ftv.v_id = :vid "
        + "ORDER BY ftv.video_id "
        + "LIMIT :setlimit OFFSET :setoffset "
        + "; ";
    @Query(value = queryFtRecommendVideoDto, nativeQuery = true)
    public List<Object[]> fetchFtRecommendVideoDto(@Param("vid") String vid, @Param("setlimit") int limit, @Param("setoffset") int offset);
}
