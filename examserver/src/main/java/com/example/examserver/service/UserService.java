package com.example.examserver.service;

import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public interface UserService {
//    Creating a user
    User saveUser(User user, Set<UserRole>userRoles)throws Exception;
    User getUser(String username);
}
