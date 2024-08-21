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
public class Basket {
    private UUID id;
    private UUID userId;
    private UUID productId;
    private String userName_productName;
    private double amount;
    private double quantity;
}
