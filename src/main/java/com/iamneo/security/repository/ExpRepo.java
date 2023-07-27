package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Expenses;


public interface ExpRepo extends JpaRepository<Expenses, String>{

}
