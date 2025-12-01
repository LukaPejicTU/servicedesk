package com.example.servicedesk.repository;

import com.example.servicedesk.entity.ServiceTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTicketRepository extends JpaRepository<ServiceTicketEntity, Long> {
}
