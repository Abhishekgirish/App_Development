package com.iamneo.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.security.entity.Employee;
import com.iamneo.security.entity.Expenses;
import com.iamneo.security.entity.Revenue;
import com.iamneo.security.repository.ExpRepo;
import com.iamneo.security.repository.RevenueRepo;

@CrossOrigin(origins="*")
@RestController
public class RevenueController {
	@Autowired
	RevenueRepo repo;
@GetMapping("/rev/all")
public List<Revenue> getAll(){
	return repo.findAll();
}
@GetMapping("/rev/{id}")
public Optional<Revenue> getbyID(@PathVariable("id") String id ){
	return repo.findById(id);
}
@PostMapping("/rev")
public  ResponseEntity<String> postData(@RequestBody Revenue inv) {
	repo.save(inv);
	return ResponseEntity.status(HttpStatus.OK).body("OK");
}
@DeleteMapping("/rev/{id}")
public String deleteData(@PathVariable("id") String id) {
	repo.deleteById(id);
	return "Deleted";
}

}