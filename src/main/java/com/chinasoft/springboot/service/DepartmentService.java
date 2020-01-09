package com.chinasoft.springboot.service;

import com.chinasoft.springboot.entities.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
}
