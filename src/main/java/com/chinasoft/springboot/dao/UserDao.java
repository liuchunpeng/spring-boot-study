package com.chinasoft.springboot.dao;

import com.chinasoft.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
