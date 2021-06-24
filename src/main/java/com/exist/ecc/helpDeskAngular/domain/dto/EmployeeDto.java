package com.exist.ecc.helpDeskAngular.domain.dto;

import com.exist.ecc.helpDeskAngular.domain.entity.Ticket;
import com.exist.ecc.helpDeskAngular.domain.reference.Department;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDto {
    private Long employeeNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Department department;
    private Ticket ticketAssigned;
}
