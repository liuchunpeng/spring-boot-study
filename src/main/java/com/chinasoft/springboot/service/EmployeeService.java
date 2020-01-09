package com.chinasoft.springboot.service;

import com.chinasoft.springboot.entities.Employee;
import com.chinasoft.springboot.entities.EmployeeInfo;

import java.util.List;

public interface EmployeeService {
    List<EmployeeInfo> findUserInfo();

    List<Employee> findByEmailLike(String email, Integer empId);

    Integer updateEmpById(Employee employee) ;

    void saveEmployee(Employee employee);

    void deleteById(Integer empId);

    Employee getOneEmployee(Integer empId);
}
