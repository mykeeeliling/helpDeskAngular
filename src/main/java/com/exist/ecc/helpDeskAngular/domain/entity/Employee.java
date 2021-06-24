package com.exist.ecc.helpDeskAngular.domain.entity;

import com.exist.ecc.helpDeskAngular.domain.reference.Department;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Employee")
@Table(
        name = "employee",
        uniqueConstraints = {
                @UniqueConstraint(name = "employee_number_unique", columnNames = "employeeNumber")
        }
)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long employeeNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Department department;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_number")
    private Ticket ticket;

    public Employee() {
    }

    public Employee(Long id, Long employeeNumber, String firstName, String middleName, String lastName, Department department, Ticket ticket) {
        this.id = id;
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.ticket = ticket;
    }
}
