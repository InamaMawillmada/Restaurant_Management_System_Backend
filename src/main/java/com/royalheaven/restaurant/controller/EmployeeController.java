package com.royalheaven.restaurant.controller;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dto.Employee;
import com.royalheaven.restaurant.dto.User;
import com.royalheaven.restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public void setUser(@RequestBody Employee employee){
        employeeService.setEmployee(employee);
    }

    @GetMapping
    public Iterable<EmployeeEntity> getEmployees(){
        return employeeService.getEmployee();
    }

    @PutMapping("/{employeeId}")
    public EmployeeEntity updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployeeById(employeeId, updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }


}
