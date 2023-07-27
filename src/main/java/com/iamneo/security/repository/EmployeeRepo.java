package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
