package com.example.emproject;

import java.util.List;

import org.springframework.stereotype.Service;

public interface EmployeeService {
	String  createEmployee(Employee employee);
	List<Employee> readEmployee();
	boolean deleteEmployee(Long id);
	String updateEmployee(Long id,Employee employee);
	Employee readEmploye(Long id);
	

}
