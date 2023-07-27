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

import com.iamneo.security.entity.Expenses;
import com.iamneo.security.repository.ExpRepo;


@CrossOrigin(origins="*")
@RestController
public class ExpensesController {
	@Autowired
	ExpRepo repo;
@GetMapping("/auth/exp/all")
public List<Expenses> getAll(){
	return repo.findAll();
}
@GetMapping("/exp/{id}")
public Optional<Expenses> getbyID(@PathVariable("id") String id ){
	return repo.findById(id);
}
@PostMapping("/exp")
public String postData(@RequestBody Expenses inv) {
	repo.save(inv);
	return "Added";
}
@DeleteMapping("/exp/{id}")
public String deleteData(@PathVariable("id") String id) {
	repo.deleteById(id);
	return "Deleted";
}

}