package com.example.examserver.controller;


import com.example.examserver.model.Role;
import com.example.examserver.model.User;
import com.example.examserver.model.UserRole;
import com.example.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Create user
     */
    @PostMapping("/")
    public ResponseEntity<User>createUser(@RequestBody User user) throws Exception {
//        return userService.saveUser()
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role=new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");

        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        Set<UserRole>userRoles=new HashSet<>();
        userRoles.add(userRole);


        return new ResponseEntity<User>(userService.saveUser(user, userRoles), HttpStatus.OK);
    }


    @GetMapping("/{username}")
    public ResponseEntity<User>getUser(@PathVariable String username){
        User response=this.userService.getUser(username);
        return new ResponseEntity<User>(response, HttpStatus.OK);
    }
}
