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

import com.iamneo.security.entity.Login;
import com.iamneo.security.repository.LoginRepo;

@RestController
public class LoginController {
	@Autowired
	LoginRepo repo;
@GetMapping("/login/all")
public List<Login> getAll(){
	return repo.findAll();
}
@GetMapping("/login/{id}")
public Optional<Login> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/login")
public String postData(@RequestBody Login cred) {
	repo.save(cred);
	return "Added";
}
@DeleteMapping("/login/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}