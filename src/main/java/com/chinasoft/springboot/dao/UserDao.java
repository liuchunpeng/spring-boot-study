package com.chinasoft.springboot.dao;

import com.chinasoft.springboot.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Component
public interface UserDao{
    User findByUserName(@Param("userName") String userName);
}
