package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtRatingVideo;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface FtRatingVideoRepository extends JpaRepository<FtRatingVideo, FtRatingVideo.Pk> {
    
}
