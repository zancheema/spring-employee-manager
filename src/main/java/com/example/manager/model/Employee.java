package com.example.manager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name = "employees")
public class Employee {
    @Id
    @Column(nullable = false, unique = true)
    private String email;

    private String name;

    private String jobTitle;

    private String phone;

    @ManyToOne
    @JoinTable(name = "email")
    private User user;

    public Employee() {
    }

    public Employee(String email, String name, String jobTitle, String phone, User user) {
        this.email = email;
        this.name = name;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employee [email=" + email + ", jobTitle=" + jobTitle + ", name=" + name + ", phone="
                + phone + ", user=" + user + "]";
    }
}
