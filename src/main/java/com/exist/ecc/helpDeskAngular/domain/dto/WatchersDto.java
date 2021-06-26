package com.exist.ecc.helpDeskAngular.domain.dto;

import com.exist.ecc.helpDeskAngular.domain.reference.Department;
import lombok.Data;

@Data
public class WatchersDto {
    private Long employeeNumber;
    private String firstName;
    private String lastName;
    private Department department;
}
