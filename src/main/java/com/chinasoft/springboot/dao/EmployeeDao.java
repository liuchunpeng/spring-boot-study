package com.chinasoft.springboot.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.chinasoft.springboot.entities.Employee;
import com.chinasoft.springboot.entities.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
@Component
public interface EmployeeDao{

	List<EmployeeInfo> findUserInfo();

	List<Employee> findByEmailLike(String email,Integer empId);

	Integer updateEmpById(Employee employee) ;

	void saveEmployee(Employee employee);

	void deleteById(Integer empId);

	Employee getOneEmployee(Integer empId);
}