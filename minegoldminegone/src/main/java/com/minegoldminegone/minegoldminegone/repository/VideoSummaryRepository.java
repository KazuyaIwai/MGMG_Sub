package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.VideoSummary;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface VideoSummaryRepository extends JpaRepository<VideoSummary, Integer> {
    
    public Page<VideoSummary> findAllByOrderById(Pageable pageable);
}
