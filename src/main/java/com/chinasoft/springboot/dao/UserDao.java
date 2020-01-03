package com.chinasoft.springboot.dao;

import com.chinasoft.springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /**
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
