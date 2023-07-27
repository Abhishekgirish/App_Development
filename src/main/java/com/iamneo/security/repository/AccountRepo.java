package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Account;


public interface AccountRepo extends JpaRepository<Account, Integer>{

}
