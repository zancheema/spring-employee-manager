package com.example.manager.util.factory;

import javax.servlet.http.HttpServletRequest;

import com.example.manager.model.Employee;
import com.example.manager.model.User;

import org.springframework.security.oauth2.core.user.OAuth2User;

public class HttpServletRequestEmployeeFactory implements EmployeeFactory {
    private final OAuth2User oAuth2User;
    private final HttpServletRequest request;

    public HttpServletRequestEmployeeFactory(OAuth2User oAuth2User, HttpServletRequest request) {
        this.oAuth2User = oAuth2User;
        this.request = request;
    }

    @Override
    public Employee create() {
        User user = new UserFactory(oAuth2User).create();
        Employee employee = new Employee();
        employee.setEmail(request.getParameter("email"));
        employee.setJobTitle(request.getParameter("jobTitle"));
        employee.setName(request.getParameter("name"));
        employee.setPhone(request.getParameter("phone"));
        employee.setUser(user);
        return employee;
    }
}
