package com.chinasoft.springboot.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.chinasoft.springboot.entities.Employee;
import com.chinasoft.springboot.entities.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Query(value = "select new com.chinasoft.springboot.entities.EmployeeInfo(e.deptId,e.lastName,e.email,e.gender,d.departmentName,e.birth) "
			+ "from Employee e,  Department d where e.deptId = d.deptId")
	List<EmployeeInfo> findUserInfo();


}
