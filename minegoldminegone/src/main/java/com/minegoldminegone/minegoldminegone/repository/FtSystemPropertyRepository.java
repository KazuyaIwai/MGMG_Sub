package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;
import com.minegoldminegone.minegoldminegone.model.FtSystemProperty;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface FtSystemPropertyRepository extends JpaRepository<FtSystemProperty, String> {
    public String findContentsByPropertiyName(String propertiyName);
}
