package com.app.neeraj.user.controller;

import com.app.neeraj.user.entity.Employee;
import com.app.neeraj.user.service.EmployeeService;
import com.app.neeraj.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveUser(@RequestBody Employee employee){
        log.info("Inside saveUser method of UserController");
        return employeeService.saveUser(employee);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO findByUserId(@PathVariable("id") Long empId){
        log.info("Inside findByUserId method of UserController");
        return employeeService.getUserWithDepartment(empId);

    }
}
