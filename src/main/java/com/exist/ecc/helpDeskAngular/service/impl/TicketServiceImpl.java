package com.exist.ecc.helpDeskAngular.service.impl;

import com.exist.ecc.helpDeskAngular.domain.dto.TicketDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Ticket;
import com.exist.ecc.helpDeskAngular.repository.TicketRepository;
import com.exist.ecc.helpDeskAngular.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private final TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDto> list() {
        return ((List<Ticket>) ticketRepository
                .findAll())
                .stream()
                .map(ticket -> modelMapper.map(ticket, TicketDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto view(Long ticketNumber) {
        Optional<Ticket> ticket = ticketRepository.findByTicketNumber(ticketNumber);
        if (ticket.isPresent()){
            TicketDto ticketDto = modelMapper.map(ticket, TicketDto.class);
            return ticketDto;
        } else {
            throw new IllegalStateException("Employee number does not exist");
        }
    }

    @Override
    public Ticket create(TicketDto ticketDto) {
        Ticket ticket = modelMapper.map(ticketDto, Ticket.class);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(TicketDto ticketDto, Long ticketNumber) {
        Optional<Ticket> ticketExists = ticketRepository.findByTicketNumber(ticketNumber);
        if (ticketExists.isPresent()){
            Ticket ticket = ticketExists.get();
            modelMapper.map(ticketDto, ticket);
            return ticketRepository.save(ticket);
        } else {
            throw new IllegalStateException("Ticket Number does not exists");
        }
    }

    @Override
    public void delete(Long ticketNumber) {
        Optional<Ticket> ticket = ticketRepository.findByTicketNumber(ticketNumber);
        if (ticket.isPresent()){
            ticketRepository.delete(ticket.get());
        } else {
            throw new IllegalStateException("Ticket number does not exist");
        }
    }
}
