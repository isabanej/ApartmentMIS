package edu.miu.apartment.service.impl;

import edu.miu.apartment.domain.Employee;
import edu.miu.apartment.repository.EmployeeRepository;
import edu.miu.apartment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional 
public class EmployeeServiceImpl implements EmployeeService {
	
 	@Autowired
	private EmployeeRepository employeeRepository;

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	public List<Employee> findAll() {
		return (List<Employee>)employeeRepository.findAll();
	}

	public Employee findByEmployeeNumber(Long employeeId) {
		return employeeRepository.findByEmployeeNumber(employeeId);
	}
 

}
