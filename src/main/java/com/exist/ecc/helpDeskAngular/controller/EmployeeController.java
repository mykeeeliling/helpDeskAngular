package com.exist.ecc.helpDeskAngular.controller;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import com.exist.ecc.helpDeskAngular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/list")
    public ResponseEntity<EmployeeDto> getAllEmployees(){
        return new ResponseEntity(employeeService.list(), HttpStatus.OK);
    }

    @GetMapping(path = "/{employeeNumber}")
    public ResponseEntity<EmployeeDto> viewEmployee(@PathVariable("employeeNumber")Long employeeNumber){
        return new ResponseEntity(employeeService.view(employeeNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<Employee>(employeeService.create(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeNumber}")
    public ResponseEntity<EmployeeDto> updateEmployee(
            @PathVariable("employeeNumber")Long employeeNumber,
            @RequestBody Employee Employee){
        return new ResponseEntity<EmployeeDto>(employeeService.update(Employee, employeeNumber), HttpStatus.OK);
    }
}
