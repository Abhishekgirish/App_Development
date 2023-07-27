package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Login;

public interface LoginRepo extends JpaRepository<Login, Integer>{

}
