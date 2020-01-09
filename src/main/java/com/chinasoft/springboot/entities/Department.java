package com.chinasoft.springboot.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer deptId;

	private String departmentName;

}
