package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enam.CategoryType;

import java.util.PrimitiveIterator;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private UUID id;
    private UUID parentId;
    private UUID customerId;
    private String name;
    private CategoryType categoryType;
}
