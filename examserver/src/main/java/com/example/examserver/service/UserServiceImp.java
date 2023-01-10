package com.example.examserver.service;

import com.example.examserver.dao.RoleRepository;
import com.example.examserver.dao.UserRepository;
import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     *Create or save a new user.....................
     */
    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception{
        User data=userRepository.findByUserName(user.getUserName());
        if(data!=null){
            throw new Exception("user already exist");
        }

        for(UserRole uRole:userRoles){
            roleRepository.save(uRole.getRole());
        }
        user.getUserRoles().addAll(userRoles);
        System.out.println(user);
        return userRepository.save(user);

    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUserName(username);
    }
}
