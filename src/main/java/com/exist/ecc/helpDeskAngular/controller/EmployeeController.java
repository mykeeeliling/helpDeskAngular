package com.exist.ecc.helpDeskAngular.controller;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import com.exist.ecc.helpDeskAngular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path =  "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("employeeNumber")Long employeeNumber,
            @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<Employee>(employeeService.update(employeeDto, employeeNumber), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{employeeNumber}")
    private ResponseEntity delete(@PathVariable(name = "employeeNumber") Long employeeNumber){
        employeeService.delete(employeeNumber);
        return new ResponseEntity("",HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{employeeNumber}/ticket/{ticketNumber}")
    private void assignTicket(@PathVariable(name = "employeeNumber") Long employeeNumber,
                              @PathVariable(name = "ticketNumber")Long ticketNumber) {
        employeeService.assignTicket(employeeNumber, ticketNumber);
    }
}
