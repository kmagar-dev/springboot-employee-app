package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entity.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/bulk")
	public List<Employee> saveEmployee(@RequestBody List<Employee> emp) {
		return employeeService.saveAllEmployees(emp);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable("id") Long id) {
		return employeeService.deleteEmployeeById(id);
	}

	@GetMapping("/name/{name}")
	public List<Employee> findByEmployeeName(@PathVariable("name") String name) {
		return employeeService.getEmployeeByName(name);
	}

	@GetMapping("/department/{department}")
	public String findByDepartmentName(@PathVariable("department") String department) {
		return employeeService.getEmployeeByDepartment(department);
	}

	@GetMapping("/salary/{salary}")
	public List<Employee> findByEmployeeSalary(@PathVariable("salary") Double salary) {
		return employeeService.getByEmployeeSalary(salary);
	}

	@PutMapping("/{id}")
	public Optional<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
		return employeeService.updateEmployee(id, emp);
	}

}
