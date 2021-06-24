package com.exist.ecc.helpDeskAngular.repository;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeNumber(Long employeeNumber);
}
