package com.chinasoft.springboot.service;

import com.chinasoft.springboot.entities.User;
import org.springframework.data.repository.query.Param;

public interface UserDaoService {
    User findByUserName( String userName);
}
