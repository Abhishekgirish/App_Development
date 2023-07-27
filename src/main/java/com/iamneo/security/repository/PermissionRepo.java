package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Permission;


public interface PermissionRepo extends JpaRepository<Permission, Integer>{

}
