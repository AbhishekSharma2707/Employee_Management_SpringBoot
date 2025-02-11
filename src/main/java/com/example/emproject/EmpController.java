package com.example.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	//List<Employee> employees=new ArrayList<>();

	//EmployeeService employeeService =new EmployeeServiceImp();
	//Dependency Injection
	@Autowired
    EmployeeService employeeService;
	
	@GetMapping("employees")
	public  List<Employee> getAllEmployee() {
      return employeeService.readEmployee();
	}
	
	@GetMapping("employees/{id}")
	public  Employee getAllEmployeeById(@PathVariable Long id) {
      return employeeService.readEmploye(id);
	}
	
	@PostMapping("employees")
	public String createEmployee(@RequestBody Employee employee ) {
		//employees.add(employee);
		
		return employeeService.createEmployee(employee);

	}
	@DeleteMapping("employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		if(employeeService.deleteEmployee(id)) {
			return "Delete Succesfully!";
		}
      return "Not Found!";
	}

	@PutMapping("employees/{id}")
	public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
		
		return employeeService.updateEmployee(id, employee);
	}
}
