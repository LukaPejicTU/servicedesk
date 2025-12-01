package com.example.servicedesk.service;

import com.example.servicedesk.entity.ServiceTicketEntity;
import com.example.servicedesk.entity.Status;
import com.example.servicedesk.entity.UserEntity;
import com.example.servicedesk.repository.ServiceTicketRepository;
import com.example.servicedesk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTicketService {
    private final UserRepository userRepository;
    private final ServiceTicketRepository serviceTicketRepository;

    public ServiceTicketService(UserRepository userRepository, ServiceTicketRepository serviceTicketRepository) {
        this.serviceTicketRepository = serviceTicketRepository;
        this.userRepository = userRepository;
    }


    public ServiceTicketEntity createTicket(String title, String description, Long userId) {
        ServiceTicketEntity serviceTicketEntity = new ServiceTicketEntity();
        serviceTicketEntity.setTitle(title);
        serviceTicketEntity.setDescription(description);
        serviceTicketEntity.setStatus(Status.OPEN);

        UserEntity user = userRepository.findById(userId)
                        .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        serviceTicketEntity.setUser(user);

        serviceTicketRepository.save(serviceTicketEntity);
        return serviceTicketEntity;

    }

    public List<ServiceTicketEntity> getAllTickets() {
        return serviceTicketRepository.findAll();
    }

    public ServiceTicketEntity getTicketById(Long ticketId) {
        return serviceTicketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));
    }

    public void updateTicketStatus(Long ticketId, Status newStatus) {
        ServiceTicketEntity ticket = serviceTicketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + ticketId));

        ticket.setStatus(newStatus);
        serviceTicketRepository.save(ticket);
    }
}
