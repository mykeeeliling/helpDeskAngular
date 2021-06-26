package com.exist.ecc.helpDeskAngular.service;

import com.exist.ecc.helpDeskAngular.domain.dto.TicketDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TicketService {
    List<TicketDto> list();
    TicketDto view(Long ticketNumber);
    Ticket create(TicketDto ticketDto);
    Ticket update(TicketDto ticketDto, Long ticketNumber);
    void delete(Long ticketNumber);
}
