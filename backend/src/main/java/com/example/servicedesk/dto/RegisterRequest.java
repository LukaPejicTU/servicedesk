package com.example.servicedesk.dto;

import com.example.servicedesk.entity.Role;

public record RegisterRequest(String username, String password, Role role) {
}
