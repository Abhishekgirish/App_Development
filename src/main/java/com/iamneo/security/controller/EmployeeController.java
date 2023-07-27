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
import com.iamneo.security.repository.EmployeeRepo;


@CrossOrigin(origins ="*")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepo repo;
@GetMapping("/emp/all")
public List<Employee> getAll(){
	return repo.findAll();
}
@GetMapping("/emp/{id}")
public Optional<Employee> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/emp")
public ResponseEntity<List<Employee>> postData(@RequestBody Employee emp) {
	repo.save(emp);
	return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
}
@DeleteMapping("/emp/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}