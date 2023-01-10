package com.example.examserver.controller;


import com.example.examserver.config.JwtUtils;
import com.example.examserver.model.JwtRequest;
import com.example.examserver.model.JwtResponse;
import com.example.examserver.model.User;
import com.example.examserver.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;



    @PostMapping("/generate-token")
    public ResponseEntity<?>generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        }catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("User not found");
        }

        UserDetails userDetails=userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=jwtUtils.generateToken(userDetails);
        JwtResponse jwtResponse=new JwtResponse();
        jwtResponse.setToken(token);
        return ResponseEntity.ok(jwtResponse);
    }

    private void authenticate(String username, String password) throws Exception {

        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException e){
            e.printStackTrace();
            throw new Exception("USER DISABLE");

        }catch (BadCredentialsException e){
            throw new Exception("INVALID CREDENTIAL");
        }
    }


    @GetMapping("/current-user")
    public ResponseEntity<User>currentUser(Principal principal){
        return new ResponseEntity<User>((User) userDetailsService.loadUserByUsername(principal.getName()), HttpStatus.OK);
    }
}
