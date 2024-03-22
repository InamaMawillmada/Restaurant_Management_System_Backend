package com.royalheaven.restaurant.service.serviceImpl;

import com.royalheaven.restaurant.dao.EmployeeEntity;
import com.royalheaven.restaurant.dto.Employee;
import com.royalheaven.restaurant.repository.EmployeeRepository;
import com.royalheaven.restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void setEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setPosition(employee.getPosition());
        employeeEntity.setDescription(employee.getDescription());
        employeeRepository.save(employeeEntity);
    }

    @Override
    public Iterable<EmployeeEntity> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeEntity updateEmployeeById(Long id, Employee updatedEmployee) {
        Optional<EmployeeEntity> optionalExistingEmployee = employeeRepository.findById(id);

        if (optionalExistingEmployee.isPresent()) {
            EmployeeEntity existingEmployee = optionalExistingEmployee.get();

            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setDescription(updatedEmployee.getDescription());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setPosition(updatedEmployee.getPosition());

            return employeeRepository.save(existingEmployee);
        } else {
            System.out.println("Error");
        }
        return null;
    }


}
