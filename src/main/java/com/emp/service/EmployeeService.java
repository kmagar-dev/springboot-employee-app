package com.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.entity.Employee;
import com.emp.exception.EmployeeNotFoundException;
import com.emp.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> saveAllEmployees(List<Employee> emp) {
		return employeeRepository.saveAll(emp);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(Long id) {

		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not found with id:" + id + "not found"));

	}

	public String deleteEmployeeById(Long id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return "Employee with id " + id + " is deleted successfully!!";
		} else {
			return "Employee with id " + id + " is not found";
		}
	}

	public List<Employee> getEmployeeByName(String name) {
		if (employeeRepository.existsByName(name)) {
			return employeeRepository.findByName(name);
		} else {
			return new ArrayList<>();
		}

	}

	public String getEmployeeByDepartment(String department) {
		if (employeeRepository.existsByDepartment(department)) {
			employeeRepository.findByDepartment(department);
			return "Employee" + department + "found";
		} else {
			return "Not found sorry";
		}

	}

	public List<Employee> getByEmployeeSalary(Double salary) {
		if (employeeRepository.existsBySalary(salary)) {
			return employeeRepository.findBySalary(salary);
		} else {
			return new ArrayList<>();
		}
	}

	public Optional<Employee> updateEmployee(Long id, Employee updatedEmp) {
		if (employeeRepository.existsById(id)) {
			Employee emp = employeeRepository.findById(id).get();

			emp.setName(updatedEmp.getName());
			emp.setDepartment(updatedEmp.getDepartment());
			emp.setSalary(updatedEmp.getSalary());

			return Optional.of(employeeRepository.save(emp));
		} else {
			return Optional.empty();
		}
	}
}
