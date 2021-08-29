package com.example.manager.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EmployeeRequestBody {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String jobTitle;

    @NotBlank
    @Min(6)
    private String name;

    @Min(10)
    @NotBlank
    private String phone;
    
    public EmployeeRequestBody() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
