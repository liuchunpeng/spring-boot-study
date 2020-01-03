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
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	@Query(value = "select new com.chinasoft.springboot.entities.EmployeeInfo(e.empId,e.lastName,e.email,e.gender,d.departmentName,e.birth) "
			+ "from Employee e,  Department d where e.deptId = d.deptId")
	List<EmployeeInfo> findUserInfo();

	@Query(value = "select e from Employee e where e.email = ?1 and (e.empId <> ?2) ")
	List<Employee> findByEmailLike(String email,Integer empId);

	@Query(value = "update Employee set last_name=:#{#employee.lastName},email=:#{#employee.email},gender=:#{#employee.gender},birth=:#{#employee.birth},dept_id=:#{#employee.deptId} "
			+ "where emp_id=:#{#employee.empId}", nativeQuery = true)
	@Modifying
	@Transactional
	Integer updateEmpById(Employee employee) ;
}