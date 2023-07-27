package com.iamneo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.security.entity.Inventory;


public interface InventoryRepo extends JpaRepository<Inventory, String>{

}
