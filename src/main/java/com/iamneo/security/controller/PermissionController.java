package com.iamneo.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Permission;
import com.iamneo.security.repository.PermissionRepo;

@RestController
public class PermissionController {
	@Autowired
	PermissionRepo repo;
@GetMapping("/perm/all")
public List<Permission> getAll(){
	return repo.findAll();
}
@GetMapping("/perm/{id}")
public Optional<Permission> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/perm")
public String postData(@RequestBody Permission perm) {
	repo.save(perm);
	return "Added";
}
@DeleteMapping("/perm/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}