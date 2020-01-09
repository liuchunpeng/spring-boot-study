package com.chinasoft.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasoft.springboot.entities.Department;
import com.chinasoft.springboot.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface DepartmentDao{
	
	List<Department> findAll();
	
}
