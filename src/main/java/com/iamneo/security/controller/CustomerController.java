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

import com.iamneo.security.entity.Customer;
import com.iamneo.security.repository.CustomerRepo;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo repo;
@GetMapping("/cust")
public List<Customer> getAll(){
	return repo.findAll();
}
@GetMapping("/cust/{id}")
public Optional<Customer> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/cust")
public String postData(@RequestBody Customer cust) {
	repo.save(cust);
	return "Added";
}
@DeleteMapping("/cust/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}