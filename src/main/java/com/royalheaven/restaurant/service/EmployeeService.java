package com.royalheaven.restaurant.service;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dto.Employee;

public interface EmployeeService {
    void setEmployee(Employee employee);

    Iterable<EmployeeEntity>  getEmployee();

    public void deleteEmployeeById(Long id);

    public EmployeeEntity updateEmployeeById(Long id, Employee updatedEmployee);
}
