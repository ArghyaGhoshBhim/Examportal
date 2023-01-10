package com.example.examserver.service;

import com.example.examserver.dao.UserRepository;
import com.example.examserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.userRepository.findByUserName(username);
        System.out.println(user);
        if(user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return user;
    }
}
