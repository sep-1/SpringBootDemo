package com.example.demo.EmployeeClass;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController 
@RequestMapping
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path = "/")
	public String test() {
		return "Hello World!";
	}
	
	@GetMapping(path = "api/v0/employee")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}
	
	@GetMapping(path = "api/v0/employee/{id}")
	public Employee getEmployee(@PathVariable("id") long id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping(path = "api/v0/employee")
	public List<Employee> newEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@DeleteMapping(path = "api/v0/employee/{id}")
	public List<Employee> delEmployee(@PathVariable("id") long id) {
		return employeeService.delEmployee(id);
	}
	
	@PutMapping(path = "api/v0/employee/{id}")
	public Employee updateEmployee(@Valid @PathVariable("id") long id, @RequestBody Employee newEmployee) {
		return employeeService.updateEmployee(id, newEmployee);
	}
}
