package com.minegoldminegone.minegoldminegone.service.impl;

import com.minegoldminegone.minegoldminegone.model.User;
import com.minegoldminegone.minegoldminegone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //与えられたユーザー名を用いてUserDetailsを取得し返却するメソッド
	    //データベースからアカウント情報を検索する
    	User user = userRepository.findByFullName(username);
    	return user;
    }

}