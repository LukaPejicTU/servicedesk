package com.example.servicedesk.controller;

import com.example.servicedesk.dto.CreateTicketRequest;
import com.example.servicedesk.entity.ServiceTicketEntity;
import com.example.servicedesk.entity.Status;
import com.example.servicedesk.service.ServiceTicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class ServiceTicketController {

    private final ServiceTicketService serviceTicketService;

    public ServiceTicketController(ServiceTicketService serviceTicketService) {
        this.serviceTicketService = serviceTicketService;
    }

    @GetMapping
    public List<ServiceTicketEntity> getAllTickets() {
        return serviceTicketService.getAllTickets();
    }

    @GetMapping("/{ticketId}")
    public ServiceTicketEntity getTicketById(@PathVariable("ticketId") Long ticketId) {
        return serviceTicketService.getTicketById(ticketId);
    }

    @PostMapping
    public ServiceTicketEntity createTicket(@RequestBody CreateTicketRequest request){
        return serviceTicketService.createTicket(request.title(), request.description(), request.userId());
    }

    @PutMapping("/{ticketId}")
    public void updateTicketStatus(@PathVariable("ticketId") Long ticketId, @RequestParam Status newStatus) {
        serviceTicketService.updateTicketStatus(ticketId, newStatus);
    }
}
