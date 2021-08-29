package com.example.manager.repository;

import java.util.List;

import com.example.manager.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("FROM employees WHERE user.email = :email")
    List<Employee> findAllByEmployerId(@Param("email") String email);
}
