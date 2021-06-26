package com.exist.ecc.helpDeskAngular.controller;

import com.exist.ecc.helpDeskAngular.domain.dto.TicketDto;
import com.exist.ecc.helpDeskAngular.domain.entity.Ticket;
import com.exist.ecc.helpDeskAngular.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path =  "/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {

    @Autowired
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(path = "/list")
    public ResponseEntity<TicketDto> getAllTickets(){
        return new ResponseEntity(ticketService.list(), HttpStatus.OK);
    }

    @GetMapping(path = "/{ticketNumber}")
    public ResponseEntity<TicketDto> viewTicket(@PathVariable("ticketNumber")Long ticketNumber){
        return new ResponseEntity(ticketService.view(ticketNumber), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ticket> saveTicket(@RequestBody TicketDto ticketDto){
        return new ResponseEntity<Ticket>(ticketService.create(ticketDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{ticketNumber}")
    public ResponseEntity<Ticket> updateTicket(
            @PathVariable("ticketNumber")Long ticketNumber,
            @RequestBody TicketDto TicketDto){
        return new ResponseEntity<Ticket>(ticketService.update(TicketDto, ticketNumber), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{ticketNumber}")
    private ResponseEntity delete(@PathVariable(name = "ticketNumber") Long ticketNumber){
        ticketService.delete(ticketNumber);
        return new ResponseEntity("",HttpStatus.NO_CONTENT);
    }
}
