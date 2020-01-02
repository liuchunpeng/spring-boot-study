package com.chinasoft.springboot.controller;

import com.chinasoft.springboot.dao.DepartmentDao;
import com.chinasoft.springboot.dao.EmployeeDao;
import com.chinasoft.springboot.entities.Department;
import com.chinasoft.springboot.entities.Employee;
import com.chinasoft.springboot.entities.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        List<EmployeeInfo> employees = employeeDao.findUserInfo();
        model.addAttribute("listEmployee",employees);
        return "/customers/list";
    }
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        List<Department> departments = departmentDao.findAll();
        model.addAttribute("depts",departments);
        return "/customers/addEmp";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee, Model model){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @PostMapping("/checkEmail")
    @ResponseBody
    public  Boolean checkEmail(@RequestParam("email")String email){
        return true;
    }

}
