package com.example.rest.api.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest.api.entity.EmployeeEntity;

/**
 * @author deepak
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
