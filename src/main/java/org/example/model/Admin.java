package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private UUID id;
    private UUID customerId;
    private String name;
    private String username;
    private String password;
    private String phoneNumber;
}
