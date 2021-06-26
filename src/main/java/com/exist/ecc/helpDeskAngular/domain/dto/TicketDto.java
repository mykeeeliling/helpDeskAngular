package com.exist.ecc.helpDeskAngular.domain.dto;

import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import com.exist.ecc.helpDeskAngular.domain.reference.Severity;
import com.exist.ecc.helpDeskAngular.domain.reference.Status;
import lombok.Data;

import java.util.List;

@Data
public class TicketDto {
    private String title;
    private String description;
    private Severity severity;
    private Status status;
    private EmployeeDto assignee;
    //private List<EmployeeWatchersDto> watchers;
}
