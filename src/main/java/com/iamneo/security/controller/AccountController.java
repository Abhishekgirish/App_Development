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

import com.iamneo.security.entity.Account;
import com.iamneo.security.repository.AccountRepo;


@RestController
public class AccountController {
	@Autowired
	AccountRepo repo;
@GetMapping("/acc/all")
public List<Account> getAll(){
	return repo.findAll();
}
@GetMapping("/acc/{id}")
public Optional<Account> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/acc")
public String postData(@RequestBody Account acc) {
	repo.save(acc);
	return "Added";
}
@DeleteMapping("/acc/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}