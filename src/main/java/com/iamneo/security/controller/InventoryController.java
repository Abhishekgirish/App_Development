package com.iamneo.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Inventory;
import com.iamneo.security.repository.InventoryRepo;

@CrossOrigin(origins="*")
@RestController
public class InventoryController {
	@Autowired
	InventoryRepo repo;
@GetMapping("/auth/inv/all")
public List<Inventory> getAll(){
	return repo.findAll();
}
@GetMapping("/inv/{id}")
public Optional<Inventory> getbyID(@PathVariable("id") String id ){
	return repo.findById(id);
}
@PostMapping("/inv")
public String postData(@RequestBody Inventory inv) {
	repo.save(inv);
	return "Added";
}
@DeleteMapping("/inv/{id}")
public String deleteData(@PathVariable("id") String id) {
	repo.deleteById(id);
	return "Deleted";
}

}