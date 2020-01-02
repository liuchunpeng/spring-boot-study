package com.chinasoft.springboot.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer deptId;
	@Column(name = "department_name")
	private String departmentName;

	public Department() {
	}

	public Department(int i, String string) {
		this.deptId = i;
		this.departmentName = string;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


}
