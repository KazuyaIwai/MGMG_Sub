package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtSubscribedChannel;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface FtSubscribedChannelRepository extends JpaRepository<FtSubscribedChannel, String> {
    
}
