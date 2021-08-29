package com.example.manager.service;

import java.util.List;

import com.example.manager.model.Employee;
import com.example.manager.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployeesByEmployerEmail(String email) {
        return employeeRepository.findAllByEmployerId(email);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeByEmail(String email) {
        employeeRepository.deleteById(email);
    }
}
