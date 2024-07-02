package com.example.emproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	//List<Employee> employees=new ArrayList<>();
	
	@Override
	public String createEmployee(Employee employee) {
		
		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		//employees.add(0, employee);
		return "saved Sucessfully!";
	}
	
	@Override
	public Employee readEmploye(Long id) {
		EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeEntity,employee );
		return employee;
	}


	@Override
	public List<Employee> readEmployee() {
	  List<EmployeeEntity> employeesList=employeeRepository.findAll();
	  List<Employee> employees=new ArrayList<>();
	  for (EmployeeEntity employeeEntity : employeesList) {
		  Employee emp=new Employee();
		 
		 emp.setId(employeeEntity.getId());
		 emp.setName(employeeEntity.getName());
		 emp.setEmail(employeeEntity.getEmail());
		 emp.setPhone(employeeEntity.getPhone());
		 
		  employees.add(emp);
	}
		return employees;
	}

	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		//employees.remove(id.intValue());
		EmployeeEntity emp=employeeRepository.findById(id).get();
		employeeRepository.delete(emp);
		return true;
	}

	@Override
	public String updateEmployee(Long id, Employee employee) {
		EmployeeEntity exestingEmployee=employeeRepository.findById(id).get();
		exestingEmployee.setEmail(employee.getEmail());
		exestingEmployee.setName(employee.getName());
		exestingEmployee.setPhone(employee.getPhone());
		employeeRepository.save(exestingEmployee);
		return "update Succesfully";
	}

	
	
}
