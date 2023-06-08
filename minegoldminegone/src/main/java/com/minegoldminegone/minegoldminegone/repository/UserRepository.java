package com.minegoldminegone.minegoldminegone.repository;

import org.springframework.stereotype.Service;

import java.util.List;

import com.minegoldminegone.minegoldminegone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
    
    public List<User> findAll();

    public User findByEmail(String email);

    public User findByFullName(String fullName);
    
}
