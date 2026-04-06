package com.capgemini.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.entity.Employee;
import com.capgemini.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private final EmployeeRepository repo;
	
	public EmployeeController(EmployeeRepository repo) {
		this.repo=repo;
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return repo.save(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEMployees(){
		return repo.findAll();
	}

}
