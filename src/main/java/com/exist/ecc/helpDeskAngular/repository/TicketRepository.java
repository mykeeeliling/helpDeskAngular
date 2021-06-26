package com.exist.ecc.helpDeskAngular.repository;

import com.exist.ecc.helpDeskAngular.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketNumber(Long ticketNumber);
}
