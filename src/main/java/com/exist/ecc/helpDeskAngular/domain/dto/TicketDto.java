package com.exist.ecc.helpDeskAngular.domain.dto;

import com.exist.ecc.helpDeskAngular.domain.entity.Employee;
import lombok.Data;

import javax.print.attribute.standard.Severity;
import javax.transaction.Status;
import java.util.List;

@Data
public class TicketDto {
    private Long ticketNumber;
    private String title;
    private String description;
    private Severity severity;
    private Status status;
    private Employee assignee;
    //private List<Employee> watchers;
}
