package com.chinasoft.springboot.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class EmployeeInfo {

    private Integer empId;
    private String lastName;
    private String email;
    //1 male, 0 female
    private Integer gender;
    private String departmentName;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
    private Date birth;


    public Integer getEmpId() {
        return empId;
    }


    public void setEmpId(Integer empId) {
        this.empId = empId;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getGender() {
        return gender;
    }


    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public Date getBirth() {
        return birth;
    }


    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public EmployeeInfo(Integer empId, String lastName, String email, Integer gender, String departmentName, Date birth) {
        this.empId = empId;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.departmentName = departmentName;
        this.birth = birth;
    }
}
