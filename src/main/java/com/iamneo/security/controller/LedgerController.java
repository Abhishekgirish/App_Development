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

import com.iamneo.security.entity.Ledger;
import com.iamneo.security.repository.LedgerRepo;

@RestController
public class LedgerController {
	@Autowired
	LedgerRepo repo;
@GetMapping("/ledger/all")
public List<Ledger> getAll(){
	return repo.findAll();
}
@GetMapping("/ledger/{id}")
public Optional<Ledger> getbyID(@PathVariable("id") int id ){
	return repo.findById(id);
}
@PostMapping("/ledger")
public String postData(@RequestBody Ledger led) {
	repo.save(led);
	return "Added";
}
@DeleteMapping("/ledger/{id}")
public String deleteData(@PathVariable("id") int id) {
	repo.deleteById(id);
	return "Deleted";
}

}