package com.example.examserver.dao;

import com.example.examserver.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserName(String userName);
}
