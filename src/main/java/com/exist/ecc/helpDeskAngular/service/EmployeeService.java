package com.exist.ecc.helpDeskAngular.service;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDto> list();
    EmployeeDto view(Long employeeNumber);
    Employee create(EmployeeDto employeeDto);
    EmployeeDto update(Employee employee, Long employeeNumber);
}
