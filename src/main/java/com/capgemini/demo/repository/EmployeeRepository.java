package com.capgemini.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
