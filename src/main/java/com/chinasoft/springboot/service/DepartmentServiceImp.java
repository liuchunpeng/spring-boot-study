package com.chinasoft.springboot.service;

import com.chinasoft.springboot.dao.DepartmentDao;
import com.chinasoft.springboot.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
