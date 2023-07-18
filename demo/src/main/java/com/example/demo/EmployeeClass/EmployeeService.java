package com.example.demo.EmployeeClass;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private final EmployeeRepo employeerepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeerepo) {
		super();
		this.employeerepo = employeerepo;
	}
	
	
	public List<Employee> getEmployees() {
			return employeerepo.findAll();
	}
	
	public List<Employee> addEmployee(Employee employee) {
		Optional<Employee> employeeEmail = employeerepo.findEmployeeByEmail(employee.getEmail());
		if (employeeEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}

		employeerepo.save(employee);
		return employeerepo.findAll();
	}
	
	public List<Employee> delEmployee(long id) {
		Optional<Employee> employeeEmail = employeerepo.findById(id);
		if (employeeEmail.isPresent()) {
			employeerepo.deleteById(id);
			return employeerepo.findAll();
		} else throw new IllegalStateException("email not found");
	}


	public Employee getEmployee(long id) {
		Optional<Employee> reqEmployee = employeerepo.findById(id);
		if (reqEmployee.isPresent()) {
			return reqEmployee.get();
		} else throw new IllegalStateException("No employee with that id");
	}

	public Employee updateEmployee(long id, Employee newEmployee) {
		Optional<Employee> reqEmployee = employeerepo.findById(id);
		if (reqEmployee.isPresent()) {
			Employee oldEmployee = reqEmployee.get();
			if (!oldEmployee.getName().equals(newEmployee.getName())) {
				oldEmployee.setName(newEmployee.getName());
			} 
			if (!oldEmployee.getEmail().equals(newEmployee.getEmail())) {
				oldEmployee.setEmail(newEmployee.getEmail());
			}
			if (!oldEmployee.getStartDate().equals(newEmployee.getStartDate())) {
				oldEmployee.setStartDate(newEmployee.getStartDate());
			}
			if (!oldEmployee.getDob().equals(newEmployee.getDob())) {
				oldEmployee.setDob(newEmployee.getDob());
			}
			
			employeerepo.save(oldEmployee);
			return oldEmployee;
		} else throw new IllegalStateException("No employee with that id");
	}
	
}
