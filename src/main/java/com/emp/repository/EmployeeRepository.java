package com.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByName(String name);

	List<Employee> findByDepartment(String department);

	List<Employee> findBySalary(Double salary);

	boolean existsByName(String name);

	boolean existsByDepartment(String department);

	boolean existsBySalary(Double salary);

}
