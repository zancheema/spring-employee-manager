package com.example.manager.util.factory;

import com.example.manager.model.Employee;
import com.example.manager.model.User;
import com.example.manager.payload.EmployeeRequestBody;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class RequestBodyEmployeeFactory implements EmployeeFactory {
    private final OAuth2User oAuth2User;
    private final EmployeeRequestBody requestBody;

    public RequestBodyEmployeeFactory(OAuth2User oAuth2User, EmployeeRequestBody requestBody) {
        this.oAuth2User = oAuth2User;
        this.requestBody = requestBody;
    }

    @Override
    public Employee create() {
        User user = new UserFactory(oAuth2User).create();
        Employee employee = new Employee();
        employee.setEmail(requestBody.getEmail());
        employee.setName(requestBody.getName());
        employee.setJobTitle(requestBody.getJobTitle());
        employee.setPhone(requestBody.getPhone());
        employee.setUser(user);
        return employee;
    }
}
