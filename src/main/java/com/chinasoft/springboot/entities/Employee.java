package com.chinasoft.springboot.entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer empId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    //1 male, 0 female
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "dept_id")
    private Integer deptId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth")
    private Date birth;

    public String getLastName() {
        return lastName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public Date getBirth() {
        return birth;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + empId +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", deptId=" + deptId +
                ", birth=" + birth +
                '}';
    }
}
