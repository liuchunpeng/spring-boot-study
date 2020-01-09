package com.chinasoft.springboot.controller;

import com.chinasoft.springboot.dao.DepartmentDao;
import com.chinasoft.springboot.dao.EmployeeDao;
import com.chinasoft.springboot.entities.Department;
import com.chinasoft.springboot.entities.Employee;
import com.chinasoft.springboot.entities.EmployeeInfo;
import com.chinasoft.springboot.service.DepartmentService;
import com.chinasoft.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/emps")
    public String list(Model model){
        List<EmployeeInfo> employees = employeeService.findUserInfo();
        model.addAttribute("listEmployee",employees);
        return "/customers/list";
    }
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        List<Department> departments = departmentService.findAll();
        model.addAttribute("depts",departments);
        return "/customers/addEmp";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee, Model model){
        employeeService.saveEmployee(employee);
        return "redirect:/emps";
    }
    @PostMapping("/modifyEmp")
    public String modifyEmp(Employee employee, Model model){
        employeeService.updateEmpById(employee);
        return "redirect:/emps";
    }
    @PostMapping("/checkEmail")
    @ResponseBody
    public  Boolean checkEmail(@RequestParam("email")String email,@RequestParam("empId")Integer empId){
        List<Employee> result = employeeService.findByEmailLike(email,empId);
        if (!ObjectUtils.isEmpty(result)){
            return true;
        }
        return false;
    }
    @GetMapping("/delEmp")
    public String delEmp(@RequestParam("empId")Integer empId){
        employeeService.deleteById(empId);
        return "redirect:/emps";
    }
    @GetMapping("/modifyEmp")
    public String toModifyEmp(@RequestParam("empId")Integer empId , Model model){
        Employee employee = employeeService.getOneEmployee(empId);
        List<Department> departments = departmentService.findAll();
        model.addAttribute("depts",departments);
        model.addAttribute("emp",employee);
        return "/customers/modifyEmp";
    }

}
