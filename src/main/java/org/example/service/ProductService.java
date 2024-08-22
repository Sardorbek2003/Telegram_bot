package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Customer;
import org.example.model.Product;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductService {
    public void add(Product product) {
        List<Product> products = readJson();
        if (has(product.getName())) {
            Product productByName = findProductByName(product.getName());
            productByName.setQuantity(product.getQuantity() + 1);
        } else {
            products.add(product);
            writeJson(products);
        }
    }

    public void removeProduct(UUID id) {
        List<Product> products = readJson();
        products = products.stream()
                .filter(product -> product.getId().equals(id))
                .toList();
        writeJson(products);
    }

    public List<Product> productList(UUID customerId) {
        List<Product> products = readJson();
        return products.stream()
                .filter(product -> product.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public boolean has(String name) {
        List<Product> products = readJson();
        return products.stream()
                .anyMatch(product -> product.getName().equals(name));
    }

    public Product findProductByName(String name) {
        List<Product> products = readJson();
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private List<Product> readJson() {
        return JsonUtil.readGson(FilePathUtil.getProduct(), new TypeReference<>() {
        });
    }

    private void writeJson(List<Product> products) {
        JsonUtil.writeGson(products, FilePathUtil.getProduct());
    }

}

