package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.Customer;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerService {

    public Customer add(Customer customer){
        List<Customer> customers = readJson();
        if (hasCustomer(customer.getName())){
            return null;
        }
        customer.setId(UUID.randomUUID());
        customers.add(customer);
        return customer;
    }

    public boolean hasCustomer(String customerName){
        List<Customer> customers = readJson();
        return customers.stream()
                .anyMatch(customer -> customer.getName().equals(customerName));
    }


    public List<Customer> getCustomerById(UUID id){
        List<Customer> customers = readJson();
        return customers.stream()
                 .filter(customer -> customer.getId().equals(id))
                 .collect(Collectors.toList());
    }



    private List<Customer> readJson(){
      return   JsonUtil.readGson(FilePathUtil.getCustomer(), new TypeReference<>() {});
    }

    private void writeJson(List<Customer> customers){
        JsonUtil.writeGson(customers,FilePathUtil.getCustomer());
    }
}
