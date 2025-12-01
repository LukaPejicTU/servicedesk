package com.example.servicedesk.dto;

public record CreateTicketRequest(String title, String description, Long userId) {
}
