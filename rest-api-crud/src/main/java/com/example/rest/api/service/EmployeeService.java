/**
 * 
 */
package com.example.rest.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.api.entity.EmployeeEntity;
import com.example.rest.api.exceptions.RecordNotFoundException;
import com.example.rest.api.repos.EmployeeRepository;

/**
 * @author deepak
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}

	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public EmployeeEntity createEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		EmployeeEntity newEmployee = new EmployeeEntity();
		newEmployee.setEmail(entity.getEmail());
		newEmployee.setFirstName(entity.getFirstName());
		newEmployee.setLastName(entity.getLastName());
		entity = repository.saveAndFlush(newEmployee);
		return newEmployee;
	}

	public EmployeeEntity updateEmployee(EmployeeEntity entity, Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);
		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());
			newEntity = repository.saveAndFlush(entity);
			return newEntity;
		}
		else {
			throw new RecordNotFoundException("No record found to update");
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

}
