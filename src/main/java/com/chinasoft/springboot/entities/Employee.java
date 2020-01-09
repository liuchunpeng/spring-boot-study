package com.chinasoft.springboot.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer empId;

    private String lastName;

    private String email;

    //1 male, 0 female
    private Integer gender;

    private Integer deptId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
