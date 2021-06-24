package com.exist.ecc.helpDeskAngular.domain.entity;

import com.exist.ecc.helpDeskAngular.domain.reference.Severity;
import com.exist.ecc.helpDeskAngular.domain.reference.Status;
import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "ticket_number",
            nullable = false
    )
    private Long ticketNumber;

    @Column(nullable = false)
    private String title;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ticket")
    private Employee assignee;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "watchers",
//            joinColumns = {@JoinColumn(name = "ticketNumber")},
//            inverseJoinColumns = {@JoinColumn(name = "employeeNumber")})
//    private List<Employee> watchers = new ArrayList<>();

    public Ticket() {
    }

    public Ticket(Long ticketNumber, String title, String description, Severity severity, Status status, Employee assignee) {
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.assignee = assignee;
    }
}
