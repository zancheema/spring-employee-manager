package com.example.manager.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.manager.model.Employee;
import com.example.manager.repository.EmployeeRepository;
import com.example.manager.util.factory.HttpServletRequestEmployeeFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // @PostMapping("add")
    // public ResponseEntity<Employee> addEmployee(@AuthenticationPrincipal
    // OAuth2User user,
    // @Valid @RequestBody EmployeeRequestBody payloadBody) {

    // Employee employee = new RequestBodyEmployeeFactory(user,
    // payloadBody).create();
    // Employee savedEmployee = employeeRepository.save(employee);
    // return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    // }

    @PostMapping("add")
    public ResponseEntity<Employee> addEmployee(@AuthenticationPrincipal OAuth2User user, HttpServletRequest request) {
        Employee employee = new HttpServletRequestEmployeeFactory(user, request).create();
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}
