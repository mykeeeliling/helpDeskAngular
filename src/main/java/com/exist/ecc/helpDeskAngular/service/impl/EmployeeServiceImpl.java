package com.exist.ecc.helpDeskAngular.service.impl;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import com.exist.ecc.helpDeskAngular.repository.EmployeeRepository;
import com.exist.ecc.helpDeskAngular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Manual mapping conversion of Employee to EmployeeDto
    private EmployeeDto convertToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeNumber(employee.getEmployeeNumber());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setMiddleName(employee.getMiddleName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDepartment(employee.getDepartment());
        employeeDto.setTicketAssigned(employee.getTicket());
        return employeeDto;
    }

    // Manual mapping conversion of EmployeeDto to Employee
    private Employee convertToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setEmployeeNumber(employeeDto.getEmployeeNumber());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setMiddleName(employeeDto.getMiddleName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setTicket(employeeDto.getTicketAssigned());
        return employee;
    }

    @Override
    public List<EmployeeDto> list() {
        return ((List<Employee>) employeeRepository
        .findAll())
        .stream()
        .map(this::convertToEmployeeDto)
        .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto view(Long employeeNumber) {
        Optional<Employee> employee = employeeRepository.findByEmployeeNumber(employeeNumber);
        if (employee.isPresent()){
            EmployeeDto employeeDto = convertToEmployeeDto(employee.get());
            return employeeDto;
        } else {
            throw new IllegalStateException("Employee number does not exist");
        }
    }

    @Override
    public Employee create(EmployeeDto employeeDto) {
        Optional<Employee> employeeExists = employeeRepository.findByEmployeeNumber(employeeDto.getEmployeeNumber());
        if (employeeExists.isPresent()){
            throw new IllegalStateException("Employee Number already exists");
        } else {
            Employee employee = convertToEmployee(employeeDto);
            return employeeRepository.save(employee);
        }
    }

    @Override
    public EmployeeDto update(Employee employeeRequests, Long employeeNumber) {
        Optional<Employee> employee = employeeRepository.findByEmployeeNumber(employeeNumber);
        if (employee.isEmpty()){
            throw new IllegalStateException("Employee Number does not exists");
        }
        Employee employeeFromDb;
        employeeFromDb = employeeRequests;
        employeeRepository.save(employeeFromDb);
        return convertToEmployeeDto(employeeFromDb);
    }
}
