package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
