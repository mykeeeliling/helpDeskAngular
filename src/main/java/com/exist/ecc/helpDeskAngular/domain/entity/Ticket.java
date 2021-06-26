package com.exist.ecc.helpDeskAngular.domain.entity;

import com.exist.ecc.helpDeskAngular.domain.dto.EmployeeDto;
import com.exist.ecc.helpDeskAngular.domain.dto.WatchersDto;
import com.exist.ecc.helpDeskAngular.domain.reference.Severity;
import com.exist.ecc.helpDeskAngular.domain.reference.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Ticket")
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            updatable = false,
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

    @Enumerated
    @Column(nullable = false)
    private Severity severity;

    @Enumerated
    @Column(nullable = false)
    private Status status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ticket")
    private Employee assignee;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "watchers",
//            joinColumns = {@JoinColumn(name = "ticketNumber")},
//            inverseJoinColumns = {@JoinColumn(name = "employeeNumber")})
//    private List<EmployeeWatchersDto> watchers = new ArrayList<>();

}
