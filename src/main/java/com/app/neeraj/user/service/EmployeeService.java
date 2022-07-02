package com.app.neeraj.user.service;

import com.app.neeraj.user.entity.Employee;
import com.app.neeraj.user.repository.EmployeeRepository;
import com.app.neeraj.user.vo.DepartmentVO;
import com.app.neeraj.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveUser(Employee employee) {
        log.info("Inside saveUser method of UserService");
        return employeeRepository.save(employee);
    }

    public Employee findByUserId(Long empId) {
        return employeeRepository.findByEmpId(empId);
    }

    public ResponseTemplateVO getUserWithDepartment(Long empId){
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Employee user = findByUserId(empId);
       DepartmentVO departmentVO =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+empId, DepartmentVO.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(departmentVO);
        return responseTemplateVO;
    }
}
